package cn.happyworlds.imgmt.mapper;

import java.util.List; 
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.happyworlds.imgmt.entity.MUserRelationDict;
import cn.happyworlds.imgmt.mybatis.PageBounds;

public interface MUserRelationDictMapper {

	void insertMUserRelationDict(MUserRelationDict MUserRelationDict);

	void deleteMUserRelationDictByUserRelationId(String userRelationId);

	void updateMUserRelationDict(MUserRelationDict MUserRelationDict);

	MUserRelationDict searchMUserRelationDictByUserRelationId(String userRelationId);

	List<MUserRelationDict> searchMUserRelationDictByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<MUserRelationDict> searchMUserRelationDictByParams(@Param("map") Map<String, String> map);

} 
