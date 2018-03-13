package cn.happyworlds.imgmt.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.AclUser;
import cn.happyworlds.imgmt.entity.FinancialStatement;
import cn.happyworlds.imgmt.entity.TSysStaff;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.service.AclUserService;
import cn.happyworlds.imgmt.service.FinancialService;
import cn.happyworlds.imgmt.service.TicketService;
import cn.happyworlds.imgmt.util.Result;
import cn.happyworlds.imgmt.util.SysDateFormat;



@Controller
@RequestMapping("/financial")
public class FinancialController {
	@Autowired
	private TicketService ticketService;
	@Autowired
	private AclUserService aclUserService;
	@Autowired
	private FinancialService financialService;
	
	//财务报表下载
	private void OpeartionStatCondition(HttpServletRequest request, Model model,String nowtime,String nowtimeOnoneMonth) {
		String paras[] = {"ctApproveTimeStart" ,"ctApproveTimeEnd" ,"classes"};
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
	
	//财务报表
	@WebAction(Permission.FINANCIAL_LIST)
	@RequestMapping("/list")
	public String listStat(HttpServletRequest  request, Integer p, Model m) {
		String nowtime = SysDateFormat.getNowDate("yyyyMMdd");
		String nowtimeOnoneMonth = ticketService.getSpecifiedDayAfterBynum(nowtime,-30);
		String ctApproveTimeStart=request.getParameter("ctApproveTimeStart");
		String ctApproveTimeEnd=request.getParameter("ctApproveTimeEnd");
		String classes=request.getParameter("classes");
		
		
		OpeartionStatCondition(request, m,nowtime,nowtimeOnoneMonth);
		if(ctApproveTimeStart==null&&ctApproveTimeEnd==null){
			ctApproveTimeStart = nowtimeOnoneMonth;
			ctApproveTimeEnd = nowtime;
		}
		Result<List<AclUser>> aclUsers = aclUserService.AclUserListAll();
		Result<PageInfo<FinancialStatement>> r = financialService.list(classes,request,new PageBounds(p,10));  
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("aclUsers", aclUsers.getValue());
			m.addAttribute("pageInfo", r.getValue());
		}
		return "financial/list";
	}
	
	//流水报表
	@WebAction(Permission.FINANCIAL_WATER)
	@RequestMapping("/water")
	public String waterStat(HttpServletRequest  request, Integer p, Model m) {
		return "financial/water";
	}
	
	//流水报表下载
	@WebAction(Permission.FINANCIAL_WATER)
	@RequestMapping("/waterDownLoad/{type}")
	public String waterStatDownLoad(@PathVariable("type") String type,HttpServletRequest  request, HttpServletResponse resp,RedirectAttributes ra) {
		Result<String> result = null;
		if(type.equals("paradise")){
			result = financialService.paradise(resp,type.toUpperCase());
		}else if(type.equals("ticket")){
			result = financialService.ticket(resp,type.toUpperCase());
		}else if(type.equals("food")){
			result = financialService.food(resp,type.toUpperCase());
		}else if(type.equals("retail")){
			result = financialService.retail(resp,type.toUpperCase());
		}else if(type.equals("grogshop")){
			result = financialService.grogshop(resp,type.toUpperCase());
		}
		
		if (result!=null) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, result.getComment());
			return "redirect:/financial/list";
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "下载成功");
		return "redirect:/financial/list";
	}

	//财务报表下载
	@WebAction(Permission.FINANCIAL_LIST_DOWNLOAD)
	@RequestMapping(value = "/listDownLoad", method = RequestMethod.POST)
	public String listDownLoad(HttpServletRequest  request, HttpServletResponse resp,RedirectAttributes ra) {
		String ctApproveTimeStart=request.getParameter("ctApproveTimeStart");
		String ctApproveTimeEnd=request.getParameter("ctApproveTimeEnd");
		String classes=request.getParameter("classes");
		TSysStaff currentStaff = WebContext.getCurrentStaff();
		
		Result<String> result = financialService.listDownLoadMethod(ctApproveTimeStart, ctApproveTimeEnd, classes,currentStaff.getId(),resp);
		
		if (result!=null) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, result.getComment());
			return "redirect:/financial/list";
		}
		/*ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "下载成功");
		return "redirect:/financial/list";*/
		return null;
	}
}
