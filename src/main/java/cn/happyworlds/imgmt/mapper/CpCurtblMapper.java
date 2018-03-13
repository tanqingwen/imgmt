package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.CpCurtbl;

public interface CpCurtblMapper {

	Long insertCpCurtbl(CpCurtbl cpCurtbl);

    Long deleteCpCurtblByCuCurrCd(Long cuCurrCd);

    Long deleteCpCurtblByParams(@Param("map") Map<String, String> map);

    Long updateCpCurtbl(CpCurtbl cpCurtbl);

    Long updateCpCurtblByParams(@Param("map") Map<String, String> map);

	CpCurtbl searchCpCurtblByCuCurrCd(Long cuCurrCd);

	List<CpCurtbl> searchCpCurtblByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<CpCurtbl> searchCpCurtblByParams(@Param("map") Map<String, String> map);

} 
