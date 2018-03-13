package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.YwPayrecord;

public interface YwPayrecordMapper {

	Long insertYwPayrecord(YwPayrecord ywPayrecord);

    Long deleteYwPayrecordByHwSn(String hwSn);

    Long deleteYwPayrecordByParams(@Param("map") Map<String, String> map);

    Long updateYwPayrecord(YwPayrecord ywPayrecord);

    Long updateYwPayrecordByParams(@Param("map") Map<String, String> map);

	YwPayrecord searchYwPayrecordByHwSn(String hwSn);

	List<YwPayrecord> searchYwPayrecordByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<YwPayrecord> searchYwPayrecordByParams(@Param("map") Map<String, String> map);

} 
