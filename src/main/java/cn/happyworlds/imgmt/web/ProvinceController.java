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
import cn.happyworlds.imgmt.entity.MCountryDict;
import cn.happyworlds.imgmt.entity.MProvinceDict;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.service.CountryService;
import cn.happyworlds.imgmt.service.ProvinceDictService;
import cn.happyworlds.imgmt.util.Result;

@Controller
@RequestMapping("/province_dict")
public class ProvinceController {

	@Autowired
	private ProvinceDictService provincDictService;
	
	@Autowired
	private CountryService countryService;
	
		
	@WebAction(Permission.PROVINCE_LIST)
	@RequestMapping("/list")
	public String list(String provinceId, String provinceName, Integer p, Model m) {
		Result<PageInfo<MProvinceDict>> r1 = provincDictService.mProvinceList(provinceId, provinceName, new PageBounds(p, 10));	
		List<MCountryDict> countryList = countryService.countryList();
		Map<String, String> countries = new HashMap<>();
		for(MCountryDict country : countryList){
			countries.put(country.getAlphaCtryCd(), country.getCtryDescription());
		}
		if (r1.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("pageInfo", r1.getValue());
			m.addAttribute("countries", countries);
		}
		return "province_dict/list";
	}

	@WebAction(Permission.PROVINCE_SHOW)
	@RequestMapping("/show")
	public String show(String provinceId, Model m) {
		Result<MProvinceDict> r = provincDictService.mProvinceGetById(provinceId);
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/staff/list";
		}
		m.addAttribute("item", r.getValue());
		
		Result<MCountryDict> country = countryService.countryGetById(r.getValue().getAlphaCtryCd());
		m.addAttribute("country", country.getValue());
		return "province_dict/show";
	}

	@WebAction(Permission.PROVINCE_ADD)
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model m) {
		m.addAttribute("provinces", provincDictService.mProvinceList());
		m.addAttribute("countrys", countryService.countryList());
		return "province_dict/add";
	}

	@WebAction(Permission.PROVINCE_ADD)
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(MProvinceDict mProvince, RedirectAttributes ra) {	
		Result<MProvinceDict> r = provincDictService.mProvinceAdd(mProvince);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/province_dict/add";
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "省份添加成功");
		return "redirect:/province_dict/list";
	}
	
	@WebAction(Permission.PROVINCE_DELETE)
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(String provinceId, RedirectAttributes ra) {
		Result<MProvinceDict> r = provincDictService.midTypeDictDelete(provinceId);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/province_dict/list";
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "省份删除成功");
		return "redirect:/province_dict/list";
	}

	@WebAction(Permission.PROVINCE_UPDATE)
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(String provinceId,String country, Model m) {
		Result<MProvinceDict> r = provincDictService.mProvinceGetById(provinceId);
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/province_dict/list";
		}
		m.addAttribute("item", r.getValue());
		m.addAttribute("provinces", provincDictService.mProvinceList());
		m.addAttribute("countrys", countryService.countryList());
		m.addAttribute("Description", country);
		return "province_dict/update";
	}

	@WebAction(Permission.PROVINCE_UPDATE)
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(MProvinceDict mProvince, RedirectAttributes ra) {
		Result<MProvinceDict> r = provincDictService.mProvinceUpdate(mProvince);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/province_dict/update?provinceId" + mProvince.getProvinceId();
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "省份信息更新成功");
		return "redirect:/province_dict/list";
	}
}
