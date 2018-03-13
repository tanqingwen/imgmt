package cn.happyworlds.imgmt.web;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.happyworlds.imgmt.entity.CpPrdgrp;
import cn.happyworlds.imgmt.entity.YwOrderitemAndPrdgrp;
import cn.happyworlds.imgmt.service.BuyCpprdgrpService;

@Controller
@RequestMapping("/buy_cpprdgrp")
public class BuyCpprdgrpController {
	
	@Autowired
	private BuyCpprdgrpService buyCpprdgrpService;
	
	@SuppressWarnings("deprecation")
	@WebAction(Permission.STAFF_LIST)
	@RequestMapping("/ticketList")
	public String ticketList(HttpServletRequest request,String ctApproveTime,Model m) {
		int TicketCount = 0;
		if(request.getSession().getValue("TicketCount") != null){
			TicketCount = (Integer) request.getSession().getAttribute("TicketCount");
		}
		//查询票务信息，判断日期是否在假期内
		if(ctApproveTime==null||ctApproveTime.equals("")){
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
			ctApproveTime = df.format(new Date());
		}
		boolean timeflag = false;
		List<CpPrdgrp> hwCategorysList = new ArrayList<CpPrdgrp>();//票类型List
		List<CpPrdgrp> cpPrdgrps = new ArrayList<CpPrdgrp>();//票信息List
		if(buyCpprdgrpService.ifLegalHoliday(ctApproveTime)){
			//在假期里
			timeflag = true;
			hwCategorysList = buyCpprdgrpService.searchCpPrdgrpByParamsHwCategory(timeflag);
			if(hwCategorysList.size()==0){
				m.addAttribute(WebContext.ACTION_FAILURE_TIP, "暂时没有可售票");
			}else{
				String prCardBrand = hwCategorysList.get(0).getPrCardBrand();
				String prCardType = hwCategorysList.get(0).getPrCardType();
				cpPrdgrps = buyCpprdgrpService.searchCpPrdgrpByIfHoliday(timeflag,prCardBrand,prCardType);
			}
		}else{
			//不在假期里，查询所有票务类别，根据大类别，小类别查询票务信息
			hwCategorysList = buyCpprdgrpService.searchCpPrdgrpByParamsHwCategory(timeflag);
			if(hwCategorysList.size()==0){
				m.addAttribute(WebContext.ACTION_FAILURE_TIP, "暂时没有可售票");
			}else{
				String prCardBrand = hwCategorysList.get(0).getPrCardBrand();
				String prCardType = hwCategorysList.get(0).getPrCardType();
				cpPrdgrps = buyCpprdgrpService.searchCpPrdgrpByIfHoliday(timeflag,prCardBrand,prCardType);
			}
		}
		request.getSession().setAttribute("TicketCount", TicketCount);
		m.addAttribute("getNowTime", ctApproveTime);
		m.addAttribute("cpPrdgrps", cpPrdgrps);
		m.addAttribute("hwCategorysList", hwCategorysList);
		m.addAttribute("TicketCount", TicketCount);
		return "buy_cpprdgrp/ticketList";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/shoppingCart",method = {RequestMethod.GET,RequestMethod.POST})
	public String shoppingCart(HttpServletRequest request,Model m) {
		//返回到购物车页面，返回订单明细信息
		List<YwOrderitemAndPrdgrp> ywOrderitems = (List<YwOrderitemAndPrdgrp>) request.getSession().getAttribute("ywOrderitems");
		m.addAttribute("ywOrderitems", ywOrderitems);
		return "buy_cpprdgrp/shoppingCart";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/shoppingConfirm", method = RequestMethod.POST)
	public String shoppingConfirm(HttpServletRequest request,Model m) {
		//返回到购物车订单确认页面，返回订单明细信息
		List<YwOrderitemAndPrdgrp> ywOrderitems = (List<YwOrderitemAndPrdgrp>) request.getSession().getAttribute("ywOrderitems");
		m.addAttribute("ywOrderitems", ywOrderitems);
		return "buy_cpprdgrp/shoppingConfirm";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public String order(HttpServletRequest request,String hwMobilePhone,RedirectAttributes m) {
		//票劵ID,手机号码,票劵数量,用户入园时间,购票金额,渠道ID,支付类型,票劵类型
		//确认支付,传入手机号
		List<YwOrderitemAndPrdgrp> ywOrderitems = (List<YwOrderitemAndPrdgrp>) request.getSession().getAttribute("ywOrderitems");
		buyCpprdgrpService.buyCpPrdgrp(hwMobilePhone, ywOrderitems);
		m.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "购票成功");
		request.getSession().removeAttribute("ywOrderitems");
		request.getSession().removeAttribute("TicketCount");
		request.getSession().removeAttribute("TicketAmount");
		return "redirect:/buy_cpprdgrp/ticketList";
	}
	
	@RequestMapping(value = "/orderOff", method = {RequestMethod.POST,RequestMethod.GET})
	public String orderOff(HttpServletRequest request,RedirectAttributes m) {
		//取消订单,把总数，总金额，订单信息清空
		List<YwOrderitemAndPrdgrp> ywOrderitems = new ArrayList<YwOrderitemAndPrdgrp>();
		int TicketCount = 0;
		BigDecimal TicketAmount = new BigDecimal(0);
		
		request.getSession().setAttribute("ywOrderitems", ywOrderitems);
		request.getSession().setAttribute("TicketCount", TicketCount);
		request.getSession().setAttribute("TicketAmount", TicketAmount);
		return "redirect:/buy_cpprdgrp/ticketList";
	}
	
	@ResponseBody
	@RequestMapping(value = "/TtypeChange", method = RequestMethod.GET)
	public List<CpPrdgrp> TtypeChange(String time,String prCardBrand,String prCardType) {
		//根据大类别，小类别查询票信息
		List<CpPrdgrp> cpPrdgrps = new ArrayList<CpPrdgrp>();//票信息List
		if(buyCpprdgrpService.ifLegalHoliday(time)){
			//在假期里
			cpPrdgrps = buyCpprdgrpService.searchCpPrdgrpByIfHoliday(true,prCardBrand,prCardType);
		}else{
			//不在假期里，查询所有票务类别，根据大类别，小类别查询票务信息
			cpPrdgrps = buyCpprdgrpService.searchCpPrdgrpByIfHoliday(false,prCardBrand,prCardType);
		}
		return cpPrdgrps;
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	@ResponseBody
	@RequestMapping(value = "/ticketAdd", method = RequestMethod.GET)
	public Integer ticketAdd(HttpServletRequest request,String prProdctGroup,String hwAdmissionTime,String hwUnitPrice,String prGroupDesc,String hwCategory) {
		//页面点击添加，加入一条订单明细信息到list里
		List<YwOrderitemAndPrdgrp> ywOrderitems = new ArrayList<YwOrderitemAndPrdgrp>();
		int TicketCount = 0;
		BigDecimal TicketAmount = new BigDecimal(0);
		if(request.getSession().getValue("ywOrderitems") != null&&request.getSession().getValue("TicketCount") != null&&request.getSession().getValue("TicketAmount") != null){
			ywOrderitems = (List<YwOrderitemAndPrdgrp>) request.getSession().getAttribute("ywOrderitems");
			TicketCount = (Integer) request.getSession().getAttribute("TicketCount");
			TicketAmount = new BigDecimal(request.getSession().getAttribute("TicketAmount").toString());
		}
		YwOrderitemAndPrdgrp ywOrderitem = new YwOrderitemAndPrdgrp();
		boolean flag = true;
		TicketCount++;
		TicketAmount = TicketAmount.add(new BigDecimal(hwUnitPrice));
		for(int i=0;i<ywOrderitems.size();i++){
			if(prProdctGroup.equals(ywOrderitems.get(i).getHwProdctGroup())){
				//判断日期，日期如果不是同一天就重新添加一条数据
				if(hwAdmissionTime.equals(ywOrderitems.get(i).getHwAdmissionTime())){
					ywOrderitems.get(i).setHwTicketCount(Integer.parseInt(ywOrderitems.get(i).getHwTicketCount())+1+"");
					Integer HwUnitPrice = ywOrderitems.get(i).getHwUnitPrice().intValue();
					Integer HwTicketCount = Integer.parseInt(ywOrderitems.get(i).getHwTicketCount());
					ywOrderitems.get(i).setHwAmount(new BigDecimal(HwUnitPrice*HwTicketCount));
					flag=false;
				}
			}
		}
		if(flag){
			ywOrderitem.setHwProdctGroup(prProdctGroup);
			ywOrderitem.setHwAdmissionTime(hwAdmissionTime);
			ywOrderitem.setHwUnitPrice(new BigDecimal(hwUnitPrice));
			ywOrderitem.setHwTicketCount("1");
			ywOrderitem.setHwAmount(new BigDecimal(hwUnitPrice));
			ywOrderitem.setPrGroupDesc(prGroupDesc);
			ywOrderitem.setTicketCount(TicketCount+"");
			ywOrderitem.setHwCategory(hwCategory);
			ywOrderitem.setTicketAmount(TicketAmount.toString());
			ywOrderitems.add(ywOrderitem);
		}
		for(int i=0;i<ywOrderitems.size();i++){
			ywOrderitems.get(i).setTicketCount(TicketCount+"");
			ywOrderitems.get(i).setTicketAmount(TicketAmount.toString()); 
			System.out.println("getHwProdctGroup"+i+":"+ywOrderitems.get(i).getHwProdctGroup());
			System.out.println("getHwAdmissionTime"+i+":"+ywOrderitems.get(i).getHwAdmissionTime());
			System.out.println("getHwUnitPrice"+i+":"+ywOrderitems.get(i).getHwUnitPrice());
			System.out.println("getHwTicketCount"+i+":"+ywOrderitems.get(i).getHwTicketCount());
			System.out.println("getHwAmount"+i+":"+ywOrderitems.get(i).getHwAmount());
			System.out.println("getPrGroupDesc"+i+":"+ywOrderitems.get(i).getPrGroupDesc());
			System.out.println("getTicketCount"+i+":"+ywOrderitems.get(i).getTicketCount());
			System.out.println("getHwCategory"+i+":"+ywOrderitems.get(i).getHwCategory());
			System.out.println("getTicketAmount"+i+":"+ywOrderitems.get(i).getTicketAmount());
		}
		request.getSession().setAttribute("ywOrderitems", ywOrderitems);
		request.getSession().setAttribute("TicketCount", TicketCount);
		request.getSession().setAttribute("TicketAmount", TicketAmount);
		return TicketCount;
	}
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/changeTCount", method = RequestMethod.GET)
	public YwOrderitemAndPrdgrp changeTCount(HttpServletRequest request,String val,String prProdctGroup) {
		//购物车页面增减订单明细信息
		List<YwOrderitemAndPrdgrp> ywOrderitems = (List<YwOrderitemAndPrdgrp>) request.getSession().getAttribute("ywOrderitems");
		int TicketCount = (Integer) request.getSession().getAttribute("TicketCount");
		BigDecimal TicketAmount = new BigDecimal(request.getSession().getAttribute("TicketAmount").toString());
		int size=0;
		for(int i=0;i<ywOrderitems.size();i++){
			if(prProdctGroup.equals(ywOrderitems.get(i).getHwProdctGroup())){
				size=i;
				if("-".equals(val)){
					ywOrderitems.get(i).setHwTicketCount(Integer.parseInt(ywOrderitems.get(i).getHwTicketCount())-1+"");
					Integer HwUnitPrice = ywOrderitems.get(i).getHwUnitPrice().intValue();
					Integer HwTicketCount = Integer.parseInt(ywOrderitems.get(i).getHwTicketCount());
					ywOrderitems.get(i).setHwAmount(new BigDecimal(HwUnitPrice*HwTicketCount));
					TicketCount--;
					TicketAmount = TicketAmount.subtract(ywOrderitems.get(i).getHwUnitPrice());
		    	}else{
		    		ywOrderitems.get(i).setHwTicketCount(Integer.parseInt(ywOrderitems.get(i).getHwTicketCount())+1+"");
		    		Integer HwUnitPrice = ywOrderitems.get(i).getHwUnitPrice().intValue();
					Integer HwTicketCount = Integer.parseInt(ywOrderitems.get(i).getHwTicketCount());
					ywOrderitems.get(i).setHwAmount(new BigDecimal(HwUnitPrice*HwTicketCount));
		    		TicketCount++;
		    		TicketAmount = TicketAmount.add(ywOrderitems.get(i).getHwUnitPrice());
		    	}
			}
		}
		for(int i=0;i<ywOrderitems.size();i++){
			ywOrderitems.get(i).setTicketCount(TicketCount+"");
			ywOrderitems.get(i).setTicketAmount(TicketAmount.toString());
			System.out.println("getHwProdctGroup"+i+":"+ywOrderitems.get(i).getHwProdctGroup());
			System.out.println("getHwAdmissionTime"+i+":"+ywOrderitems.get(i).getHwAdmissionTime());
			System.out.println("getHwUnitPrice"+i+":"+ywOrderitems.get(i).getHwUnitPrice());
			System.out.println("getHwTicketCount"+i+":"+ywOrderitems.get(i).getHwTicketCount());
			System.out.println("getHwAmount"+i+":"+ywOrderitems.get(i).getHwAmount());
			System.out.println("getPrGroupDesc"+i+":"+ywOrderitems.get(i).getPrGroupDesc());
			System.out.println("getTicketCount"+i+":"+ywOrderitems.get(i).getTicketCount());
			System.out.println("getHwCategory"+i+":"+ywOrderitems.get(i).getHwCategory());
			System.out.println("getTicketAmount"+i+":"+ywOrderitems.get(i).getTicketAmount());
		}
		request.getSession().setAttribute("ywOrderitems", ywOrderitems);
		request.getSession().setAttribute("TicketCount", TicketCount);
		request.getSession().setAttribute("TicketAmount", TicketAmount);
		return ywOrderitems.get(size);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/deteleTCounts/{prProdctGroup}")
	public String deteleTCount(HttpServletRequest request,@PathVariable("prProdctGroup") String prProdctGroup,RedirectAttributes ra) {
		//购物车页面删除订单明细信息,合计TicketAmount，结算TicketCount会发生改变，合计减去小计HwUnitPrice，结算减去数量HwTicketCount
		List<YwOrderitemAndPrdgrp> ywOrderitems = (List<YwOrderitemAndPrdgrp>) request.getSession().getAttribute("ywOrderitems");
		int TicketCount = (Integer) request.getSession().getAttribute("TicketCount");
		BigDecimal TicketAmount = new BigDecimal(request.getSession().getAttribute("TicketAmount").toString());
		for(int i=0;i<ywOrderitems.size();i++){
			if(prProdctGroup.equals(ywOrderitems.get(i).getHwProdctGroup())){
				Integer HwUnitPrice = ywOrderitems.get(i).getHwUnitPrice().intValue();
				Integer HwTicketCount = Integer.parseInt(ywOrderitems.get(i).getHwTicketCount());
				TicketCount -= HwTicketCount;
				TicketAmount = TicketAmount.subtract(new BigDecimal(HwUnitPrice*HwTicketCount));//删除时调整合计金额，需要考虑票数
				ywOrderitems.remove(i);
			}
		}
		for(int i=0;i<ywOrderitems.size();i++){
			ywOrderitems.get(i).setTicketCount(TicketCount+"");
			ywOrderitems.get(i).setTicketAmount(TicketAmount.toString());
			System.out.println("getHwProdctGroup"+i+":"+ywOrderitems.get(i).getHwProdctGroup());
			System.out.println("getHwAdmissionTime"+i+":"+ywOrderitems.get(i).getHwAdmissionTime());
			System.out.println("getHwUnitPrice"+i+":"+ywOrderitems.get(i).getHwUnitPrice());
			System.out.println("getHwTicketCount"+i+":"+ywOrderitems.get(i).getHwTicketCount());
			System.out.println("getHwAmount"+i+":"+ywOrderitems.get(i).getHwAmount());
			System.out.println("getPrGroupDesc"+i+":"+ywOrderitems.get(i).getPrGroupDesc());
			System.out.println("getTicketCount"+i+":"+ywOrderitems.get(i).getTicketCount());
			System.out.println("getHwCategory"+i+":"+ywOrderitems.get(i).getHwCategory());
			System.out.println("getTicketAmount"+i+":"+ywOrderitems.get(i).getTicketAmount());
		}
		request.getSession().setAttribute("ywOrderitems", ywOrderitems);
		request.getSession().setAttribute("TicketCount", TicketCount);
		request.getSession().setAttribute("TicketAmount", TicketAmount);
		return "redirect:/buy_cpprdgrp/shoppingCart";
	}
}	
