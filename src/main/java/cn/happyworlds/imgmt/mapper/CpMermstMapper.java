package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.entity.CpMermst;

public interface CpMermstMapper {

	Long insertCpMermst(CpMermst cpMermst);

    Long deleteCpMermstByMmMerchantNo(String mmMerchantNo);

    Long deleteCpMermstByParams(@Param("map") Map<String, String> map);

    Long updateCpMermst(CpMermst cpMermst);

    Long updateCpMermstByParams(@Param("map") Map<String, String> map);

	CpMermst searchCpMermstByMmMerchantNo(String mmMerchantNo);

	List<CpMermst> searchCpMermstByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<CpMermst> searchCpMermstByParams(@Param("map") Map<String, String> map);
	
	//新增商户获取商户最大值叠加1
	CpMermst searchMaxMermstId();
	
	//新增场馆获取场馆最大值叠加1
	CpMermst searchMaxVeneId();
	

} 
