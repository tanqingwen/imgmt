package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.YwGate;

public interface YwGateMapper {

	Long insertYwGate(YwGate ywGate);

    Long deleteYwGateByHwGateId(String hwGateId);

    Long deleteYwGateByParams(@Param("map") Map<String, String> map);

    Long updateYwGate(YwGate ywGate);

    Long updateYwGateByParams(@Param("map") Map<String, String> map);

	YwGate searchYwGateByHwGateId(String hwGateId);

	List<YwGate> searchYwGateByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	YwGate searchYwGateByParams(@Param("map") Map<String, String> map);

} 
