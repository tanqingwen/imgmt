package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.District;

public interface DistrictMapper {

	Long insertDistrict(District district);

    Long deleteDistrictById(Integer id);

    Long deleteDistrictByParams(@Param("map") Map<String, String> map);

    Long updateDistrict(District district);

    Long updateDistrictByParams(@Param("map") Map<String, String> map);

	District searchDistrictByCode(String Code);

	List<District> searchDistrictByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<District> searchDistrictByParams(@Param("map") Map<String, String> map);

} 
