package cn.happyworlds.imgmt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.happyworlds.imgmt.entity.CpPrdgrp;
import cn.happyworlds.imgmt.entity.CpTktype;
import cn.happyworlds.imgmt.mapper.CpTktypeMapper;
import cn.happyworlds.imgmt.mapper.SequenceMapper;
import cn.happyworlds.imgmt.util.Result;

@Service
public class TktypeService {

	@Autowired
	private CpTktypeMapper cpTktypeMapper;
	

	public Result<List<CpTktype>> tktypeListAll() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("ttTypeStatus", "X");
		List<CpTktype> page = cpTktypeMapper.searchCpTktypeByParams(params);
		return Result.create(page);
	}
	
	/**
	 * 柜台购票获取票券记录
	 * 
	 * @param  ttType
	 * @return CpTktype 
	 * 
	 * @author Hugh
	 */
	public CpTktype tktypeListGetById(String ttType) {
		CpTktype cpTktype = cpTktypeMapper.searchCpTktypeByTtTypeId(Integer.parseInt(ttType));
		return cpTktype;
	}
	
	

	/**
	 *  删除票种
	 *
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
