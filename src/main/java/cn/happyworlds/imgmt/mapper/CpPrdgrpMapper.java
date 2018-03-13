package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.CpPrdgrp;

public interface CpPrdgrpMapper {

	Long insertCpPrdgrp(CpPrdgrp cpPrdgrp);

    Long deleteCpPrdgrpByPrProdctGroup(Integer prProdctGroup);

    Long deleteCpPrdgrpByParams(@Param("map") Map<String, String> map);

    Long updateCpPrdgrp(CpPrdgrp cpPrdgrp);

    Long updateCpPrdgrpByParams(@Param("map") Map<String, String> map);

	CpPrdgrp searchCpPrdgrpByPrProdctGroup(Integer prProdctGroup);

	List<CpPrdgrp> searchCpPrdgrpByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<CpPrdgrp> searchCpPrdgrpByParams(@Param("map") Map<String, String> map);
	
	List<CpPrdgrp> searchCpPrdgrpByprProdctGroup(@Param("prProdctGroup") Integer prProdctGroup);
	
//	添加会员等级时，获取会员等级最大值id
	CpPrdgrp searchMaxprProdctgroup();
} 
