package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.happyworlds.imgmt.entity.AppTicket;
import cn.happyworlds.imgmt.mybatis.PageBounds;

public interface AppTicketMapper {

	Long insertAppTicket(AppTicket appTicket);

    Long deleteAppTicketByTicketId(String ticketId);

    Long deleteAppTicketByParams(@Param("map") Map<String, String> map);

    Long updateAppTicket(AppTicket appTicket);

    Long updateAppTicketByParams(@Param("map") Map<String, String> map);

	AppTicket searchAppTicketByTicketId(String ticketId);

	List<AppTicket> searchAppTicketByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<AppTicket> searchAppTicketByParams(@Param("map") Map<String, String> map);

} 
