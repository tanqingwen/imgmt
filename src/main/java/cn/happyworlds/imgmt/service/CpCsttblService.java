package cn.happyworlds.imgmt.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpCsttbl;
import cn.happyworlds.imgmt.entity.YwPayrecord;
import cn.happyworlds.imgmt.mapper.CpCsttblMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.util.Result;

@Service
public class CpCsttblService {

	@Autowired
	private CpCsttblMapper cpCsttblMapper;
	
	
	//查询会员信息
	public Result<PageInfo<CpCsttbl>> searchCpCsttblList(final String cbMemberCode, final String cbCustomerIdno, final String cbCardholderName, final String cbMobileNo, PageBounds pageBounds){
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(cbMemberCode)) {
			params.put("cbMemberCode", cbMemberCode);
		}
		if (StringUtils.hasText(cbCustomerIdno)) {
			params.put("cbCustomerIdno", cbCustomerIdno);
		}
		if (StringUtils.hasText(cbCardholderName)) {
			params.put("cbCardholderName", cbCardholderName);
		}
		if (StringUtils.hasText(cbMobileNo)) {
			params.put("cbMobileNo", cbMobileNo);
		}
		List<CpCsttbl> page = cpCsttblMapper.searchCpCsttblByParams(params, pageBounds);
		
		return Result.create(new PageInfo<CpCsttbl>(page));
	}
	
	
	//查询会员余额
	public CpCsttbl searchCpCsttblByCbCustomerIdno(String cbCustomerIdno) {
		CpCsttbl cpCsttbl = cpCsttblMapper.searchCpCsttblByCbCustomerIdno(cbCustomerIdno);
		return cpCsttbl;
	}
	
	public List<CpCsttbl> searchCpCsttblByParams(String cbIdType,String cbIdno) {
		//判断会员是否存在
		Map<String, String> cpCsttblParams = new HashMap<>();
		cpCsttblParams.put("cbIdType", cbIdType);
		cpCsttblParams.put("cbCustomerIdno",cbIdno);
				
		List<CpCsttbl> cpCsttbl = cpCsttblMapper.searchCpCsttblByParams(cpCsttblParams);
		return cpCsttbl;
	}
	
	//跟着证件种类和证件号码查数据，会员表Cp_Csttbl
	public List<CpCsttbl> searchCpCrdtblByParamsTocbIdTypeAndcbCustomerIdno(String cbIdType,String cbCustomerIdno) {
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(cbIdType)) {
			params.put("cbIdType", cbIdType);
		}
		if (StringUtils.hasText(cbCustomerIdno)) {
			params.put("cbCustomerIdno", cbCustomerIdno);
		}
		List<CpCsttbl> page = cpCsttblMapper.searchCpCsttblByParams(params);
		return page;
	}
	
	//跟着证件种类和证件号码查数据，会员表Cp_Csttbl
		public List<CpCsttbl> searchCpCsttblByParamsList(String cbMemberCode,String cbCustomerIdno,String cbCardholderName,String cbMobileNo) {
			Map<String, String> params = new HashMap<>();
			if (StringUtils.hasText(cbMemberCode)) {
				params.put("cbMemberCode", cbMemberCode);
			}
			if (StringUtils.hasText(cbCustomerIdno)) {
				params.put("cbCustomerIdno", cbCustomerIdno);
			}
			if (StringUtils.hasText(cbCardholderName)) {
				params.put("cbCardholderName", cbCardholderName);
			}
			if (StringUtils.hasText(cbMobileNo)) {
				params.put("cbMobileNo", cbMobileNo);
			}
			List<CpCsttbl> page = cpCsttblMapper.searchCpCsttblByParams(params);
			return page;
		}
	
		
}
