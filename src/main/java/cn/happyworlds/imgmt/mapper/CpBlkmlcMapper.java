package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.CpBlkmlc;

public interface CpBlkmlcMapper {

	Long insertCpBlkmlc(CpBlkmlc cpBlkmlc);

    Long deleteCpBlkmlcByBmCardNo(String bmCardNo);

    Long deleteCpBlkmlcByParams(@Param("map") Map<String, String> map);

    Long updateCpBlkmlc(CpBlkmlc cpBlkmlc);

    Long updateCpBlkmlcByParams(@Param("map") Map<String, String> map);

	CpBlkmlc searchCpBlkmlcByBmCardNo(String bmCardNo);

	List<CpBlkmlc> searchCpBlkmlcByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<CpBlkmlc> searchCpBlkmlcByParams(@Param("map") Map<String, String> map);

} 
