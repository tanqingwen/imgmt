package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.happyworlds.imgmt.entity.FillCard;
import cn.happyworlds.imgmt.mybatis.PageBounds;


public interface FillCardMapper {

	List<FillCard> searchFillCardByParams(@Param("map") Map<String, String> map,PageBounds pageBoundss);
	
	List<FillCard> searchFillChangeCardByParams(@Param("map") Map<String, String> map,PageBounds pageBoundss);
	
	List<FillCard> searchFillChangeCardByParams(@Param("map") Map<String, String> map);

} 
