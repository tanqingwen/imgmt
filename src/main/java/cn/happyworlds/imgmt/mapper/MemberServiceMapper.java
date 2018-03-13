package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.happyworlds.imgmt.mybatis.PageBounds;

public interface MemberServiceMapper {
	
	List<Map> searchMemberByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

}
