package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.happyworlds.imgmt.entity.CpTuiPiao;
import cn.happyworlds.imgmt.mybatis.PageBounds;

public interface CpTuiPiaoMapper {
	List<CpTuiPiao> searchCpChannelsByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);
	
	List<CpTuiPiao> getAllReturnTicket(@Param("startTime") String startTime,@Param("endTime") String endTime);
}
