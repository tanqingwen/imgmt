package cn.happyworlds.imgmt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpPrdgrp;
import cn.happyworlds.imgmt.entity.CpPrdtrm;
import cn.happyworlds.imgmt.entity.YwGate;
import cn.happyworlds.imgmt.entity.YwVenue;
import cn.happyworlds.imgmt.mapper.YwVenueMapper;
import cn.happyworlds.imgmt.mapper.YwGateMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.util.Result;

@Service
public class YwVenueService {

	@Autowired
	private YwVenueMapper ywVenueMapper;
	
	@Autowired
	private YwGateMapper ywGateMapper;
	
	public Result<PageInfo<YwVenue>> list(final String id, final String name, PageBounds pageBounds) {
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(id)) {
			params.put("hwVenueId", id);
		}
		if (StringUtils.hasText(name)) {
			params.put("hwVenueName", name);
		}
		List<YwVenue> page = ywVenueMapper.searchYwVenueByParams(params, pageBounds);
		return Result.create(new PageInfo<YwVenue>(page));
	}
	public Result<YwVenue> add(YwVenue ywVenue) {
		Map<String, String> params = new HashMap<>();
		params.put("hwVenueId", ywVenue.getHwVenueId());
//		params.put("hwVenueName", ywVenue.getHwVenueName());
		YwVenue ywVenue1 = ywVenueMapper.searchYwVenueByParams(params);
		if (ywVenue1 != null) {
			return Result.create("DUPLICATING", "同样的场馆ID和场馆名已经存在于列表中！");
		}
		ywVenueMapper.insertYwVenue(ywVenue);
		return Result.create(ywVenue);
	}
	
	public Long deleteYwVenueByHwVenueId(final String hwVenueId) {
		Long r = ywVenueMapper.deleteYwVenueByHwVenueId(hwVenueId);
		return r;
	}
	
	/**
	 * 查询闸机ID
	 */
	public Result<PageInfo<YwGate>> searchYwGateByParams(PageBounds pageBounds){
		Map<String, String> params = new HashMap<>();
		List<YwGate> page = ywGateMapper.searchYwGateByParams(params,pageBounds);
		
		return Result.create(new PageInfo<YwGate>(page));
	}
	
	public Result<YwVenue> ywVenueGetById(String hwVenueId) {
		YwVenue ywVenue = ywVenueMapper.searchYwVenueByHwVenueId(hwVenueId);
		if (null == ywVenue) {
			return Result.create("PRDGRP_NOT_EXISTS", "场馆不存在");
		}
		return Result.create(ywVenue);
	}
	
	public Result<YwVenue> update(YwVenue ywVenue){
		try {
			ywVenueMapper.updateYwVenue(ywVenue);
		} catch (Throwable t) {
			t.printStackTrace();
			return Result.create("YWVENUE_UPDATE_FAILED", "场馆更新失败");
		}
		return Result.create(ywVenue);
	}
}
