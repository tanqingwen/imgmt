package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.happyworlds.imgmt.entity.TSysRole;
import cn.happyworlds.imgmt.mybatis.PageBounds;

public interface TSysRoleMapper {

	void insertTSysRole(TSysRole TSysRole);

	void deleteTSysRoleById(String id);

	void updateTSysRole(TSysRole TSysRole);

	TSysRole searchTSysRoleById(String id);
	
//	根据角色名查询
	TSysRole searchTSysRoleByIdAndName(String name);

	List<TSysRole> searchTSysRoleByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<TSysRole> searchTSysRoleByParams(@Param("map") Map<String, String> map);

} 
