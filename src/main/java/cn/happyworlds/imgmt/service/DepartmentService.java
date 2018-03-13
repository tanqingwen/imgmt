package cn.happyworlds.imgmt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.happyworlds.imgmt.entity.TSysDepartment;
import cn.happyworlds.imgmt.entity.TSysStaff;
import cn.happyworlds.imgmt.mapper.TSysDepartmentMapper;
import cn.happyworlds.imgmt.util.DateTimes;
import cn.happyworlds.imgmt.util.StatusResult;
import cn.happyworlds.imgmt.util.Strings;

@Service("departmentService")
public class DepartmentService {
	
	private int[] ID_SECTIONS_SIZE = new int[] { 1, 1, 2, 3, 3, 3, 3, 3, 3 };
	
	@Autowired
	private TSysDepartmentMapper tSysDepartmentMapper;
	
	@Autowired
	private TSysDepartmentMapper departmentServiceMapper;
	
	public List<TSysDepartment> organizationList() {
		return tSysDepartmentMapper.searchTSysDepartmentByParams(null);
	}
	
	public StatusResult<TSysDepartment> searchdepartmentById(String deptid) {
		TSysDepartment dbdepartment = tSysDepartmentMapper.searchTSysDepartmentByDeptId(deptid);
		if (null == dbdepartment) {
			return StatusResult.create("DEPARTMENT_NOT_EXISTS", "部门不存在");
		}
		return StatusResult.create(dbdepartment);
	}

	public StatusResult<TSysDepartment> departmentDelete(String deptid) {
		try {
			tSysDepartmentMapper.deleteTSysDepartmentByDeptId(deptid);
		} catch (Throwable t) {
			t.printStackTrace();
			return StatusResult.create("DEPARTMENT_DELETE_FIAL", "部门删除失败");
		}
		return StatusResult.create(null);
	}
	
	public StatusResult<List<TSysDepartment>> searchDepartmentByParentId(String parentId) {
		if (StringUtils.isEmpty(parentId)) {
			return StatusResult.create("PARENT_ID_IS_EMPTY", "父级ID不能为空");
		}
		Map<String, String> params = new HashMap<String, String>();
		params.put("deptParentId", parentId);
		List<TSysDepartment> childrens = tSysDepartmentMapper.searchTSysDepartmentByParams(params);
		if (null == childrens || childrens.isEmpty()) {
			return StatusResult.create("CHILDRENS_DEPARTMENT_NOT_EXISTS", "子级机构不存在");
		}
		return StatusResult.create(childrens);
	}
	
	
	
	public StatusResult<TSysDepartment> addDeptOrUpdateDept(TSysDepartment department, TSysStaff staff) {
		TSysDepartment dbdepartment = tSysDepartmentMapper.searchTSysDepartmentByDeptId(department.getDeptId());
		if (null != dbdepartment) {// 更新信息
			// organization.setId(DateTimes.nowTimestamp());
			dbdepartment.setDeptParentId(department.getDeptParentId());
			dbdepartment.setDeptUpdateBy(staff.getId());
			dbdepartment.setDeptUpdateDate(DateTimes.nowTimestamp());
			dbdepartment.setDeptName(department.getDeptName());
			dbdepartment.setDeptLevel(department.getDeptLevel());
			dbdepartment.setDeptRemark(department.getDeptRemark());
			dbdepartment.setDeptStatus("NORMAL");
			tSysDepartmentMapper.updateTSysDepartment(dbdepartment);
		} else {// 插入信息
			TSysDepartment parent = tSysDepartmentMapper.searchTSysDepartmentByDeptId(department.getDeptParentId());
			String nextId = buildDeptId(parent);
			department.setDeptId(nextId);
			if ("".equals(department.getDeptParentId())) {
				department.setDeptParentId("ROOT");
			}
			department.setDeptCreateDate(DateTimes.nowTimestamp());
			department.setDeptCreateBy(staff.getId());
			department.setDeptStatus("NORMAL");
			tSysDepartmentMapper.insertTSysDepartment(department);
		}
		return StatusResult.create(department);
	}
	
	public String deleteDept(String id){
		tSysDepartmentMapper.deleteTSysDepartmentByDeptId(id);  
		return  "success";  
	}
	
	private String buildDeptId(TSysDepartment parent) {
		StringBuilder buf = new StringBuilder();
		if (!"ROOT".equals(parent.getDeptId())) {
			buf.append(parent.getDeptId());
		}
		int level = Short.parseShort(parent.getDeptLevel());
		TSysDepartment childen = departmentServiceMapper.searchMaxChildenByParentId(parent.getDeptId());
		if (null == childen) {
			buf.append(Strings.leftAppend("1", ID_SECTIONS_SIZE[level], '0'));
		} else {
			String maxId = childen.getDeptId().substring(childen.getDeptId().length() - ID_SECTIONS_SIZE[level]);
			int nextId = Integer.parseInt(maxId) + 1;
			buf.append(Strings.leftAppend(nextId, ID_SECTIONS_SIZE[level], '0'));
		}
		return buf.toString();
	}
}
