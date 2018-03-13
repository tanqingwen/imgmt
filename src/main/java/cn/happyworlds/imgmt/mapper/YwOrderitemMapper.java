package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.YwOrderitem;

public interface YwOrderitemMapper {

	Long insertYwOrderitem(YwOrderitem ywOrderitem);

    Long deleteYwOrderitemByHwOrderitemId(String hwOrderitemId);

    Long deleteYwOrderitemByParams(@Param("map") Map<String, String> map);

    Long updateYwOrderitem(YwOrderitem ywOrderitem);

    Long updateYwOrderitemByParams(@Param("map") Map<String, String> map);

	YwOrderitem searchYwOrderitemByHwOrderitemId(String hwOrderitemId);

	List<YwOrderitem> searchYwOrderitemByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<YwOrderitem> searchYwOrderitemByParams(@Param("map") Map<String, String> map);
	
	List<Map<String, String>> statisticYworderItemByOrderId(@Param("orderId") String orderId);

	List<YwOrderitem> searchYwOrderitemByPos(@Param("orderId") String orderId);
	
	List<Map<String, Object>> searchYwOrderitemByPos2(@Param("orderId") String orderId);
	
	Integer searchStatusByPos2(@Param("orderId") String orderId);
} 
