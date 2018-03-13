package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.TSysFunction2;

public interface TSysFunction2Mapper {

	Long insertTSysFunction2(TSysFunction2 TSysFunction2);

    Long deleteTSysFunction2ByFuntId(Integer funtId);

    Long deleteTSysFunction2ByParams(@Param("map") Map<String, String> map);

    Long updateTSysFunction2(TSysFunction2 TSysFunction2);

    Long updateTSysFunction2ByParams(@Param("map") Map<String, String> map);

	TSysFunction2 searchTSysFunction2ByFuntId(Integer funtId);

	List<TSysFunction2> searchTSysFunction2ByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<TSysFunction2> searchTSysFunction2ByParams(@Param("map") Map<String, String> map);
	
	TSysFunction2 searchMaxChildenByParentId(String funtParentId);
	
	TSysFunction2 searchMaxNodeByLevel(String level);
	
	Long deleteTSysFunction2ById(String id);

} 
