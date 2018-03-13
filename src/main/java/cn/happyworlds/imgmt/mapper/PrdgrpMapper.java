package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.happyworlds.imgmt.entity.CpPrdgrp;

public interface PrdgrpMapper {

	List<CpPrdgrp> searchCpPrdgrpByParamsHwCategoryALL();
	
	List<CpPrdgrp> searchCpPrdgrpByParamsHwCategory(String prGroupDesc);
	
	List<CpPrdgrp> searchCpPrdgrpByHoliday(@Param("map") Map<String, String> map);
	
	List<CpPrdgrp> searchCpPrdgrpByNotHoliday(@Param("map") Map<String, String> map);

} 
