package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.CpCtrycd;

public interface CpCtrycdMapper {

	Long insertCpCtrycd(CpCtrycd cpCtrycd);

    Long deleteCpCtrycdBySysAlphaCtryCd(String sysAlphaCtryCd);

    Long deleteCpCtrycdByParams(@Param("map") Map<String, String> map);

    Long updateCpCtrycd(CpCtrycd cpCtrycd);

    Long updateCpCtrycdByParams(@Param("map") Map<String, String> map);

	CpCtrycd searchCpCtrycdBySysAlphaCtryCd(String sysAlphaCtryCd);

	List<CpCtrycd> searchCpCtrycdByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<CpCtrycd> searchCpCtrycdByParams(@Param("map") Map<String, String> map);

} 
