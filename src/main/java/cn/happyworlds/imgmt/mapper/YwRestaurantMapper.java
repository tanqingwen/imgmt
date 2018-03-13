package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.happyworlds.imgmt.entity.YwRestaurant;
import cn.happyworlds.imgmt.mybatis.PageBounds;

public interface YwRestaurantMapper {

	Long insertYwRestaurant(YwRestaurant ywRestaurant);

    Long deleteYwRestaurantByRestaurantId(String restaurantId);

    Long deleteYwRestaurantByParams(@Param("map") Map<String, String> map);

    Long updateYwRestaurant(YwRestaurant ywRestaurant);

    Long updateYwRestaurantByParams(@Param("map") Map<String, String> map);

	YwRestaurant searchYwRestaurantByRestaurantId(String restaurantId);

	List<YwRestaurant> searchYwRestaurantByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<YwRestaurant> searchYwRestaurantByParams(@Param("map") Map<String, String> map);

} 
