package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.CpMemberPoint;

public interface CpMemberPointMapper {

	Long insertCpMemberPoint(CpMemberPoint cpMemberPoint);

    Long deleteCpMemberPointByPoId(String poId);

    Long deleteCpMemberPointByParams(@Param("map") Map<String, String> map);

    Long updateCpMemberPoint(CpMemberPoint cpMemberPoint);

    Long updateCpMemberPointByParams(@Param("map") Map<String, String> map);

	CpMemberPoint searchCpMemberPointByPoId(String poId);

	List<CpMemberPoint> searchCpMemberPointByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<CpMemberPoint> searchCpMemberPointByParams(@Param("map") Map<String, String> map);

} 
