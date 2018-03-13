package cn.happyworlds.imgmt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpPrdtrm;
import cn.happyworlds.imgmt.entity.TSysRole;
import cn.happyworlds.imgmt.mapper.CpPrdtrmMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.util.DateTimes;
import cn.happyworlds.imgmt.util.Digests;
import cn.happyworlds.imgmt.util.Result;

@Service
public class CpPrdtrmService {

	@Autowired
	private CpPrdtrmMapper cpPrdtrmMapper;
	
	public Result<CpPrdtrm> add(CpPrdtrm cpPrdtrm) {
		Map<String, String> params = new HashMap<>();
		params.put("pt_terminal_id", cpPrdtrm.getPt_terminal_id());
		params.put("pt_prodct_group", cpPrdtrm.getPt_prodct_group());
		CpPrdtrm cpPrdtrm2 = cpPrdtrmMapper.searchCpPrdtrmByParams(params);
		if (cpPrdtrm2 != null) {
			return Result.create("DUPLICATING", "同样的产品组和机具号已经存在于列表中！");
		}
		try {
			cpPrdtrmMapper.insertCpPrdtrm(cpPrdtrm);
		} catch (Exception e) {
			return Result.create("ADD_FALSE", "添加机具失败！");
		}
		return Result.create("OK", "添加机具成功！");
	}
	
	public  Result<CpPrdtrm> deleteCpPrdtrmByParams(String id,String level) {
		Map<String, String> params = new HashMap<>();
		params.put("pt_terminal_id", id);
		params.put("pt_prodct_group", level);
		try {
			cpPrdtrmMapper.deleteCpPrdtrmByParams(params);
		} catch (Exception e) {
			return Result.create("DEL_FALSE", "删除失败！");
		}
		return Result.create("OK", "删除该机具成功！");
	}
	
	public Result<CpPrdtrm> update(CpPrdtrm cpPrdtrm) {
		try {
			cpPrdtrmMapper.updateCpPrdtrm(cpPrdtrm);
		} catch (Exception e) {
			return Result.create("UPDATE_FALSE", "更新失败！");
		}
		return Result.create("OK", "更新机具成功！");
	}
	
	public Result<CpPrdtrm> searchCpPrdtrmByParams(String id, String level) {
		Map<String, String> params = new HashMap<>();
		params.put("pt_terminal_id", id);
		params.put("pt_prodct_group", level);
		CpPrdtrm cpPrdtrm = null;
		try {
			cpPrdtrm = cpPrdtrmMapper.searchCpPrdtrmByParams(params);
		} catch (Exception e) {
			return Result.create("SEARCH_FALSE", "查询该机具失败！");
		}
		return Result.create("OK",cpPrdtrm);
	}
	
	public Result<PageInfo<CpPrdtrm>> mainpage(String id, String level, PageBounds pageBounds) {
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(id)) {
			params.put("pt_terminal_id", id);
		}
		if (StringUtils.hasText(level)) {
			params.put("pt_prodct_group", level);
		}
		List<CpPrdtrm> page = cpPrdtrmMapper.searchCpPrdtrmByParams(params, pageBounds);
		return Result.create(new PageInfo<CpPrdtrm>(page));
	}
	
}
