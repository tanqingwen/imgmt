package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.CpTrmmst;

public interface CpTrmmstMapper {

	Long insertCpTrmmst(CpTrmmst cpTrmmst);

    Long deleteCpTrmmstByTmTerminalId(String tmTerminalId);

    Long deleteCpTrmmstByParams(@Param("map") Map<String, String> map);

    Long updateCpTrmmst(CpTrmmst cpTrmmst);

    Long updateCpTrmmstByParams(@Param("map") Map<String, String> map);

	CpTrmmst searchCpTrmmstByTmTerminalId(String tmTerminalId);

	List<CpTrmmst> searchCpTrmmstByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<CpTrmmst> searchCpTrmmstByParams(@Param("map") Map<String, String> map);

	//新增闸机获取闸机最大值叠加1
	CpTrmmst searchMaxGateTrmmstTerminalId();
	
	//新增终端获取终端最大值叠加1
	CpTrmmst searchMaxTrmmstTerminalId();
	
	//根据终端ip查询终端名称
	CpTrmmst seachTrmmstByIp(@Param("posIp")String posIp);
	
} 
