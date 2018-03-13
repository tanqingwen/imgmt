package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.happyworlds.imgmt.entity.TSysOrganization;
import cn.happyworlds.imgmt.mybatis.PageBounds;

public interface TSysOrganizationMapper {

	void insertTSysOrganization(TSysOrganization TSysOrganization);

	void deleteTSysOrganizationById(String id);

	void updateTSysOrganization(TSysOrganization TSysOrganization);

	TSysOrganization searchTSysOrganizationById(String id);

	List<TSysOrganization> searchTSysOrganizationByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<TSysOrganization> searchTSysOrganizationByParams(@Param("map") Map<String, String> map);

} 
