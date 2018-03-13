package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.happyworlds.imgmt.mybatis.PageBounds;

import cn.happyworlds.imgmt.entity.AclUser;

public interface AclUserMapper {
	/*@Insert(" INSERT INTO acl_user(user_id,user_name,user_passwd,status,dep_name,occupation,email_id,contact_no,password_cre_time,"
			+ "password_exp_time,fail_count,modify_time,modify_by,com_port)VALUES(#{userId},#{userName},#{userPasswd},#{status},#{depName},#{occupation},"
			+ "#{emailId},#{contactNo},#{passwordCreTime},#{passwordExpTime},#{failCount},#{modifyTime},#{modifyBy},#{comPort})")*/
	Long insertAclUser(AclUser aclUser);

    Long deleteAclUserByUserId(String userId);

    Long deleteAclUserByParams(@Param("map") Map<String, String> map);

    Long updateAclUser(AclUser aclUser);

    Long updateAclUserByParams(@Param("map") Map<String, String> map);

	AclUser searchAclUserByUserId(String userId);

	List<AclUser> searchAclUserByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);
	
/*	@Select("Select user_id,user_name,user_passwd,status,dep_name,occupation,email_id,contact_no,password_cre_time,"
			+ "password_exp_time,fail_count,modify_time,modify_by from acl_user")*/
	
	List<AclUser> searchAclUserByParams(@Param("map") Map<String, String> map);

} 
