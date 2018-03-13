package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.happyworlds.imgmt.entity.MIdtypeDict;
import cn.happyworlds.imgmt.mybatis.PageBounds;

public interface MIdtypeDictMapper {

	void insertMIdtypeDict(MIdtypeDict MIdtypeDict);

	void deleteMIdtypeDictByIdtypeId(String idtypeId);

	void updateMIdtypeDict(MIdtypeDict MIdtypeDict);

	MIdtypeDict searchMIdtypeDictByIdtypeId(String idtypeId);

	List<MIdtypeDict> searchMIdtypeDictByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<MIdtypeDict> searchMIdtypeDictByParams(@Param("map") Map<String, String> map);

} 
