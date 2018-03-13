package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.CpTicket;

public interface BuyTicketStatMapper {

	List<CpTicket> searchCpTicketAndCpTktypeStat(@Param("map") Map<String, String> map , PageBounds pageBounds);
	
	List<CpTicket> searchCpTicketAndCpTktypeStat(@Param("map") Map<String, String> map);

} 
