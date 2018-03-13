package cn.happyworlds.imgmt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.happyworlds.imgmt.entity.TSysDepartment;
import cn.happyworlds.imgmt.entity.TSysFunction;
import cn.happyworlds.imgmt.entity.TSysStaff;
import cn.happyworlds.imgmt.mapper.TSysDepartmentMapper;
import cn.happyworlds.imgmt.mapper.TSysFunctionMapper;
import cn.happyworlds.imgmt.util.DateTimes;
import cn.happyworlds.imgmt.util.StatusResult;
import cn.happyworlds.imgmt.util.Strings;

@Service("departmentService2")
public class DepartmentService2 {
	
	private int[] ID_SECTIONS_SIZE = new int[] { 2, 2, 2, 3, 3, 3, 3, 3, 3 };
	
	@Autowired
	private TSysDepartmentMapper tSysDepartmentMapper;
	
	@Autowired
	private TSysDepartmentMapper departmentServiceMapper;
	
	@Autowired
	private TSysFunctionMapper functionServiceMapper;
	
	public List<TSysDepartment> organizationList() {
		return tSysDepartmentMapper.searchTSysDepartmentByParams(null);
	}
	
	public StatusResult<TSysFunction> searchdepartmentById(String deptid) {
		TSysFunction function = functionServiceMapper.searchTSysFunctionByFuntId(Integer.valueOf(deptid));
		if (null == function) {
			return StatusResult.create("DEPARTMENT_NOT_EXISTS", "部门不存在");
		}
		return StatusResult.create(function);
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
	
	public StatusResult<List<TSysFunction>> searchDepartmentByParentId(Integer parentId) {
		if (StringUtils.isEmpty(parentId)) {
			return StatusResult.create("PARENT_ID_IS_EMPTY", "父级ID不能为空");
		}
		Map<String, String> params = new HashMap<String, String>();
		params.put("funtParentId", String.valueOf(parentId));
		List<TSysFunction> childrens = functionServiceMapper.searchTSysFunctionByParams(params);
		if (null == childrens || childrens.isEmpty()) {
			return StatusResult.create("CHILDRENS_DEPARTMENT_NOT_EXISTS", "子级机构不存在");
		}
		return StatusResult.create(childrens);
	}
	
	public StatusResult<TSysFunction> updatefunction(TSysFunction function, TSysStaff staff){		
		functionServiceMapper.updateTSysFunction(function);
		return StatusResult.create(function);
	}
	
	public StatusResult<TSysFunction> addDeptOrUpdateDept(TSysFunction function, TSysStaff staff) {
		
		TSysFunction dbfunction = functionServiceMapper.searchTSysFunctionByFuntId(function.getFuntId());
		if (null != dbfunction) {// 更新信息
			// organization.setId(DateTimes.nowTimestamp());
			dbfunction.setFuntParentId(function.getFuntParentId());
			dbfunction.setFuntUpdateBy(staff.getId());
			dbfunction.setFuntUpdateData(DateTimes.nowTimestamp());
			dbfunction.setName(function.getName());
			dbfunction.setFuntLevel(function.getFuntLevel());
//			dbfunction.setDeptRemark(department.getDeptRemark());
//			dbfunction.setDeptStatus("NORMAL");
			functionServiceMapper.updateTSysFunction(dbfunction);
		} else {// 插入信息
			TSysFunction parent = functionServiceMapper.searchTSysFunctionByFuntId(Integer.valueOf(function.getFuntParentId()));
			/*String nextId = buildDeptId(parent);
			function.setFuntId(Integer.valueOf(nextId));*/
			if (function.getFuntParentId()==null) {
				function.setFuntParentId(1);
			}
			function.setFuntCreateDate(DateTimes.nowTimestamp());
			function.setFuntCreateBy(staff.getId());
			//function.setDeptStatus("NORMAL");
			//tSysDepartmentMapper.insertTSysDepartment(function);
			functionServiceMapper.insertTSysFunction(function);
		}
		return StatusResult.create(function);
	}
	
	public String deleteDept(Integer funtId){
		functionServiceMapper.deleteTSysFunctionByFuntId(funtId);  
		return  "success";  
	}
	
	/*private String buildDeptId(TSysFunction parent) {
		StringBuilder buf = new StringBuilder();
		if (!"0".equals(String.valueOf(parent.getFuntId()))) {
			buf.append(parent.getFuntId());
		}
		int level = Short.parseShort(String.valueOf(parent.getFuntLevel()));
		TSysFunction childen = functionServiceMapper.searchMaxChildenByParentId(""+parent.getFuntId());
		if (null == childen) {
			buf.append(Strings.leftAppend("1", ID_SECTIONS_SIZE[level], '0'));
		} else {
			String funtIdStr = String.valueOf(childen.getFuntId());
			if(funtIdStr.length()==1){
				funtIdStr = "0"+funtIdStr;
			}
			int aa  =funtIdStr.length() - ID_SECTIONS_SIZE[level];
			System.out.println("___________"+funtIdStr.length());
			System.out.println("___________"+ID_SECTIONS_SIZE[level]);
			System.out.println("___________"+aa);
			String maxId = funtIdStr.substring(funtIdStr.length() - ID_SECTIONS_SIZE[level]);
			int nextId = Integer.parseInt(maxId) + 1;
			buf.append(Strings.leftAppend(nextId, ID_SECTIONS_SIZE[level], '0'));
		}
		return buf.toString();
	}*/
	
}
