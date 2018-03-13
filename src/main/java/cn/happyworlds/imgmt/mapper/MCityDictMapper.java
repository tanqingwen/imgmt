package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.happyworlds.imgmt.entity.MCityDict;
import cn.happyworlds.imgmt.mybatis.PageBounds;

public interface MCityDictMapper {

	void insertMCityDict(MCityDict MCityDict);

	void deleteMCityDictByCityId(String cityId);

	void updateMCityDict(MCityDict MCityDict);

	MCityDict searchMCityDictByCityId(String cityId);

	List<MCityDict> searchMCityDictByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<MCityDict> searchMCityDictByParams(@Param("map") Map<String, String> map);

} 
