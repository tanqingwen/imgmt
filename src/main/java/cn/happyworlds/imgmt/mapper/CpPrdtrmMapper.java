package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.happyworlds.imgmt.entity.CpPrdtrm;
import cn.happyworlds.imgmt.mybatis.PageBounds;

public interface CpPrdtrmMapper {

	void insertCpPrdtrm(CpPrdtrm CpPrdtrm);

	void deleteCpPrdtrmByParams(@Param("map") Map<String, String> map);

	void updateCpPrdtrm(CpPrdtrm CpPrdtrm);

	CpPrdtrm searchCpPrdtrmById(String id);
	
	List<CpPrdtrm> searchCpPrdtrmByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	CpPrdtrm searchCpPrdtrmByParams(@Param("map") Map<String, String> map);

} 
