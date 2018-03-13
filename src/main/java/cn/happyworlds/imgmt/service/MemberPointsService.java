package cn.happyworlds.imgmt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpMemberPoint;
import cn.happyworlds.imgmt.mapper.CpMemberPointMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.util.Result;

@Service
public class MemberPointsService {
	
	@Autowired
	private CpMemberPointMapper pointMapper;
	
	public List<CpMemberPoint> pointList(){
		return pointMapper.searchCpMemberPointByParams(null);
	}
	
	@SuppressWarnings({"rawtypes","unchecked"})
	public Result<PageInfo<CpMemberPoint>> pointList(final String pointId,final String pointName,PageBounds pageBounds){
		Map<String, String> params=new HashMap<>();
		if(StringUtils.hasText(pointId)){
			params.put("poId", pointId);
		}
		if(StringUtils.hasText(pointName)){
			params.put("poTypeName", pointName);
		}
		List<CpMemberPoint> page=pointMapper.searchCpMemberPointByParams(params,pageBounds);
		return Result.create(new PageInfo(page));
	}
	
	public Result<CpMemberPoint> memberPointsById(final String pointId){
		if(StringUtils.isEmpty(pointId)){
			return Result.create("CPMEMBERPOINTS_DICT_ID_IS_EMPTY", "积分配置ID不能为空");
		}
		CpMemberPoint point=pointMapper.searchCpMemberPointByPoId(pointId);
		if(point == null){
			return Result.create("CPMEMBERPOINTS_DICT_NOT_FOUND", "积分配置没有找到");
		}
		return Result.create(point);
	}
	
	public Result<String> memberPointsAdd(CpMemberPoint point){
		CpMemberPoint pointId=pointMapper.searchCpMemberPointByPoId(point.getPoId());
		Map<String, String> params=new HashMap<>();
		params.put("poTypeName", point.getPoTypeName());
		List<CpMemberPoint> pointName=pointMapper.searchCpMemberPointByParams(params);
		if(pointId !=null){
			return Result.create("POINTS_DICT_NOT_FOUND","此积分id已存在");
		}else if(pointName.size()>0){
			return Result.create("POINTS_DICT_NOT_FOUND", "此积分名称已存在");
		}
		pointMapper.insertCpMemberPoint(point);
		return Result.create(point.getPoId());
	}
	
	public Result<String> memberPointsUpdate(CpMemberPoint points){
		Map<String, String> params=new HashMap<>();
		params.put("poTypeName", points.getPoTypeName());
		List<CpMemberPoint> pointName=pointMapper.searchCpMemberPointByParams(params);
		if(pointName.size()>0){
			params.put("poId", points.getPoId());
			params.put("poTypeName", points.getPoTypeName());
			List<CpMemberPoint> po=pointMapper.searchCpMemberPointByParams(params);
			if(po.size()>0){
				pointMapper.updateCpMemberPoint(points);
				return Result.create(points.getPoId());
			}else{
				return Result.create("POINTS_DICT_NOT_FOUND", "此积分名称已存在");
			}
		}
		pointMapper.updateCpMemberPoint(points);
		return Result.create(points.getPoId());
	}
	
	public Result<String> memberPointsDelete(String id){
		if(StringUtils.isEmpty(id)){
			return Result.create("POINTS_DICT_NOT_FOUND", "没有获取积分ID");
		}
		pointMapper.deleteCpMemberPointByPoId(id);
		return Result.create(id);
	}
}
