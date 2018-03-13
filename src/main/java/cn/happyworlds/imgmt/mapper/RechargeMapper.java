package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.happyworlds.imgmt.entity.Recharge;
import cn.happyworlds.imgmt.mybatis.PageBounds;

public interface RechargeMapper {

	List<Recharge> searchRechargeByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);
	
	List<Recharge> searchRechargeByParams(@Param("map") Map<String, String> map);

} 
