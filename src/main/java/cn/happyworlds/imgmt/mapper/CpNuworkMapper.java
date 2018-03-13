package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.entity.CpNuwork;

public interface CpNuworkMapper {

	Long insertCpNuwork(CpNuwork cpNuwork);

    //Long deleteCpNuworkBy${table.pkColumn.variableSpellSqlName}(${table.pkColumn.javaType} ${table.pkColumn.variableName});

    Long deleteCpNuworkByParams(@Param("map") Map<String, String> map);

    //Long updateCpNuwork(CpNuwork cpNuwork);

    Long updateCpNuworkByParams(@Param("map") Map<String, String> map);

    //CpNuwork searchCpNuworkBy${table.pkColumn.variableSpellSqlName}(${table.pkColumn.javaType} ${table.pkColumn.variableName});

	//List<CpNuwork> searchCpNuworkByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<CpNuwork> searchCpNuworkByParams(@Param("map") Map<String, String> map);

} 
