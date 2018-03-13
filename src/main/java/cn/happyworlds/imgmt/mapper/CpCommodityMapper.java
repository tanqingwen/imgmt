package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.CpCommodity;

public interface CpCommodityMapper {

	Long insertCpCommodity(CpCommodity cpCommodity);

    Long deleteCpCommodityByCcTypeId(Integer ccTypeId);

    Long deleteCpCommodityByParams(@Param("map") Map<String, String> map);

    Long updateCpCommodity(CpCommodity cpCommodity);

    Long updateCpCommodityByParams(@Param("map") Map<String, String> map);

	CpCommodity searchCpCommodityByCcTypeId(Integer ccTypeId);

	List<CpCommodity> searchCpCommodityByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<CpCommodity> searchCpCommodityByParams(@Param("map") Map<String, String> map);
	
	CpCommodity searchMaxCpCommodityId();
} 
