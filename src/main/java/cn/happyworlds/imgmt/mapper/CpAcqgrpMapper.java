package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.CpAcqgrp;

public interface CpAcqgrpMapper {

	Long insertCpAcqgrp(CpAcqgrp cpAcqgrp);

    Long deleteCpAcqgrpByAlGroupId(Long alGroupId);

    Long deleteCpAcqgrpByParams(@Param("map") Map<String, String> map);

    Long updateCpAcqgrp(CpAcqgrp cpAcqgrp);

    Long updateCpAcqgrpByParams(@Param("map") Map<String, String> map);

	CpAcqgrp searchCpAcqgrpByAlGroupId(Long alGroupId);

	List<CpAcqgrp> searchCpAcqgrpByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<CpAcqgrp> searchCpAcqgrpByParams(@Param("map") Map<String, String> map);
	
	//新增场馆组获取场馆组最大值叠加1
	CpAcqgrp searchMaxGroupId();

} 
