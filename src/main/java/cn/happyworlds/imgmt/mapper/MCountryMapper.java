package cn.happyworlds.imgmt.mapper;

import java.util.List; 
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.happyworlds.imgmt.entity.MCountryDict;
import cn.happyworlds.imgmt.mybatis.PageBounds;

public interface MCountryMapper {

	void insertMCountryDict(MCountryDict MCountryDict);

	void deleteMCountryDictByAlphaCtryCd(String alphaCtryCd);

	void updateMCountryDict(MCountryDict MCountryDict);

	MCountryDict searchMCountryDictByAlphaCtryCd(String alphaCtryCd);

	List<MCountryDict> searchMCountryDictByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<MCountryDict> searchMCountryDictByParams(@Param("map") Map<String, String> map);

} 
