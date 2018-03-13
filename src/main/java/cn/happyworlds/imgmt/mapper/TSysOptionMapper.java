package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.happyworlds.imgmt.entity.TSysOption;
import cn.happyworlds.imgmt.mybatis.PageBounds;

public interface TSysOptionMapper {

	void insertTSysOption(TSysOption TSysOption);

	void deleteTSysOptionById(String id);

	void updateTSysOption(TSysOption TSysOption);

	TSysOption searchTSysOptionById(String id);

	List<TSysOption> searchTSysOptionByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<TSysOption> searchTSysOptionByParams(@Param("map") Map<String, String> map);

} 
