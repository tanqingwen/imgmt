package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.happyworlds.imgmt.entity.CpTrmacc;
import cn.happyworlds.imgmt.mybatis.PageBounds;



public interface CpTrmaccMapper {

	Long insertCpTrmacc(CpTrmacc cpTrmacc);

    Long deleteCpTrmaccByTmTerminalId(String tmTerminalId);

    Long deleteCpTrmaccByParams(@Param("map") Map<String, String> map);

    Long updateCpTrmacc(CpTrmacc cpTrmacc);

    Long updateCpTrmaccByParams(@Param("map") Map<String, String> map);

	CpTrmacc searchCpTrmaccByTmTerminalId(String tmTerminalId);

	List<CpTrmacc> searchCpTrmaccByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<CpTrmacc> searchCpTrmaccByParams(@Param("map") Map<String, String> map);
	
	//新增闸机获取闸机最大值叠加1
	CpTrmacc searchMaxGateTrmaccTerminalId();
	
	//新增终端获取终端最大值叠加1
	CpTrmacc searchMaxTrmaccTerminalId();

} 
