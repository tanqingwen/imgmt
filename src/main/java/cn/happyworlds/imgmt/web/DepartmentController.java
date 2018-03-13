package cn.happyworlds.imgmt.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.happyworlds.imgmt.entity.TSysDepartment;
import cn.happyworlds.imgmt.entity.TSysStaff;
import cn.happyworlds.imgmt.service.DepartmentService;
import cn.happyworlds.imgmt.util.StatusResult;

@Controller("departmentController")
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;

	@WebAction(Permission.DEPARTMENT_LIST)
	@RequestMapping(value = "/depttree", method = RequestMethod.GET)
	public String tree(String parentId, Model m) {
		if (StringUtils.isEmpty(parentId)) {
			parentId = "ROOT";
		}
		StatusResult<TSysDepartment> r1 = departmentService.searchdepartmentById(parentId);
		m.addAttribute("deptparent", r1.getValue());
		return "department/depttree";
	}

	@WebAction(Permission.DEPARTMENT_SHOW)
	@RequestMapping(value = "/search_childrens", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, String>> searchChildrens(String parentId, Model m) {
		StatusResult<List<TSysDepartment>> r2 = departmentService.searchDepartmentByParentId(parentId);
		List<Map<String, String>> nodes = new ArrayList<>();
		// 子节点
		List<TSysDepartment> orgs = r2.getValue();
		if(null != orgs){
			for (TSysDepartment org : orgs) {
				Map<String, String> node = new HashMap<>();
				node.put("id", org.getDeptId());
				node.put("parentId", org.getDeptParentId());
				node.put("name", org.getDeptName());
				node.put("remark", org.getDeptRemark());
				node.put("isParent", "true");
				nodes.add(node);
			}
		}
		return nodes;
	}
	@WebAction(Permission.DEPARTMENT_UPDATE)
	@RequestMapping(value="update_nodename",method = RequestMethod.POST)  
	@ResponseBody  
	public StatusResult<TSysDepartment> updateOrgName(TSysDepartment department, Model m) {  
		TSysStaff staff = WebContext.getCurrentStaff();
		StatusResult<TSysDepartment> org = departmentService.addDeptOrUpdateDept(department, staff);
		return org;
	}
	@WebAction(Permission.DEPARTMENT_DELETE)
	@RequestMapping(value="delete_nodename")  
	@ResponseBody  
	public String deleteOrgName(String id, Model m) {  
		StatusResult<List<TSysDepartment>> r2 = departmentService.searchDepartmentByParentId(id);
		if(r2.getStatus().equals("OK")){
			return "fail";
		}else{
			return departmentService.deleteDept(id);  
		}
	}

}
