package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.CpCeptrx;

public interface ReCpCeptrxMapper {

	List<CpCeptrx> searchReturnTicketStat(@Param("map") Map<String, String> map , PageBounds pageBounds);
	
	List<CpCeptrx> searchReturnTicketStat(@Param("map") Map<String, String> map);

} 
