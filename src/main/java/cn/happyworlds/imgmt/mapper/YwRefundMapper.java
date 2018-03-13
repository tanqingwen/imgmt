package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.YwRefund;

public interface YwRefundMapper {

	Long insertYwRefund(YwRefund ywRefund);

    Long deleteYwRefundByHwId(Integer hwId);

    Long deleteYwRefundByParams(@Param("map") Map<String, String> map);

    Long updateYwRefund(YwRefund ywRefund);

    Long updateYwRefundByParams(@Param("map") Map<String, String> map);

	YwRefund searchYwRefundByHwId(Integer hwId);

	List<YwRefund> searchYwRefundByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<YwRefund> searchYwRefundByParams(@Param("map") Map<String, String> map);

} 
