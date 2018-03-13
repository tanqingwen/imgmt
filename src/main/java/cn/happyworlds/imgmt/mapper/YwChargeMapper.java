package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.YwCharge;

public interface YwChargeMapper {

	Long insertYwCharge(YwCharge ywCharge);

    Long deleteYwChargeByHwSn(String hwSn);

    Long deleteYwChargeByParams(@Param("map") Map<String, String> map);

    Long updateYwCharge(YwCharge ywCharge);

    Long updateYwChargeByParams(@Param("map") Map<String, String> map);

	YwCharge searchYwChargeByHwSn(String hwSn);

	List<YwCharge> searchYwChargeByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<YwCharge> searchYwChargeByParams(@Param("map") Map<String, String> map);

	
} 
