package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.happyworlds.imgmt.entity.Shifting;

public interface ShiftingMapper {

	List<Shifting> searchShifting(@Param("map") Map<String, String> map);
	
	List<Shifting> searchMoney(@Param("map") Map<String, String> map);
	List<Shifting> searchTotalRefund(@Param("map") Map<String, String> map);
	
	Shifting searchCount(@Param("userId")String userId,@Param("day")String day,@Param("ip") String ip);
	
	Shifting searchTicketCash(@Param("userId")String userId,@Param("day")String day,@Param("ip") String ip);
	
	Shifting searchCardCash(@Param("userId")String userId,@Param("day")String day);
	
	
	Shifting searchTicketRefund(@Param("userId")String userId,@Param("day")String day,@Param("ip") String ip);
	//时间验证
	List<Shifting> searchShifting2(@Param("map") Map<String, String> map);
} 
