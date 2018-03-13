package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.YwCardMapping;

public interface YwCardMappingMapper {

	Long insertYwCardMapping(YwCardMapping ywCardMapping);

    Long deleteYwCardMappingByHwCardId(String hwCardId);

    Long deleteYwCardMappingByParams(@Param("map") Map<String, String> map);

    Long updateYwCardMapping(YwCardMapping ywCardMapping);

    Long updateYwCardMappingByParams(@Param("map") Map<String, String> map);

	YwCardMapping searchYwCardMappingByHwCardId(String hwCardId);

	List<YwCardMapping> searchYwCardMappingByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<YwCardMapping> searchYwCardMappingByParams(@Param("map") Map<String, String> map);

} 
