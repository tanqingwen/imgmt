package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.VipCardStat;

public interface VipCardStatMapper {

	List<VipCardStat> searchVipCardInfoStat(@Param("map") Map<String, String> map , PageBounds pageBounds);
	
	List<VipCardStat> searchVipCardCaseNullStat(@Param("map") Map<String, String> map , PageBounds pageBounds);
	
	List<VipCardStat> searchVipCardCaseNormalStat(@Param("map") Map<String, String> map , PageBounds pageBounds);
	
	List<VipCardStat> searchVipCardCaseLossStat(@Param("map") Map<String, String> map , PageBounds pageBounds);
	
	List<VipCardStat> searchVipCardCaseRecedeStat(@Param("map") Map<String, String> map , PageBounds pageBounds);
	
	List<VipCardStat> searchVipCardCaseNullStat(@Param("map") Map<String, String> map);
	
	List<VipCardStat> searchVipCardCaseNormalStat(@Param("map") Map<String, String> map);
	
	List<VipCardStat> searchVipCardCaseLossStat(@Param("map") Map<String, String> map);
	
	List<VipCardStat> searchVipCardCaseRecedeStat(@Param("map") Map<String, String> map);

} 
