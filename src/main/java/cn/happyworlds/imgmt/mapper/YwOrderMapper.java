package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.YwOrder;

public interface YwOrderMapper {

	Long insertYwOrder(YwOrder ywOrder);

    Long deleteYwOrderByHwOrderId(String hwOrderId);

    Long deleteYwOrderByParams(@Param("map") Map<String, String> map);

    Long updateYwOrder(YwOrder ywOrder);

    Long updateYwOrderByParams(@Param("map") Map<String, String> map);

	YwOrder searchYwOrderByHwOrderId(String hwOrderId);

	List<YwOrder> searchYwOrderByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);
	
	List<YwOrder> searchYwOrderByParams(@Param("map") Map<String, String> map);

	List<YwOrder> searchYwOrderByParamstime(@Param("map") Map<String, String> map);
	
	List<YwOrder> searchYwOrderByPos(@Param("map") Map<String, String> map, PageBounds pageBounds);

} 
