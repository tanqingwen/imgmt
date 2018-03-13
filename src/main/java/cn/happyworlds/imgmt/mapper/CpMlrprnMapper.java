package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.CpMlrprn;

public interface CpMlrprnMapper {

	Long insertCpMlrprn(CpMlrprn cpMlrprn);

    //Long deleteCpMlrprnBy${table.pkColumn.variableSpellSqlName}(${table.pkColumn.javaType} ${table.pkColumn.variableName});

    Long deleteCpMlrprnByParams(@Param("map") Map<String, String> map);

    Long updateCpMlrprn(CpMlrprn cpMlrprn);

    Long updateCpMlrprnByParams(@Param("map") Map<String, String> map);

	//CpMlrprn searchCpMlrprnBy${table.pkColumn.variableSpellSqlName}(${table.pkColumn.javaType} ${table.pkColumn.variableName});

	List<CpMlrprn> searchCpMlrprnByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<CpMlrprn> searchCpMlrprnByParams(@Param("map") Map<String, String> map);

} 
