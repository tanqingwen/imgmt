package cn.happyworlds.imgmt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpAcqgrp;
import cn.happyworlds.imgmt.mapper.CpAcqgrpMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.util.Result;

@Service
public class CpAcqgrpService {

	@Autowired
	private CpAcqgrpMapper cpAcqgrpMapper;
	
	/**
	 * 查询所有受理点分组
	 * 
	 * @author Hugh
	 */
	public List<CpAcqgrp> CpAcqgrpList() {
		List<CpAcqgrp> page = cpAcqgrpMapper.searchCpAcqgrpByParams(null);
		return page;
	}
	
	
	/**
	 * 条件查询所有受理点分组
	 * 
	 * @author Hugh
	 */
	public Result<PageInfo<CpAcqgrp>> CpAcqgrpAll(final String alGroupId, final String alDesc, PageBounds pageBounds) {
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(alGroupId)) {
			params.put("alGroupId", alGroupId);
		}
		if (StringUtils.hasText(alDesc)) {
			params.put("alDesc", alDesc);
		}
		// 状态为1
		params.put("status", "1");
		List<CpAcqgrp> page = cpAcqgrpMapper.searchCpAcqgrpByParams(params, pageBounds);
		return Result.create(new PageInfo<CpAcqgrp>(page));
	}
	
	
	/**
	 * 查询一个受理点分组
	 * 
	 * @author Hugh
	 */
	public CpAcqgrp searchCpAcqgrpByAlGroupId(Integer alGroupId){
		CpAcqgrp cpAcqgrp = cpAcqgrpMapper.searchCpAcqgrpByAlGroupId(new Long(alGroupId));
		return cpAcqgrp;
	}
	
	
	/**
	 * 添加受理点分组
	 * 
	 * @author Hugh
	 */
	public Result<CpAcqgrp> insertCpAcqgrp(CpAcqgrp cpAcqgrp){
		CpAcqgrp acqgrp = cpAcqgrpMapper.searchCpAcqgrpByAlGroupId(cpAcqgrp.getAlGroupId());
		if(acqgrp!=null){
			return Result.create("DUPLICATING", "同样的分组号已经存在于列表中！");
		}
		cpAcqgrp.setChecksum("");
		//添加状态
		cpAcqgrp.setStatus(new Long(1));
		cpAcqgrpMapper.insertCpAcqgrp(cpAcqgrp);
		return Result.create(acqgrp);
	}
	
	
	/**
	 * 更新受理点分组
	 * 
	 * @author Hugh
	 */
	public Result<CpAcqgrp> update(CpAcqgrp acqgrp){
		try {
			cpAcqgrpMapper.updateCpAcqgrp(acqgrp);
		} catch (Throwable t) {
			t.printStackTrace();
			return Result.create("CpAcqgrp_UPDATE_FAILED", "受理点分组更新失败");
		}
		return Result.create(acqgrp);
	}
	
	
	/**
	 * 场馆组自增长 
	 * 
	 * @author Hugh
	 * @return
	 */
	public String maxGroupId() {

		CpAcqgrp acqgrpDto = cpAcqgrpMapper.searchMaxGroupId();
		return String.valueOf(acqgrpDto);
	}
}
