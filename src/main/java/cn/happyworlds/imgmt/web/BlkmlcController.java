package cn.happyworlds.imgmt.web;


import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.happyworlds.imgmt.entity.CpCrdtbl;
import cn.happyworlds.imgmt.entity.CpCsttbl;
import cn.happyworlds.imgmt.entity.CpIdtype;
import cn.happyworlds.imgmt.entity.CpPrdgrp;
import cn.happyworlds.imgmt.entity.TSysRole;
import cn.happyworlds.imgmt.service.CpBlkmlcService;
import cn.happyworlds.imgmt.service.CpCsttblService;
import cn.happyworlds.imgmt.service.CrdtblService;
import cn.happyworlds.imgmt.service.IdtypeService;
import cn.happyworlds.imgmt.service.PrdgrpService;
import cn.happyworlds.imgmt.service.RoleService;
import cn.happyworlds.imgmt.to.Constants;
import cn.happyworlds.imgmt.util.Result;
import cn.happyworlds.imgmt.util.StatusResult;
import cn.happyworlds.imgmt.util.StringUtil;

@Controller
@RequestMapping("/blkmlc")
public class BlkmlcController {

	@Autowired
	private CpBlkmlcService blkmlcService;
	@Autowired
	private IdtypeService IdtypeService;// 证件类型表
	@Autowired
	private PrdgrpService PrdgrpService;// 票务种类表
	@Autowired
	private CrdtblService crdtblService;// 卡表
	@Autowired
	private CpCsttblService cpCsttblService;// 账户表
	@Autowired
	private RoleService roleService;// 角色表
	Result<List<CpIdtype>> idTypeList = null;
	Result<List<CpPrdgrp>> prdGrpList = null;
	List<TSysRole> roles = null;

	//挂失
	@WebAction(Permission.LOSS_ADD)
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model m) {
		idTypeList = IdtypeService.idTypeListAll();
		prdGrpList = PrdgrpService.prdGrpListAll();
		roles = roleService.roleList();
		
		
		System.out.println("idType:"+idTypeList+"---prdGrp:"+prdGrpList+"---role:"+roles);
		m.addAttribute("idTypeList", idTypeList.getValue());
		m.addAttribute("prdGrpList", prdGrpList.getValue());
		m.addAttribute("roles", roles);
		return "blkmlc/add";
	}

	//解挂
	@WebAction(Permission.LOSS_OPENADD)
	@RequestMapping(value = "/openadd", method = RequestMethod.GET)
	public String openAdd(Model m) {
		idTypeList = IdtypeService.idTypeListAll();
		prdGrpList = PrdgrpService.prdGrpListAll();
		roles = roleService.roleList();
		m.addAttribute("idTypeList", idTypeList.getValue());
		m.addAttribute("prdGrpList", prdGrpList.getValue());
		m.addAttribute("roles", roles);
		return "blkmlc/openadd";
	}
	
	

	// 挂失查询卡号,跟着证件类型，身份证号码查会员名下的持卡人号码，表用的是CP_CRDTBL卡表
	@ResponseBody
	@RequestMapping(value = "/show", method = RequestMethod.POST)
	public List show(String cbIdType, String cbIdno) {
		// 查询是否有会员
		List<CpCsttbl> cpCsttbl = cpCsttblService.searchCpCsttblByParams(cbIdType, cbIdno);
		if (cpCsttbl.size() == 0) {
			return cpCsttbl;
		}
		// 得到卡号
		System.out.println("得到卡号");
		List<CpCrdtbl> cpCrdtbl = crdtblService.curTblListGetByIdCbIdTypeAndCbIdno(cbIdType, cbIdno);
		return cpCrdtbl;
	}

	// 根据一个卡号（持卡人号码）查数据，表用CP_CRDTBL卡表
	@ResponseBody
	@RequestMapping(value = "/getInfo", method = RequestMethod.POST)
	public CpCrdtbl getInfo(String cbCardholderNo) {
		CpCrdtbl cpCrdtbl = crdtblService.curTblListGetById(cbCardholderNo);
		return cpCrdtbl;
	}

	// 根据一个卡号（持卡人号码）查会员余额，表用cp_csttbl账户表
	@ResponseBody
	@RequestMapping(value = "/getBalance", method = RequestMethod.POST)
	public CpCsttbl getBalance(String cbCustomerIdno) {
		CpCsttbl cpCsttbl = cpCsttblService.searchCpCsttblByCbCustomerIdno(cbCustomerIdno);
		return cpCsttbl;
	}

	@WebAction(Permission.STAFF_ADD)
	@RequestMapping(value = "/freeAdd", method = RequestMethod.GET)
	public String freeAdd(Model m) {

		Result<List<CpIdtype>> idTypeList = IdtypeService.idTypeListAll();
		Result<List<CpPrdgrp>> prdGrpList = PrdgrpService.prdGrpListAll();
		m.addAttribute("idTypeList", idTypeList.getValue());
		m.addAttribute("prdGrpList", prdGrpList.getValue());
		m.addAttribute("roles", roleService.roleList());
		return "blkmlc/freeAdd";
	}

	@WebAction(Permission.STAFF_ADD)
	@RequestMapping(value = "/lossTicket", method = RequestMethod.GET)
	public String lossTicket(Model m) {

		Result<List<CpIdtype>> idTypeList = IdtypeService.idTypeListAll();
		Result<List<CpPrdgrp>> prdGrpList = PrdgrpService.prdGrpListAll();
		m.addAttribute("idTypeList", idTypeList.getValue());
		m.addAttribute("prdGrpList", prdGrpList.getValue());
		m.addAttribute("roles", roleService.roleList());
		return "blkmlc/lossTicket";
	}

	// 挂失获取卡信息
	@WebAction(Permission.LOSS_ADD)
	@ResponseBody
	@RequestMapping(value = "/getCardInfo", method = RequestMethod.POST)
	public StatusResult<String[]> getCardInfo(String idType, String idNo,String cbPlasticCd) {
		try {
			List crdtblList = crdtblService.getCrdtblList(idType, idNo,cbPlasticCd);
			String[] res = new String[crdtblList.size()];
			if (null != crdtblList && crdtblList.size() > 0) {
				for (int i = 0; i < crdtblList.size(); i++) {
					CpCrdtbl crdtbl = (CpCrdtbl) crdtblList.get(i);
					res[i] = crdtbl.getCbCardholderNo();
				}
			}
			if (null == res || res.length <= 0) {
				return StatusResult.create("FAILE", "使用证件信息没有找到对应数据");
			} else {
				return StatusResult.create(res);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// 挂失获取卡信息
	@WebAction(Permission.LOSS_ADD)
	@ResponseBody
	@RequestMapping(value = "/getCardInfo1", method = RequestMethod.POST)
	public StatusResult<String[]> getCardInfo1(String cardNo){
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
	
//	手机号获取挂失卡信息
	@WebAction(Permission.LOSS_ADD)
	@ResponseBody
	@RequestMapping(value="/getCardInfo2", method = RequestMethod.POST)
	public StatusResult<String[]> getCardInfo2(String mobile,String cbPlasticCd){
		try {
			String result[] = crdtblService.getCardInfo2(mobile,cbPlasticCd);
			if(null ==result || result.length <= 0){
				return StatusResult.create("FAILE", "没有找到卡信息记录");
			}else{
				return StatusResult.create(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	//挂失|解挂提交
	@WebAction(Permission.LOSS_ADD)
	@ResponseBody
	@RequestMapping(value = "/loseCard", method = RequestMethod.POST)
	public StatusResult<String> loseCard(String cardNo,String newPlasticCode) {
		String staffId = WebContext.getCurrentStaff().getId();
		cardNo=Constants.baseBIN+cardNo;
		System.out.println("-----------card:"+cardNo);
		try{
			StatusResult<String> r=blkmlcService.loseCard(cardNo, newPlasticCode,staffId);
			return r;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	// 会员提现获取卡面号
	@WebAction(Permission.LOSS_ADD)
	@ResponseBody
	@RequestMapping(value = "/getRecommInfo", method = RequestMethod.POST)
	public StatusResult<CpCrdtbl> getRecommInfo(String idType, String idNo,String cbRecommenderNo) {
		try {
			if(StringUtils.isEmpty(cbRecommenderNo)){
				return StatusResult.create("FAILE", "卡面号不能为空");
			}
			
			List<CpCrdtbl> crdtblList = crdtblService.getCbRecommenderNo(idType, idNo);
			if(!StringUtil.hasText(crdtblList)){
				return StatusResult.create("FAILE", "证件号找不到对应会员卡");
			}			
			if(crdtblList.size() > 1){
				return StatusResult.create("FAILE", "使用证件信息没有找到对应数据");
			}
			CpCrdtbl crdtbl = new CpCrdtbl();
				for (int i = 0; i < crdtblList.size(); i++) {					
					String Recommend = crdtblList.get(i).getCbRecommenderNo();
					
					if(!cbRecommenderNo.equals(Recommend.substring(6, Recommend.length()))){
						return StatusResult.create("FAILE", "身份证和卡面号不匹配");
					}
					crdtbl =  crdtblList.get(i);
				}
				return StatusResult.create(crdtbl);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
