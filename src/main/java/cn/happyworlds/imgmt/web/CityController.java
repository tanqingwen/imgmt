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
import cn.happyworlds.imgmt.entity.MCityDict;
import cn.happyworlds.imgmt.entity.MProvinceDict;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.service.CityDictService;
import cn.happyworlds.imgmt.service.ProvinceDictService;
import cn.happyworlds.imgmt.util.StatusResult;

@Controller
@RequestMapping("/city_dict")
public class CityController {
	
	@Autowired
	private CityDictService cityDictService;
	
	@Autowired
	private ProvinceDictService provinceDictService;
	
	@WebAction(Permission.CITYDICTATIONDICT_LIST)
	@RequestMapping("/list")
	public String list(String cityId,String cityName,Integer p, Model m){
		StatusResult<PageInfo<MCityDict>> mcity=cityDictService.cityList(cityId, cityName, new PageBounds(p,10));
		List<MProvinceDict> provinceList = provinceDictService.mProvinceList();
		Map<String, String> provinceies = new HashMap<>();
		for(MProvinceDict province : provinceList){
			provinceies.put(province.getProvinceId(), province.getProvinceName());
		}
		if(mcity.isError()){
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
		    m.addAttribute("pageInfo", mcity.getValue());
		    m.addAttribute("provinceies", provinceies);
		}
		return "city_dict/list";
	}
	@WebAction(Permission.CITYDICTATIONDICT_SHOW)
	@RequestMapping("/show")
	public String show(String cityId,Model m){
		StatusResult<MCityDict> r=cityDictService.mcityId(cityId);
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/city_dict/list";
		}
		m.addAttribute("city", r.getValue());
		return "city_dict/show";
	}
	@WebAction(Permission.CITYDICTATIONDICT_ADD)
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model m) {
		m.addAttribute("mProvince",provinceDictService.mProvinceList());
		return "city_dict/add";
	}
	@WebAction(Permission.CITYDICTATIONDICT_ADD)
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(MCityDict mcitydict,RedirectAttributes ra){
		StatusResult<MCityDict> mcity=cityDictService.mcityAdd(mcitydict);
		if(mcity.isError()){
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP,mcity.getComment());
			return "redirect:/city_dict/add";
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "城市添加成功");
		return "redirect:/city_dict/list";
	}
	@WebAction(Permission.CITYDICTATIONDICT_UPDATE)
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(String  id, Model m) {
		StatusResult<MCityDict> r = cityDictService.mcityId(id);
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/city_dict/list";
		}		
		m.addAttribute("city", r.getValue());
		m.addAttribute("mProvince",provinceDictService.mProvinceList());
		return "city_dict/update";
	}
	@WebAction(Permission.CITYDICTATIONDICT_UPDATE)
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(MCityDict mcitydict, RedirectAttributes ra) {
		StatusResult<MCityDict> r = cityDictService.mcityUpdate(mcitydict);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/city_dict/update?id" + mcitydict.getCityId();
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "城市信息更新成功");
		return "redirect:/city_dict/list";
	}
	@WebAction(Permission.CITYDICTATIONDICT_DELETE)
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(String cityId,RedirectAttributes ra){
		StatusResult<MCityDict> r=cityDictService.mcitydelete(cityId);
		if(r.isError()){
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP,r.getComment());
			return "redirect:/city_dict/list";
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP,"删除成功");
		return "redirect:/city_dict/list";
	}
}
