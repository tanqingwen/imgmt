package cn.happyworlds.imgmt.web;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.PageInfo;
import cn.happyworlds.imgmt.entity.MIdtypeDict;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.service.IdtypeDictService;
import cn.happyworlds.imgmt.util.StatusResult;

@Controller
@RequestMapping("/idtype_dict")
public class IdtypeController {

	@Autowired
	private IdtypeDictService idtypeDictService;
	
	@WebAction(Permission.IDTYPE_LIST)
	@RequestMapping("/list")
	public String list(String idtypeId, String idtypeDesc, Integer p, Model m) {
		StatusResult<PageInfo<MIdtypeDict>> r = idtypeDictService.midTypeDictList(idtypeId, idtypeDesc, new PageBounds(p, 10));
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("idtypeId",idtypeId);
			m.addAttribute("idtypeDesc",idtypeDesc);
			m.addAttribute("pageInfo", r.getValue());
		}
		return "idtype_dict/list";
	}
	@WebAction(Permission.IDTYPE_ADD)
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model m) {
		return "idtype_dict/add";
	}
	@WebAction(Permission.IDTYPE_ADD)
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(MIdtypeDict midTypeDict, RedirectAttributes ra) {		
		StatusResult<MIdtypeDict> r = idtypeDictService.midTypeDictAdd(midTypeDict);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/idtype_dict/add";
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "证件类型添加成功");
		return "redirect:/idtype_dict/list";
	}
	@WebAction(Permission.IDTYPE_UPDATE)
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(String id, Model m) {
		StatusResult<MIdtypeDict> r = idtypeDictService.midTypeDictGetById(id);
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/idtype_dict/list";
		}
		m.addAttribute("midTypeDict", r.getValue());
		return "idtype_dict/update";
	}
	@WebAction(Permission.IDTYPE_UPDATE)
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(MIdtypeDict midTypeDict, RedirectAttributes ra) {
		StatusResult<MIdtypeDict> r = idtypeDictService.midTypeDictUpdate(midTypeDict);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/idtype_dict/update?id" + midTypeDict.getIdtypeId();
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "证件类型更新成功");
		return "redirect:/idtype_dict/list";
	}
	@WebAction(Permission.IDTYPE_DELETE)
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(String id, RedirectAttributes ra) {
		StatusResult<MIdtypeDict> r = idtypeDictService.midTypeDictDelete(id);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/idtype_dict/list";
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "证件类型删除成功");
		return "redirect:/idtype_dict/list";
	}
	
	
	@WebAction(Permission.IDTYPE_SHOW)
	@RequestMapping("/show")
	public String show(String id, Model m) {
		StatusResult<MIdtypeDict> r = idtypeDictService.midTypeDictGetById(id);
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/idtype_dict/list";
		}
		m.addAttribute("item", r.getValue());
		return "idtype_dict/show";
	}

}
