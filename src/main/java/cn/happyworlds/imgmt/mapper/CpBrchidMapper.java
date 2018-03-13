package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.entity.CpBrchid;
import cn.happyworlds.imgmt.mybatis.PageBounds;

public interface CpBrchidMapper {


	Long insertCpBrchid(CpBrchid cpBrchid);

    Long deleteCpBrchidByBrBranchId(String brBranchId);

    Long deleteCpBrchidByParams(@Param("map") Map<String, String> map);

    Long updateCpBrchid(CpBrchid cpBrchid);

    Long updateCpBrchidByParams(@Param("map") Map<String, String> map);

	CpBrchid searchCpBrchidByBrBranchId(String brBranchId);

	List<CpBrchid> searchCpBrchidByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<CpBrchid> searchCpBrchidByParams(@Param("map") Map<String, String> map);
	
	
} 
