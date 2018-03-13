package cn.happyworlds.imgmt.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.happyworlds.imgmt.entity.TSysStaff;
import cn.happyworlds.imgmt.mybatis.PageBounds;

// 接口文件有一个非常坑爹的地方，就是光看这个文件完全不知道对应的映射表mapper.xml在哪里。
public interface TSysStaffMapper {

	void insertTSysStaff(TSysStaff TSysStaff);

	void deleteTSysStaffById(String id);

	void updateTSysStaff(TSysStaff TSysStaff);

	TSysStaff searchTSysStaffById(String id);
	
//	员工邮箱查询
	TSysStaff searchTSysStaffByEmail(String email);
	
//	员工手机号查询
	TSysStaff searchTSysStaffByPhone(String phoneNumber);
	
//  查询员工列表是否配置该角色选项
	List<TSysStaff> searchTSysStaffByRoles(String roleid);
	
	List<TSysStaff> searchTSysStaffByParams(@Param("map") Map<String, String> map , PageBounds pageBounds);

	List<TSysStaff> searchTSysStaffByParams(@Param("map") Map<String, String> map);

} 
