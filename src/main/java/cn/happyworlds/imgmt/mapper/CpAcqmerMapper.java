package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.CpAcqmer;

public interface CpAcqmerMapper {

	Long insertCpAcqmer(CpAcqmer cpAcqmer);

    Long deleteCpAcqmer(@Param("map") Map<String, String> map);

    Long deleteCpAcqmerByParams(@Param("map") Map<String, String> map);

//    Long updateCpAcqmer(CpAcqmer cpAcqmer);

    Long updateCpAcqmerByParams(@Param("map") Map<String, String> map);

//	CpAcqmer searchCpAcqmerBy${table.pkColumn.variableSpellSqlName}(${table.pkColumn.javaType} ${table.pkColumn.variableName});

	List<CpAcqmer> searchCpAcqmerByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<CpAcqmer> searchCpAcqmerByParams(@Param("map") Map<String, String> map);
	
//	新增场馆分组获取场馆分组最大值叠加
	CpAcqmer searchMaxAmGroupId();
} 
