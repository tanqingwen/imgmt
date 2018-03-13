package cn.happyworlds.imgmt.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.MCountryDict;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.service.CountryService;
import cn.happyworlds.imgmt.util.Result;

@Controller
@RequestMapping("/country_dict")
public class CountryController {

	@Autowired
	private CountryService countryService;
	
	@RequestMapping("/list")
	public String list(String countryId, String countryName, Integer p, Model m) {
		Result<PageInfo<MCountryDict>> r = countryService.countryList(countryId, countryName, new PageBounds(p, 10));
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("pageInfo", r.getValue());
		}
		return "country_dict/list";
	}

	@RequestMapping("/show")
	public String show(String id, Model m) {
		Result<MCountryDict> r = countryService.countryGetById(id);
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
		} else {
			m.addAttribute("countryDict", r.getValue());
		}
		return "country_dict/show";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(String id, Model m, RedirectAttributes ra) {
		return "country_dict/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(MCountryDict countryDict, RedirectAttributes ra) {
		Result<String> r = countryService.countryAdd(countryDict);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/country_dict/add";
		} else {
			ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "更新成功");
		}
		return "redirect:/country_dict/list";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(String id, Model m, RedirectAttributes ra) {
		Result<String> r = countryService.countryDelete(id);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
		}else{
			ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "删除成功");
		}
		return "redirect:/country_dict/list";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(String id, Model m, RedirectAttributes ra) {
		Result<MCountryDict> r = countryService.countryGetById(id);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/country_dict/list";
		}
		m.addAttribute("countryDict", r.getValue());
		return "country_dict/update";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(MCountryDict countryDict, RedirectAttributes ra) {
		Result<String> r = countryService.countryUpdate(countryDict);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
		} else {
			ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "更新成功");
		}
		return "redirect:/country_dict/list";
	}

}
