package cn.happyworlds.imgmt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpCommodity;
import cn.happyworlds.imgmt.entity.CpPrdgrp;
import cn.happyworlds.imgmt.entity.CpTktype;
import cn.happyworlds.imgmt.entity.CpTrmacc;
import cn.happyworlds.imgmt.mapper.CpCommodityMapper;
import cn.happyworlds.imgmt.mapper.CpTktypeMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.util.Result;

@Service
public class CpCommodityService {

	@Autowired
	private CpCommodityMapper cpCommodityMapper;
	
	/**
	 * 查询所有商品
	 */
	public Result<PageInfo<CpCommodity>> cpCommodityList(final String ccTypeId, final String ccTypeDesc, PageBounds pageBounds) {
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(ccTypeId)) {
			params.put("ccTypeId", ccTypeId);
		}
		if (StringUtils.hasText(ccTypeDesc)) {
			params.put("ccTypeDesc", ccTypeDesc);
		}
		List<CpCommodity> page = cpCommodityMapper.searchCpCommodityByParams(params, pageBounds);
		return Result.create(new PageInfo<CpCommodity>(page));
	}
	public List<CpCommodity> findAllUsefulTktypeList(Map<String,String> params){
		 return  cpCommodityMapper.searchCpCommodityByParams(params, new PageBounds(1,20));
	}
	
	/**
	 * 查询一个商品
	 */
	public CpCommodity searchCpTktypeByTtTypeId(Integer ttTypeId){
		CpCommodity cpCommodity = cpCommodityMapper.searchCpCommodityByCcTypeId(ttTypeId);
		return cpCommodity;
	}
	
	/**
	 * 添加票劵
	 */
	public Result<CpCommodity> insertCpTktype(CpCommodity cpTktype){
	
		CpCommodity tktype = cpCommodityMapper.searchCpCommodityByCcTypeId(cpTktype.getCcTypeId());
		if(tktype!=null){
			return Result.create("DUPLICATING", "同样的商品ID已经存在于列表中！");
		}
		cpCommodityMapper.insertCpCommodity(cpTktype);
		return Result.create(tktype);
	}
	
	/**
	 * 更新商品
	 */
	public Result<CpCommodity> update(CpCommodity cpTktype){
		try {
			cpCommodityMapper.updateCpCommodity(cpTktype);
		} catch (Throwable t) {
			t.printStackTrace();
			return Result.create("CpTktype_UPDATE_FAILED", "商品更新失败");
		}
		return Result.create(cpTktype);
	}
	
	
	/**
	 * 票种id自动生成
	 * 
	 * @author Hugh
	 */
	public CpCommodity searchMaxTktype(){
		
		CpCommodity tktype = cpCommodityMapper.searchMaxCpCommodityId();
		return tktype;
	}
	
	
	
	/**
	 * 删除票种
	 */
	public Result<CpCommodity> delect(CpCommodity tktype) {
		try {
			cpCommodityMapper.deleteCpCommodityByCcTypeId(tktype.getCcTypeId());
		} catch (Throwable t) {
			t.printStackTrace();
			return Result.create("TKTYPE_DELETE_FAILED", "商品删除失败");
		}
		return Result.create(null);
	}
	
	
	
}
