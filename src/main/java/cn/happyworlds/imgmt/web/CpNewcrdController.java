package cn.happyworlds.imgmt.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.happyworlds.imgmt.entity.CpNewcrd;
import cn.happyworlds.imgmt.service.CpNewcrdService;
import cn.happyworlds.imgmt.util.Result;

@Controller
@RequestMapping("/cpnewcrd")
public class CpNewcrdController {
	@Autowired
	private CpNewcrdService cpNewcrdService;

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String add(@RequestParam("ncCardNo") String ncCardNo,HttpServletResponse resp,RedirectAttributes ra) {
		if(ncCardNo!=null && !ncCardNo.equals("")){
			Result<CpNewcrd> r = cpNewcrdService.select(ncCardNo);
			if(r!=null){
				ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
				return "redirect:/cpnewcrd/list";
			}
		}
		cpNewcrdService.upload(ncCardNo,resp);
		return "redirect:/cpnewcrd/list";
	}

	@WebAction(Permission.STAFF_LIST)
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String list() {
		return "cpnewcrd/list";
	}

}
