package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.CpTrxcde;

public interface CpTrxcdeMapper {

	Long insertCpTrxcde(CpTrxcde cpTrxcde);

    Long deleteCpTrxcdeBySysTrxnCd(String sysTrxnCd);

    Long deleteCpTrxcdeByParams(@Param("map") Map<String, String> map);

    Long updateCpTrxcde(CpTrxcde cpTrxcde);

    Long updateCpTrxcdeByParams(@Param("map") Map<String, String> map);

	CpTrxcde searchCpTrxcdeBySysTrxnCd(String sysTrxnCd);

	List<CpTrxcde> searchCpTrxcdeByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<CpTrxcde> searchCpTrxcdeByParams(@Param("map") Map<String, String> map);

} 
