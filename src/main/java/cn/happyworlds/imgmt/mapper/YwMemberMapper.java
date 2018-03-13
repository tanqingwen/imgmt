package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;


import cn.happyworlds.imgmt.entity.YwMember;
import cn.happyworlds.imgmt.mybatis.PageBounds;

public interface YwMemberMapper {

	Long insertYwMember(YwMember ywMember);

    Long deleteYwMemberByUserId(Integer userId);

    Long deleteYwMemberByParams(@Param("map") Map<String, String> map);

    Long updateYwMember(YwMember ywMember);

    Long updateYwMemberByParams(@Param("map") Map<String, String> map);

	YwMember searchYwMemberByUserId(Integer userId);

	List<YwMember> searchYwMemberByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<YwMember> searchYwMemberByParams(@Param("map") Map<String, String> map);

} 
