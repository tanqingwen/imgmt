package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.Serial;

public interface SerialMapper {

	Long insertSerial(Serial serial);

    Long deleteSerialById(Integer id);

    Long deleteSerialByParams(@Param("map") Map<String, String> map);

    Long updateSerial(Serial serial);

    Long updateSerialByParams(@Param("map") Map<String, String> map);

	Serial searchSerialById(Integer id);

	List<Serial> searchSerialByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<Serial> searchSerialByParams(@Param("map") Map<String, String> map);

} 
