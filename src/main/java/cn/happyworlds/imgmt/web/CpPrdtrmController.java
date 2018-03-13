package cn.happyworlds.imgmt.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpPrdtrm;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.service.CpPrdtrmService;
import cn.happyworlds.imgmt.util.Result;

@Controller
@RequestMapping("/cpprdtrm")
public class CpPrdtrmController {

	@Autowired
	private CpPrdtrmService cpPrdtrmService;

	@RequestMapping(value = "/toAddPage")
	public String toAddPage() {
		return "cpprdtrm/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(CpPrdtrm cpPrdtrm, RedirectAttributes ra) {
		Result<CpPrdtrm> r = cpPrdtrmService.add(cpPrdtrm);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/cpprdtrm/toAddPage";
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, r.getComment());
		return "redirect:/cpprdtrm/mainpage";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteCpPrdtrmByParams(String id, String level, RedirectAttributes ra) {
		Result<CpPrdtrm> r = cpPrdtrmService.deleteCpPrdtrmByParams(id, level);
		if(r.isError()){
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
		}else{
			ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, r.getComment());
		}
		return "redirect:/cpprdtrm/mainpage";
	}

	@RequestMapping(value = "/toUpdatePage", method = RequestMethod.GET)
	public String toUpdatePage(String id, String level, Model m,RedirectAttributes ra) {
		Result<CpPrdtrm> r = cpPrdtrmService.searchCpPrdtrmByParams(id, level);
		if(r.isError()){
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/cpprdtrm/mainpage";
		}else{
			m.addAttribute("item", r.getValue());
		}
		return "cpprdtrm/update";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(CpPrdtrm cpPrdtrm, RedirectAttributes ra) {
		Result<CpPrdtrm> r = cpPrdtrmService.update(cpPrdtrm);
		if(r.isError()){
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
		}else{
			ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, r.getComment());
		}
		return "redirect:/cpprdtrm/mainpage";
	}

	@RequestMapping("/mainpage")
	public String mainpage(String pt_terminal_id, String pt_prodct_group, Integer p, Model m) {
		Result<PageInfo<CpPrdtrm>> r = cpPrdtrmService.mainpage(pt_terminal_id, pt_prodct_group, new PageBounds(p, 5));
		m.addAttribute("pageInfo", r.getValue());
		return "cpprdtrm/machine_mainpage";
	}
}
