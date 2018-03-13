package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.CpMerupd;

public interface CpMerupdMapper {

	Long insertCpMerupd(CpMerupd cpMerupd);

    Long deleteCpMerupdByMmMerchantNo(String mmMerchantNo);

    Long deleteCpMerupdByParams(@Param("map") Map<String, String> map);

    Long updateCpMerupd(CpMerupd cpMerupd);

    Long updateCpMerupdByParams(@Param("map") Map<String, String> map);

	CpMerupd searchCpMerupdByMmMerchantNo(String mmMerchantNo);

	List<CpMerupd> searchCpMerupdByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<CpMerupd> searchCpMerupdByParams(@Param("map") Map<String, String> map);

} 
