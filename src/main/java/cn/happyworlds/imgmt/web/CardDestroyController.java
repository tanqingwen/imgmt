package cn.happyworlds.imgmt.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.happyworlds.imgmt.entity.CpCrdtbl;
import cn.happyworlds.imgmt.entity.CpIdtype;
import cn.happyworlds.imgmt.entity.CpPrdgrp;
import cn.happyworlds.imgmt.service.CardDestroyService;
import cn.happyworlds.imgmt.service.CrdtblService;
import cn.happyworlds.imgmt.service.IdtypeService;
import cn.happyworlds.imgmt.service.IndaccService;
import cn.happyworlds.imgmt.service.PrdgrpService;
import cn.happyworlds.imgmt.service.RoleService;
import cn.happyworlds.imgmt.tools.happypass.HappyCardforActiveX;
import cn.happyworlds.imgmt.util.Result;
import cn.happyworlds.imgmt.util.StatusResult;

@Controller
@RequestMapping("/CardDestroy")
public class CardDestroyController {

	@Autowired
	private IdtypeService IdtypeService;
	@Autowired
	private PrdgrpService PrdgrpService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private CardDestroyService cardDestroyService;
	@Autowired
	private IndaccService IndaccService;
	@Autowired
	private CrdtblService crdtblService;

	@RequestMapping("/list")
	public String search() {
		return "card_destroy/list";
	}
	
	
	//退卡
	@WebAction(Permission.CARD_BACK)
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model m) {
		
		Result<List<CpIdtype>> idTypeList = IdtypeService.idTypeListAll();
		Result<List<CpPrdgrp>> prdGrpList = PrdgrpService.prdGrpListAll();
		m.addAttribute("idTypeList", idTypeList.getValue());
		m.addAttribute("prdGrpList", prdGrpList.getValue());
		m.addAttribute("roles", roleService.roleList());
		return "card_destroy/add";
	}
	
	
	//退卡会员卡余额
	@WebAction(Permission.CARD_BACK)
	@ResponseBody
	@RequestMapping(value = "/readBalance", method = RequestMethod.POST)
	public StatusResult<String> getReadBalance(String str,String block0,String cardNo){
		return IndaccService.getBalance(cardNo);
	}

	//退卡获取卡信息
	@WebAction(Permission.CARD_BACK)
	@ResponseBody
	@RequestMapping(value = "/getCardInfo", method = RequestMethod.POST)
	public StatusResult<String[]> getCardInfo(String cardNumber){
		try{
			CpCrdtbl cpCrdtbl=crdtblService.getCrdtbl(cardNumber);
			String[] str=crdtblService.getCardInfo(cpCrdtbl);
			if(null==str || str.length<=0){
				return StatusResult.create("FALSE","使用证件信息没有找到对应数据");
			}else{
				return StatusResult.create(str);
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// 退卡信息获取
		@WebAction(Permission.CARD_BACK)
		@ResponseBody
		@RequestMapping(value = "/getCardInfo1", method = RequestMethod.POST)
		public StatusResult<String[]> getCardInfo1(String cardNo) {
			System.out.println("-----:"+cardNo);
			try {
				String result[] = crdtblService.getCardInfo1(cardNo);
				if (null == result || result.length <= 0) {
					return StatusResult.create("FAILE", "没有找到卡信息记录");
				} else {
					return StatusResult.create(result);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
	//退卡校验
	@WebAction(Permission.CARD_BACK)
	@ResponseBody
	@RequestMapping(value = "/checkCardNo", method = RequestMethod.POST)
	public StatusResult<String> checkCardNo(String cardNumber){
		String cardNo="";
		try{
			CpCrdtbl cpCrdtbl=crdtblService.getCrdtbl(cardNumber);
			if(null!=cpCrdtbl){
				cardNo=cpCrdtbl.getCbCardholderNo();
			}
			return StatusResult.create(cardNo);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	//退卡检查卡状态
	@WebAction(Permission.CARD_BACK)
	@ResponseBody
	@RequestMapping(value = "/checkState", method = RequestMethod.POST)
	public StatusResult<String> checkState(String cardNumber){
		try{
			//卡状态 
			String cardState=""; 	
			if(null!=cardNumber ||  !"".equals(cardNumber)){
				CpCrdtbl cpCrdtbl=crdtblService.getCrdtbl(cardNumber);
				if(null!=cpCrdtbl){
					cardState=cpCrdtbl.getCbPlasticCd();
				}
			}
			return StatusResult.create(cardState);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	//退卡检查更新对应表
	@WebAction(Permission.CARD_BACK)
	@ResponseBody
	@RequestMapping(value = "/doCheckerApprove", method = RequestMethod.POST)
	public StatusResult<String> doCheckerApprove(String cardNumber,String cbIdType,String cbIdno,String varDesc,String varDestype){
		try{
			String staffId = WebContext.getCurrentStaff().getId();
			return cardDestroyService.doCheckerApprove(cardNumber,cbIdType,cbIdno,staffId,varDesc,varDestype);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//退卡写实卡还原
	@WebAction(Permission.CARD_BACK)
	@ResponseBody
	@RequestMapping(value = "/doReset", method = RequestMethod.POST)
	public StatusResult<List<List<String>>> doReset(String cardNumber) {
		HappyCardforActiveX bcax = new HappyCardforActiveX();
		return StatusResult.create(bcax.doResetCard(cardNumber));
	}
	
}
