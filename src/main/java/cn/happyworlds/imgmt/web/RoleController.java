package cn.happyworlds.imgmt.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.TSysFunction;
import cn.happyworlds.imgmt.entity.TSysFunction2;
import cn.happyworlds.imgmt.entity.TSysRole;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.service.FunctionService;
import cn.happyworlds.imgmt.service.RoleService;
import cn.happyworlds.imgmt.util.JsonPalmView;
import cn.happyworlds.imgmt.util.Result;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private FunctionService functionService;
	
	@WebAction(Permission.ROLE_LIST)
	@RequestMapping("/list")
	public String list(String id, String name, Integer p, Model m) {		
		Result<PageInfo<TSysRole>> r = roleService.roleList(id, name, new PageBounds(p, 10));
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("id", id);
			m.addAttribute("name", name);
			m.addAttribute("pageInfo", r.getValue());
		}
		return "role/list";
	}

	@WebAction(Permission.ROLE_SHOW)
	@RequestMapping("/show")
	public String show(String id, Model m) {
		Result<TSysRole> r = roleService.roleGetById(id);
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/role/list";
		}
		List<TSysFunction> list = functionService.functionList();
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for(int i=0; i<list.size(); i++){
			Map<String,String> map = new HashMap<>();
			map.put("id", list.get(i).getFuntId().toString());
			map.put("pId", list.get(i).getFuntParentId().toString());
			map.put("funtid", list.get(i).getId().toString());
			map.put("name", list.get(i).getName().toString());
			map.put("open", "true");
			JSONObject object = JSONObject.fromObject(map);
			sb.append(object.toString());
		}
		sb.append("]");
		String data = String.valueOf(sb);
		data = data.replace("}{", "},{");
		m.addAttribute("item", r.getValue());
		m.addAttribute("functions", data);
	/*	m.addAttribute("functions", functionService.functionList());*/
		return "role/show";
	}

	@WebAction(Permission.ROLE_ADD)
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model m) {
		
		List<TSysFunction> list = functionService.functionList();
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for(int i=0; i<list.size(); i++){
			Map<String,String> map = new HashMap<>();
			map.put("id", list.get(i).getFuntId().toString());
			map.put("pId", list.get(i).getFuntParentId().toString());
			map.put("funtid", list.get(i).getId().toString());
			map.put("name", list.get(i).getName().toString());
			map.put("open", "true");
			JSONObject object = JSONObject.fromObject(map);
			sb.append(object.toString());
		}
		sb.append("]");
		String data = String.valueOf(sb);
		data = data.replace("}{", "},{");
		m.addAttribute("functions", data);
		return "role/add";
	}

	@WebAction(Permission.ROLE_ADD)
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(TSysRole role, RedirectAttributes ra) {
		role.setCreatedBy(WebContext.getCurrentStaff().getId());
		Result<TSysRole> r = roleService.roleAdd(role);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/role/add";
		}
		WebContext.reloadRoles(roleService, true);
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "角色添加成功");
		return "redirect:/role/list";
	}
	
	@WebAction(Permission.ROLE_DELETE)
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(String id, RedirectAttributes ra) {
		Result<TSysRole> r = roleService.roleDelete(id);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/role/list";
		}
		WebContext.reloadRoles(roleService, true);
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "角色删除成功");
		return "redirect:/role/list";
	}

	@WebAction(Permission.ROLE_UPDATE)
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(String id, Model m) {
		Result<TSysRole> r = roleService.roleGetById(id);
		List<TSysFunction> list = functionService.functionList();
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		for(int i=0; i<list.size(); i++){
			Map<String,String> map = new HashMap<>();
			map.put("id", list.get(i).getFuntId().toString());
			map.put("pId", list.get(i).getFuntParentId().toString());
			map.put("funtid", list.get(i).getId().toString());
			map.put("name", list.get(i).getName().toString());
			map.put("open", "true");
			JSONObject object = JSONObject.fromObject(map);
			sb.append(object.toString());
		}
		sb.append("]");
		String data = String.valueOf(sb);
		data = data.replace("}{", "},{");
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/role/list";
		}
		m.addAttribute("item",r.getValue());
		m.addAttribute("functions", data);
		return "role/update";
	}

	@WebAction(Permission.ROLE_UPDATE)
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(TSysRole role, RedirectAttributes ra) {
		role.setUpdatedBy(WebContext.getCurrentStaff().getId());
		Result<TSysRole> r = roleService.roleUpdate(role);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/role/list";
		}
		WebContext.reloadRoles(roleService, true);
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "角色信息更新成功");
		return "redirect:/role/list";
	}

}
