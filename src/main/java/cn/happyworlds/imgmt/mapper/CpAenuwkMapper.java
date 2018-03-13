package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.happyworlds.imgmt.entity.CpAenuwk;
import cn.happyworlds.imgmt.mybatis.PageBounds;

public interface CpAenuwkMapper {

	Long insertCpAenuwk(CpAenuwk cpAenuwk);

    Long deleteCpAenuwkByNuAeBin(Long nuAeBin);

    Long deleteCpAenuwkByParams(@Param("map") Map<String, String> map);

    Long updateCpAenuwk(CpAenuwk cpAenuwk);

    Long updateCpAenuwkByParams(@Param("map") Map<String, String> map);

	CpAenuwk searchCpAenuwkByNuAeBin(Long nuAeBin);

	List<CpAenuwk> searchCpAenuwkByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<CpAenuwk> searchCpAenuwkByParams(@Param("map") Map<String, String> map);

} 
