package cn.happyworlds.imgmt.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.happyworlds.imgmt.json.Jackson;
import cn.happyworlds.imgmt.service.OptionService;
import cn.happyworlds.imgmt.util.Result;

@Controller
@RequestMapping("/option")
public class OptionController {

	@Autowired
	private OptionService optionService;

	@WebAction(Permission.OPTION_LOGIN_CONFIG_SHOW)
	@RequestMapping("/login_config_show")
	public String loginConfigShow(Model m) {
		Result<Map<String, String>> r = optionService.optionGetById(WebContext.OPTION_LOGIN_CONFIG);
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "登录参数没有找到");
		} else {
			m.addAttribute("loginOptions", r.getValue());
		}
		return "option/login_config_show";
	}

	@WebAction(Permission.OPTION_LOGIN_CONFIG_UPDATE)
	@RequestMapping(value = "/login_config_update", method = RequestMethod.GET)
	public String loginConfigUpdate(Model m) {
		Result<Map<String, String>> r = optionService.optionGetById(WebContext.OPTION_LOGIN_CONFIG);
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "登录参数没有找到");
		} else {
			m.addAttribute("loginOptions", r.getValue());
		}
		return "option/login_config_update";
	}

	@WebAction(Permission.OPTION_LOGIN_CONFIG_UPDATE)
	@RequestMapping(value = "/login_config_update", method = RequestMethod.POST)
	public String loginConfigUpdate(RedirectAttributes ra) {
		Map<String, String> loginOptions = WebContext.getParametersMap(WebContext.OPTION_LOGIN_CONFIG);
		optionService.optionSaveById(WebContext.OPTION_LOGIN_CONFIG, Jackson.writeJson(loginOptions));
		return "redirect:/option/login_config_update";
	}

}