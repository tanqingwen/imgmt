package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.CpCrdlnk;

public interface CpCrdlnkMapper {

	Long insertCpCrdlnk(CpCrdlnk cpCrdlnk);

    Long deleteCpCrdlnkByClOldCard(String clOldCard);

    Long deleteCpCrdlnkByParams(@Param("map") Map<String, String> map);

    Long updateCpCrdlnk(CpCrdlnk cpCrdlnk);

    Long updateCpCrdlnkByParams(@Param("map") Map<String, String> map);

	CpCrdlnk searchCpCrdlnkByClOldCard(String clOldCard);

	List<CpCrdlnk> searchCpCrdlnkByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<CpCrdlnk> searchCpCrdlnkByParams(@Param("map") Map<String, String> map);

} 
