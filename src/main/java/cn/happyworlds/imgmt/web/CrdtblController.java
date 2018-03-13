package cn.happyworlds.imgmt.web;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.happyworlds.imgmt.bean.HappyCardBean;
import cn.happyworlds.imgmt.entity.CpIdtype;
import cn.happyworlds.imgmt.entity.CpPrdgrp;
import cn.happyworlds.imgmt.service.CrdtblService;
import cn.happyworlds.imgmt.service.IdtypeService;
import cn.happyworlds.imgmt.service.PrdgrpService;
import cn.happyworlds.imgmt.service.RoleService;
import cn.happyworlds.imgmt.to.Constants;
import cn.happyworlds.imgmt.util.Result;
import cn.happyworlds.imgmt.util.StatusResult;
import cn.happyworlds.imgmt.util.StringUtil;
import cn.happyworlds.imgmt.util.ToolsUtil;

@Controller
@RequestMapping("/crdtbl")
public class CrdtblController {

	@Autowired
	private CrdtblService crdtblService;

	@Autowired
	private PrdgrpService PrdgrpService;
	@Autowired
	private IdtypeService IdtypeService;
	@Autowired
	private RoleService roleService;

	//@WebAction(Permission.CARD_ADD)
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model m) {

		Result<List<CpIdtype>> idTypeList = IdtypeService.idTypeListAll();
		Result<List<CpPrdgrp>> prdGrpList = PrdgrpService.prdGrpListAll();
		m.addAttribute("idTypeList", idTypeList.getValue());
		m.addAttribute("prdGrpList", prdGrpList.getValue());
		m.addAttribute("roles", roleService.roleList());
		return "crdtbl/add";
	}

	// 掌静脉登记
	//@WebAction(Permission.CARD_ADD)
	@ResponseBody
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public StatusResult<String[]> register(HttpServletRequest request, String barcode) {

		String clientIp = ToolsUtil.getIpAddr(request);
		String[] rtnResult = crdtblService.RtnResult(clientIp, barcode);
		System.out.println("掌静脉信息: " + rtnResult);
		return StatusResult.create(rtnResult);
	}

	// 登记处理
	//@WebAction(Permission.CARD_ADD)
	@ResponseBody
	@RequestMapping(value = "/sign", method = RequestMethod.POST)
	public StatusResult<String[]> sign(HttpServletRequest request, String barcode) {
		String clientIp = ToolsUtil.getIpAddr(request);
		String[] siResult = crdtblService.RtnSign(clientIp, barcode);
		return StatusResult.create(siResult);
	}

	// 取消掌处理
	//@WebAction(Permission.CARD_ADD)
	@ResponseBody
	@RequestMapping(value = "/cancel", method = RequestMethod.POST)
	public StatusResult<String[]> cancel(HttpServletRequest request, String barcode) {

		String clientIp = ToolsUtil.getIpAddr(request);
		String[] canResult = crdtblService.RtnCancel(clientIp, barcode);
		return StatusResult.create(canResult);
	}

	//@WebAction(Permission.CARD_ADD)
	@ResponseBody
	@RequestMapping(value = "/openCard", method = RequestMethod.POST)
	public StatusResult<List<String>> openCard(String cbCardholderNo, String cbIdType, String idNo, String birthday,
			String mobile, String preAmount, String uname, String prProdctGroup, String deposit, String cardtype,
			String block0str) throws ParseException {

		List<String> res = new ArrayList<String>();
		// m1是空卡|随机生成一个卡号、不然就引用页面卡号
		StatusResult<List<String>> r = crdtblService.genCardNo();

		if ("FALSE".equals(r.getStatus())) {
			return r;
		}
		if (!StringUtil.hasText(cbCardholderNo)) {
			cbCardholderNo = r.getValue().get(0).toString();
		}

		// 身份证
		if ("1".equals(cbIdType)) {
			birthday = idNo.substring(6, 14);
		}

		double p = 0d;
		double c = 0d;

		if (StringUtil.hasText(preAmount)) {
			p = Double.valueOf(preAmount);
			c = Double.valueOf(deposit); // 押金
			if (p < c) {
				return StatusResult.create("FALSE", "预存金额不能低于押金");
			}
		}

		String staffId = WebContext.getCurrentStaff().getId();
		StatusResult<List<String>> r1 = crdtblService.openHCard(deposit, cbCardholderNo, cbIdType, idNo, uname, mobile,
				prProdctGroup, birthday, staffId);
		if ("FALSE".equals(r1.getStatus())) {
			return r1;
		}

		try {
			HappyCardBean happyCardBean = new HappyCardBean();
			List<String> nlist = happyCardBean.newCard(cbCardholderNo, uname, block0str, cardtype,birthday);
			res = new ArrayList<String>();
			if (StringUtil.hasText(preAmount)) {
				StatusResult<List<String>> r2 = crdtblService.doCharge(cbCardholderNo, Double.toString(p - c),
						"DEPOSIT", "充值", staffId);
				if ("FALSE".equals(r2.getValue())) {
					return r2;
				}
			}
			res = nlist;
		} catch (Exception e) {
			e.printStackTrace();
			StatusResult.create("FALSE", "后台处理异常报错,请查看");
		}
		return StatusResult.create(res);
	}

	// 文件上传
	//@WebAction(Permission.CARD_ADD)
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
	public StatusResult<String> upload(String barcode, MultipartFile myfile) {

		String rtnResult = crdtblService.getUploadFile(barcode, myfile);
		return StatusResult.create(rtnResult);
	}

	// 实卡激活作业跳转
	@WebAction(Permission.CRDTBL_LIST)
	@RequestMapping(value = "/activeCard", method = RequestMethod.GET)
	public String activeCard(Model m) {

		return "crdtbl/list";
	}

	
	// 炎武制卡作业操作
	@WebAction(Permission.CRDTBL_LIST)
	@ResponseBody
	@RequestMapping(value = "/activeCard", method = RequestMethod.POST)
	public StatusResult<List<String>> activeCard(String cbRecommenderNo, String cbRwdsAccno, String block0str)
			throws ParseException {

		String staffId = WebContext.getCurrentStaff().getId();
		List<String> res = new ArrayList<String>();
		Map<String, String> keyMap = new HashMap<String, String>();
		HappyCardBean happyCardBean = new HappyCardBean();

		String cardNo =crdtblService.searchMaxCrdNo(); //10位实卡号
		String allCardNo = Constants.baseBIN + cardNo; //16位实卡号
		
		StatusResult<String> r = crdtblService.insertDate("1100",allCardNo); //普通游客
		
		//绑卡号、实卡面流水号
		StatusResult<List<String>> r1 = crdtblService.activeHCard(allCardNo, cbRecommenderNo, cbRwdsAccno, staffId);
		if ("FALSE".equals(r1.getStatus())) {
			return r1;
		}

		try {
			keyMap = crdtblService.getkeyMap();
			// 查询实卡客户
			List<String> nlist = happyCardBean.newCard1(allCardNo, staffId, block0str, keyMap);
			res = new ArrayList<String>();
			res = nlist;
			return StatusResult.create(nlist);
		} catch (Exception e) {
			e.printStackTrace();
			StatusResult.create("FALSE", "后台处理异常报错,请查看");
		}
		return StatusResult.create(res);
	}
}
