package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.entity.Opeartion;
import cn.happyworlds.imgmt.mybatis.PageBounds;

public interface OpeartionMapper {

	List<Opeartion> searchOpeartionStatWhereOther(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<Opeartion> searchOpeartionStatWhereK(@Param("map") Map<String, String> map,PageBounds pageBounds);
	
	List<Opeartion> searchOpeartionStatWhereOther(@Param("map") Map<String, String> map);

	List<Opeartion> searchOpeartionStatWhereK(@Param("map") Map<String, String> map);

} 
