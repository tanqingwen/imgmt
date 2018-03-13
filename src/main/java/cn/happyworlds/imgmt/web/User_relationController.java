package cn.happyworlds.imgmt.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.PageInfo;
import cn.happyworlds.imgmt.entity.MUserRelationDict;
import cn.happyworlds.imgmt.mapper.MUserRelationDictMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.service.UserRelationDictService;
import cn.happyworlds.imgmt.util.StatusResult;

@Controller
@RequestMapping("/user_relation_dict")
public class User_relationController {

	@Autowired
	private UserRelationDictService  userRelationDictService;
	
	
	@WebAction(Permission.USER_RELATION_DICT_LIST)
	@RequestMapping("/list")
	public String list(String userRelationId, String userRelationDesc, Integer p, Model m) {
		StatusResult<PageInfo<MUserRelationDictMapper>> r = userRelationDictService.mUserRelationDictList(userRelationId, userRelationDesc, new PageBounds(p, 10));
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("pageInfo", r.getValue());
		}
		return "user_relation_dict/list";
	}

	@WebAction(Permission.USER_RELATION_DICT_SHOW)
	@RequestMapping("/show")
	public String show(String userRelationId, Model m) {
		StatusResult<MUserRelationDict> r =  userRelationDictService.muserRelationDictGetById(userRelationId);
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/user_relation_dict/list";
		}
		m.addAttribute("item", r.getValue());
		return "user_relation_dict/show";
	}

	@WebAction(Permission.USER_RELATION_DICT_ADD)
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return "user_relation_dict/add";
	}
	
	@WebAction(Permission.USER_RELATION_DICT_ADD)
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(MUserRelationDict mUserRelationDict, RedirectAttributes ra) {
		StatusResult<MUserRelationDict> r = userRelationDictService.muserRelationDictAdd(mUserRelationDict);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/user_relation_dict/add";
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "人际关系添加成功");
		return "redirect:/user_relation_dict/list";
	}
	@WebAction(Permission.USER_RELATION_DICT_DELETE)
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(String userRelationId, RedirectAttributes ra) {
		StatusResult<MUserRelationDict> r =userRelationDictService.midTypeDictDelete(userRelationId);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/user_relation_dict/list";
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "人际关系删除成功");
		return "redirect:/user_relation_dict/list";
	}

	@WebAction(Permission.USER_RELATION_DICT_UPDATE)
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(String userRelationId, Model m) {
		StatusResult<MUserRelationDict> r = userRelationDictService.muserRelationDictGetById(userRelationId);
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/user_relation_dict/list";
		}
		m.addAttribute("item",r.getValue());
		return "user_relation_dict/update";
	}

	@WebAction(Permission.USER_RELATION_DICT_UPDATE)
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(MUserRelationDict muserRelationDict, RedirectAttributes ra) {
		StatusResult<MUserRelationDict> r = userRelationDictService.muserRelationDictUpdate(muserRelationDict);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/user_relation_dict/update?id" + muserRelationDict.getUserRelationId();
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "人际关系信息更新成功");
		return "redirect:/user_relation_dict/list";
	}

}
