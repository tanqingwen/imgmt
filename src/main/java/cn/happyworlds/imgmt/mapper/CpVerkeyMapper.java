package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.CpVerkey;

public interface CpVerkeyMapper {

	Long insertCpVerkey(CpVerkey cpVerkey);

    Long deleteCpVerkeyByVkValue(String vkValue);

    Long deleteCpVerkeyByParams(@Param("map") Map<String, String> map);

    Long updateCpVerkey(CpVerkey cpVerkey);

    Long updateCpVerkeyByParams(@Param("map") Map<String, String> map);

	CpVerkey searchCpVerkeyByVkValue(String vkValue);

	List<CpVerkey> searchCpVerkeyByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<CpVerkey> searchCpVerkeyByParams(@Param("map") Map<String, String> map);

} 
