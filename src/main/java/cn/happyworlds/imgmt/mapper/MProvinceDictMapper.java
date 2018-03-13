package cn.happyworlds.imgmt.mapper;

import java.util.List; 
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.happyworlds.imgmt.entity.MProvinceDict;
import cn.happyworlds.imgmt.mybatis.PageBounds;

public interface MProvinceDictMapper {

	void insertMProvinceDict(MProvinceDict MProvinceDict);

	void deleteMProvinceDictByProvinceId(String provinceId);

	void updateMProvinceDict(MProvinceDict MProvinceDict);

	MProvinceDict searchMProvinceDictByProvinceId(String provinceId);
	
	List<String> searchCountryById(String alphaCtryCd);
	
	List<MProvinceDict> searchMProvinceDictByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<MProvinceDict> searchMProvinceDictByParams(@Param("map") Map<String, String> map);

} 
