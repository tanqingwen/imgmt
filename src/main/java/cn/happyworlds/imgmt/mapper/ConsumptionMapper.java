package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.happyworlds.imgmt.entity.Consumption;
import cn.happyworlds.imgmt.mybatis.PageBounds;


public interface ConsumptionMapper {

	List<Consumption> searchConsumptionByParams(@Param("map") Map<String, String> map,PageBounds pageBoundss);
	List<Consumption> searchConsumptionByParams(@Param("map") Map<String, String> map);

} 
