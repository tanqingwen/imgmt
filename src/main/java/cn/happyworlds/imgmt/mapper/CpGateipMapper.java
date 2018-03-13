package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.CpGateip;
import cn.happyworlds.imgmt.entity.CpTrmacc;

public interface CpGateipMapper {

	Long insertCpGateip(CpGateip cpGateip);

    Long deleteCpGateipByGaId(Integer gaId);

    Long deleteCpGateipByParams(@Param("map") Map<String, String> map);

    Long updateCpGateip(CpGateip cpGateip);

    Long updateCpGateipByParams(@Param("map") Map<String, String> map);

	CpGateip searchCpGateipByGaId(Integer gaId);

	List<CpGateip> searchCpGateipByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<CpGateip> searchCpGateipByParams(@Param("map") Map<String, String> map);
	
	//新增闸机IP获取闸机IP最大值叠加1
	CpGateip searchMaxGateIpId();
	
} 
