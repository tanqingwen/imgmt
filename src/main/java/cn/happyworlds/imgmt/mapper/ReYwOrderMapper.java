package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.YwOrder;

public interface ReYwOrderMapper {

	List<YwOrder> searchYwOrderStat(@Param("map") Map<String, String> map , PageBounds pageBounds);
	List<YwOrder> searchYwOrderStat2(@Param("map") Map<String, String> map , PageBounds pageBounds);
	List<YwOrder> searchEachChannel(@Param("map") Map<String, String> map);
} 
