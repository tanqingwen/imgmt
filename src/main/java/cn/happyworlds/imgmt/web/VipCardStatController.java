package cn.happyworlds.imgmt.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpPrdgrp;
import cn.happyworlds.imgmt.entity.FillCard;
import cn.happyworlds.imgmt.entity.ListCardSaleInfo;
import cn.happyworlds.imgmt.entity.TSysStaff;
import cn.happyworlds.imgmt.entity.VipCardStat;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.service.ConsumptionService;
import cn.happyworlds.imgmt.service.PrdgrpService;
import cn.happyworlds.imgmt.service.StatService;
import cn.happyworlds.imgmt.service.TicketService;
import cn.happyworlds.imgmt.util.Result;
import cn.happyworlds.imgmt.util.SysDateFormat;

@Controller
@RequestMapping("/vipcardStat")
public class VipCardStatController {
	
	@Autowired
	private StatService statService;
	@Autowired
	private PrdgrpService PrdgrpService;
	@Autowired
	private ConsumptionService consumptionServer;
	@Autowired
	private TicketService ticketService;
	
	//会员卡信息查询页面字段，卡号，姓名，手机号码，证件号码
	private void VipCardInfoStatCondition(HttpServletRequest request, Model model) {
		String paras[] = {"cbCardholderNo" ,"cbEmbossname" ,"cbSourceCd","cbIdno"};
		for (int i = 0; i < paras.length; i++) {
			model.addAttribute(paras[i], request.getParameter(paras[i]));
		}
	}
	
	//会员卡情况查询页面字段，开始时间，结束时间，卡号，卡类型，卡状态，卡主证件号 
	private void VipCardCaseStatCondition(HttpServletRequest request, Model model,String nowtime,String nowtimeOnoneMonth) {
		String paras[] = {"cbAnnivDateStart" ,"cbAnnivDateEnd" ,"cbCardholderNo","prGroupDesc","cbPlasticCd","cbIdno"};
		for (int i = 0; i < paras.length; i++) {
			model.addAttribute(paras[i], request.getParameter(paras[i]));
		}
		String cbAnnivDateStart=request.getParameter("cbAnnivDateStart");
		String cbAnnivDateEnd=request.getParameter("cbAnnivDateEnd");
		if(cbAnnivDateStart==null&&cbAnnivDateEnd==null){
			model.addAttribute("cbAnnivDateStart", nowtimeOnoneMonth);
			model.addAttribute("cbAnnivDateEnd", nowtime);
		}
	}
	
	//会员卡换卡查询页面字段，旧卡号，新卡号，换卡开始时间，换卡结束时间
	private void VipCardChangeStatCondition(HttpServletRequest request, Model model,String nowtime,String nowtimeOnoneMonth) {
		String pageInfo[] = { "cl_old_card", "cl_new_card", "cl_timestampStart", "cl_timestampEnd"};
		for (int i = 0; i < pageInfo.length; i++) {
			model.addAttribute(pageInfo[i], request.getParameter(pageInfo[i]));
		}
		String cl_timestampStart=request.getParameter("cl_timestampStart");
		String cl_timestampEnd=request.getParameter("cl_timestampEnd");
		if(cl_timestampStart==null&&cl_timestampEnd==null){
			model.addAttribute("cl_timestampStart", nowtimeOnoneMonth);
			model.addAttribute("cl_timestampEnd", nowtime);
		}
	}
	
	//会员卡换卡查询，返回查询字段旧卡号，新卡号，姓名，身份证号，换卡日期，换卡时间，换卡费
	@WebAction(Permission.VIPCARDSTAT_VIPCHANGESTAT)
	@RequestMapping("/vipChangeStat")
	public String vipChangeStat(HttpServletRequest  request, Integer p, Model m) {
		String nowtime = SysDateFormat.getNowDate("yyyy-MM-dd");
		String nowtimeOnoneMonth = ticketService.getSpecifiedDayAfterBynum(nowtime,-30);
		VipCardChangeStatCondition(request, m,nowtime,nowtimeOnoneMonth);

		String cl_old_card = request.getParameter("cl_old_card");
		String cl_new_card = request.getParameter("cl_new_card");
		String cl_timestampStart = request.getParameter("cl_timestampStart");
		String cl_timestampEnd = request.getParameter("cl_timestampEnd");
		if(cl_timestampStart==null&&cl_timestampEnd==null){
			cl_timestampStart = nowtimeOnoneMonth;
			cl_timestampEnd = nowtime;
		}
		
		Result<PageInfo<FillCard>> r = consumptionServer.FillCardChangeList(cl_old_card, cl_new_card, cl_timestampStart, cl_timestampEnd,  new PageBounds(p,10));  
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("pageInfo", r.getValue());
			m.addAttribute("queryString", request.getQueryString());
		}
		return "stat/vipcardChangeStatpage";
	}
	
	//会员卡情况查询，返回查询字段卡号,卡类型，卡状态，余额，日期，卡有效期，卡主证件类型，卡主证件号
	@WebAction(Permission.VIPCARDSTAT_VIPCASESTAT)
	@RequestMapping("/vipCaseStat")
	public String vipCaseStat(HttpServletRequest  request, Integer p, Model m) {
		String nowtime = SysDateFormat.getNowDate("yyyyMMdd");
		String nowtimeOnoneMonth = ticketService.getSpecifiedDayAfterBynum(nowtime,-30);
		String cbAnnivDateStart=request.getParameter("cbAnnivDateStart");
		String cbAnnivDateEnd=request.getParameter("cbAnnivDateEnd");
		String cbCardholderNo=request.getParameter("cbCardholderNo");
		String prGroupDesc=request.getParameter("prGroupDesc");
		String cbPlasticCd=request.getParameter("cbPlasticCd");
		String cbIdno=request.getParameter("cbIdno");
		
		VipCardCaseStatCondition(request, m,nowtime,nowtimeOnoneMonth);
		if(cbAnnivDateStart==null&&cbAnnivDateEnd==null&&cbPlasticCd==null){
			cbAnnivDateStart = nowtimeOnoneMonth;
			cbAnnivDateEnd = nowtime;
			cbPlasticCd="";
		}else cbPlasticCd = cbPlasticCd.equals("NOP") ? " " : cbPlasticCd;
		Result<List<CpPrdgrp>> prdGrpList = PrdgrpService.prdGrpListAll();
		Result<PageInfo<VipCardStat>> result = statService.vipcardCaseStatMethod(cbAnnivDateStart, cbAnnivDateEnd, cbCardholderNo,prGroupDesc, cbPlasticCd, cbIdno,new PageBounds(p,10));  
		
		if (result.isError()||prdGrpList.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("pageInfo", result.getValue());
			m.addAttribute("prdGrpList", prdGrpList.getValue());
			m.addAttribute("queryString", request.getQueryString());
		}
		return "stat/vipcardCaseStatpage";
	}
		
	//会员卡信息查询，返回查询字段卡号,姓名，证件类型，卡产品，证件号码，押金，时间，手机号码，状态，操作员
	@WebAction(Permission.VIPCARDSTAT_VIPINFOSTAT)
	@RequestMapping("/vipInfoStat")
	public String vipInfoStat(HttpServletRequest  request, Integer p, Model m) {
		String cbCardholderNoes=request.getParameter("cbCardholderNo");
		String cbCardholderNo="";
		if(StringUtils.isNotEmpty(cbCardholderNoes)){
			cbCardholderNo="333502"+cbCardholderNoes;
		}
		
		String cbEmbossname=request.getParameter("cbEmbossname");
		String cbSourceCd=request.getParameter("cbSourceCd");
		String cbIdno=request.getParameter("cbIdno");
		
		VipCardInfoStatCondition(request, m);
		
		Result<PageInfo<VipCardStat>> result = statService.vipcardInfoStatMethod(cbCardholderNo, cbEmbossname, cbSourceCd, cbIdno,new PageBounds(p,10));  
		
		if (result.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("pageInfo", result.getValue());
			m.addAttribute("queryString", request.getQueryString());
		}
		return "stat/vipcardInfoStatpage";
	}
	
	//卡片交易详细信息查询，返回查询字段姓名，卡号,身份证号，交易时间，交易码，交易描述，交易金额，交易金额，交易前金额，交易后金额
	@WebAction(Permission.VIPCARDSTAT_LISTCARDSALEINFO)
	@RequestMapping(value="/listCardSaleInfo",method=RequestMethod.GET)
	public String listCardSaleInfo(String ctCardNumber, HttpServletRequest  request,Integer p, Model m) {
		//交易详细信息
		Result<PageInfo<ListCardSaleInfo>> result = statService.ListCardSaleInfoMethod(ctCardNumber,new PageBounds(p,10));
		if (result.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("ctCardNumber", ctCardNumber);
			m.addAttribute("queryString", request.getQueryString());
			m.addAttribute("pageInfo", result.getValue());
		}
		return "stat/vipcardSaleInfoStatpage";
	}
	
	
	
	//会员卡情况统计下载
	@WebAction(Permission.VIPCARDSTAT_VIPCASESTAT_DOWNLOAD)
	@RequestMapping(value = "/vipCaseStatDownLoad", method = RequestMethod.POST)
	public String vipCaseStatDownLoad(HttpServletRequest  request, HttpServletResponse resp,RedirectAttributes ra) {
		String cbAnnivDateStart=request.getParameter("cbAnnivDateStart");
		String cbAnnivDateEnd=request.getParameter("cbAnnivDateEnd");
		String cbCardholderNo=request.getParameter("cbCardholderNo");
		String prGroupDesc=request.getParameter("prGroupDesc");
		String cbPlasticCd=request.getParameter("cbPlasticCd");
		cbPlasticCd = cbPlasticCd.equals("NOP") ? " " : cbPlasticCd;
		String cbIdno=request.getParameter("cbIdno");
		TSysStaff currentStaff = WebContext.getCurrentStaff();
		
		Result<String> result = statService.vipCaseStatDownLoadMethod(cbAnnivDateStart, cbAnnivDateEnd, cbCardholderNo,prGroupDesc, cbPlasticCd, cbIdno,currentStaff.getId(),resp);
		
		if (result!=null) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, result.getComment());
			return "redirect:/opeartion/list";
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "下载成功");
		return "redirect:/opeartion/list";
	}
	
	//会员卡换卡统计下载
	@WebAction(Permission.VIPCARDSTAT_VIPCHANGESTAT_DOWNLOAD)
	@RequestMapping(value = "/vipChangeStatDownLoad", method = RequestMethod.POST)
	public String vipChangeStatDownLoad(HttpServletRequest  request, HttpServletResponse resp,RedirectAttributes ra) {
		String cl_old_card = request.getParameter("cl_old_card");
		String cl_new_card = request.getParameter("cl_new_card");
		String cl_timestampStart = request.getParameter("cl_timestampStart");
		String cl_timestampEnd = request.getParameter("cl_timestampEnd");
		TSysStaff currentStaff = WebContext.getCurrentStaff();
		
		Result<String> result = statService.vipChangeStatDownLoadMethod(cl_old_card, cl_new_card, cl_timestampStart, cl_timestampEnd,currentStaff.getId(),resp);
		
		if (result!=null) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, result.getComment());
			return "redirect:/opeartion/list";
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "下载成功");
		return "redirect:/opeartion/list";
	}

}
