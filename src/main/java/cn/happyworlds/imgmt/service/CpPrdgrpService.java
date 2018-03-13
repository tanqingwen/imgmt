package cn.happyworlds.imgmt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpPrdgrp;
import cn.happyworlds.imgmt.mapper.CpPrdgrpMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.util.Result;

@Service
public class CpPrdgrpService {

	@Autowired
	private CpPrdgrpMapper cPPrdgrpMapper;
	
	
	public List<CpPrdgrp> prdgrpList() {
        return cPPrdgrpMapper.searchCpPrdgrpByParams(null);
    }
	/**
	 * 查询所有prProdctGroup值大于或等于2000 的数据， 即游客 所属优待类别极其折扣
	 * @param prProdctGroup
	 * @return
	 */
	public List<CpPrdgrp> prdgrpListObj(Integer prProdctGroup){
		return cPPrdgrpMapper.searchCpPrdgrpByprProdctGroup(prProdctGroup);
	}
	
	public Result<CpPrdgrp> prdgrpAdd(CpPrdgrp prdgrp) {
		 CpPrdgrp dbprdgrp = cPPrdgrpMapper.searchCpPrdgrpByPrProdctGroup(prdgrp.getPrProdctGroup());
			if (null == dbprdgrp) {
				return Result.create("ASSISTANT_NOT_EXISTS", "会员等级不存在");
				
			}
			return Result.create(dbprdgrp);
		}
	
	
	/**
	 * 查询会员等级列表
	 */
	public Result<PageInfo<CpPrdgrp>> prdgrpList(final String prProdctGroup, final String prGroupDesc, PageBounds pageBounds) {
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(prProdctGroup)) {
			params.put("prProdctGroup", prProdctGroup);
		}
		if (StringUtils.hasText(prGroupDesc)) {
			params.put("prGroupDesc", prGroupDesc);
		}
		List<CpPrdgrp> page = cPPrdgrpMapper.searchCpPrdgrpByParams(params, pageBounds);
		return Result.create(new PageInfo<CpPrdgrp>(page));
	}
	
	/**
	 * 添加会员等级
	 */
	public Result<CpPrdgrp> prdgrpGetById(CpPrdgrp prdgrp) {
		CpPrdgrp cpPrdgrp = cPPrdgrpMapper.searchCpPrdgrpByPrProdctGroup(prdgrp.getPrProdctGroup());
		if (null != cpPrdgrp) {
			return Result.create("PRDGRP_NOT_EXISTS", "会员等级已存在");
		}
		try{
			cPPrdgrpMapper.insertCpPrdgrp(prdgrp);
			return Result.create(prdgrp);
		} catch (Throwable t){
			t.printStackTrace();
            return Result.create("STAFF_ADD_FAILED", "会员等级添加失败");
		}
	}
	
	/**
	 * 更新会员等级
	 */
	public Result<CpPrdgrp> update(CpPrdgrp cpprdgrp){
		try {
			cPPrdgrpMapper.updateCpPrdgrp(cpprdgrp);
		} catch (Throwable t) {
			t.printStackTrace();
			return Result.create("CpPrdgrp_UPDATE_FAILED", "会员等级更新失败");
		}
		return Result.create(cpprdgrp);
	}
	
	/**
	 * 删除会员等级
	 */
	public Result<CpPrdgrp> delect(CpPrdgrp prdgrp){
		try {
			cPPrdgrpMapper.deleteCpPrdgrpByPrProdctGroup(prdgrp.getPrProdctGroup());
		} catch (Throwable t) {
			t.printStackTrace();
			return Result.create("ASSISTANT_DELETE_FAILED", "会员删除失败");
		}
		return Result.create(null);
	}
	
	/**
	 * 获取会员等级id最大值
	 * @return
	 */
	public CpPrdgrp maxPrProdctGroup(){
		CpPrdgrp prd=cPPrdgrpMapper.searchMaxprProdctgroup();
		return prd;
	}
}
