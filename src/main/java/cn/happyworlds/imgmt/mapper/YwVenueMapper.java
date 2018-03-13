package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.entity.YwVenue;

public interface YwVenueMapper {

	Long insertYwVenue(YwVenue ywVenue);

    Long deleteYwVenueByHwVenueId(String hwVenueId);

    Long deleteYwVenueByParams(@Param("map") Map<String, String> map);

    Long updateYwVenue(YwVenue ywVenue);

    Long updateYwVenueByParams(@Param("map") Map<String, String> map);

	YwVenue searchYwVenueByHwVenueId(String hwVenueId);

	List<YwVenue> searchYwVenueByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	YwVenue searchYwVenueByParams(@Param("map") Map<String, String> map);
} 
