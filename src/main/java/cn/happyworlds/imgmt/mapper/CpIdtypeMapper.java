package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.CpIdtype;

public interface CpIdtypeMapper {

	Long insertCpIdtype(CpIdtype cpIdtype);

    Long deleteCpIdtypeByCbIdType(String cbIdType);

    Long deleteCpIdtypeByParams(@Param("map") Map<String, String> map);

    Long updateCpIdtype(CpIdtype cpIdtype);

    Long updateCpIdtypeByParams(@Param("map") Map<String, String> map);

	CpIdtype searchCpIdtypeByCbIdType(String cbIdType);

	List<CpIdtype> searchCpIdtypeByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<CpIdtype> searchCpIdtypeByParams(@Param("map") Map<String, String> map);

} 
