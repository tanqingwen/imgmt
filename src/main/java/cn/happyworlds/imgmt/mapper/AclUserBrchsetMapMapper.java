package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.AclUserBrchsetMap;

public interface AclUserBrchsetMapMapper {

	Long insertAclUserBrchsetMap(AclUserBrchsetMap aclUserBrchsetMap);

    Long deleteAclUserBrchsetMapByUserId(String userId);

    Long deleteAclUserBrchsetMapByParams(@Param("map") Map<String, String> map);

    Long updateAclUserBrchsetMap(AclUserBrchsetMap aclUserBrchsetMap);

    Long updateAclUserBrchsetMapByParams(@Param("map") Map<String, String> map);

	AclUserBrchsetMap searchAclUserBrchsetMapByUserId(String userId);

	List<AclUserBrchsetMap> searchAclUserBrchsetMapByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<AclUserBrchsetMap> searchAclUserBrchsetMapByParams(@Param("map") Map<String, String> map);

} 
