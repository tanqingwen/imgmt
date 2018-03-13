package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.YwTicket;

public interface YwTicketMapper {

	Long insertYwTicket(YwTicket ywTicket);

    Long deleteYwTicketByHwTicketCode(String hwTicketCode);

    Long deleteYwTicketByParams(@Param("map") Map<String, String> map);

    Long updateYwTicket(YwTicket ywTicket);

    Long updateYwTicketByParams(@Param("map") Map<String, String> map);

	YwTicket searchYwTicketByHwTicketCode(String hwTicketCode);

	List<YwTicket> searchYwTicketByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<YwTicket> searchYwTicketByParams(@Param("map") Map<String, String> map);

} 
