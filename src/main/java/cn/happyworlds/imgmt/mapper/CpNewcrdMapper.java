package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.CpNewcrd;

public interface CpNewcrdMapper {

	Long insertCpNewcrd(CpNewcrd cpNewcrd);

    Long deleteCpNewcrdByNcCardNo(String ncCardNo);

    Long deleteCpNewcrdByParams(@Param("map") Map<String, String> map);

    Long updateCpNewcrd(CpNewcrd cpNewcrd);

    Long updateCpNewcrdByParams(@Param("map") Map<String, String> map);

	CpNewcrd searchCpNewcrdByNcCardNo(String ncCardNo);

	List<CpNewcrd> searchCpNewcrdByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<CpNewcrd> searchCpNewcrdByParams(@Param("map") Map<String, String> map);

} 
