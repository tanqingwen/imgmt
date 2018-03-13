package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.CpTicket;

public interface CpTicketMapper {

	Long insertCpTicket(CpTicket cpTicket);

    Long deleteCpTicketByTkTicketId(Long tkTicketId);


    Long deleteCpTicketByParams(@Param("map") Map<String, String> map);

    Long updateCpTicket(CpTicket cpTicket);

    Long updateCpTicketByParams(@Param("map") Map<String, String> map);

	CpTicket searchCpTicketByTkTicketId(Long tkTicketId);


	List<CpTicket> searchCpTicketByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<CpTicket> searchCpTicketByParams(@Param("map") Map<String, String> map);

} 
