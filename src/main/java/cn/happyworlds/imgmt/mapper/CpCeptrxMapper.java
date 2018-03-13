package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.CpCeptrx;

public interface CpCeptrxMapper {

	Long insertCpCeptrx(CpCeptrx cpCeptrx);

    Long deleteCpCeptrxByCtTranId(Long ctTranId);

    Long deleteCpCeptrxByParams(@Param("map") Map<String, String> map);

    Long updateCpCeptrx(CpCeptrx cpCeptrx);

    Long updateCpCeptrxByParams(@Param("map") Map<String, String> map);

	CpCeptrx searchCpCeptrxByCtTranId(Long ctTranId);

	List<CpCeptrx> searchCpCeptrxByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<CpCeptrx> searchCpCeptrxByParams(@Param("map") Map<String, String> map);

} 
