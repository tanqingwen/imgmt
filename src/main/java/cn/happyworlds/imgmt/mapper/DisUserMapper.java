package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.happyworlds.imgmt.entity.DisUser;
import cn.happyworlds.imgmt.mybatis.PageBounds;

public interface DisUserMapper {

	Long insertDisUser(DisUser disUser);

    Long deleteDisUserById(Integer id);

    Long deleteDisUserByParams(@Param("map") Map<String, String> map);

    Long updateDisUser(DisUser disUser);

    Long updateDisUserByParams(@Param("map") Map<String, String> map);

	DisUser searchDisUserById(Integer id);

	List<DisUser> searchDisUserByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<DisUser> searchDisUserByParams(@Param("map") Map<String, String> map);

} 
