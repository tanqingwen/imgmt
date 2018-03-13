package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.YwPayrecord;

public interface ReYwPayrecordMapper {

	List<YwPayrecord> searchYwPayrecordByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

} 
