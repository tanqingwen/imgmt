package cn.happyworlds.imgmt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpPrdgrp;
import cn.happyworlds.imgmt.entity.YwGate;
import cn.happyworlds.imgmt.entity.YwVenue;
import cn.happyworlds.imgmt.mapper.YwGateMapper;
import cn.happyworlds.imgmt.mapper.YwVenueMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.util.Result;

@Service
public class YwGateService {

	@Autowired
	private YwGateMapper ywGateMapper;
	
	@Autowired
	private YwVenueMapper ywVenueMapper;
	
	public Result<PageInfo<YwGate>> list(final String id, final String name, PageBounds pageBounds) {
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(id)) {
			params.put("hwGateId", id);
		}
		if (StringUtils.hasText(name)) {
			params.put("hwGateName", name);
		}
		List<YwGate> page = ywGateMapper.searchYwGateByParams(params, pageBounds);
		return Result.create(new PageInfo<YwGate>(page));
	}
	
	/**
	 * 查询场馆ID
	 */
	public Result<PageInfo<YwVenue>> searchYwVenueByParams(PageBounds pageBounds){
		Map<String, String> params = new HashMap<>();
		List<YwVenue> page = ywVenueMapper.searchYwVenueByParams(params,pageBounds);
		
		return Result.create(new PageInfo<YwVenue>(page));
	}
	
	/**
	 * 通过ID查询场馆信息
	 */
	public YwVenue searchYwVenueById(String hwVenueId){
		YwVenue ywVenue = ywVenueMapper.searchYwVenueByHwVenueId(hwVenueId);
		return ywVenue;
	}
	
	public Result<YwGate> add(YwGate ywGate) {
		Map<String, String> params = new HashMap<>();
		params.put("hwGateId", ywGate.getHwGateId());
		YwGate ywGate1 = ywGateMapper.searchYwGateByParams(params);
		if (ywGate1 != null) {
			return Result.create("DUPLICATING", "同样的闸机ID已经存在于列表中！");
		}
		ywGateMapper.insertYwGate(ywGate);
		return Result.create(ywGate);
	}
	
	
	public Long deleteYwGateByHwGateId(final String hwGateId) {
		Long r = ywGateMapper.deleteYwGateByHwGateId(hwGateId);
		return r;
	}
	
	public Result<YwGate> ywGateGetById(String hwGateId) {
		YwGate ywGate = ywGateMapper.searchYwGateByHwGateId(hwGateId);
		if (null == ywGate) {
			return Result.create("PRDGRP_NOT_EXISTS", "闸机不存在");
		}
		return Result.create(ywGate);
	}
	
	public Result<YwGate> update(YwGate ywGate){
		try {
			ywGateMapper.updateYwGate(ywGate);
		} catch (Throwable t) {
			t.printStackTrace();
			return Result.create("YWGATE_UPDATE_FAILED", "闸机更新失败");
		}
		return Result.create(ywGate);
	}
	
	
	
}
