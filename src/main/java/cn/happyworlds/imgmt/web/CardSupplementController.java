package cn.happyworlds.imgmt.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.happyworlds.imgmt.entity.CpIdtype;
import cn.happyworlds.imgmt.entity.CpPrdgrp;
import cn.happyworlds.imgmt.service.CardSupplementService;
import cn.happyworlds.imgmt.service.IdtypeService;
import cn.happyworlds.imgmt.service.PrdgrpService;
import cn.happyworlds.imgmt.service.RoleService;
import cn.happyworlds.imgmt.util.Result;
import cn.happyworlds.imgmt.util.StatusResult;
import cn.happyworlds.imgmt.web.WebContext;

@Controller
@RequestMapping("/CardSupplement")
public class CardSupplementController {

	@Autowired
	private IdtypeService IdtypeService;
	@Autowired
	private PrdgrpService PrdgrpService;
	@Autowired
	private CardSupplementService supplementService;
	@Autowired
	private RoleService roleService;

	@RequestMapping("/search")
	public String search() {
		return "card_supplement/search";
	}
	
	@WebAction(Permission.STAFF_ADD)
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model m) {
		
		Result<List<CpIdtype>> idTypeList = IdtypeService.idTypeListAll();
		Result<List<CpPrdgrp>> prdGrpList = PrdgrpService.prdGrpListAll();
		m.addAttribute("idTypeList", idTypeList.getValue());
		m.addAttribute("prdGrpList", prdGrpList.getValue());
		m.addAttribute("roles", roleService.roleList());
		return "card_supplement/add";
	}
	
	
	
	//挂失补卡判断
	@WebAction(Permission.OPENLOSS_ADD)
	@ResponseBody
	@RequestMapping(value = "/doCheck", method = RequestMethod.POST)
	public StatusResult<String> doCheck(String cardNo) {
		StatusResult<String> r = supplementService.doCheck(cardNo);
		return r;
	}
	
	//挂失补卡满足条件可以补卡
	@WebAction(Permission.OPENLOSS_ADD)
	@ResponseBody
	@RequestMapping(value = "/checkCardReplace", method = RequestMethod.POST)
	public StatusResult<String> checkCardReplace(String oldCardNo,String newCardNo) {
		StatusResult<String> r = supplementService.checkCardReplace(oldCardNo,newCardNo);
		return r;
	}
	
	
	//挂失补卡提交写卡
	@WebAction(Permission.OPENLOSS_ADD)
	@ResponseBody
	@RequestMapping(value = "/doCheckerApprove", method = RequestMethod.POST)	
	public StatusResult<List<String>> doCheckerApprove(String oldCardNo,String newCardNo,String cbPrdct1,String yajin,String varBlock0str,String trxnCode,String varRn_reason,String varNC_EMERGENCY) {
		String staffId = WebContext.getCurrentStaff().getId();
		System.out.println("--写卡--："+newCardNo);
		StatusResult<List<String>> r = supplementService.doCheckerApprove(oldCardNo,newCardNo,cbPrdct1,yajin,varBlock0str,trxnCode,varRn_reason,varNC_EMERGENCY,staffId);
		return r;
	}
	
}
