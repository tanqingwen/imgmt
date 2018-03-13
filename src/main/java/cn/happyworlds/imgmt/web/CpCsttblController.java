package cn.happyworlds.imgmt.web;


import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpCrdtbl;
import cn.happyworlds.imgmt.entity.CpCsttbl;
import cn.happyworlds.imgmt.entity.CpIndacc;
import cn.happyworlds.imgmt.mapper.CpCrdtblMapper;
import cn.happyworlds.imgmt.mapper.CpCsttblMapper;
import cn.happyworlds.imgmt.mapper.CpIndaccMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.service.CpCrdtblService;
import cn.happyworlds.imgmt.service.CpCsttblService;
import cn.happyworlds.imgmt.util.Result;
import cn.happyworlds.imgmt.util.StatusResult;

@CrossOrigin
@Controller
@RequestMapping("/cpcsttbl")
public class CpCsttblController {
	
	
	@Autowired
	private CpCsttblService cpcsttblService;
	
	@Autowired
	private CpCrdtblService cpcrdtblService;
	
	@Autowired
	private CpCsttblMapper cstMapper;
	
	@Autowired
	private CpCrdtblMapper crdMapper;
	
	@Autowired
	private CpIndaccMapper indMapper;
	/**
	 * 会员ID，会员姓名，会员手机号，会员证件号
	 */
	
	//查询会员信息
	@RequestMapping("/cpcsttblQueryStat")
	public String CpCsttblQueryStat(HttpServletRequest  request, Integer p, Model m) {			
		String cbMemberCode=request.getParameter("cbMemberCode");
		String cbCustomerIdno=request.getParameter("cbCustomerIdno");
		String cbCardholderName=request.getParameter("cbCardholderName");
		String cbMobileNo=request.getParameter("cbMobileNo");			
		Result<PageInfo<CpCsttbl>> result = cpcsttblService.searchCpCsttblList(cbMemberCode,cbCustomerIdno,cbCardholderName,cbMobileNo, new PageBounds(p,10));  
		
		if (result.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("pageInfo", result.getValue());
		}
		return "login1";
	}
	
	@RequestMapping("/cpcrdtblCbIdno")
	public String CpCrdtblCbIdno(HttpServletRequest  request,Model m,Integer p) {
		String cbCustomerIdno=request.getParameter("cbCustomerIdno");			
		Result<CpCrdtbl> result = cpcrdtblService.searchCpCsttblCbIdno(cbCustomerIdno);  
		try {
			if (result.isError()) {
				
				m.addAttribute(WebContext.ACTION_FAILURE_TIP, "没有绑定会员卡");
				String cbMemberCode=request.getParameter("cbMemberCode");
				String cbCardholderName=request.getParameter("cbCardholderName");
				String cbMobileNo=request.getParameter("cbMobileNo");
				Result<PageInfo<CpCsttbl>> result2 = cpcsttblService.searchCpCsttblList(cbMemberCode,cbCustomerIdno,cbCardholderName,cbMobileNo, new PageBounds(p,10));  
				
				if (result.isError()) {
					m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
				} else {
					m.addAttribute("pageInfo", result2.getValue());
				}
				System.out.println("麻蛋1111");
				return "member/list";
				
			} else {
				m.addAttribute("pageInfo", result.getValue());
			}
		} catch (Exception e) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
			// TODO: handle exception
			e.printStackTrace();
		}	
		System.out.println("麻蛋4444");
		return "member/list_card";
	}
	
	
	
	@ResponseBody
	@RequestMapping(value="/seachWechat",method=RequestMethod.GET,produces = "application/json")
	public StatusResult  seachWechat(String openId){
		if(!StringUtils.isNotEmpty(openId)){
			return StatusResult.create("FALSE", "openId不能为空");
		}
		CpCsttbl cpCsttbl=cstMapper.searchCpCsttblOpenId(openId);
		if(cpCsttbl == null){
			return StatusResult.create("FALSE", "此用户未绑定身份证");
		}
		CpCrdtbl cpCrdtbl=crdMapper.searchCpCrdtblByCbIdno(cpCsttbl.getCbCustomerIdno());
		if(cpCrdtbl == null){
			return StatusResult.create("FALSE", "此用户没有在使用的会员卡");
		}
		CpIndacc cpIndacc=indMapper.searchCpIndaccByAcctNo(cpCrdtbl.getCbIndividualAcctno());
		if(cpIndacc == null){
			return StatusResult.create("FALSE", "此用户的账户不存在");
		}
		return StatusResult.create("SUCCESS",cpIndacc.getCbOutstdBal());
	}
	
}
