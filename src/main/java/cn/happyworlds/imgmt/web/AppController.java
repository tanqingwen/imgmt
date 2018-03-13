package cn.happyworlds.imgmt.web;

import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.bean.StaffTokenBean;
import cn.happyworlds.imgmt.entity.BuyTicketParam;
import cn.happyworlds.imgmt.entity.CpPrdgrp;
import cn.happyworlds.imgmt.entity.CpTicket;
import cn.happyworlds.imgmt.entity.CpTktype;
import cn.happyworlds.imgmt.entity.Item;
import cn.happyworlds.imgmt.entity.TSysStaff;
import cn.happyworlds.imgmt.entity.YwOrder;
import cn.happyworlds.imgmt.entity.YwOrderitem;
import cn.happyworlds.imgmt.json.Jackson;
import cn.happyworlds.imgmt.mapper.CpTicketMapper;
import cn.happyworlds.imgmt.mapper.YwChargeMapper;
import cn.happyworlds.imgmt.mapper.YwOrderMapper;
import cn.happyworlds.imgmt.mapper.YwOrderitemMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.service.AppService;
import cn.happyworlds.imgmt.service.AutomaticGrowthService;
import cn.happyworlds.imgmt.service.CpPrdgrpService;
import cn.happyworlds.imgmt.service.CpTicketService;
import cn.happyworlds.imgmt.service.CpTktypeService;
import cn.happyworlds.imgmt.service.StaffService;
import cn.happyworlds.imgmt.service.YwOrderitemService;
import cn.happyworlds.imgmt.util.DateTimes;
import cn.happyworlds.imgmt.util.Digests;
import cn.happyworlds.imgmt.util.JwtTokenUtils;
import cn.happyworlds.imgmt.util.Requests;
import cn.happyworlds.imgmt.util.Result;
import cn.happyworlds.imgmt.util.StatusResult;

@Controller("AppController")
@RequestMapping("/app")
@CrossOrigin
public class AppController {
	private static final Logger log = LoggerFactory.getLogger(AppController.class);
	@Autowired
	private CpPrdgrpService cpPrdgrpService;
	@Autowired
	private CpTktypeService cpTktypeService;
	@Autowired
	private AutomaticGrowthService automaticgrowthService;
	@Autowired
	private YwOrderMapper yworderMapper;
	@Autowired
	private YwOrderitemMapper yworderitemMapper;
	@Autowired
	private YwOrderMapper ywOrderMapper;
	@Autowired
	private YwOrderitemService YwOrderitemService;
	@Autowired
	private YwChargeMapper ywChargeMapper;
	@Autowired
	private CpTicketService cpTicketService;
	@Autowired
	private CpTicketMapper cpTicketMapper;
	@Autowired
	private AppService appService;
	@Autowired
	private StaffService staffService;
	
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Object login(HttpServletRequest request){
		try{
			String staffId = request.getParameter("staffId");
			String password = request.getParameter("password");
			password = Digests.md5DigestAsHex(password);
			String token = request.getParameter("token");
			log.info("REST登录请求staffId:{},password:{},token:{}", staffId,password,token);
			Result<TSysStaff> r1 = staffService.staffLogin(staffId, password);
			if(r1.isError())
				return r1;
			TSysStaff staff = r1.getValue();
			WebContext.setCurrentStaffByToken(staff);
			StaffTokenBean subject = new StaffTokenBean(staff.getId(),staff.getRoles(),staff.getStatus());
			subject.setToken(JwtTokenUtils.createJwtToken(staff.getId(), subject, JwtTokenUtils.defaultExpPeriod));
			return Result.create(subject);
		}catch(Exception e){
			log.error("rest登录请求系统异常", e);
			return Result.create("error", "系统异常");
		}
	}
	@RestAction
	@ResponseBody
	@RequestMapping(value = "/loginout", method = RequestMethod.POST)
	public Object loginOut(HttpServletRequest request){
		try{
			WebContext.removeCurrentStaffByToken();
			return Result.create("注销成功");
		}catch(Exception e){
			log.error("rest登录请求系统异常", e);
			return Result.create("error", "系统异常");
		}
	}
	
	@RequestMapping("/")
	public String index(Model m) {
		return "app/login";
	}

	@RestAction
	@ResponseBody
	@RequestMapping(value="/objGrade/list",method=RequestMethod.GET,produces = "application/json")
	public StatusResult<List<CpPrdgrp>> queryObj(){
		return StatusResult.create("SUCCESS", cpPrdgrpService.prdgrpListObj(2000));
	}
	
	/**
	 * 票券种类接口 ，查询所有状态为可用，并在有效时间段的票券
	 * @return
	 */
	@RestAction
	@ResponseBody
	@RequestMapping(value="/ticketType/list",method=RequestMethod.GET, produces = "application/json")
	public StatusResult<List<CpTktype>> queryUsefulCptktype(){
		Map<String,String> params = new HashMap<String, String>();
		params.put("ttStartDate", DateTimes.date(LocalDate.now()));
		params.put("ttEndDate", DateTimes.date(LocalDate.now()));
		params.put("ttTypeStatus", "Y");
		return StatusResult.create("SUCCESS", cpTktypeService.findAllUsefulTktypeList(params));
	}
	
	@RestAction
	@Transactional
	@ResponseBody
	@RequestMapping(value="/buy/start",method = RequestMethod.POST,produces = "application/json",consumes="application/json")
	public  String buyStart( @RequestBody BuyTicketParam params){
		try{
			log.info("支付下单params:{}", params);
			TSysStaff currentStaff = WebContext.getCurrentStaffByToken();
			if(params.getOrderAmount()==null || params.getOrderAmount().compareTo(BigDecimal.ZERO)==0){
				 return Jackson.writeJson(StatusResult.create("FAIL", "购票总金额不能为空"));
			}
			YwOrder yworder = new YwOrder();
			String orderID = automaticgrowthService.nextdindang("name");
			yworder.setHwOperatorId(currentStaff.getId());
			yworder.setHwOrderId(orderID);
			yworder.setHwType("1");
			yworder.setHwMobilePhone(params.getPhoneNumber());		//手机号					 
			yworder.setHwChannel("12");				//渠道ID		1为微信，2为APP，3现场，4官网，5为OTA 12 终端pos
			yworder.setHwMoney(params.getOrderAmount());					//金额		从接口传过来
			yworder.setHwOrderState("N");
			yworder.setHwOrderAddtime(DateTimes.newDateTime());//订单生成时间	获取当前时间
			yworder.setHwPaymentStatus("N");
			yworder.setHwIp(params.getHwIp());
			yworderMapper.insertYwOrder(yworder);
			List<Item> items = params.getItems();
			if(items!=null){
				String hwAdmisssionTime = DateTimes.getDateTime(new Date());
				Calendar ca = Calendar.getInstance();
		        ca.add(Calendar.DATE, 30);// num为增加的天数，可以改变的
		        Date date  =ca.getTime();
		        String hwEndTime =DateTimes.getDateTime(date);
		        String ids = "";
				for(Item item: items){
					YwOrderitem ywOrderitem = new YwOrderitem();
					ywOrderitem.setHwOperatorId(currentStaff.getId());
					ywOrderitem.setHwMobile(params.getPhoneNumber());
					ywOrderitem.setHwOrderitemId(automaticgrowthService.dindangitem("name"));	
					ywOrderitem.setHwProdctGroup(item.getTicketType());
					ywOrderitem.setHwSpecialMethod(item.getObjGrade());
					ywOrderitem.setHwAmount(item.getItemAmount());
					ywOrderitem.setHwBirthday(item.getBirthDay());
					ywOrderitem.setHwDiscount(item.getDiscount());
					ywOrderitem.setHwMemberId(item.getCredentyNumber());
					ywOrderitem.setHwOrderId(orderID);
					ywOrderitem.setHwSpecialcredentynumber(item.getSpecialCredentyNumber());
					ywOrderitem.setHwSpecialcredentytype(item.getSpecialCredentyType());
					ywOrderitem.setHwCardserialno(item.getCardSerialNo());
					ywOrderitem.setHwCardhosternumber(item.getCardHosterNumber());
					ywOrderitem.setHwAdmissionTime(hwAdmisssionTime);
					ywOrderitem.setHwTicketCount(item.getTicketNumber());
					ywOrderitem.setHwUnitPrice(item.getItemAmount());
					ywOrderitem.setHwCredentytype(item.getCredentyType());
					ywOrderitem.setHwCredentyname(item.getCredentyName());
					ywOrderitem.setHwAddress(item.getAddress());
					ywOrderitem.setHwStatus("T");
					ywOrderitem.setHwEndTime(hwEndTime);
					ywOrderitem.setHwTicketName(item.getTicketName());
					ywOrderitem.setHwChargeAmount(item.getRechargeAmount());
					ywOrderitem.setHwVisitTime(DateTimes.nowDate());
					yworderitemMapper.insertYwOrderitem(ywOrderitem);
					
				}
				yworder.setHwSonOrderList(ids);
				yworderMapper.updateYwOrder(yworder);
			}
			Map<String, Object> map  = new HashMap<>();
			map.put("orderId", orderID);
			map.put("amount", params.getOrderAmount());
			return Jackson.writeJson(StatusResult.create("SUCCESS", map ));
		}catch(Exception e){
			log.error("支付下单异常",e);
			return Jackson.writeJson(StatusResult.create("error", "系统异常"));
		}
	}
	/**
	 * 退票下单
	 * @param orderId
	 * @param hwIp
	 * @return
	 */
	@RestAction
	@Transactional
	@ResponseBody
	@RequestMapping(value="/cancel/start",method = RequestMethod.POST,produces = "application/json",consumes="application/json")
	public  StatusResult<Object> cancelStart(String orderId, String hwIp){
		log.info("退票下单orderId:{},hwIp:{}", orderId, hwIp);
		YwOrder order =ywOrderMapper.searchYwOrderByHwOrderId(orderId);
		Map<String, String> orderMap = new HashMap<>();
		orderMap.put("hwOrderId", order.getHwOrderId());
		List<YwOrderitem> itemList = yworderitemMapper.searchYwOrderitemByParams(orderMap);
		for(YwOrderitem item : itemList){
			if(!"T".equals(item.getHwStatus()))
				return StatusResult.create("error", "订单已使用");
		}
		
		YwOrder cancelOrder = new YwOrder();
		String orderID = automaticgrowthService.nextdindang("name");
		cancelOrder.setHwOrderId(orderID);
		cancelOrder.setHwType("4");
		cancelOrder.setHwChannel("12");
		cancelOrder.setHwMobilePhone(order.getHwMobilePhone());
		cancelOrder.setHwMoney(order.getHwMoney());
		cancelOrder.setHwOperatorId(WebContext.getCurrentStaffByToken().getId());
		cancelOrder.setHwOrderFinishtime(DateTimes.getTimeStr(new Date()));
		cancelOrder.setHwMemberId(order.getHwMemberId());
		cancelOrder.setHwOrderAddtime(DateTimes.getTimeStr(new Date()));
		cancelOrder.setHwOrderState("N");
		cancelOrder.setHwPaymentStatus("N");
		cancelOrder.setHwSonOrderList(orderId);
		cancelOrder.setHwIp(hwIp);
		yworderMapper.insertYwOrder(cancelOrder);
		Map<String, Object> result = new HashMap<>();
		result.put("orderId", orderID);
		result.put("amount", order.getHwMoney().multiply(new BigDecimal(100)).longValue());
		result.put("origTransNo", order.getHwPaymentListid());
		return StatusResult.create("SUCCESS", result);
	}
	
	@RequestMapping(value="/updateOrderStatus",method=RequestMethod.POST,produces = "application/json")
	@ResponseBody
	public  StatusResult<Object> updateOrderStatus(@RequestParam("orderId")String orderId,@RequestParam("payType") String payType,@RequestParam("receiptsPrice")BigDecimal receiptsPrice,@RequestParam("hwPaymentListid")String hwPaymentListid){
		try {
			YwOrder ywOrder =ywOrderMapper.searchYwOrderByHwOrderId(orderId);
			if(ywOrder!=null){
				if("Y".equals(ywOrder.getHwPaymentStatus())){
					StatusResult.create("PAYED", "订单已支付");
				}
				ywOrder.setHwPaymentStatus("Y");
				ywOrder.setHwPayType(payType);
				ywOrder.setHwPaymentListid(hwPaymentListid);
				ywOrder.setHwOrderPaytime(DateTimes.newDateTime());
				boolean zhi = cpTicketService.tictekadd(orderId);
				if(zhi){
					return  StatusResult.create("SUCCESS", orderId);
				}
				StatusResult.create("FAIL", "添加票卷失败");
			}else{
				StatusResult.create("FAIL", "订单号不存在");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return StatusResult.create("FAIL", "更新订单状态失败");
	}
	/**
	 * 更新交易状态
	 * @param orderId		订单id
	 * @param transType		交易类型，1支付更新，2退款更新
	 * @param payType		支付方式
	 * @param settlePrice	结算金额
	 * @param serialNo		
	 * @return
	 * @throws ParseException
	 */
	@RestAction
	@ResponseBody
	@RequestMapping(value="/update/order/state",method=RequestMethod.POST,produces = "application/json")
	public StatusResult<Object> updateOrderPayState(String orderId, String transType, String payType, 
			BigDecimal settlePrice, String serialNo, String refNo) throws ParseException{
		System.out.println(Requests.getRequest().getParameter("orderId"));
		log.info("更新交易状态orderId:{},transType:{},payType:{},settlePrice:{},serialNo:{},refNo:{}",
				orderId,transType,payType,settlePrice,serialNo,refNo);
		YwOrder ywOrder = yworderMapper.searchYwOrderByHwOrderId(orderId);
		if(Objects.isNull(ywOrder))
			return StatusResult.create("PAYED", "未找到订单信息");
		if("1".equals(transType)){
			if("Y".equals(ywOrder.getHwPaymentStatus())){
				return StatusResult.create("PAYED", "该订单已支付");
			}
			ywOrder.setHwPaymentStatus("Y");
			ywOrder.setHwPayType(payType);
			ywOrder.setHwPaymentListid(serialNo);
			ywOrder.setHwOrderPaytime(DateTimes.newDateTime());
			ywOrder.setHwOrderFinishtime(DateTimes.newDateTime());
			yworderMapper.updateYwOrder(ywOrder);
			return StatusResult.create("状态更新成功");
		}
		
		if("2".equals(transType)){
			ywOrder.setHwPaymentStatus("Y");
			ywOrder.setHwPaymentListid(serialNo);
			ywOrder.setHwOrderPaytime(DateTimes.newDateTime());
			YwOrder payOrder = yworderMapper.searchYwOrderByHwOrderId(ywOrder.getHwSonOrderList());
			ywOrder.setHwPayType(payOrder.getHwPayType());
			yworderMapper.updateYwOrder(ywOrder);
			if(payOrder == null || !payOrder.getHwPaymentStatus().equals("Y")){
				return StatusResult.create("PAYED", "退款订单不存在或未完成支付");
			}
			payOrder.setHwOrderState("R");
			yworderMapper.updateYwOrder(payOrder);
			Map<String, String> orderMap = new HashMap<>();
			orderMap.put("hwOrderId", payOrder.getHwOrderId());
			List<YwOrderitem> itemList = yworderitemMapper.searchYwOrderitemByParams(orderMap);
			for(YwOrderitem item : itemList){
				item.setHwStatus("R");
				item.setHwOperatorId(WebContext.getCurrentStaffByToken().getId());
				yworderitemMapper.updateYwOrderitem(item);
				CpTicket ticket = cpTicketMapper.searchCpTicketByTkTicketId(Long.parseLong(item.getHwOrderitemId()));
				if(!Objects.isNull(ticket)){
					ticket.setTkStatus("R");
					cpTicketMapper.updateCpTicket(ticket);
				}
			}
			return StatusResult.create("状态更新成功");
		}
		return StatusResult.create("PAYED", "交易类型不支持");
	}
	
	
	@RequestMapping(value="/queryItemsByOrderId3",method=RequestMethod.GET)
	public String queryOrderItemsByOrderId3(String orderId,Model model,String receiptsPrice){
		if(StringUtils.isNotEmpty(orderId)){
			 PageBounds pageBounds = new PageBounds(1, 10);
			 Result<PageInfo<YwOrderitem>> rs =   YwOrderitemService.searchYwOrderitemByhwOrderId(orderId, pageBounds);
			 PageInfo<YwOrderitem> page = rs.getValue();
			 for(int i =0; i<page.getList().size();i++){
				 page.getList().get(i).setHwAmount(page.getList().get(i).getHwAmount().setScale(2,BigDecimal.ROUND_HALF_UP));;
				 if(page.getList().get(i).getHwChargeAmount()!=null){
					 page.getList().get(i).setHwChargeAmount(page.getList().get(i).getHwChargeAmount().setScale(2,BigDecimal.ROUND_HALF_UP));;
				 }
			 }
			 //List<YwOrderitem> list = rs.getValue().getList();
			 model.addAttribute("orderItems",rs.getValue().getList());
			 Map<String,String> paramMap = new HashMap<String, String>();
			 paramMap.put("hwOrderId", orderId);
			 ywChargeMapper.searchYwChargeByParams(paramMap);
			 YwOrder ywOrder = yworderMapper.searchYwOrderByHwOrderId(orderId);
			 ywOrder.setHwMoney(ywOrder.getHwMoney().setScale(2,BigDecimal.ROUND_HALF_UP));
			 model.addAttribute("ywOrder",ywOrder);
			 model.addAttribute("receiptsPrice", receiptsPrice);
		}
		return "ticket/buyTicketDetail3";
	}
	@RequestMapping(value="test",method=RequestMethod.GET)
	@ResponseBody
	public Object test(String orderId) {
		return yworderitemMapper.searchStatusByPos2(orderId);
	}
	
	/**
	 * 根据用户id查询订单信息
	 * @param staffId
	 * @return
	 * @throws ParseException
	 */
	@RestAction
	@RequestMapping(value="/query/order",method=RequestMethod.POST,produces = "application/json")
	@ResponseBody
	public StatusResult<List<Map<String, Object>>> queryOrder(String orderId, Integer pageNum, Integer pageSize) throws ParseException{
		String userId = WebContext.getCurrentStaffByToken().getId();
		log.info("订单查询staffId:{},orderId:{}",userId,orderId);
		try {
			List<YwOrder> orders = new ArrayList<>();
			if(!StringUtils.isEmpty(orderId)){
				YwOrder order = yworderMapper.searchYwOrderByHwOrderId(orderId);
				orders.add(order);
			}else{
				StatusResult<PageInfo<YwOrder>> orderRes = appService.queryOrder(userId, "12", pageNum, pageSize);
				if(orderRes.isOk()){
					orders = orderRes.getValue().getList();
				}else{
					return StatusResult.create("PAYED", "未找到订单信息");
				}
			}
			List<Map<String, Object>> result = new ArrayList<>();
			for(int i=0;i<orders.size();i++){
				String orderId1 = orders.get(i).getHwOrderId();
				Map<String, Object> map = new HashMap<>();
				map.put("orderId", orderId1);
				map.put("createtime", orders.get(i).getHwOrderAddtime());
				String payStatus = "";
				Integer status = yworderitemMapper.searchStatusByPos2(orderId1);
				if("R".equals(orders.get(i).getHwOrderState()))
					payStatus = "R";
				else if(status != null && status > 0)
					payStatus = "U";
				else
					payStatus = orders.get(i).getHwPaymentStatus();
				map.put("status", payStatus);
				map.put("payType", orders.get(i).getHwPayType());
				map.put("money", orders.get(i).getHwMoney());
//				List<YwOrderitem> itemList1 = yworderitemMapper.searchYwOrderitemByPos(orderId1);
				List<Map<String, Object>> itemList = yworderitemMapper.searchYwOrderitemByPos2(orderId1);
				List<Map<String, Object>> list = new ArrayList<>();
				for(int j=0;j<itemList.size();j++) {
					Map<String, Object> map1 = new HashMap<>();
					map1.put("money", itemList.get(j).get("money"));
					map1.put("goodsId", itemList.get(j).get("goodsId"));
					map1.put("itemIds", "," + itemList.get(j).get("itemIds"));
					map1.put("typeName", itemList.get(j).get("typeName"));
					map1.put("count", itemList.get(j).get("count"));
					map1.put("ticketName", itemList.get(j).get("ticketName"));
					list.add(map1);
				}
				map.put("items", list);
				result.add(map);
			}
			return StatusResult.create(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return StatusResult.create("PAYED", "系统异常");
		}
	}

	@RequestMapping(value="/pos/pay",method=RequestMethod.POST,produces = "application/json")
	@ResponseBody
	public StatusResult<String> pay() throws ParseException{
		try {
			appService.queryOrder("wwt", "12", 1, 20);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 订单可否退票验证
	 * @param staffId
	 * @return
	 * @throws ParseException
	 */
	@RestAction
	@RequestMapping(value="/pos/cancel/check",method=RequestMethod.POST,produces = "application/json")
	@ResponseBody
	public StatusResult<Object> cancelCheck(String orderId, String ip) throws ParseException{
		log.info("pos可否退票验证orderId:{},ip",orderId,ip);
		try {
			TSysStaff currentStaff = WebContext.getCurrentStaffByToken();
			StatusResult<Object> result = appService.cancelCheck(orderId, ip, currentStaff.getId());
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return StatusResult.create("PAYED", "系统异常");
		}
	}
	
}
