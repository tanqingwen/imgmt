package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.YwIntegral;

public interface YwIntegralMapper {

	Long insertYwIntegral(YwIntegral ywIntegral);

    Long deleteYwIntegralByHwIntegralId(String hwIntegralId);

    Long deleteYwIntegralByParams(@Param("map") Map<String, String> map);

    Long updateYwIntegral(YwIntegral ywIntegral);

    Long updateYwIntegralByParams(@Param("map") Map<String, String> map);

	YwIntegral searchYwIntegralByHwIntegralId(String hwIntegralId);

	List<YwIntegral> searchYwIntegralByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<YwIntegral> searchYwIntegralByParams(@Param("map") Map<String, String> map);

} 
