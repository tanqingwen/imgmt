package cn.happyworlds.imgmt.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpCrdtbl;
import cn.happyworlds.imgmt.entity.CpIndacc;
import cn.happyworlds.imgmt.entity.CpMermst;
import cn.happyworlds.imgmt.entity.TSysRole;
import cn.happyworlds.imgmt.entity.YwOrder;
import cn.happyworlds.imgmt.entity.YwOrderitem;
import cn.happyworlds.imgmt.json.Jackson;
import cn.happyworlds.imgmt.json.TypeRef;
import cn.happyworlds.imgmt.mapper.CpCrdtblMapper;
import cn.happyworlds.imgmt.mapper.CpIndaccMapper;
import cn.happyworlds.imgmt.mapper.YwOrderMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.service.StatService;
import cn.happyworlds.imgmt.service.TicketService;
import cn.happyworlds.imgmt.service.YwOrderService;
import cn.happyworlds.imgmt.service.YwOrderitemService;
import cn.happyworlds.imgmt.util.Result;
import cn.happyworlds.imgmt.util.StatusResult;
import cn.happyworlds.imgmt.util.Strings;
import cn.happyworlds.imgmt.util.SysDateFormat;

@CrossOrigin
@Controller
@RequestMapping("/yworder")
public class YwOrderController {
	
	@Autowired
	private YwOrderService ywOrderService;
	@Autowired
	private YwOrderitemService ywOrderitemService;
	@Autowired
	private StatService statService;
	@Autowired
	private TicketService ticketService;
	@Autowired
	private YwOrderMapper ywOrderMapper;
	@Autowired
	private CpCrdtblMapper cpCrdtblMapper;
	@Autowired
	private CpIndaccMapper cpIndaccMapper;
	
	//订单查询页面字段，订单号，手机号，开始添加时间，结束添加时间
	private void YworderQueryStatCondition(HttpServletRequest request, Model model,String nowtime,String nowtimeOnoneMonth) {
		String paras[] = {"hwOrderId" ,"hwMobilePhone" ,"hwOrderAddtimeStart","hwOrderAddtimeEnd"};
		for (int i = 0; i < paras.length; i++) {
			model.addAttribute(paras[i], request.getParameter(paras[i]));
		}
		String hwOrderAddtimeStart=request.getParameter("hwOrderAddtimeStart");
		String hwOrderAddtimeEnd=request.getParameter("hwOrderAddtimeEnd");
		if(hwOrderAddtimeStart==null&&hwOrderAddtimeEnd==null){
			model.addAttribute("hwOrderAddtimeStart", nowtimeOnoneMonth);
			model.addAttribute("hwOrderAddtimeEnd", nowtime);
		}
	}
	
	//订单查询，返回查询字段订单号，会员号，手机号，通道，支付列表号，金额，订单状态，凭据，添加时间，支付时间，完成时间，详情
	@WebAction(Permission.ORDER_QUERY)
	@RequestMapping("/yworderQueryStat")
	public String yworderQueryStat(HttpServletRequest  request, Integer p, Model m) {
		String nowtime = SysDateFormat.getNowDate("yyyyMMdd");
		String nowtimeOnoneMonth = ticketService.getSpecifiedDayAfterBynum(nowtime,-30);
		YworderQueryStatCondition(request, m,nowtime,nowtimeOnoneMonth);
		
		String hwOrderId=request.getParameter("hwOrderId");
		String hwMobilePhone=request.getParameter("hwMobilePhone");
		String hwOrderAddtimeStart=request.getParameter("hwOrderAddtimeStart");
		String hwOrderAddtimeEnd=request.getParameter("hwOrderAddtimeEnd");
		

		if(hwOrderAddtimeStart==null&&hwOrderAddtimeEnd==null){
			hwOrderAddtimeStart = nowtimeOnoneMonth;
			hwOrderAddtimeEnd = nowtime+" 23:59:59";
		}else{
			hwOrderAddtimeEnd += " 23:59:59";
		}
		hwOrderAddtimeStart =hwOrderAddtimeStart.replace("-", "");
		hwOrderAddtimeEnd =hwOrderAddtimeEnd.replace("-", "");
		Result<PageInfo<YwOrder>> result = statService.yworderQueryStatMethod(hwOrderId,hwMobilePhone, hwOrderAddtimeStart,hwOrderAddtimeEnd, new PageBounds(p,10));  
		
		if (result.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("pageInfo", result.getValue());
			System.out.println("+++++"+result.getValue());
		}
		return "stat/yworderQueryStat";
	}
	
	//订单详情，返回查询字段订单项号，订单号，商品组，准许进入时间，单价，票数，数量，特别方法，状态
	@RequestMapping("/yworderDetail")
	public String yworderDetail(String hwOrderId,Integer p, Model m) {
		YwOrder ywOrder =ywOrderMapper.searchYwOrderByHwOrderId(hwOrderId);
		String sonOrderList =ywOrder.getHwSonOrderList();
		String[] ids = new String[1];
		if(StringUtils.isNotEmpty(sonOrderList)) {
			ids = sonOrderList.split(",");
		}else {
			ids[0] = ywOrder.getHwOrderId();
		}
		List<Map> list = new ArrayList<Map>();		
		/*if(StringUtils.isNotEmpty(sonOrderList)){
			String[] ids = sonOrderList.split(",");*/
			for(String id:ids){
				if(StringUtils.isNotEmpty(id)){
					Map<String,Object> map = new HashMap<String, Object>();
					YwOrder order =ywOrderMapper.searchYwOrderByHwOrderId(id);
					if(order.getHwMemberId() == null ||order.getHwMemberId().equals("")){
						map.put("card", order.getHwCredential());
						map.put("amount", order.getHwMoney());
						map.put("oramount", "");
						map.put("CbOutstdBal", "");
						list.add(map);
					}else{
						CpCrdtbl cpCrdtbl = cpCrdtblMapper.searchCpCrdtblByCbIdno(order.getHwMemberId());
						if(cpCrdtbl == null){
							map.put("card", order.getHwCredential());
							map.put("amount", order.getHwMoney());
							map.put("oramount", "");
							map.put("CbOutstdBal", "");
							list.add(map);
						}else{
							CpIndacc cpindacc = cpIndaccMapper.searchCpIndaccByAcctNo(cpCrdtbl.getCbIndividualAcctno());
							map.put("card", order.getHwCredential());
							map.put("amount", order.getHwMoney());
							map.put("oramount", cpindacc.getCbOutstdBal().subtract(order.getHwMoney()));
							map.put("CbOutstdBal", cpindacc.getCbOutstdBal());
							list.add(map);
						}
						
					}
					
					
					
				}
			}
		/*}*/		
		m.addAttribute("orders",list);
		Result<PageInfo<YwOrderitem>> ywOrderitem = ywOrderitemService.searchYwOrderitemByhwOrderId(hwOrderId, new PageBounds(p,10));  
		if (ywOrderitem.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("ywOrderitem", ywOrderitem.getValue());
		}
		return "stat/yworderDetail";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(String hwMobilePhone,String hwOrderId, Integer p, Model m) {
		Result<PageInfo<YwOrder>> r = ywOrderService.ywOrderList(hwMobilePhone,hwOrderId,new PageBounds(p,10));
		if (r.isError()){
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("pageInfo", r.getValue());
		}
		return "order/list";
	}
	
	/**
	 * 通过订单编号查询订单详细信息
	 */
	@ResponseBody
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public List<YwOrderitem> show(String hwOrderId, Model m) {
		List<YwOrderitem> r  = ywOrderService.ywOrderLists(hwOrderId);
		System.out.println("test   "+r.get(0).getHwOrderitemId()+"");
		return r;
	}
	
	
	/**
	 * 通过票劵编号查询票券详情信息
	 */
	@ResponseBody
	@WebAction(Permission.STAFF_SHOW)
	@RequestMapping(value = "/find",method = RequestMethod.GET)
	public YwOrderitem showUI(String hwOrderitemId) {
		YwOrderitem r = ywOrderService.ywOrderGetById(hwOrderitemId);
		return r;
	}
	
	@WebAction(Permission.STAFF_RESET_PASSWORD)
	@RequestMapping("/delete")
	public String delete(String hwOrderId, RedirectAttributes ra) {
		ywOrderService.deleteYwOrderByHwOrderId(hwOrderId);
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "订单信息删除成功");
		return "redirect:/yworder/list";
	}
	
	/**
	 * 多种查询方式查询订单信息
	 */
	@ResponseBody
	@RequestMapping(value="/orderparams",method=RequestMethod.GET)
	public StatusResult<?> orderparams(@RequestParam("data")String data){
		if(data == null || "".equals(data)){
			return StatusResult.create("FAIL", "入参数据为空:"+data);
		}
		//List<YwOrder> list = new ArrayList<YwOrder>();
		List<YwOrder> list =ywOrderService.yworderlist(data);
		if(list == null){
			return StatusResult.create("FAIL", "查询数据为空");
		}
		return StatusResult.create(list);
	}
	
	@WebAction(Permission.ORDER_REFUND_LIST)
	@RequestMapping(value = "/orderrefund", method = RequestMethod.GET)
	public String orderrefund(String orderId, Integer p,Map<String,Object> map,HttpSession session) {
		Result<PageInfo<YwOrder>> result = ywOrderService.tuiPiaoList(orderId,new PageBounds(p, 10));
		map.put("YwOrder", result.getValue());
		
		return "order/orderrefund";
	}
	
	
	/*//订单查询，返回查询字段订单号，会员号，手机号，通道，支付列表号，金额，订单状态，凭据，添加时间，支付时间，完成时间，详情
	@ResponseBody	
	@RequestMapping(value ="/yworderbuyID", method = RequestMethod.POST)
	public String yworderQueryStat(String orderId, Model m) {
		try {			
			StatusResult<?> result = ywOrderService.YworderbuyId(orderId);
			m.addAttribute("yworder", result.getValue());
			return "order/orderrefund";
		} catch (Exception e) {
			e.printStackTrace();
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
			return "order/orderrefund";
		}	  
	}*/
	
	/*@WebAction(Permission.ORDER_REFUND_LIST)
	@RequestMapping(value ="/yworderbuyID", method = RequestMethod.POST)
	public String yworderbuyID(String orderId, Model m) {
		StatusResult<?> result = ywOrderService.YworderbuyId(orderId);
		if (result.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, result.getComment());
			return "redirect:/yworder/orderrefund";
		}
		m.addAttribute("yworder", result.getValue());
		return "order/orderrefund";
	}*/
	
	@WebAction(Permission.ORDER_REFUND_LIST)
	@RequestMapping(value = "/yworderbuyID", method = RequestMethod.POST)
	public String orderrefun2(String orderId, Integer p,Map<String,Object> map,HttpSession session) {
		Result<PageInfo<YwOrder>> result = ywOrderService.tuiPiaoList(orderId,new PageBounds(p, 10));
		map.put("YwOrder", result.getValue());
		
		return "order/orderrefund";
	}
	
	
}