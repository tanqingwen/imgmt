package cn.happyworlds.imgmt.web;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;   // allow controller
import org.springframework.ui.Model;   // allow model
import org.springframework.web.bind.annotation.RequestMapping;   // allow map tag
import org.springframework.web.bind.annotation.RequestMethod;   // allow post method
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.happyworlds.imgmt.entity.CpCrdtbl;
import cn.happyworlds.imgmt.entity.CpIdtype;
import cn.happyworlds.imgmt.entity.CpPrdgrp;
import cn.happyworlds.imgmt.entity.TSysStaff;
import cn.happyworlds.imgmt.service.CardSupplementService;
import cn.happyworlds.imgmt.service.CrdtblService;
import cn.happyworlds.imgmt.service.IdtypeService;
import cn.happyworlds.imgmt.service.PrdgrpService;
import cn.happyworlds.imgmt.service.RoleService;
import cn.happyworlds.imgmt.util.Result;
import cn.happyworlds.imgmt.util.StatusResult;

@Controller
@RequestMapping("/CardSupplement1")
public class CardSController {

	// Spring will inject the container only after using this annotation
	@Autowired
	private PrdgrpService PrdgrpService;
	@Autowired
	private IdtypeService IdtypeService;//证件类型表
	@Autowired
	private CrdtblService crdtblService;//卡表
	@Autowired
	private RoleService roleService;
	
	// go to add page
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model m) {
		Result<List<CpPrdgrp>> prdGrpList = PrdgrpService.prdGrpListAll();
		Result<List<CpIdtype>> idTypeList = IdtypeService.idTypeListAll();
		m.addAttribute("prdGrpList", prdGrpList.getValue());
		m.addAttribute("idTypeList", idTypeList.getValue());
		m.addAttribute("roles", roleService.roleList());
		return "card_supplement/list";
	}
	
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(String cbIdType,String cbIdno,String oldCbCardholderNo,String cbOutstdBal,String cbEmbossname,String cbSuspendDate,String cbSourceCd,String cbCardPrdctGroup,String newCbCardholderNo,String newCbCardPrdctGroup,String cbCvki) throws ParseException {
		//取用户
		TSysStaff currentStaff = WebContext.getCurrentStaff();
		StatusResult<String> r=null;
		//r = crdtblService.doCheck(oldCbCardholderNo);//补卡的挂失判断，挂失15分钟后才能换卡，换卡前请先挂失
		//if(r==null){
			//r = crdtblService.checkAllowCards(cbSuspendDate, cbIdType, cbIdno);
			r = crdtblService.doCheckerApprove(cbIdType,cbIdno,oldCbCardholderNo,cbOutstdBal,cbEmbossname,cbSuspendDate,cbSourceCd,cbCardPrdctGroup,newCbCardholderNo,newCbCardPrdctGroup,cbCvki,currentStaff);
			//return "补卡成功";
		//}
		/*String rtn = crdtblService.checkCardReplace(newCbCardholderNo, oldCbCardholderNo);
		if(rtn!="0"){
			r.setValue(rtn);
		}*/
		if(r==null){
			return "补卡成功";
		}
		return r.getComment();
	}
	
}
