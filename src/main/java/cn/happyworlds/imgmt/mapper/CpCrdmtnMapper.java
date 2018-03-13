package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.CpCrdmtn;

public interface CpCrdmtnMapper {

	Long insertCpCrdmtn(CpCrdmtn cpCrdmtn);

    //Long deleteCpCrdmtnBy${table.pkColumn.variableSpellSqlName}(${table.pkColumn.javaType} ${table.pkColumn.variableName});

    Long deleteCpCrdmtnByParams(@Param("map") Map<String, String> map);

    Long updateCpCrdmtn(CpCrdmtn cpCrdmtn);

    Long updateCpCrdmtnByParams(@Param("map") Map<String, String> map);

    //CpCrdmtn searchCpCrdmtnBy${table.pkColumn.variableSpellSqlName}(${table.pkColumn.javaType} ${table.pkColumn.variableName});

	List<CpCrdmtn> searchCpCrdmtnByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<CpCrdmtn> searchCpCrdmtnByParams(@Param("map") Map<String, String> map);

} 
