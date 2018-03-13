package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.happyworlds.imgmt.entity.CpPlstic;
import cn.happyworlds.imgmt.mybatis.PageBounds;

public interface CpPlsticMapper {

	Long insertCpPlstic(CpPlstic cpPlstic);

    Long deleteCpPlsticByParams(@Param("map") Map<String, String> map);

    Long updateCpPlstic(CpPlstic cpPlstic);

    Long updateCpPlsticByParams(@Param("map") Map<String, String> map);

	List<CpPlstic> searchCpPlsticByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<CpPlstic> searchCpPlsticByParams(@Param("map") Map<String, String> map);

} 
