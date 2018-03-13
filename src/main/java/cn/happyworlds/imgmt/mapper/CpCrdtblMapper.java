package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.CpCrdtbl;

public interface CpCrdtblMapper {

	Long insertCpCrdtbl(CpCrdtbl cpCrdtbl);

    Long deleteCpCrdtblByCbCardholderNo(String cbCardholderNo);

    Long deleteCpCrdtblByParams(@Param("map") Map<String, String> map);

    Long updateCpCrdtbl(CpCrdtbl cpCrdtbl);

    Long updateCpCrdtblByParams(@Param("map") Map<String, String> map);

	CpCrdtbl searchCpCrdtblByCbCardholderNo(String cbCardholderNo);
	
	CpCrdtbl searchCpCrdtblByCbSourceCd(@Param("map") Map<String, String> map);
	
	CpCrdtbl searchCpCrdtblByCbIdno(String cbIdno);
	
	CpCrdtbl searchCpCrdtblByCbRecommenderNo(String CbRecommenderNo);

	List<CpCrdtbl> searchCpCrdtblByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<CpCrdtbl> searchCpCrdtblByParams(@Param("map") Map<String, String> map);
	
	String searchMaxCrdNo();
	
	Integer searchAvailableNumber();

} 
