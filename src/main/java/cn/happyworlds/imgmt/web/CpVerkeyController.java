package cn.happyworlds.imgmt.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import cn.happyworlds.imgmt.entity.CpVerkey;
import cn.happyworlds.imgmt.service.CpVerkeyService;
import cn.happyworlds.imgmt.util.Result;

@Controller
@RequestMapping("/cpverkey")
public class CpVerkeyController {
	
	@Autowired
	private CpVerkeyService cpverkeyService;
	
	@RequestMapping("/list")
	public String list(String id, String name, Integer p, Model m) {
		Result<List<CpVerkey>> r = cpverkeyService.cpverkeyList();
		if (r.isError()){
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("items", r.getValue());
		}
		return "fahang/list";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(String id, Model m) {
		Result<CpVerkey> r = cpverkeyService.cpVerkeyGetById(id);
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/fahang/list";
		}
		m.addAttribute("cpverkeys", cpverkeyService.cpverkeyList());
		m.addAttribute("item",r.getValue());
		return "fahang/update";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(RedirectAttributes ra,HttpServletRequest request) {
		String newvkDesc = request.getParameter("newvkDesc");
		String vkValue = request.getParameter("vkValue");
		CpVerkey cpverkey = cpverkeyService.cpVerkeyGetByVKValue(vkValue);
		if("".equals(newvkDesc)){
			ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "新密匙不能为空");
			return "redirect:/cpverkey/update?id=" + cpverkey.getVkValue();
		}
		cpverkey.setVkDesc(newvkDesc);
		Result<CpVerkey> r = cpverkeyService.cpVerkeyUpdate(cpverkey);
		
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/cpverkey/update?id=" + cpverkey.getVkValue();
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "密匙值更新成功");
		return "redirect:/cpverkey/list";
	}
	  

}
