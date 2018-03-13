package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.happyworlds.imgmt.entity.CpChannels;
import cn.happyworlds.imgmt.mybatis.PageBounds;

public interface CpChannelsMapper {
	List<CpChannels> searchCpChannelsByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);
	
	List<CpChannels> findAllOrder(@Param("startTime")String startTime,@Param("endTime")String endTime);
}
