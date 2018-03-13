package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.CpMemberShip;

public interface CpMemberShipMapper {

	Long insertCpMemberShip(CpMemberShip cpMemberShip);

    Long deleteCpMemberShipByMeGradeId(String meGradeId);

    Long deleteCpMemberShipByParams(@Param("map") Map<String, String> map);

    Long updateCpMemberShip(CpMemberShip cpMemberShip);

    Long updateCpMemberShipByParams(@Param("map") Map<String, String> map);

	CpMemberShip searchCpMemberShipByMeGradeId(String meGradeId);
	
	CpMemberShip searchCpMemberShipByMeGradeDesc(String meGradeDesc);

	List<CpMemberShip> searchCpMemberShipByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<CpMemberShip> searchCpMemberShipByParams(@Param("map") Map<String, String> map);

} 
