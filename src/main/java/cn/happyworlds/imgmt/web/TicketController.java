package cn.happyworlds.imgmt.web;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.happyworlds.imgmt.entity.CpIdtype;
import cn.happyworlds.imgmt.entity.CpPrdgrp;
import cn.happyworlds.imgmt.entity.CpTktype;
import cn.happyworlds.imgmt.service.BuyCpprdgrpService;
import cn.happyworlds.imgmt.service.IdtypeService;
import cn.happyworlds.imgmt.service.PrdgrpService;
import cn.happyworlds.imgmt.service.RoleService;
import cn.happyworlds.imgmt.service.TicketService;
import cn.happyworlds.imgmt.service.TktypeService;
import cn.happyworlds.imgmt.util.Result;
import cn.happyworlds.imgmt.util.StatusResult;
import cn.happyworlds.imgmt.util.SysDateFormat;

@Controller
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	private TicketService ticketService;
	@Autowired
	private TktypeService tktypeService;
	@Autowired
	private PrdgrpService PrdgrpService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private IdtypeService IdtypeService;
	@Autowired
	private BuyCpprdgrpService buyCpprdgrpService;

	@WebAction(Permission.BUYTICKET_ADD)
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model m) {

		Result<List<CpPrdgrp>> prdGrpList = PrdgrpService.prdGrpListAll();
		Result<List<CpTktype>> tkTypeList = tktypeService.tktypeListAll();
		Result<List<CpIdtype>> idTypeList = IdtypeService.idTypeListAll();
		String nowDate = SysDateFormat.getNowDate("yyyyMMdd");
		tkTypeList=ticketService.getTkTypeList(nowDate,tkTypeList);
		if(buyCpprdgrpService.ifLegalHoliday(nowDate)){
			List<CpTktype> tkTypeAll = tkTypeList.getValue();
			for (int i = 0; i < tkTypeAll.size(); i++) {
				BigDecimal Price = tkTypeAll.get(i).getTtListPrice().multiply(new BigDecimal(0.8));
				tkTypeAll.get(i).setTtListPrice(Price);
			}
		}
		
		m.addAttribute("prdGrpList", prdGrpList.getValue());
		m.addAttribute("tkTypeList", tkTypeList.getValue());
		m.addAttribute("idTypeList", idTypeList.getValue());
		m.addAttribute("nowDate", nowDate);
		m.addAttribute("roles", roleService.roleList());
		return "ticket/add";
	}
	
	@WebAction(Permission.BUYTICKET_ADD)
	@RequestMapping(value = "/add2", method = RequestMethod.GET)
	public String add2(Model m) {

		Result<List<CpPrdgrp>> prdGrpList = PrdgrpService.prdGrpListAll();
		Result<List<CpTktype>> tkTypeList = tktypeService.tktypeListAll();
		String nowDate = SysDateFormat.getNowDate("yyyyMMdd");
		tkTypeList=ticketService.getTkTypeList(nowDate,tkTypeList);
		if(buyCpprdgrpService.ifLegalHoliday(nowDate)){
			List<CpTktype> tkTypeAll = tkTypeList.getValue();
			for (int i = 0; i < tkTypeAll.size(); i++) {
				BigDecimal Price = tkTypeAll.get(i).getTtListPrice().multiply(new BigDecimal(0.8));
				tkTypeAll.get(i).setTtListPrice(Price);
			}
		}
		
		m.addAttribute("prdGrpList", prdGrpList.getValue());
		m.addAttribute("tkTypeList", tkTypeList.getValue());
		m.addAttribute("nowDate", nowDate);
		m.addAttribute("roles", roleService.roleList());
		return "ticket/add2";
	}

	//柜台购票提交
	@WebAction(Permission.BUYTICKET_ADD)
	@ResponseBody
	@RequestMapping(value = "/addTicket", method = RequestMethod.POST)
	public StatusResult<String> addTicket(String cardNo,String idNo,String ticketType,String paperNo,String amount,String status) {
		String staffId = WebContext.getCurrentStaff().getId();
		return ticketService.addTicket(cardNo, idNo, ticketType, paperNo, amount, status, staffId);
	}

	
	// 选中票券类别时计算折扣
	@WebAction(Permission.BUYTICKET_ADD)
	@ResponseBody
	@RequestMapping(value = "/tkpriceInf", method = RequestMethod.POST)
	public StatusResult<BigDecimal> tkpriceInf(String ttTypeId, String prodct, String num) {
		String nowDate = SysDateFormat.getNowDate("yyyyMMdd");
		boolean flag = false;
		if(buyCpprdgrpService.ifLegalHoliday(nowDate)){
			flag=true;
		}
		return ticketService.tkpriceInf(ttTypeId, prodct,flag);
	}	
	
}
