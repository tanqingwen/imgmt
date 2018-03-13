package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.happyworlds.imgmt.entity.TSysDepartment;
import cn.happyworlds.imgmt.mybatis.PageBounds;

public interface TSysDepartmentMapper {

	void insertTSysDepartment(TSysDepartment TSysDepartment);

	void deleteTSysDepartmentByDeptId(String deptId);

	void updateTSysDepartment(TSysDepartment TSysDepartment);

	TSysDepartment searchTSysDepartmentByDeptId(String deptId);

	List<TSysDepartment> searchTSysDepartmentByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<TSysDepartment> searchTSysDepartmentByParams(@Param("map") Map<String, String> map);

	TSysDepartment searchMaxChildenByParentId(String deptParentId);
} 
