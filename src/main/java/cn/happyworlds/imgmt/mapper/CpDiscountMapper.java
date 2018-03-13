package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.happyworlds.imgmt.entity.CpDiscount;
import cn.happyworlds.imgmt.mybatis.PageBounds;

public interface CpDiscountMapper {

	Long insertCpDiscount(CpDiscount cpDiscount);

    Long deleteCpDiscountByDisId(String disId);

    Long deleteCpDiscountByParams(@Param("map") Map<String, String> map);

    Long updateCpDiscount(CpDiscount cpDiscount);

    Long updateCpDiscountByParams(@Param("map") Map<String, String> map);

	CpDiscount searchCpDiscountByDisId(String disId);

	List<CpDiscount> searchCpDiscountByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<CpDiscount> searchCpDiscountByParams(@Param("map") Map<String, String> map);
	
	CpDiscount searchCpDiscountByMaxId();
} 
