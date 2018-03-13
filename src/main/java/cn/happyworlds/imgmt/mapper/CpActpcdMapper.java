package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.happyworlds.imgmt.entity.CpActpcd;
import cn.happyworlds.imgmt.mybatis.PageBounds;

public interface CpActpcdMapper {

	Long insertCpActpcd(CpActpcd cpActpcd);

    Long deleteCpActpcdBySysAcctTypeCode(String sysAcctTypeCode);

    Long deleteCpActpcdByParams(@Param("map") Map<String, String> map);

    Long updateCpActpcd(CpActpcd cpActpcd);

    Long updateCpActpcdByParams(@Param("map") Map<String, String> map);

	CpActpcd searchCpActpcdBySysAcctTypeCode(String sysAcctTypeCode);

	List<CpActpcd> searchCpActpcdByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<CpActpcd> searchCpActpcdByParams(@Param("map") Map<String, String> map);


} 
