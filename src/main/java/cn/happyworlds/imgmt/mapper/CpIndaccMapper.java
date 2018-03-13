package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.CpIndacc;

public interface CpIndaccMapper {

	Long insertCpIndacc(CpIndacc cpIndacc);

    Long deleteCpIndaccByParams(@Param("map") Map<String, String> map);

    Long updateCpIndacc(CpIndacc cpIndacc);

    Long updateCpIndaccByParams(@Param("map") Map<String, String> map);

    CpIndacc searchCpIndaccByAcctNo(String acctNo);

	List<CpIndacc> searchCpIndaccByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<CpIndacc> searchCpIndaccByParams(@Param("map") Map<String, String> map);

} 
