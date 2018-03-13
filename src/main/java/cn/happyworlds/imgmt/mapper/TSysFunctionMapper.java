package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.TSysFunction;

public interface TSysFunctionMapper {
	
	void insertTSysFunction(TSysFunction TSysFunction);

    Long deleteTSysFunctionByFuntId(Integer funtId);
    
    void deleteTSysFunctionById(String id);

    Long deleteTSysFunctionByParams(@Param("map") Map<String, String> map);
    
    void updateTSysFunction(TSysFunction TSysFunction);

    Long updateTSysFunctionByParams(@Param("map") Map<String, String> map);

	TSysFunction searchTSysFunctionByFuntId(Integer funtId);
	
	TSysFunction searchTSysFunctionById(String id);

	List<TSysFunction> searchTSysFunctionByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<TSysFunction> searchTSysFunctionByParams(@Param("map") Map<String, String> map);

} 
