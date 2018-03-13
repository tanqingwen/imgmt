package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.CpCopmst;

public interface CpCopmstMapper {

	Long insertCpCopmst(CpCopmst cpCopmst);

    Long deleteCpCopmstByCoCorporateId(String coCorporateId);

    Long deleteCpCopmstByParams(@Param("map") Map<String, String> map);

    Long updateCpCopmst(CpCopmst cpCopmst);

    Long updateCpCopmstByParams(@Param("map") Map<String, String> map);

	CpCopmst searchCpCopmstByCoCorporateId(String coCorporateId);

	List<CpCopmst> searchCpCopmstByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<CpCopmst> searchCpCopmstByParams(@Param("map") Map<String, String> map);

} 
