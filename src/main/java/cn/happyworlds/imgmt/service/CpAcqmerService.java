package cn.happyworlds.imgmt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpAcqgrp;
import cn.happyworlds.imgmt.entity.CpAcqmer;
import cn.happyworlds.imgmt.mapper.CpAcqgrpMapper;
import cn.happyworlds.imgmt.mapper.CpAcqmerMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.util.Result;

@Service
public class CpAcqmerService {

	@Autowired
	private CpAcqmerMapper cpAcqmerMapper;
	@Autowired
	private CpAcqgrpMapper cpAcqgrpMapper;
	
	
	/**
	 * 查询所有受理点分组
	 * 
	 * @author Hugh
	 */
	public List<CpAcqmer> cpAcqmerList() {
		List<CpAcqmer> page = cpAcqmerMapper.searchCpAcqmerByParams(null);
		return page;
	}
	
	
	/**
	 * 条件查询所有受理点商户分组	
	 */
	public Result<PageInfo<CpAcqmer>> CpAcqmerAll(final String amGroupId, final String amMerchantId, PageBounds pageBounds) {
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(amGroupId)) {
			params.put("amGroupId", amGroupId);
		}
		if (StringUtils.hasText(amMerchantId)) {
			params.put("amMerchantId", amMerchantId);
		}
		List<CpAcqmer> page = cpAcqmerMapper.searchCpAcqmerByParams(params, pageBounds);
		List<CpAcqgrp> pageCpAcqgrp = cpAcqgrpMapper.searchCpAcqgrpByParams(null);
		for (int i = 0; i < page.size(); i++) {
			for (int j = 0; j < pageCpAcqgrp.size(); j++) {
				if(page.get(i).getAmGroupId().equals(pageCpAcqgrp.get(j).getAlGroupId())){
					page.get(i).setAmGroupdec(pageCpAcqgrp.get(j).getAlDesc());
				}
			}
		}
		return Result.create(new PageInfo<CpAcqmer>(page));
	}
	
	/**
	 * 查询一个受理点商户分组
	 */
	public CpAcqmer searchCpAcqmerByParams(String amGroupId,String amMerchantId){
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(amGroupId)) {
			params.put("amGroupId", amGroupId);
		}
		if (StringUtils.hasText(amMerchantId)) {
			params.put("amMerchantId", amMerchantId);
		}
		List<CpAcqmer> cpAcqmers = cpAcqmerMapper.searchCpAcqmerByParams(params);
		return cpAcqmers.get(0);
	}
	
	/**
	 * 添加受理点商户分组
	 */
	public Result<CpAcqmer> insertCpAcqmer(CpAcqmer cpAcqmer){
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(cpAcqmer.getAmGroupId().toString())) {
			params.put("amGroupId", cpAcqmer.getAmGroupId().toString());
		}
		if (StringUtils.hasText(cpAcqmer.getAmMerchantId())) {
			params.put("amMerchantId", cpAcqmer.getAmMerchantId());
		}
		List<CpAcqmer> cpAcqmers = cpAcqmerMapper.searchCpAcqmerByParams(params);
		if(cpAcqmers.size()>0){
			return Result.create("DUPLICATING", "同样的闸机描述和 馆描述已经存在于列表中！");
		}
		cpAcqmer.setChecksum("");
		cpAcqmerMapper.insertCpAcqmer(cpAcqmer);
		return Result.create(cpAcqmer);
	}
	
	/**
	 * 更新受理点商户分组
	 */
	public Result<CpAcqmer> update(CpAcqmer cpAcqmer){
		try {
			Map<String, String> params = new HashMap<>();
			params.put("amRecycleType", cpAcqmer.getAmRecycleType());
			//params.put("amRecycleDate", cpAcqmer.getAmRecycleDate().toString());
			params.put("amUserDefine1", cpAcqmer.getAmUserDefine1().toString());
			params.put("amMerchantId", cpAcqmer.getAmMerchantId());
			params.put("amGroupIdCondition", cpAcqmer.getAmGroupId().toString());
			params.put("amUserDefine0", cpAcqmer.getAmUserDefine0().toString());
			params.put("amUserDefine2", cpAcqmer.getAmUserDefine2().toString());
			params.put("amUserDefine3", cpAcqmer.getAmUserDefine3().toString());
			params.put("amUserDefine4", cpAcqmer.getAmUserDefine4().toString());
			cpAcqmerMapper.updateCpAcqmerByParams(params);
		} catch (Throwable t) {
			t.printStackTrace();
			return Result.create("CpAcqmer_UPDATE_FAILED", "闸机更新失败");
		}
		return Result.create(cpAcqmer);
	}
	/**
	 * 删除闸机
	 */
	public Result<CpAcqmer> delete(String amGroupId,String amMerchantId){
		try {
			Map<String, String> params = new HashMap<>();
			params.put("amGroupId", amGroupId);
			params.put("amMerchantId", amMerchantId);
			cpAcqmerMapper.deleteCpAcqmer(params);
		} catch (Throwable t) {
			t.printStackTrace();
			return Result.create("CpAcqmer_UPDATE_FAILED", "闸机删除失败");
		}
		return Result.create(null);
	}
	
	/**
	 * 
	 * @return
	 */
	public CpAcqmer maxAmGroupId(){
		CpAcqmer cpAcqmer= cpAcqmerMapper.searchMaxAmGroupId();
		return cpAcqmer;
	}
}
