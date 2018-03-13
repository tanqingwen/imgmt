package cn.happyworlds.imgmt.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.AclUser;
import cn.happyworlds.imgmt.entity.CpCeptrx;
import cn.happyworlds.imgmt.entity.CpTicket;
import cn.happyworlds.imgmt.entity.TSysStaff;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.service.AclUserService;
import cn.happyworlds.imgmt.service.StatService;
import cn.happyworlds.imgmt.service.TicketService;
import cn.happyworlds.imgmt.util.DateTimes;
import cn.happyworlds.imgmt.util.Result;
import cn.happyworlds.imgmt.util.SysDateFormat;

@Controller
@RequestMapping("/cpceptrx")
public class CpCeptrxController {
	
	@Autowired
	private StatService statService;
	@Autowired
	private AclUserService aclUserService;
	@Autowired
	private TicketService ticketService;
	
	/**
	 * 退票保存页面查询字段,起始时间，结束时间，票号，操作员
	 * 转票保存页面查询字段，起始时间，结束时间，票号，操作员，状态
	 */
	private void ReturnTicketStatCondition(HttpServletRequest request, Model model,String nowtime,String nowtimeOnoneMonth) {
		String paras[] = {"ctUserCreate" ,"ctApproveTimeStart" ,"ctApproveTimeEnd","ctCardNumber","ctTranCode"};
		for (int i = 0; i < paras.length; i++) {
			model.addAttribute(paras[i], request.getParameter(paras[i]));
		}
		String ctApproveTimeStart=request.getParameter("ctApproveTimeStart");
		String ctApproveTimeEnd=request.getParameter("ctApproveTimeEnd");
		if(ctApproveTimeStart==null&&ctApproveTimeEnd==null){
			model.addAttribute("ctApproveTimeStart", nowtimeOnoneMonth);
			model.addAttribute("ctApproveTimeEnd", nowtime);
		}
	}
	
	//购票信息查询页面字段，起始时间，结束时间，卡号
	private void BuyTicketStatCondition(String tkCardNo,String tkEffectiveDateStart,String tkEffectiveDateEnd, Model model,String nowtime,String nowtimeOnoneMonth) {
		model.addAttribute("tkCardNo", tkCardNo);
		if(tkEffectiveDateStart==null&&tkEffectiveDateEnd==null){
			model.addAttribute("tkEffectiveDateStart", nowtimeOnoneMonth);
			model.addAttribute("tkEffectiveDateEnd", nowtime);
		}else{
			model.addAttribute("tkEffectiveDateStart", tkEffectiveDateStart);
			model.addAttribute("tkEffectiveDateEnd", tkEffectiveDateEnd);
		}
	}
	
	//购票信息查询，返回查询字段票号,卡号,票劵类别,生效日期,失效日期,最近入园日期,最近离园日期
	@WebAction(Permission.CPCEPTRX_BUYTICKETSTAT)
	@RequestMapping("/buyTicketStat")
	public String buyTicketStat(HttpServletRequest  request, Integer p, Model m) {
		String nowtime = SysDateFormat.getNowDate("yyyyMMdd");
		String nowtimeOnoneMonth = ticketService.getSpecifiedDayAfterBynum(nowtime,-30);
		String tkCardNo=request.getParameter("tkCardNo");
		String tkEffectiveDateStart=request.getParameter("tkEffectiveDateStart");
		String tkEffectiveDateEnd=request.getParameter("tkEffectiveDateEnd");
		
		//BuyTicketStatCondition(tkCardNo,tkEffectiveDateStart,tkEffectiveDateEnd, m,nowtime,nowtimeOnoneMonth);
		
		if(tkEffectiveDateStart==null&&tkEffectiveDateEnd==null){
			tkEffectiveDateStart = nowtimeOnoneMonth;
			tkEffectiveDateEnd = nowtime;
		}
		
		Result<PageInfo<CpTicket>> result = statService.buyTicketStatMethod(tkCardNo, tkEffectiveDateStart,tkEffectiveDateEnd,new PageBounds(p,10));  
		
		if (result.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("pageInfo", result.getValue());
			m.addAttribute("queryString", request.getQueryString());
			m.addAttribute("tkCardNo",tkCardNo);
			m.addAttribute("tkEffectiveDateStart",tkEffectiveDateStart);
			m.addAttribute("tkEffectiveDateEnd",tkEffectiveDateEnd);
		}
		return "stat/buyTicketStat";
	}
	
	//购票信息下载，返回查询字段票号,卡号,票劵类别,生效日期,失效日期,最近入园日期,最近离园日期
	@RequestMapping(value = "/buyTicketDownLoad", method = RequestMethod.POST)
	public String buyTicketDownLoad(HttpServletRequest  request, HttpServletResponse resp,RedirectAttributes ra) {
		String tkCardNo=request.getParameter("tkCardNo");
		String tkEffectiveDateStart=request.getParameter("tkEffectiveDateStart");
		String tkEffectiveDateEnd=request.getParameter("tkEffectiveDateEnd");
		TSysStaff currentStaff = WebContext.getCurrentStaff();
		
		Result<String> result = statService.buyTicketDownLoadMethod(tkCardNo, tkEffectiveDateStart,tkEffectiveDateEnd,currentStaff.getId(),resp);
		
		if (result!=null) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, result.getComment());
			return "redirect:/stat/buyTicketStat";
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "下载成功");
		return "redirect:/stat/buyTicketStat";
	}
	
	//退票统计，返回查询字段票号，卡号，姓名，卡类型，日期，时间
	@WebAction(Permission.CPCEPTRX_RETURNTICKETSTAT)
	@RequestMapping("/returnTicketStat")
	public String returnTicketStat(HttpServletRequest  request, Integer p, Model m) {
		String nowtime = SysDateFormat.getNowDate("yyyyMMdd");
		String nowtimeOnoneMonth = ticketService.getSpecifiedDayAfterBynum(nowtime,-30);
		ReturnTicketStatCondition(request, m,nowtime,nowtimeOnoneMonth);
		
		String ctUserCreate=request.getParameter("ctUserCreate");
		String ctApproveTimeStart=request.getParameter("ctApproveTimeStart");
		
		String ctApproveTimeEnd=request.getParameter("ctApproveTimeEnd");
		String ctCardNumber=request.getParameter("ctCardNumber");
		
		if(ctApproveTimeStart==null&&ctApproveTimeEnd==null){
			ctApproveTimeStart = nowtimeOnoneMonth;
			ctApproveTimeEnd = nowtime;
		}
		ctApproveTimeStart = ctApproveTimeStart.replace("-", "");
		ctApproveTimeEnd = ctApproveTimeEnd.replace("-", "");
		Result<PageInfo<CpCeptrx>> result = statService.returnTicketStatMethod(ctUserCreate, ctApproveTimeStart,ctApproveTimeEnd,ctCardNumber,"UNTICKET", new PageBounds(p,10));  
		Result<List<AclUser>> aclUsers = aclUserService.AclUserListAll();
		
		if (result.isError() || aclUsers.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("pageInfo", result.getValue());
			m.addAttribute("aclUsers", aclUsers.getValue());
			m.addAttribute("queryString", request.getQueryString());
		}
		return "stat/returnTicketStat";
	}
	
	//退票下载
	@WebAction(Permission.CPCEPTRX_RETURNTICKETSTAT_DOWNLOAD)
	@RequestMapping(value = "/returnTicketDownLoad", method = RequestMethod.POST)
	public String returnTicketDownLoad(HttpServletRequest  request, HttpServletResponse resp,RedirectAttributes ra) {
		String ctUserCreate=request.getParameter("ctUserCreate");
		String ctApproveTimeStart=request.getParameter("ctApproveTimeStart");
		String ctApproveTimeEnd=request.getParameter("ctApproveTimeEnd");
		String ctCardNumber=request.getParameter("ctCardNumber");
		TSysStaff currentStaff = WebContext.getCurrentStaff();
		
		Result<String> result = statService.returnTicketDownLoadMethod(ctUserCreate, ctApproveTimeStart,ctApproveTimeEnd,ctCardNumber,"UNTICKET", currentStaff.getId(),resp);
		
		if (result!=null) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, result.getComment());
			return "redirect:/stat/returnTicketStat";
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "下载成功");
		return "redirect:/stat/returnTicketStat";
	}
	
	//转票下载
	@WebAction(Permission.CPCEPTRX_CONVERTTICKETSTAT_DOWNLOAD)
	@RequestMapping(value = "/convertTicketDownLoad", method = RequestMethod.POST)
	public String convertTicketDownLoad(HttpServletRequest  request, HttpServletResponse resp,RedirectAttributes ra) {
		String ctUserCreate=request.getParameter("ctUserCreate");
		String ctApproveTimeStart=request.getParameter("ctApproveTimeStart");
		String ctApproveTimeEnd=request.getParameter("ctApproveTimeEnd");
		String ctCardNumber=request.getParameter("ctCardNumber");
		String ctTranCode=request.getParameter("ctTranCode");
		TSysStaff currentStaff = WebContext.getCurrentStaff();
		
		Result<String> result = statService.returnTicketDownLoadMethod(ctUserCreate, ctApproveTimeStart,ctApproveTimeEnd,ctCardNumber,ctTranCode, currentStaff.getId(),resp);
		
		if (result!=null) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, result.getComment());
			return "redirect:/stat/convertTicketStat";
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "下载成功");
		return "redirect:/stat/convertTicketStat";
	}
	
	//转票统计，返回查询字段票号，卡号，姓名，卡类型，日期，时间
	@RequestMapping("/convertTicketStat")
	public String convertTicketStat(HttpServletRequest  request, Integer p, Model m) {
		String nowtime = SysDateFormat.getNowDate("yyyyMMdd");
		String nowtimeOnoneMonth = ticketService.getSpecifiedDayAfterBynum(nowtime,-30);
		ReturnTicketStatCondition(request, m,nowtime,nowtimeOnoneMonth);
		
		String ctUserCreate=request.getParameter("ctUserCreate");
		String ctApproveTimeStart=request.getParameter("ctApproveTimeStart");
		String ctApproveTimeEnd=request.getParameter("ctApproveTimeEnd");
		String ctCardNumber=request.getParameter("ctCardNumber");
		String ctTranCode=request.getParameter("ctTranCode");
		
		if(ctApproveTimeStart==null&&ctApproveTimeEnd==null&&ctTranCode==null){
			ctApproveTimeStart = nowtimeOnoneMonth;
			ctApproveTimeEnd = nowtime;
			ctTranCode = "TRANTKIN";
		}
		
		Result<PageInfo<CpCeptrx>> result = statService.returnTicketStatMethod(ctUserCreate, ctApproveTimeStart,ctApproveTimeEnd,ctCardNumber,ctTranCode, new PageBounds(p,10));  
		Result<List<AclUser>> aclUsers = aclUserService.AclUserListAll();
		
		if (result.isError() || aclUsers.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("pageInfo", result.getValue());
			m.addAttribute("aclUsers", aclUsers.getValue());
			m.addAttribute("queryString", request.getQueryString());
		}
		return "stat/convertTicketStat";
	}
	
}
