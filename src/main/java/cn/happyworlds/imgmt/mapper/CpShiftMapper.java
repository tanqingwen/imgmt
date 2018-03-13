package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.CpShift;

public interface CpShiftMapper {

	Long insertCpShift(CpShift cpShift);

    Long deleteCpShiftByCpShiftId(String cpShiftId);

    Long deleteCpShiftByParams(@Param("map") Map<String, String> map);

    Long updateCpShift(CpShift cpShift);

    Long updateCpShiftByParams(@Param("map") Map<String, String> map);

	CpShift searchCpShiftByCpShiftId(Integer cpShiftId);

	List<CpShift> searchCpShiftByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<CpShift> searchCpShiftByParams(@Param("map") Map<String, String> map);
	
	CpShift searchQianBan(@Param("day") String day,@Param("posIp") String posIp);

	CpShift searchRefundXj(@Param ("day") String day,@Param("posIp") String posIp);
	
	CpShift searchJieBan(@Param("day")String day,@Param("posIp") String posIp);

} 
