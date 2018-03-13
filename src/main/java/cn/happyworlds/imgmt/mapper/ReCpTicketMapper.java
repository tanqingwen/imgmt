package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.happyworlds.imgmt.entity.CpTicket;
import cn.happyworlds.imgmt.mybatis.PageBounds;

public interface ReCpTicketMapper {

	List<CpTicket> searchCpTicketAndCpTktypeConvert(@Param("map") Map<String, String> map , PageBounds pageBounds);
	
	List<CpTicket> searchCpTicketAndCpTktypeBack(@Param("map") Map<String, String> map , PageBounds pageBounds);

} 
