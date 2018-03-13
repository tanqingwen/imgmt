package cn.happyworlds.imgmt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.TSysRole;
import cn.happyworlds.imgmt.entity.TSysStaff;
import cn.happyworlds.imgmt.mapper.TSysRoleMapper;
import cn.happyworlds.imgmt.mapper.TSysStaffMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.util.DateTimes;
import cn.happyworlds.imgmt.util.Result;

@Service
public class RoleService {

	@Autowired
	private TSysRoleMapper tSysRoleMapper;
	@Autowired
	private TSysStaffMapper tSysStaffMapper;
	
	public List<TSysRole> roleList() {
		return tSysRoleMapper.searchTSysRoleByParams(null);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Result<PageInfo<TSysRole>> roleList(final String id, final String name, PageBounds pageBounds) {
		Map<String, String> params = new HashMap<>();
		if (StringUtils.hasText(id)) {
			params.put("id", id);
		}
		if (StringUtils.hasText(name)) {
			params.put("name", name);
		}
		List<TSysRole> page = tSysRoleMapper.searchTSysRoleByParams(params, pageBounds);
		return Result.create(new PageInfo(page));
	}

	public Result<TSysRole> roleAdd(TSysRole role) {
		TSysRole dbRole = tSysRoleMapper.searchTSysRoleById(role.getId());
		
//		根据角色名和角色id
		TSysRole dbRoleAll=tSysRoleMapper.searchTSysRoleByIdAndName(role.getName());
		if(null !=dbRole){
			return Result.create("ROLE_ID_EXISTS", "角色已经存在");
		}else if(null !=dbRoleAll){
			return Result.create("ROLE_ID_EXISTS", "角色已经存在");
		}
		try {
			role.setCreatedAt(DateTimes.nowTimestamp());
			role.setStatus("NORMAL");
			/**
			 * 权限添加登录逻辑
			 */
			role.setFunctions("ROOT_INDEX");
			//
			tSysRoleMapper.insertTSysRole(role);
			return Result.create(role);
		} catch (Throwable t) {
			t.printStackTrace();
			return Result.create("ROLE_ADD_FAILED", "角色添加失败");
		}
	}

	public Result<TSysRole> roleGetById(String id) {
		TSysRole dbRole = tSysRoleMapper.searchTSysRoleById(id);
		if (null == dbRole) {
			return Result.create("ROLE_NOT_EXISTS", "角色不存在");
		}
		return Result.create(dbRole);
	}

	public Result<TSysRole> roleUpdate(TSysRole role) {
		TSysRole roleName=tSysRoleMapper.searchTSysRoleByIdAndName(role.getName());
		Map<String, String> params=new HashMap<>();
		params.put("id", role.getId());
		params.put("name", role.getName());
		role.setUpdatedAt(DateTimes.nowTimestamp());
		List<TSysRole> roleId=tSysRoleMapper.searchTSysRoleByParams(params);
		if(null != roleName){
			if(roleId.size()>0){
				tSysRoleMapper.updateTSysRole(role);
				return Result.create(role);
			}else{
				return Result.create("ROLE_NOT_EXISTS", "角色更新失败");
			}
		}else{
		
			tSysRoleMapper.updateTSysRole(role);
			return Result.create(role);
		}
			
	}
	
	public Result<TSysRole> roleDelete(String id) {
		try {
			List<TSysStaff> list =tSysStaffMapper.searchTSysStaffByRoles(id);
			if(list!=null &&list.size()>0){
				return Result.create("IDTYPE_DICT_UPDATE_FAILED", "员工配置该角色，不能删除");
			}
			tSysRoleMapper.deleteTSysRoleById(id);
		} catch (Throwable t) {
			t.printStackTrace();
			return Result.create("IDTYPE_DICT_UPDATE_FAILED", "角色删除失败");
		}
		return Result.create(null);
	}
}
