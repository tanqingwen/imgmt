package cn.happyworlds.imgmt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpPrdgrp;
import cn.happyworlds.imgmt.entity.CpTktype;
import cn.happyworlds.imgmt.entity.CpTrmacc;
import cn.happyworlds.imgmt.mapper.CpTktypeMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.util.Result;

@Service
public class CpTktypeService {

	@Autowired
	private CpTktypeMapper cpTktypeMapper;
	
	/**
	 * 查询所有票劵
	 */
	public Result<PageInfo<CpTktype>> cpTktypeList(final String ttTypeId, final String ttTypeDesc, PageBounds pageBounds) {
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(ttTypeId)) {
			params.put("ttTypeId", ttTypeId);
		}
		if (StringUtils.hasText(ttTypeDesc)) {
			params.put("ttTypeDesc", ttTypeDesc);
		}
		List<CpTktype> page = cpTktypeMapper.searchCpTktypeByParams(params, pageBounds);
		return Result.create(new PageInfo<CpTktype>(page));
	}
	public List<CpTktype> findAllUsefulTktypeList(Map<String,String> params){
		 return  cpTktypeMapper.searchCpTktypeByParams(params, new PageBounds(1,20));
	}
	
	/**
	 * 查询一个票劵
	 */
	public CpTktype searchCpTktypeByTtTypeId(Integer ttTypeId){
		CpTktype cpTktype = cpTktypeMapper.searchCpTktypeByTtTypeId(ttTypeId);
		return cpTktype;
	}
	
	/**
	 * 添加票劵
	 */
	public Result<CpTktype> insertCpTktype(CpTktype cpTktype){
		cpTktype.setTtTypeStatus("Y");
		CpTktype tktype = cpTktypeMapper.searchCpTktypeByTtTypeId(cpTktype.getTtTypeId());
		if(tktype!=null){
			return Result.create("DUPLICATING", "同样的票劵ID已经存在于列表中！");
		}
		cpTktypeMapper.insertCpTktype(cpTktype);
		return Result.create(tktype);
	}
	
	/**
	 * 更新票种
	 */
	public Result<CpTktype> update(CpTktype cpTktype){
		try {
			cpTktypeMapper.updateCpTktype(cpTktype);
		} catch (Throwable t) {
			t.printStackTrace();
			return Result.create("CpTktype_UPDATE_FAILED", "票劵更新失败");
		}
		return Result.create(cpTktype);
	}
	
	
	/**
	 * 票种id自动生成
	 * 
	 * @author Hugh
	 */
	public CpTktype searchMaxTktype(){
		
		CpTktype tktype = cpTktypeMapper.searchMaxTktypeId();
		return tktype;
	}
	
	
	
	/**
	 * 删除票种
	 */
	public Result<CpTktype> delect(CpTktype tktype) {
		try {
			cpTktypeMapper.deleteCpTktypeByTtTypeId(tktype.getTtTypeId());
		} catch (Throwable t) {
			t.printStackTrace();
			return Result.create("TKTYPE_DELETE_FAILED", "票种删除失败");
		}
		return Result.create(null);
	}
	
	
	
}
