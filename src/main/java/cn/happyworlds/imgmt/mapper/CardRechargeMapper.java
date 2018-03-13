package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.happyworlds.imgmt.entity.CardRecharge;

public interface CardRechargeMapper {

	List<CardRecharge> seachCard(@Param("map") Map<String, String> map);
	
} 
