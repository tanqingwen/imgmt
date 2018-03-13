package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.CpSeckey;

public interface CpSeckeyMapper {

	Long insertCpSeckey(CpSeckey cpSeckey);

    //Long deleteCpSeckeyBy${table.pkColumn.variableSpellSqlName}(${table.pkColumn.javaType} ${table.pkColumn.variableName});

    Long deleteCpSeckeyByParams(@Param("map") Map<String, String> map);

    Long updateCpSeckey(CpSeckey cpSeckey);

    Long updateCpSeckeyByParams(@Param("map") Map<String, String> map);

    CpSeckey searchCpSeckeyByProdct(String prodct);

	List<CpSeckey> searchCpSeckeyByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<CpSeckey> searchCpSeckeyByParams(@Param("map") Map<String, String> map);

} 
