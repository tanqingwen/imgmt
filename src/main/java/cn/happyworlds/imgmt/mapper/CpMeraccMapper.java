package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.CpMeracc;

public interface CpMeraccMapper {

	Long insertCpMeracc(CpMeracc cpMeracc);

    Long deleteCpMeraccByMmMerchantNo(String mmMerchantNo);

    Long deleteCpMeraccByParams(@Param("map") Map<String, String> map);

    Long updateCpMeracc(CpMeracc cpMeracc);

    Long updateCpMeraccByParams(@Param("map") Map<String, String> map);

	CpMeracc searchCpMeraccByMmMerchantNo(String mmMerchantNo);

	List<CpMeracc> searchCpMeraccByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<CpMeracc> searchCpMeraccByParams(@Param("map") Map<String, String> map);

	//新增商户获取商户最大值叠加1
	CpMeracc searchMaxMeraccId();
	
	//新增场馆获取场馆最大值叠加1
	CpMeracc searchMaxVeneId();
	
} 
