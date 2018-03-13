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
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.happyworlds.imgmt.entity.BuyTicketParam;
import cn.happyworlds.imgmt.entity.CpCrdtbl;
import cn.happyworlds.imgmt.entity.CpIdtype;
import cn.happyworlds.imgmt.entity.CpIndacc;
import cn.happyworlds.imgmt.entity.CpPrdgrp;
import cn.happyworlds.imgmt.entity.CpTicket;
import cn.happyworlds.imgmt.entity.CpTktype;
import cn.happyworlds.imgmt.entity.Item;
import cn.happyworlds.imgmt.entity.MIdtypeDict;
import cn.happyworlds.imgmt.entity.TSysStaff;
import cn.happyworlds.imgmt.entity.TicketShoppingCart;
import cn.happyworlds.imgmt.entity.YwOrder;
import cn.happyworlds.imgmt.entity.YwOrderitem;
import cn.happyworlds.imgmt.json.Jackson;
import cn.happyworlds.imgmt.json.TypeRef;
import cn.happyworlds.imgmt.mapper.CpCrdtblMapper;
import cn.happyworlds.imgmt.mapper.CpIndaccMapper;
import cn.happyworlds.imgmt.mapper.CpTicketMapper;
import cn.happyworlds.imgmt.mapper.ReYwOrderMapper;
import cn.happyworlds.imgmt.mapper.YwChargeMapper;
import cn.happyworlds.imgmt.mapper.YwOrderMapper;
import cn.happyworlds.imgmt.mapper.YwOrderitemMapper;
import cn.happyworlds.imgmt.mapper.YwPayrecordMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.service.AutomaticGrowthService;
import cn.happyworlds.imgmt.service.BuyCpprdgrpService;
import cn.happyworlds.imgmt.service.CpPrdgrpService;
import cn.happyworlds.imgmt.service.CpTicketService;
import cn.happyworlds.imgmt.service.CpTktypeService;
import cn.happyworlds.imgmt.service.CrdtblService;
import cn.happyworlds.imgmt.service.IdtypeDictService;
import cn.happyworlds.imgmt.service.IdtypeService;
import cn.happyworlds.imgmt.service.PaymentService;
import cn.happyworlds.imgmt.service.PrdgrpService;
import cn.happyworlds.imgmt.service.RoleService;
import cn.happyworlds.imgmt.service.SybWxPayService;
import cn.happyworlds.imgmt.service.TicketService;
import cn.happyworlds.imgmt.service.TktypeService;
import cn.happyworlds.imgmt.service.YwOrderitemService;
import cn.happyworlds.imgmt.util.DateTimes;
import cn.happyworlds.imgmt.util.HttpPostUtil;
import cn.happyworlds.imgmt.util.Requests;
import cn.happyworlds.imgmt.util.Result;
import cn.happyworlds.imgmt.util.StatusResult;
import cn.happyworlds.imgmt.util.SysDateFormat;
//import cn.happyworlds.imgmt.util.JNA.testdll;








import com.github.pagehelper.PageInfo;


@CrossOrigin
@Controller
@RequestMapping("/cpticket")
public class CpTicketController {

	@Autowired
	private CpTicketService cpTicketService;
	@Autowired
	private SybWxPayService sybwxpayservice;
	@Autowired
	private CpTicketMapper ticketMapper;
	@Autowired
	private TktypeService tktypeService;
	@Autowired
	private TicketService ticketService;
	@Autowired
	private PrdgrpService PrdgrpService;
	@Autowired
	private BuyCpprdgrpService buyCpprdgrpService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private IdtypeService IdtypeService;
	@Autowired
	private CpTktypeService cpTktypeService;
	@Autowired
	private CpPrdgrpService cpPrdgrpService;
	@Autowired
	private YwOrderMapper yworderMapper;
	@Autowired
	private YwOrderitemMapper yworderitemMapper;
	@Autowired
	private YwPayrecordMapper ywPayrecordMapper;
	@Autowired
	private ReYwOrderMapper reYwOrderMapper;
	@Autowired
	private PaymentService paymentService;
	@Value("${china-flame.apiip}")
	private String chinaFlameApiIp;
	@Autowired
	private AutomaticGrowthService automaticgrowthService;
	
	private static final Logger LOG = LoggerFactory.getLogger(CpTicketController.class);
	
	@Autowired
	private IdtypeDictService idtypeDictService;
	@Autowired
	private YwOrderitemService YwOrderitemService;
	@Autowired
	private CpTicketMapper cpTicketMapper;
	@Autowired
	private YwChargeMapper ywChargeMapper;
	@Autowired
	private CpCrdtblMapper cpCrdtblMapper;
	@Autowired
	private CpIndaccMapper cpIndaccMapper;
	@Autowired
	private CrdtblService crdtblService;
	@Autowired
	private YwOrderMapper ywOrderMapper;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	// 选中票券类别时计算折扣
	@WebAction(Permission.BUYTICKET_ADD)
	@ResponseBody
	@RequestMapping(value = "/tkpriceInf", method = RequestMethod.POST)
	public StatusResult<BigDecimal> tkpriceInf(String ttTypeId, String ticketKind) {
		String nowDate = SysDateFormat.getNowDate("yyyyMMdd");
		boolean flag = false;
		if(buyCpprdgrpService.ifLegalHoliday(nowDate)){
			flag=true;
		}
		System.out.println("-----ttTypeId---:"+ttTypeId);
		return ticketService.tkpriceInf(ttTypeId, ticketKind, flag);
	}
	
	//查询出卡面号
	@ResponseBody
	@RequestMapping(value = "/kamianhao", method = RequestMethod.POST)
	public StatusResult<String> kamianhao(String cardNo) {
		return cpTicketService.kamianhaiselect(cardNo);
	}
	//查询出卡面号
	@ResponseBody
	@RequestMapping(value = "/getMemberMsgByCardNo", method = RequestMethod.POST)
	public StatusResult<Map<String,Object>> get(String cardNo) {
		return cpTicketService.getMemberMsgByCardNo(cardNo);
	}
	
	//查询出卡面号
	@ResponseBody
	@RequestMapping(value = "/ceshi", method = RequestMethod.POST)
	public StatusResult<String> ceshi() {
		 cpTicketService.aa();
		 return null; 
	}
		
	
	//转票查询
	//@WebAction(Permission.CPTICKET_LIST)
	@RequestMapping("/list")
	public String convert(String tkCardNo, Integer p, Model m) {
		Result<PageInfo<CpTicket>> r = cpTicketService.CpAcqgrpConvertList(tkCardNo,new PageBounds(p, 10));
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("tkCardNo", tkCardNo);
			m.addAttribute("pageInfo", r.getValue());
		}
		return "cpticket/list";
	}
	
	//退票查询
	@WebAction(Permission.CPTICKET_BACK)
	@RequestMapping("/back")
	public String back(String tkCardNo, Integer p, Model m) {
		Result<PageInfo<CpTicket>> r = cpTicketService.CpAcqgrpBackList(tkCardNo,new PageBounds(p, 10));
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("tkCardNo", tkCardNo);
			m.addAttribute("pageInfo", r.getValue());
		}
		return "cpticket/back";
	}
	
	@ResponseBody
	@RequestMapping(value="/ticket/refund",method=RequestMethod.POST)
	public StatusResult<String> doRefund(String orderItems){
		String[] rsManagementList = orderItems.split(",");
		TSysStaff currentStaff = WebContext.getCurrentStaff();
		StatusResult<String> r = cpTicketService.BackTicket(rsManagementList, currentStaff.getId());
		if(r==null){
			r=StatusResult.create("SUCCESS", "退票成功");
		}
		return r;
	}
	
	//退票
	@ResponseBody
	@RequestMapping(value = "/doRemove", method = RequestMethod.POST)
	public StatusResult<String> doRemove(String rsManagement) {
		String[] rsManagementList = rsManagement.split(",");
		TSysStaff currentStaff = WebContext.getCurrentStaff();
		StatusResult<String> r = cpTicketService.BackTicket(rsManagementList, currentStaff.getId());
		if(r==null){
			r=StatusResult.create("SUCCESS", "退票成功");
		}
		return r;
	}
	
	//转票
	@ResponseBody
	@RequestMapping(value = "/doChange", method = RequestMethod.POST)
	public StatusResult<String> doChange(String tkCardNo1,String rsManagement) {
		String[] rsManagementList = rsManagement.split(",");
		TSysStaff currentStaff = WebContext.getCurrentStaff();
		StatusResult<String> r = cpTicketService.ChangeTicket(tkCardNo1, rsManagementList, currentStaff.getId());
		if(r==null){
			r=StatusResult.create("SUCCESS", "转票成功");
		}
		return r;
	}
	/**
	 * 票券种类接口 ，查询所有状态为可用，并在有效时间段的票券
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/ticketType/list",method=RequestMethod.GET, produces = "application/json")
	public StatusResult<List<CpTktype>> queryUsefulCptktype(){
		Map<String,String> params = new HashMap<String, String>();
		params.put("ttStartDate", DateTimes.date(LocalDate.now()));
		params.put("ttEndDate", DateTimes.date(LocalDate.now()));
		params.put("ttTypeStatus", "Y");
		return StatusResult.create("SUCCESS", cpTktypeService.findAllUsefulTktypeList(params));
	}
	/**
	 * 票券种类接口 ，查询所有状态为可用，并在有效时间段，并且是实名制的票券
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/ticketType/listReal",method=RequestMethod.GET, produces = "application/json")
	public StatusResult<List<CpTktype>> queryUsefulCptktypeByReal(){
		Map<String,String> params = new HashMap<String, String>();
		params.put("ttStartDate", DateTimes.date(LocalDate.now()));
		params.put("ttEndDate", DateTimes.date(LocalDate.now()));
		params.put("ttTypeStatus", "Y");
		List<CpTktype> list = cpTktypeService.findAllUsefulTktypeList(params);
		for(int i=0;i<list.size();i++) {
			if("V".equals(list.get(i).getTtTypeUser()))
				list.remove(i);
		}
		return StatusResult.create("SUCCESS", list);
	}
	@ResponseBody
	@RequestMapping(value="/objGrade/list",method=RequestMethod.GET,produces = "application/json")
	public StatusResult<List<CpPrdgrp>> queryObj(){
		return StatusResult.create("SUCCESS", cpPrdgrpService.prdgrpListObj(2000));
	}
	
	@Transactional
	@ResponseBody
	@RequestMapping(value="/buy/ticket", method = RequestMethod.POST,produces = "application/json",consumes="application/json")
	public StatusResult<?> buyTicket(@RequestBody BuyTicketParam params) throws Exception{
		String ip = "";
		ip = Requests.getRequestAddr();
		if("".equals(ip) || ip == null){
			ip = params.getHwIp();
		}
		String staffID = "";
		staffID = WebContext.getCurrentStaff().getId();
		if("".equals(staffID)){
			staffID = "customer";
		}
		YwOrder yworder = new YwOrder();
		String orderID = automaticgrowthService.nextdindang("name");
		yworder.setHwOrderId(orderID);					//订单ID
		yworder.setHwType("1");							//订单类型：1.购票，2.充值，3.消费，4.退票，5.提现
		yworder.setHwMobilePhone(params.getPhoneNumber());		//手机号					 
		yworder.setHwChannel("3");				//渠道ID:微信公众号(1),APP(2),现场(3),官网(4),5驴妈妈-6携程-7途牛-8同程-9淘宝旅行-10终端，11闸机，12智能pos
		yworder.setHwPayType(params.getPayType());			//支付方式 CASH-现金；XC_WX-微信支付；XC_ZFB-支付宝支付；JSAPI-公众号微信支付；APP-app微信；
															//POS-pos机刷卡支付；ZNPOS-智能pos刷卡支付；YLTLH5-H5快捷支付；LYK-乐园卡支付；ZD_POS-一体机pos							
		yworder.setHwMoney(params.getOrderAmount());					//金额		从接口传过来
		yworder.setHwOrderState("N");							//购票类订单状态：N正常、已退票R、部分退票P
		yworder.setHwOrderAddtime(DateTimes.newDateTime());//订单生成时间	获取当前时间
		yworder.setHwPaymentStatus("N");					//支付状态
		yworder.setHwIp(ip);					//ip地址
		yworder.setHwOperatorId(staffID);		//用户ID
		yworder.setHwCredential(params.getRealName());		//判断是否非实名，（1为实名）
		Long affectedorder = yworderMapper.insertYwOrder(yworder);
		if(affectedorder == null || affectedorder < 0){
			return StatusResult.create("FAIL", "添加订单失败");
		}
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
				ywOrderitem.setHwOperatorId(staffID);			//用户ID
				ywOrderitem.setHwMobile(params.getPhoneNumber());	//手机号
				ywOrderitem.setHwOrderitemId(automaticgrowthService.dindangitem("name"));		//订单详情ID	
				ywOrderitem.setHwProdctGroup(item.getTicketType());		//门票ID
				ywOrderitem.setHwSpecialMethod(item.getObjGrade());		//优惠方式：会员、儿童长者、周末假日，缺省平日
				ywOrderitem.setHwAmount(item.getItemAmount().multiply(new BigDecimal(item.getTicketNumber())));		//应付总额
				ywOrderitem.setHwBirthday(item.getBirthDay());			//出生日期
				ywOrderitem.setHwDiscount(item.getDiscount());			//折扣率
				ywOrderitem.setHwCredentyname(item.getCredentyName());	//证件类型
				ywOrderitem.setHwMemberId(item.getCredentyNumber());	//游客证件号码
				ywOrderitem.setHwCredentytype(item.getCredentyType());		//证件姓名
				ywOrderitem.setHwAddress(item.getAddress());			//户籍地址
				ywOrderitem.setHwOrderId(orderID);						//订单ID
				ywOrderitem.setHwSpecialcredentynumber(item.getSpecialCredentyNumber());		//特殊证件号码
				ywOrderitem.setHwSpecialcredentytype(item.getSpecialCredentyType());			//特殊证件类型（老人证，残疾人证，学生证，军人证）
				ywOrderitem.setHwCardserialno(item.getCardSerialNo());					//	卡面号				
				ywOrderitem.setHwCardhosternumber(item.getCardHosterNumber());			//  物理卡号
				ywOrderitem.setHwAdmissionTime(hwAdmisssionTime);						//用户入园时间
				ywOrderitem.setHwEndTime(hwEndTime);									//用户截至入园时间
				ywOrderitem.setHwTicketCount(item.getTicketNumber());					//订票数量
				ywOrderitem.setHwUnitPrice(item.getItemAmount().divide(new BigDecimal(item.getDiscount()),2,BigDecimal.ROUND_HALF_EVEN));	//单价			
				ywOrderitem.setHwStatus("T");								//票卷状态										
				ywOrderitem.setHwTicketName(item.getTicketName());			//票倦名称
				ywOrderitem.setHwChargeAmount(item.getRechargeAmount());
				String visitTime = params.getVisitTime()!=null?params.getVisitTime():DateTimes.nowDate();
				DateTimes.parse(visitTime, new String[] {DateTimes.DATE_PATTERN,DateTimes.TIME_STYLE,DateTimes.DATE_PATTERN2});
				ywOrderitem.setHwVisitTime(visitTime);						//交易日期
				Long affectedorderitem = yworderitemMapper.insertYwOrderitem(ywOrderitem);
				if(affectedorderitem == null || affectedorderitem < 0){
					return StatusResult.create("FAIL", "添加订单详情失败");
				}
			}
		}
		Map<String,Object> map  = new HashMap<String,Object>();
		map.put("orderId", orderID);
		map.put("amount", params.getOrderAmount());
		return StatusResult.create("SUCCESS", map );
		
	}
	
	@Transactional
	@ResponseBody
	@RequestMapping(value="/buy/start",method = RequestMethod.POST,produces = "application/json",consumes="application/json")
	public  StatusResult buyStart( @RequestBody BuyTicketParam params){
		/*if(!StringUtils.isNotEmpty(params.getPhoneNumber())){
			return StatusResult.create("FAIL", "购票人手机号码不能为空");
		}*/
		
		String clientIp = Requests.getRequestAddr();
		
		if(params.getOrderAmount()==null || params.getOrderAmount().compareTo(BigDecimal.ZERO)==0){
			 return StatusResult.create("FAIL", "购票总金额不能为空");
		}
		YwOrder yworder = new YwOrder();
		/*String staffId = WebContext.getCurrentStaff().getId();*/
		String orderID = automaticgrowthService.nextdindang("name");
		/*yworder.setHwOperatorId(staffId);*/
		yworder.setHwOrderId(orderID);
		yworder.setHwType("1");
		yworder.setHwMobilePhone(params.getPhoneNumber());		//手机号					 
		yworder.setHwChannel("3");				//渠道ID		1为微信，2为APP，3现场，4官网，5为OTA
		yworder.setHwPayType(params.getPayType());			//支付方式
		yworder.setHwMoney(params.getOrderAmount());					//金额		从接口传过来
		yworder.setHwOrderState("N");
		yworder.setHwOrderAddtime(DateTimes.newDateTime());//订单生成时间	获取当前时间
		yworder.setHwPaymentStatus("N");
		yworder.setHwIp(clientIp!= null?clientIp:params.getHwIp());
		yworder.setHwOperatorId(WebContext.getCurrentStaff().getId());
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
			/*	ywOrderitem.setHwOperatorId(staffId);*/
				ywOrderitem.setHwMobile(params.getPhoneNumber());
				ywOrderitem.setHwOrderitemId(automaticgrowthService.dindangitem("name"));	
				ywOrderitem.setHwProdctGroup(item.getTicketType());
				ywOrderitem.setHwSpecialMethod(item.getObjGrade());
				ywOrderitem.setHwAmount(item.getItemAmount().multiply(new BigDecimal(item.getTicketNumber())));
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
				ywOrderitem.setHwUnitPrice(item.getItemAmount().divide(new BigDecimal(item.getDiscount()),2,BigDecimal.ROUND_HALF_EVEN));
				ywOrderitem.setHwCredentytype(item.getCredentyType());
				ywOrderitem.setHwCredentyname(item.getCredentyName());
				ywOrderitem.setHwAddress(item.getAddress());
				ywOrderitem.setHwStatus("T");
				ywOrderitem.setHwEndTime(hwEndTime);
				ywOrderitem.setHwTicketName(item.getTicketName());
				ywOrderitem.setHwChargeAmount(item.getRechargeAmount());
				String visitTime = params.getVisitTime()!=null?params.getVisitTime():DateTimes.nowDate();
				DateTimes.parse(visitTime, new String[] {DateTimes.DATE_PATTERN,DateTimes.TIME_STYLE,DateTimes.DATE_PATTERN2});
				ywOrderitem.setHwVisitTime(visitTime);
				yworderitemMapper.insertYwOrderitem(ywOrderitem);
				if(StringUtils.isNotBlank(item.getCredentyNumber())){
					int flag = BigDecimal.ZERO.compareTo(item.getRechargeAmount());
					if(flag!=0){
						YwOrder order = new YwOrder();
						String id = automaticgrowthService.nextdindang("name");
						ids +=id+",";
						order.setHwOrderId(id);
						order.setHwChannel("3");
						order.setHwIp(params.getHwIp());
						order.setHwMobilePhone(params.getPhoneNumber());
						order.setHwMemberId(item.getCredentyNumber());
						order.setHwCustomerName(item.getCredentyName());
						order.setHwMoney(item.getRechargeAmount());
						order.setHwOrderState("N");
						order.setHwCredential(item.getCardHosterNumber());
						order.setHwOrderAddtime(hwAdmisssionTime);
						order.setHwPaymentStatus("N");
						/*order.setHwOperatorId(staffId);*/
						order.setHwType("2");
						yworderMapper.insertYwOrder(order);
					}
				}
				
			}
			yworder.setHwSonOrderList(ids);
			yworderMapper.updateYwOrder(yworder);
		}
		
		Map map  = new HashMap();
		map.put("orderId", orderID);
		map.put("amount", params.getOrderAmount());
		return StatusResult.create("SUCCESS", map );
	}
	
	/**
	 * 实名购票改订单状态
	 * @param orderId
	 * @param payType
	 * @param receiptsPrice
	 * @param hwPaymentListid
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value="/RealNameOrderStatus",method=RequestMethod.POST,produces = "application/json")
	@ResponseBody
	public StatusResult<?> RealNameOrderStatus(@RequestParam("orderId")String orderId,@RequestParam("payType") String payType,@RequestParam("receiptsPrice")BigDecimal receiptsPrice,
												@RequestParam("hwPaymentListid")String hwPaymentListid) throws Exception{
		YwOrder ywOrder = yworderMapper.searchYwOrderByHwOrderId(orderId);
		if(ywOrder != null) {
			if("Y".equals(ywOrder.getHwPaymentStatus())){
				StatusResult.create("PAYED", "该订单已支付");
			}
			ywOrder.setHwPaymentStatus("Y");
			ywOrder.setHwPayType(payType);
			ywOrder.setHwOrderPaytime(DateTimes.newDateTime());
			ywOrder.setHwPaymentListid(hwPaymentListid);
			yworderMapper.updateYwOrder(ywOrder);
			StatusResult<?> reqq = cpTicketService.RealNameCard(orderId);
			if("OK".equals(reqq.getStatus())){
				return reqq;
			}else{
				return StatusResult.create("FAIL", reqq.getComment());
			}
			
		}
		return StatusResult.create("FAIL", "查找订单为空");
	}
	
	@RequestMapping(value="/updateOrderStatus",method=RequestMethod.POST,produces = "application/json")
	@ResponseBody
	public StatusResult updateOrderStatus(@RequestParam("orderId")String orderId,@RequestParam("payType") String payType,@RequestParam("receiptsPrice")BigDecimal receiptsPrice,@RequestParam("hwPaymentListid")String hwPaymentListid) throws ParseException{
		YwOrder ywOrder =yworderMapper.searchYwOrderByHwOrderId(orderId);
		if(ywOrder!=null){
			if("Y".equals(ywOrder.getHwPaymentStatus())){
				StatusResult.create("PAYED", "该订单已支付");
			}
			ywOrder.setHwPaymentStatus("Y");
			ywOrder.setHwPayType(payType);
			ywOrder.setHwOrderPaytime(DateTimes.newDateTime());
			ywOrder.setHwPaymentListid(hwPaymentListid);
			yworderMapper.updateYwOrder(ywOrder);//流水ID		随机生成32位字母加数字
			if("10".equals(ywOrder.getHwChannel())){//终端支付完成
				return cpTicketService.ticketProcessByZD(ywOrder);
			}
			if("3".equals(ywOrder.getHwChannel())){

				

				if(StringUtils.isNotBlank(ywOrder.getHwMobilePhone())){
					String staffId = WebContext.getCurrentStaff().getId();
					cpTicketService.cartCardAndBuy(orderId, staffId);
				}
				
			}
			String sonOrdrList =ywOrder.getHwSonOrderList();
			if(StringUtils.isNotEmpty(sonOrdrList)){
				String[] ids=sonOrdrList.split(",");
				String hwPayTime = DateTimes.getDateTime(new Date());
				for(String id:ids){
					if(StringUtils.isNotEmpty(id)){
						YwOrder ord =yworderMapper.searchYwOrderByHwOrderId(id);
						ord.setHwPaymentStatus("Y");
						ord.setHwPaymentListid(hwPaymentListid);
						ord.setHwOrderPaytime(hwPayTime);
						ord.setHwPayType(payType);
						yworderMapper.updateYwOrder(ord);
						CpCrdtbl cpCrdtbl =cpCrdtblMapper.searchCpCrdtblByCbCardholderNo("333502"+ord.getHwCredential());
						Map<String,String> paramMap = new HashMap<String,String>();
						paramMap.put("cbIndCardholderNo", cpCrdtbl.getCbCardholderNo());
						List<CpIndacc> cpIndaccs =cpIndaccMapper.searchCpIndaccByParams(paramMap);
						CpIndacc cpIndacc =cpIndaccs.get(0);
						cpIndacc.setCbOutstdBal(cpIndacc.getCbOutstdBal().add(ord.getHwMoney()));
						//將退票金额退回会员卡
						cpIndaccMapper.updateCpIndacc(cpIndacc);
					}
				}
			}
			return  StatusResult.create("SUCCESS", receiptsPrice);
		}
		return StatusResult.create("FAIL", "更新订单状态失败");
	}

	
	@RequestMapping(value="/queryItemsByOrderId",method=RequestMethod.GET)
	public String queryOrderItemsByOrderId(String orderId,Model model,String receiptsPrice){
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
		return "ticket/buyTicketDetail";
	}
	
	
	@RequestMapping(value="/queryItemsByOrderId2",method=RequestMethod.GET)
	public String queryOrderItemsByOrderId2(String orderId,Model model,String receiptsPrice){
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
			 String sql = "select hw_prodct_group,hw_special_method,hw_ticketname,hw_unit_price,COUNT(hw_ticket_count) hw_ticket_count,sum(hw_amount) hw_amount from yw_orderitem where hw_order_id = '"+orderId+"' group by hw_prodct_group,hw_special_method,hw_ticketname,hw_unit_price order by COUNT(hw_ticket_count) desc";
			 List list = jdbcTemplate.queryForList(sql);
			 model.addAttribute("countitem",list);
			 model.addAttribute("orderItems",rs.getValue().getList());
			 Map<String,String> paramMap = new HashMap<String, String>();

			 
			 ywChargeMapper.searchYwChargeByParams(paramMap);
			 YwOrder ywOrder = yworderMapper.searchYwOrderByHwOrderId(orderId);
			 ywOrder.setHwMoney(ywOrder.getHwMoney().setScale(2,BigDecimal.ROUND_HALF_UP));
			 model.addAttribute("ywOrder",ywOrder);
			 model.addAttribute("receiptsPrice", receiptsPrice);
		}
		return "ticket/buyTicketDetail2";
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
	
	@ResponseBody
	@RequestMapping(value="/ticket/query",method=RequestMethod.POST,produces = "application/json")
	public StatusResult queryOrderItems(String orderId,String phoneNumber){
		Map<String,String> paramMap = new HashMap<String, String>();
		if(StringUtils.isNotEmpty(orderId)){
			paramMap.put("hwOrderId", orderId);
			List<YwOrderitem> items =yworderitemMapper.searchYwOrderitemByParams(paramMap);
			for(YwOrderitem item:items){
				CpTicket type=ticketMapper.searchCpTicketByTkTicketId(Long.parseLong(item.getHwOrderitemId()));
				CpTktype tkType =cpTktypeService.searchCpTktypeByTtTypeId(Integer.parseInt(item.getHwProdctGroup()));
				if(tkType!=null){
					item.setHwTicketName(tkType.getTtTypeDesc());
				}
				
				if(type!=null){
					item.setIsBind(Boolean.TRUE);
				}else{
					item.setIsBind(Boolean.FALSE);
				}
			}
			return StatusResult.create("SUCCESS", items);
		}
		if(StringUtils.isNotEmpty(phoneNumber)){
			paramMap.put("hwMobilePhone", phoneNumber);
			paramMap.put("hwPaymentStatus", "Y");
			List<YwOrder> orders =yworderMapper.searchYwOrderByParams(paramMap);
			paramMap.remove("hwMobilePhone");
			paramMap.remove("hwPaymentStatus");
			List<YwOrderitem> list = new ArrayList<YwOrderitem>();
			for(YwOrder order:orders){
				paramMap.put("hwOrderId", order.getHwOrderId());
				List<YwOrderitem> items =yworderitemMapper.searchYwOrderitemByParams(paramMap);
				for(YwOrderitem item:items){
					CpTicket type=ticketMapper.searchCpTicketByTkTicketId(Long.parseLong(item.getHwOrderitemId()));
					CpTktype tkType =cpTktypeService.searchCpTktypeByTtTypeId(Integer.parseInt(item.getHwProdctGroup()));
					if(tkType!=null){
						item.setHwTicketName(tkType.getTtTypeDesc());
					}
					if(type!=null){
						item.setIsBind(Boolean.TRUE);
					}else{
						item.setIsBind(Boolean.FALSE);
					}
				}
				list.addAll(items);
				paramMap.remove("hwOrderId");
			}
			
			return StatusResult.create("SUCCESS", list);
		};
		 return StatusResult.create("FAIL", "请输入查询信息");
	}
	@ResponseBody
	@RequestMapping(value="/ticket/queryByCardNo",method=RequestMethod.POST,produces = "application/json")
	public StatusResult queryOrderItems(String cardNo){
		Map<String,String> paramMap = new HashMap<String, String>();
		paramMap.put("tkStatus", "T");
		paramMap.put("tkCardNo", cardNo);
		if(StringUtils.isNotEmpty(cardNo)){
			List<CpTicket>  tickets =cpTicketMapper.searchCpTicketByParams(paramMap, new PageBounds(1, 20));
			for(CpTicket ticket: tickets){
				YwOrderitem orderItem =yworderitemMapper.searchYwOrderitemByHwOrderitemId(String.valueOf(ticket.getTkTicketId()));
				ticket.setCredentyName(orderItem.getHwCredentyname());
				ticket.setCredentyNumber(orderItem.getHwMemberId());
				ticket.setTicketName(orderItem.getHwTicketName());
			}
			return StatusResult.create("SUCCESS", tickets);
		}
		return StatusResult.create("FAIL", "请输入查询信息");
	}	
	
	@WebAction(Permission.NON_REAL_NAME_VOTING)
	@RequestMapping("/tictek")
	public String NonNameticket(){
		
		return "ticket/tictek";
	}
	
	//移动POS机跳转页面  
	@RequestMapping(value = "/feishiming", method = RequestMethod.GET)
	public String feishiming(Model m) {
		
		return "ticket/feishiming";
	}
	
	//查看购物车
	@WebAction(Permission.CART_SHOW)
	@RequestMapping(value = "/cart_show", method = RequestMethod.GET)
	public String cart_select(Model m) {
		String staffId = WebContext.getCurrentStaff().getId();
		Result<List<TicketShoppingCart>> TicketShoppingCartList = cpTicketService.ticketshoppingcartShow(staffId);	
		m.addAttribute("TicketShoppingCart", TicketShoppingCartList.getValue());
		return "ticket/cartlist";
	}
	
	//购物车结算
	
	@WebAction(Permission.CART_ADD)
	@RequestMapping("/cart_ticket")
	public String cart_ticket(RedirectAttributes ra) throws ParseException{
		String staffId = WebContext.getCurrentStaff().getId();
		Result<List<TicketShoppingCart>> TicketShoppingCartList = cpTicketService.ticketshoppingcartShow(staffId);	
		List<TicketShoppingCart> list = TicketShoppingCartList.getValue();
		List<Object> list2 = new ArrayList<Object>();
		for(int i = 0; i<list.size(); i++){
			Map<String, String> rv = new HashMap<String, String>();	
			TicketShoppingCart ticket = list.get(i);
			rv.put("mobile", ticket.getMobile());
			rv.put("amount", ticket.getAmount());
			rv.put("ticketType", ticket.getTicketType());
			rv.put("varTkPaperNo", ""+ticket.getVarTkPaperNo());
			rv.put("specialCertificate", ticket.getSpecialCertificate());
			rv.put("specialCertificateNumber", ticket.getSpecialCertificateNumber());
			rv.put("ticketform", ticket.getTicketform());
			rv.put("varoldPrdgrp", ticket.getVaroldPrdgrp());
			rv.put("CbRwdsAccno", ticket.getCbRwdsAccno());
			rv.put("cbCardholderNo", ticket.getCbCardholderNo());
			rv.put("cbIdType", ticket.getCbIdType());
			rv.put("idNo", ticket.getIdNo());
			rv.put("uname", ticket.getUname());
			rv.put("birthday", ticket.getBirthday());			
			rv.put("Address", ticket.getAddress());
			rv.put("vartkAmount", ticket.getVartkAmount());
			rv.put("totalAmountPaid", ticket.getTotalAmountPaid());
			rv.put("shoppingId", ""+ticket.getShoppingId());
			list2.add(rv);	
		}
		JSONArray json = JSONArray.fromObject(list2); 
		
		StatusResult<String> status =cpTicketService.cartCardAndBuy(json.toString(),staffId);
		if("OK".equals(status.getStatus())){
			ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "购票成功");
			return "redirect:/cpticket/cart_show";
				
		}else{
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, status.getComment());
			return "redirect:/cpticket/cart_show";
		}
		
	}   
	
	
	//购票页面
	@WebAction(Permission.BUYTICKET_ADD)
	@RequestMapping(value = "/ceshi2", method = RequestMethod.GET)
	public String ceshi2(Model m) {
		Result<List<CpPrdgrp>> prdGrpList = PrdgrpService.prdGrpListAll();
		Result<List<CpTktype>> tkTypeList = tktypeService.tktypeListAll();
		Result<List<CpIdtype>> idTypeList = IdtypeService.idTypeListAll();
		String nowDate = SysDateFormat.getNowDate("yyyyMMdd");
		tkTypeList=ticketService.getTkTypeList(nowDate,tkTypeList);
		if(buyCpprdgrpService.ifLegalHoliday(nowDate)){			
			List<CpTktype> tkTypeAll = tkTypeList.getValue();
			for (int i = 0; i < tkTypeAll.size(); i++) {
				BigDecimal Price = tkTypeAll.get(i).getTtListPrice().multiply(new BigDecimal(0.8));
				Price=(Price.setScale(0,BigDecimal.ROUND_HALF_UP));
				tkTypeAll.get(i).setTtListPrice(Price);
				m.addAttribute("tkTypeList", tkTypeAll);
			}
		}else{
			m.addAttribute("tkTypeList", tkTypeList.getValue());
		}
		StatusResult<PageInfo<MIdtypeDict>> r = idtypeDictService.midTypeDictList(null, null, new PageBounds(1, 10));
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		}
		m.addAttribute("prdGrpList", prdGrpList.getValue());
		m.addAttribute("idTypeList", r.getValue().getList());
		m.addAttribute("nowDate", nowDate);
		m.addAttribute("roles", roleService.roleList());
		return "ticket/ceshi2";
	}

	//购票页面
	@WebAction(Permission.BUYTICKET_ADD)
	@RequestMapping("/shuaka")
	public String shuaka(TicketShoppingCart tsc,HttpServletRequest request){
		HttpSession session=request.getSession();
		session.setAttribute("tsc", tsc);
		return "ticket/shuaka";
	}
	
	//购票页面
	@WebAction(Permission.BUYTICKET_ADD)
	@RequestMapping("/tixian")
	public String shuakapay(Model m){
		StatusResult<PageInfo<MIdtypeDict>> r = idtypeDictService.midTypeDictList(null, null, new PageBounds(1, 10));
		m.addAttribute("idTypeList", r.getValue().getList());
		return "ticket/tixian";
	}
	
	//根据卡面号查询卡信息
	@ResponseBody
	@RequestMapping(value="/Crdtbl/CRN",method=RequestMethod.GET, produces = "application/json")
	public Result byCbRecommenderNo(String cbRecommenderNo){
		CpCrdtbl crdtbl = null;
		if(StringUtils.isEmpty(cbRecommenderNo)){
			return Result.create("FAIL", "卡面号为空");
		}
		cbRecommenderNo = "HWCARD"+cbRecommenderNo;
		try {
			crdtbl = crdtblService.byCbRecommenderNo(cbRecommenderNo);
			if(Objects.isNull(crdtbl) && cbRecommenderNo.length() >= 14){
				crdtbl = crdtblService.getCrdtblByRwdsAccnoAndUsing(cbRecommenderNo.substring(6, 14));
			}
			if(org.springframework.util.StringUtils.isEmpty(crdtbl)){
				return Result.create("FAIL", "未找到会员卡信息");
			}
			CpIndacc indacc = cpIndaccMapper.searchCpIndaccByAcctNo(crdtbl.getCbIndividualAcctno());
			if(org.springframework.util.StringUtils.isEmpty(indacc)){
				return Result.create("FAIL", "未找到对应账户");
			}
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("CARD", crdtbl.getCbBasicCardholderNo());
			map.put("name", crdtbl.getCbEmbossname());
			map.put("amount", indacc.getCbOutstdBal());
			return Result.create("SUCCESS", map);
		} catch (Exception e) {
			return Result.create("FAIL", e);
		}	
	}
	
	
	@ResponseBody
	@RequestMapping(value="/bychongzhi",method=RequestMethod.GET, produces = "application/json")
	public Result bychongzhi(String orderid){
		if(StringUtils.isEmpty(orderid)){
			return Result.create("FAIL", "订单ID不能为空");
		}
		try {
			YwOrder ywOrder= ywOrderMapper.searchYwOrderByHwOrderId(orderid);
			if(org.springframework.util.StringUtils.isEmpty(ywOrder)){}
			CpCrdtbl cpCrdtbl = cpCrdtblMapper.searchCpCrdtblByCbIdno(ywOrder.getHwMemberId());
			if(org.springframework.util.StringUtils.isEmpty(cpCrdtbl)){
				return Result.create("FAIL", "未找到会员卡信息");
			}
			CpIndacc indacc = cpIndaccMapper.searchCpIndaccByAcctNo(cpCrdtbl.getCbIndividualAcctno());
			if(org.springframework.util.StringUtils.isEmpty(indacc)){
				return Result.create("FAIL", "未找到对应账户");
			}
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("a", indacc.getCbOutstdBal().subtract(ywOrder.getHwMoney()));
			map.put("b", ywOrder.getHwMoney());
			map.put("c", indacc.getCbOutstdBal());
			return Result.create("SUCCESS", map);
		} catch (Exception e) {
			return Result.create("FAIL", e);
		}	
	}
	
	
	
	//购票页面
	@ResponseBody
	@RequestMapping(value = "/idyz", method = RequestMethod.POST)
	public int shuakapay(String id){
		int i =cpTicketService.authentication(id.substring(6, 14));
		return i;
	}
	
	
	/**
	 * 现场支付 ---微信扫码，支付宝扫码收款
	 * @param formAmount
	 * @param payCode
	 * @param ra
	 * @param request
	 * @param formOrderId
	 * @param payType
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/tonglian/pay", method = RequestMethod.POST,produces = "application/json")
	public StatusResult<String> testPay(@RequestParam("formAmount") BigDecimal formAmount,@RequestParam("payCode") String payCode,RedirectAttributes ra,HttpServletRequest request,@RequestParam("formOrderId")String formOrderId,@RequestParam("payType")String payType) throws Exception{
		long trxamt = formAmount.multiply(new BigDecimal("100")).longValue();
		Map<String, String> map =new HashMap<String, String>();
		System.out.println(formAmount+"-"+formOrderId);
		try{
			if("LYK".equals(payType)){
				String url = "http://"+chinaFlameApiIp+"/openapi/member/Member_consumption";
				Map<String,String> params = new HashMap<String,String>();
		        params.put("cbRecommenderNo",payCode ); 
		        params.put("amount", formAmount.toString());
		        params.put("hwchannel", "3");
		        params.put("paytype", "LYK");
		        params.put("type", "3");
		        JSONObject jsonObj = JSONObject.fromObject(params);
				String receive = HttpPostUtil.doPost(url, jsonObj.toString());
				Map<String, String> val = Jackson.readJson(receive, new TypeRef<Map<String, String>>());
				if("OK".equals(val.get("status"))){					
					return this.updateOrderStatus(formOrderId, payType, new BigDecimal("0"), val.get("value"));
				}				
			}else{
				
				/*System.out.println("扫码枪调通联支付接口时间："+new Date());
				long t1 = System.currentTimeMillis();*/
				map= sybwxpayservice.pay(trxamt, formOrderId, payType, "购票", "欢乐大世界购票", "", payCode,"","");
				long t2 = System.currentTimeMillis();				
				System.out.println("++++++++:"+map);
				if("0000".equals(map.get("trxstatus"))){
					if("W04".equals(payType)){
						payType ="XC_WX";
					}else if ("A04".equals(payType)){
						payType="XC_ZFB";
					}
					return this.updateOrderStatus(formOrderId, payType, new BigDecimal("0"), map.get("trxid"));
				}
			}
			
		}catch (Exception e) {
				for(String key:map.keySet()){
					System.out.println(key+":"+map.get(key));
				}
		}
		return StatusResult.create("FAIL", "支付失败");
	}
	/**
	 * 现场支付 ---微信扫码，支付宝扫码收款
	 * @param formAmount
	 * @param payCode
	 * @param ra
	 * @param request
	 * @param formOrderId
	 * @param payType
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/tonglian/pay_old", method = RequestMethod.POST,produces = "application/json")
	public StatusResult<String> testPayOld(@RequestParam("formAmount") BigDecimal formAmount,@RequestParam("payCode") String payCode,RedirectAttributes ra,HttpServletRequest request,@RequestParam("formOrderId")String formOrderId,@RequestParam("payType")String payType) throws Exception{
		long trxamt = formAmount.multiply(new BigDecimal("100")).longValue();
		Map<String, String> map =new HashMap<String, String>();
		System.out.println(formAmount+"-"+formOrderId);
		try{
			if("LYK".equals(payType)){
				String url = "http://"+chinaFlameApiIp+"/openapi/member/Member_consumption";
				Map<String,String> params = new HashMap<String,String>();
		        params.put("cbRecommenderNo",payCode ); 
		        params.put("amount", formAmount.toString());
		        params.put("hwchannel", "3");
		        params.put("paytype", "LYK");
		        params.put("type", "3");
		        JSONObject jsonObj = JSONObject.fromObject(params);
				String receive = HttpPostUtil.doPost(url, jsonObj.toString());
				Map<String, String> val = Jackson.readJson(receive, new TypeRef<Map<String, String>>());
				if("OK".equals(val.get("status"))){					
					return this.updateOrderStatus(formOrderId, payType, new BigDecimal("0"), val.get("value"));
				}				
			}else{
				
				/*System.out.println("扫码枪调通联支付接口时间："+new Date());
				long t1 = System.currentTimeMillis();*/
				map= sybwxpayservice.pay_old(trxamt, formOrderId, payType, "购票", "欢乐大世界购票", "", payCode,"","");
				long t2 = System.currentTimeMillis();				
				System.out.println("++++++++:"+map);
				if("0000".equals(map.get("trxstatus"))){
					if("W04".equals(payType)){
						payType ="XC_WX";
					}else if ("A04".equals(payType)){
						payType="XC_ZFB";
					}
					return this.updateOrderStatus(formOrderId, payType, new BigDecimal("0"), map.get("trxid"));
				}
			}
			
		}catch (Exception e) {
				for(String key:map.keySet()){
					System.out.println(key+":"+map.get(key));
				}
		}
		return StatusResult.create("FAIL", "支付失败");
	}
	@RequestMapping(value="/tonglian/pos",method=RequestMethod.POST)
	@ResponseBody
	public StatusResult posPay(String business_id,String amount,String orderId,String ip ){
		ip ="192.168.1.40";
		StatusResult<String> receive=null;;
		try {
			System.out.println("===========40");
			receive = sybwxpayservice.batchzhinengPOS(ip,business_id,amount,orderId);
			String value =receive.getValue();
			Map<String ,Object> map =Jackson.readJson(value,  new TypeRef<Map<String,Object>>());
			for (String key:map.keySet()) {
				System.out.println(key+":"+map.get(key));
			}
			if("00".equals(map.get("rejcode"))){
				receive= this.updateOrderStatus(orderId, "ZNPOS", new BigDecimal("0"), (String)map.get("ref_no"));
			}else{
				receive = StatusResult.create("FAIL", "参数错误");
			}
		} catch (Exception e) {
			receive = StatusResult.create("FAIL", "参数错误");
		}
		return receive;
	}
	
	@RequestMapping(value="/tonglian/pos41",method=RequestMethod.POST)
	@ResponseBody
	public StatusResult posPay41(String business_id,String amount,String orderId,String ip ){
		ip ="192.168.1.41";
		StatusResult<String> receive=null;;
		try {
			System.out.println("===========41");
			receive = sybwxpayservice.batchzhinengPOS(ip,business_id,amount,orderId);
			String value =receive.getValue();
			Map<String ,Object> map =Jackson.readJson(value,  new TypeRef<Map<String,Object>>());
			for (String key:map.keySet()) {
				System.out.println(key+":"+map.get(key));
			}
			if("00".equals(map.get("rejcode"))){
				receive= this.updateOrderStatus(orderId, "POS", new BigDecimal("0"), (String)map.get("ref_no"));
			}else{
				receive = StatusResult.create("FAIL", "参数错误");
			}
		} catch (Exception e) {
			receive = StatusResult.create("FAIL", "参数错误");
		}
		return receive;
	}
	
	@CrossOrigin
	@RequestMapping(value="/queryOrder",method=RequestMethod.POST)
	@ResponseBody
	public StatusResult<List<YwOrder>> queryOrder(String state , String startTime,String endTime){
		Map params = new HashMap();
		params.put("hwOrderState", state);
		if(StringUtils.isNotEmpty(startTime)){
			params.put("hwOrderAddtimeStart", startTime);
		}
		if(StringUtils.isNotEmpty(endTime)){
			params.put("hwOrderAddtimeEnd", endTime);
		}
		
		
		List<YwOrder> orders =reYwOrderMapper.searchYwOrderStat(params, new PageBounds(0, Integer.MAX_VALUE));
		return StatusResult.create("success", orders);
	}

	@CrossOrigin
	@RequestMapping(value="/queryOrder_receive",method=RequestMethod.POST)
	@ResponseBody
	public StatusResult<List<YwOrder>> queryOrder_receive(String state , String startTime,String endTime,String paymentStatus){
		Map params = new HashMap();
		params.put("hwOrderState", "PR");
		if(StringUtils.isNotEmpty(startTime)){
			params.put("hwOrderAddtimeStart", startTime);
		}
		if(StringUtils.isNotEmpty(endTime)){
			params.put("hwOrderAddtimeEnd", endTime);
		}
		if(StringUtils.isNotEmpty(paymentStatus)){
			params.put("hwPaymentStatus", paymentStatus);
		}
		List<YwOrder> orders =reYwOrderMapper.searchYwOrderStat2(params, new PageBounds(0, Integer.MAX_VALUE));
		for(YwOrder order :orders){
			params.clear();
			params.put("hwOrderId", order.getHwOrderId());
			order.setTicketNumber(yworderitemMapper.searchYwOrderitemByParams(params).size());
		}
		return StatusResult.create("success", orders);
	}
	

	@CrossOrigin
	@RequestMapping(value="/queryByChannel",method=RequestMethod.POST)
	@ResponseBody
	public StatusResult<List<YwOrder>> queryByChannel(String startTime,String endTime){
		Map map = new HashMap<String, String>();
		map.put("startTime", startTime+" 000000");
		map.put("endTime", endTime+" 235959");
		List<YwOrder> orders =reYwOrderMapper.searchEachChannel(map);
		return StatusResult.create("success", orders);
	}
	
	/**
	 * 现场---微信扫码、支付宝扫码，撤销退票
	 * @param orderId
	 * @param ra
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/tonglian/cancel", method = RequestMethod.POST,produces = "application/json")
	@Transactional
	public StatusResult<String> cancelPay(@RequestParam("orderId")String orderId,RedirectAttributes ra,HttpServletRequest request) throws Exception{
		try{
			TSysStaff currentStaff = WebContext.getCurrentStaff();
			return paymentService.cancel(orderId, currentStaff.getId());
		}catch (Exception e) {
			e.printStackTrace();
			return StatusResult.create("FAIL", "系统异常");
		}
	}
	/**
	 * 现场---微信扫码、支付宝扫码--根据订单号退款
	 * @param orderId
	 * @param ra
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/tonglian/refund/order", method = RequestMethod.POST,produces = "application/json")
	@Transactional
	public StatusResult<?> refundOrder(String orderId,String PaymentListid,RedirectAttributes ra,HttpServletRequest request) throws Exception{
		try{
			
			TSysStaff currentStaff = WebContext.getCurrentStaff();
			return paymentService.refundByOrder(orderId, currentStaff.getId(),PaymentListid);
		}catch (Exception e) {
			e.printStackTrace();
			return StatusResult.create("FAIL", "系统异常"); 
		}
	}
	/**
	 * 现场---微信扫码、支付宝扫码--根据票号退款
	 * @param orderId
	 * @param ra
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/tonglian/refund/item", method = RequestMethod.POST,produces = "application/json")
	@Transactional
	public StatusResult<String> refundItem(String itemId,RedirectAttributes ra,HttpServletRequest request) throws Exception{
		try{
			TSysStaff currentStaff = WebContext.getCurrentStaff();
			return paymentService.refund(itemId, currentStaff.getId());
		}catch (Exception e) {
			e.printStackTrace();
			return StatusResult.create("FAIL", "系统异常");
		}
	}
}
