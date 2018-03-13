package cn.happyworlds.imgmt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpMermst;
import cn.happyworlds.imgmt.entity.CpMerupd;
import cn.happyworlds.imgmt.mapper.CpMermstMapper;
import cn.happyworlds.imgmt.mapper.CpMerupdMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.util.Result;

@Service
public class MerchantService {

	@Autowired
	private CpMermstMapper cpMermstMapper;
	@Autowired
	private CpMerupdMapper cpMerupdMapper;
	
	
	//场馆授权后查询
	public Result<PageInfo<CpMermst>> venueList( String mmMerchantNo, String mmDbaName, String mmBizName,
			String mmPmtMode, PageBounds pageBounds) {
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(mmMerchantNo)) {
			params.put("mmMerchantNo", mmMerchantNo);
		}
		if (StringUtils.hasText(mmDbaName)) {
			params.put("mmDbaName", mmDbaName);
		}
		/*if(StringUtils.hasText(mmStmtName)){
			params.put("mmStmtName", mmStmtName);
		}*/
		if (StringUtils.hasText(mmBizName)) {
			params.put("mmBizName", mmBizName);
		}
		if(!"0".equals(mmPmtMode)){
			if (StringUtils.hasText(mmPmtMode)) {
				params.put("mmPmtMode", mmPmtMode);
			}
		}
		params.put("mmPhyState", "0");
		params.put("mmRiskStatus", "1");
		List<CpMermst> page = cpMermstMapper.searchCpMermstByParams(params, pageBounds);
		return Result.create(new PageInfo<CpMermst>(page));
	}
	
	//商户授权后查询列表
	public Result<PageInfo<CpMermst>> merchantList(String mmMerchantNo,String mmDbaName,String mmBizName,PageBounds pageBounds){
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(mmMerchantNo)) {
			params.put("mmMerchantNo", mmMerchantNo);
		}
		if (StringUtils.hasText(mmDbaName)) {
			params.put("mmDbaName", mmDbaName);
		}
		if (StringUtils.hasText(mmBizName)) {
			params.put("mmBizName", mmBizName);
		}
		List<CpMermst> page = cpMermstMapper.searchCpMermstByParams(params, pageBounds);
		return Result.create(new PageInfo<CpMermst>(page));
	}
	
	//商户授权后查询列表
	public Result<PageInfo<CpMermst>> merchantList1(String mmMerchantNo,String mmDbaName,String mmBizName, String mmChainAccno,PageBounds pageBounds){
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(mmMerchantNo)) {
			params.put("mmMerchantNo", mmMerchantNo);
		}
		if (StringUtils.hasText(mmDbaName)) {
			params.put("mmDbaName", mmDbaName);
		}
		if (StringUtils.hasText(mmBizName)) {
			params.put("mmBizName", mmBizName);
		}
		//商户必输条件
		params.put("mmPhyState", "1");
		//归属场馆
		if (StringUtils.hasText(mmChainAccno)){
			params.put("mmChainAccno", mmChainAccno);
		}
		
		List<CpMermst> page = cpMermstMapper.searchCpMermstByParams(params, pageBounds);
		return Result.create(new PageInfo<CpMermst>(page));
	}
	
	
	//场馆维护后查询列表
	public Result<PageInfo<CpMermst>> venueMermstList(String mmMerchantNo,String mmBizName, PageBounds pageBounds){
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(mmMerchantNo)) {
			params.put("mmMerchantNo", mmMerchantNo);
		}
		if (StringUtils.hasText(mmBizName)) {
			params.put("mmBizName", mmBizName);
		}
		//场馆必输条件
		params.put("mmPhyState", "0");
		params.put("mmRiskStatus", "1");
		List<CpMermst> page = cpMermstMapper.searchCpMermstByParams(params, pageBounds);
		return Result.create(new PageInfo<CpMermst>(page));
	}
	
	
	//商户维护后查询列表
	public Result<PageInfo<CpMermst>> mermstList(String mmMerchantNo,String mmBizName, PageBounds pageBounds){
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(mmMerchantNo)) {
			params.put("mmMerchantNo", mmMerchantNo);
		}
		if (StringUtils.hasText(mmBizName)) {
			params.put("mmBizName", mmBizName);
		}
		//商户必输条件
		params.put("mmPhyState", "1");
		params.put("mmRiskStatus", "1");
		List<CpMermst> page = cpMermstMapper.searchCpMermstByParams(params, pageBounds);
		return Result.create(new PageInfo<CpMermst>(page));
	}
	
	
	//场馆维护后查询等待授权列表数据
	public Result<PageInfo<CpMerupd>> venueMerupdAuthList(String mmMerchantNo, String mmBizName,
			PageBounds pageBounds) {
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(mmMerchantNo)) {
			params.put("mmMerchantNo", mmMerchantNo);
		}
		if (StringUtils.hasText(mmBizName)) {
			params.put("mmBizName", mmBizName);
		}
		// 场馆必输条件
		params.put("mmPhyState", "0");
		params.put("mmRiskStatus", "1");
		List<CpMerupd> page = cpMerupdMapper.searchCpMerupdByParams(params, pageBounds);
		return Result.create(new PageInfo<CpMerupd>(page));
	}
	

	//商户维护后查询等待授权列表数据
	public Result<PageInfo<CpMerupd>> merupdAuthList(String mmMerchantNo, String mmBizName,
			PageBounds pageBounds) {
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(mmMerchantNo)) {
			params.put("mmMerchantNo", mmMerchantNo);
		}
		if (StringUtils.hasText(mmBizName)) {
			params.put("mmBizName", mmBizName);
		}
		// 商户必输条件
		params.put("mmPhyState", "1");
		params.put("mmRiskStatus", "1");
		List<CpMerupd> page = cpMerupdMapper.searchCpMerupdByParams(params, pageBounds);
		return Result.create(new PageInfo<CpMerupd>(page));
	}
	
	
	
	public Result<CpMermst> merchantGetById(String id) {
		CpMermst dbStaff = cpMermstMapper.searchCpMermstByMmMerchantNo(id);
		if (null == dbStaff) {
			return Result.create("STAFF_NOT_EXISTS", "场馆不存在");
		}
		return Result.create(dbStaff);
	}

}
