package cn.happyworlds.imgmt.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.YwOrder;
import cn.happyworlds.imgmt.entity.YwOrderitem;
import cn.happyworlds.imgmt.entity.YwPayrecord;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.service.StatService;
import cn.happyworlds.imgmt.service.TicketService;
import cn.happyworlds.imgmt.service.YwOrderService;
import cn.happyworlds.imgmt.service.YwOrderitemService;
import cn.happyworlds.imgmt.util.Result;
import cn.happyworlds.imgmt.util.SysDateFormat;

@Controller
@RequestMapping("/ywpayrecord")
public class YwPayrecordController {
	
	@Autowired
	private YwOrderService ywOrderService;
	@Autowired
	private YwOrderitemService ywOrderitemService;
	@Autowired
	private StatService statService;
	@Autowired
	private TicketService ticketService;
	
	//订单查询页面字段，订单号，手机号，开始添加时间，结束添加时间
	private void YworderQueryStatCondition(HttpServletRequest request, Model model,String nowtime,String nowtimeOnoneMonth) {
		String paras[] = {"hwOrderId" ,"hwMobilePhone" ,"hwMemberId","hwPayStatus","hwPayTimeStart","hwPayTimeEnd"};
		for (int i = 0; i < paras.length; i++) {
			model.addAttribute(paras[i], request.getParameter(paras[i]));
		}
		String hwPayTimeStart=request.getParameter("hwPayTimeStart");
		String hwPayTimeEnd=request.getParameter("hwPayTimeEnd");
		if(hwPayTimeStart==null&&hwPayTimeEnd==null){
			model.addAttribute("hwPayTimeStart", nowtimeOnoneMonth);
			model.addAttribute("hwPayTimeEnd", nowtime);
		}
	}
	
	//订单查询，返回查询字段订单号，会员号，手机号，通道，支付列表号，金额，订单状态，凭据，添加时间，支付时间，完成时间，详情
	@WebAction(Permission.ORDER_QUERY)
	@RequestMapping("/ywpayrecordQueryStat")
	public String yworderQueryStat(HttpServletRequest  request, Integer p, Model m) {
		String nowtime = SysDateFormat.getNowDate("yyyyMMdd");
		String nowtimeOnoneMonth = ticketService.getSpecifiedDayAfterBynum(nowtime,-30);
		YworderQueryStatCondition(request, m,nowtime,nowtimeOnoneMonth);
		
		String hwOrderId=request.getParameter("hwOrderId");
		String hwMobilePhone=request.getParameter("hwMobilePhone");
		String hwMemberId=request.getParameter("hwMemberId");
		String hwPayStatus=request.getParameter("hwPayStatus");
		String hwPayTimeStart=request.getParameter("hwPayTimeStart");
		String hwPayTimeEnd=request.getParameter("hwPayTimeEnd");
		
		if(hwPayTimeStart==null&&hwPayTimeEnd==null){
			hwPayTimeStart = nowtimeOnoneMonth;
			hwPayTimeEnd = nowtime+" 23:59:59";
		}else{
			hwPayTimeEnd += " 23:59:59";
		}
		
		Result<PageInfo<YwPayrecord>> result = statService.ywpayrecordQueryStatMethod(hwOrderId,hwMobilePhone,hwMemberId,hwPayStatus, hwPayTimeStart,hwPayTimeEnd, new PageBounds(p,10));  
		if (result.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("pageInfo", result.getValue());
		}
		return "stat/ywpayrecordQueryStatpage";
	}
	
	//订单详情，返回查询字段订单项号，订单号，商品组，准许进入时间，单价，票数，数量，特别方法，状态
	@RequestMapping("/yworderDetail")
	public String yworderDetail(String hwOrderId,Integer p, Model m) {
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
}