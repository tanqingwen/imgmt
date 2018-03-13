package cn.happyworlds.imgmt.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;   // allow Spring injection
import org.springframework.stereotype.Controller;   // allow controller
import org.springframework.ui.Model;   // allow model
import org.springframework.web.bind.annotation.RequestMapping;   // allow map tag
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.happyworlds.imgmt.entity.CpCrdtbl;
import cn.happyworlds.imgmt.entity.CpIdtype;
import cn.happyworlds.imgmt.entity.CpPrdgrp;
import cn.happyworlds.imgmt.entity.TSysStaff;
import cn.happyworlds.imgmt.service.CardDService;
import cn.happyworlds.imgmt.service.IdtypeService;
import cn.happyworlds.imgmt.service.PrdgrpService;
import cn.happyworlds.imgmt.service.RoleService;
import cn.happyworlds.imgmt.util.Result;

@Controller
@RequestMapping("/CardDestroy2")
public class CardDController {
	
	@Autowired
	private IdtypeService IdtypeService;
	@Autowired
	private PrdgrpService PrdgrpService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private CardDService cardDestroyService;

	//退卡，证件类型，用户等级
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model m) {
		Result<List<CpIdtype>> idTypeList = IdtypeService.idTypeListAll();
		Result<List<CpPrdgrp>> prdGrpList = PrdgrpService.prdGrpListAll();
		m.addAttribute("idTypeList", idTypeList.getValue());
		m.addAttribute("prdGrpList", prdGrpList.getValue());
		m.addAttribute("roles", roleService.roleList());
		return "card_destroy/add";
	}
	
	//输入持卡人号码点击读卡号
	@ResponseBody
	@RequestMapping(value = "/findCard", method = RequestMethod.POST)
	public List<CpCrdtbl> findCard(String cbCardholderNo) {
		List<CpCrdtbl> cpCrdtbls = new ArrayList<>();
		CpCrdtbl cpCrdtbl = cardDestroyService.searchCpCrdtblByParams(cbCardholderNo);
		cpCrdtbls.add(cpCrdtbl);
		return cpCrdtbls;
	}
	
	@RequestMapping("/destroy")
	public String destroy(CpCrdtbl cpCrdtbl,@RequestParam("varDesc") String varDesc, RedirectAttributes ra) {
		//取用户
		TSysStaff currentStaff = WebContext.getCurrentStaff();
		Result<CpCrdtbl> result = cardDestroyService.doCheckerApprove(cpCrdtbl.getCbCardholderNo(), varDesc, currentStaff);
		if(result!=null){
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, result.getComment());
			return "redirect:add";
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "退卡成功！");
		return "redirect:add";
	}
	
}
