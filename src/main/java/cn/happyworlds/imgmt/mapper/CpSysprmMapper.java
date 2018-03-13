package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.CpSysprm;

public interface CpSysprmMapper {

	Long insertCpSysprm(CpSysprm cpSysprm);

    Long deleteCpSysprmBySpId(String spId);

    Long deleteCpSysprmByParams(@Param("map") Map<String, String> map);

    Long updateCpSysprm(CpSysprm cpSysprm);

    Long updateCpSysprmByParams(@Param("map") Map<String, String> map);

	CpSysprm searchCpSysprmBySpId(String spId);

	List<CpSysprm> searchCpSysprmByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<CpSysprm> searchCpSysprmByParams(@Param("map") Map<String, String> map);

} 
