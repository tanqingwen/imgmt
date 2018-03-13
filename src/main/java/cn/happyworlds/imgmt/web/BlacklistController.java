package cn.happyworlds.imgmt.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpBlkmlc;
import cn.happyworlds.imgmt.entity.CpPrdgrp;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.service.PrdgrpService;
import cn.happyworlds.imgmt.service.RoleService;
import cn.happyworlds.imgmt.service.BlacklistService;
import cn.happyworlds.imgmt.util.Result;

@Controller
@RequestMapping("/blacklist")
public class BlacklistController {
	
	@Autowired
	private PrdgrpService prdgrpService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private BlacklistService blacklistService;
	
	@RequestMapping("list")
	public String list(String bmCardNo, String bmCardName, Integer p, Model m) {
		Result<PageInfo<CpBlkmlc>> r = blacklistService.blackList(bmCardNo, bmCardName, new PageBounds(p, 10));
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("bmCardNo", bmCardNo);
			m.addAttribute("bmCardName", bmCardName);
			m.addAttribute("pageInfo", r.getValue());
		}
		return "blacklist/list";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model m) {
		m.addAttribute("roles", blacklistService.blackList());
		return "blacklist/add";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(CpBlkmlc bllmlc, RedirectAttributes ra) {
		//bllmlc.setBmCardNo(WebContext.getCurrentStaff().getId());
		Result<CpBlkmlc> r = blacklistService.blkmlcAdd(bllmlc);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/blacklist/add" + bllmlc.getBmOrgId();
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "黑名单添加成功");
		return "redirect:/blacklist/list";
	}
	
//	@WebAction(Permission.STAFF_UPDATE)
//	@RequestMapping(value = "/update", method = RequestMethod.GET)
//	public String update(Integer prProdctGroup, Model m) {
//		Result<CpPrdgrp> r = prdgrpService.prdgrpGetById(prProdctGroup);
//		if (r.isError()) {
//			m.addAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
//			return "redirect:/prdgrp/list";
//		}
//		m.addAttribute("item", r.getValue());
//		m.addAttribute("roles", roleService.roleList());
//		return "prdgrp/update";
//	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(String bmCardNo, Model m, RedirectAttributes ra) {
		Result<CpBlkmlc> r = blacklistService.blkmlcGetBmCardNo(bmCardNo);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/blacklist/list";
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "黑名单删除成功");
		return "redirect:/blacklist/list";
	}
}
