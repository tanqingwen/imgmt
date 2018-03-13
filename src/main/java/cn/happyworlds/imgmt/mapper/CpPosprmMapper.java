package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.happyworlds.imgmt.entity.CpPosprm;
import cn.happyworlds.imgmt.mybatis.PageBounds;


public interface CpPosprmMapper {

	Long insertCpPosprm(CpPosprm cpPosprm);

    Long deleteCpPosprmByPpBrand(String ppBrand);

    Long deleteCpPosprmByParams(@Param("map") Map<String, String> map);

    Long updateCpPosprm(CpPosprm cpPosprm);

    Long updateCpPosprmByParams(@Param("map") Map<String, String> map);

	CpPosprm searchCpPosprmByPpBrand(String ppBrand);
	/**
	 * 查询机具牌子
	 */
	List<CpPosprm> findAllCpPosprmPpBrand();

	List<CpPosprm> searchCpPosprmByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<CpPosprm> searchCpPosprmByParams(@Param("map") Map<String, String> map);

} 
