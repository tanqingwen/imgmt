package cn.happyworlds.imgmt.mapper;

import java.util.Map;

public interface OrganizationServiceMapper {
	
	Map<String, String> searchOrgIdByparentId(String parentId);
	Map<String, String> searchOrgIdBylevelId(String levelId);
}
