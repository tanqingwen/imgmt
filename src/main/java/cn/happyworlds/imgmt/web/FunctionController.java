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
import cn.happyworlds.imgmt.entity.TSysFunction;
import cn.happyworlds.imgmt.entity.TSysStaff;
import cn.happyworlds.imgmt.service.DepartmentService;
import cn.happyworlds.imgmt.service.DepartmentService2;
import cn.happyworlds.imgmt.util.StatusResult;
import scala.Function;
import scala.Function2;

@Controller("FunctionController")
@RequestMapping("/function")
public class FunctionController {
	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private DepartmentService2 departmentService2;

	@WebAction(Permission.PERMISSION_MANAGEMENT_LIST)
	@RequestMapping(value = "/funttree", method = RequestMethod.GET)
	public String tree(String parentId, Model m) {
		if (StringUtils.isEmpty(parentId)) {
			parentId = "1";
		}
		StatusResult<TSysFunction> r1 = departmentService2.searchdepartmentById(parentId);
		m.addAttribute("deptparent", r1.getValue());
		return "function/funttree";
	}

	@WebAction(Permission.PERMISSION_MANAGEMENT_SHOW)
	@RequestMapping(value = "/search_childrens", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, String>> searchChildrens(Integer parentId, Model m) {
		StatusResult<List<TSysFunction>> r2 = departmentService2.searchDepartmentByParentId(parentId);
		List<Map<String, String>> nodes = new ArrayList<>();
		// 子节点
		List<TSysFunction> orgs = r2.getValue();
		if(null != orgs){
			for (TSysFunction org : orgs) {
				Map<String, String> node = new HashMap<>();
				node.put("id", String.valueOf(org.getFuntId()));
				node.put("parentId", String.valueOf(org.getFuntParentId()));
				node.put("name", org.getName());
				node.put("remark", org.getId());
				node.put("isParent", "true");
				nodes.add(node);
			}
		}
		return nodes;
	}
	
	@WebAction(Permission.PERMISSION_MANAGEMENT_UPDATE)
	@RequestMapping(value="update",method = RequestMethod.POST)  
	@ResponseBody  
	public StatusResult<TSysFunction> updateOrgName(String funtid, String funtparentId,String name_name,String id_id, Model m) {  
		if(StringUtils.isEmpty(funtid)||StringUtils.isEmpty(funtparentId)||StringUtils.isEmpty(name_name)||StringUtils.isEmpty(id_id)){
			return StatusResult.create("Value cannot be null ", "值不能为空");
		}
		TSysStaff staff = WebContext.getCurrentStaff();
		TSysFunction function = new TSysFunction();
		function.setFuntId(Integer.valueOf(funtid));
		function.setFuntParentId(Integer.valueOf(funtparentId));
		function.setName(name_name);
		function.setId(id_id);
		StatusResult<TSysFunction> org = departmentService2.updatefunction(function, staff);
		return org;
	}
	
	@WebAction(Permission.PERMISSION_MANAGEMENT_ADD)
	@RequestMapping(value="update_nodename",method = RequestMethod.POST)  
	@ResponseBody  
	public StatusResult<TSysFunction> updateOrgName(TSysFunction function, Model m) {  
		TSysStaff staff = WebContext.getCurrentStaff();
		StatusResult<TSysFunction> org = departmentService2.addDeptOrUpdateDept(function, staff);
		return org;
	}
	
	@WebAction(Permission.PERMISSION_MANAGEMENT_DELETE)
	@RequestMapping(value="delete_nodename")  
	@ResponseBody  
	public String deleteOrgName(Integer funtId, Model m) {  
		StatusResult<List<TSysFunction>> r2 = departmentService2.searchDepartmentByParentId(funtId);
		if(r2.getStatus().equals("OK")){
			return "fail";
		}else{
			return departmentService2.deleteDept(funtId);  
		}
	}

}
