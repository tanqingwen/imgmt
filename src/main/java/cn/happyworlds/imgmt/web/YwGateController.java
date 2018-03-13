package cn.happyworlds.imgmt.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpMermst;
import cn.happyworlds.imgmt.entity.CpPrdgrp;
import cn.happyworlds.imgmt.entity.CpPrdtrm;
import cn.happyworlds.imgmt.entity.YwGate;
import cn.happyworlds.imgmt.entity.YwVenue;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.service.CpPrdtrmService;
import cn.happyworlds.imgmt.service.RoleService;
import cn.happyworlds.imgmt.service.YwGateService;
import cn.happyworlds.imgmt.service.YwVenueService;
import cn.happyworlds.imgmt.util.Result;

@Controller
@RequestMapping("/ywgate")
public class YwGateController {

	@Autowired
	private YwGateService ywGateService;
	
	@Autowired
	private YwVenueService ywVenueService;
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value = "/toAddPage")
	public String toAddPage(Model m,Integer p) {
		Result<PageInfo<YwVenue>> r = ywGateService.searchYwVenueByParams(new PageBounds(p, 10));
		m.addAttribute("pageInfo", r.getValue());
		m.addAttribute("roles", roleService.roleList());
		return "gate/add";
	}

//	@WebAction(Permission.GATE_LIST)
	@RequestMapping(value="/list")
	public String list(String hwGateId, String hwGateName, Integer p,Model m) {
		Result<PageInfo<YwGate>> r = ywGateService.list(hwGateId, hwGateName, new PageBounds(p, 10));
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("pageInfo", r.getValue());
		}
		return "gate/list";
	}
	
//	@WebAction(Permission.GATE_ADD)
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addUi(Model m, Integer p) {
		Result<PageInfo<YwVenue>> r = ywGateService.searchYwVenueByParams(new PageBounds(p, 10));
		
		m.addAttribute("pageInfo", r.getValue());
		m.addAttribute("roles", roleService.roleList());
		return "ywgate/toAddPage";
	}
	
//	@WebAction(Permission.GATE_ADD)
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(YwGate ywGate, RedirectAttributes ra) {
		Result<YwGate> r = ywGateService.add(ywGate);
		YwVenue ywVenue = ywGateService.searchYwVenueById(r.getValue().getHwVenueId());
		ywVenue.setHwGateId(r.getValue().getHwGateId());
		ywVenueService.update(ywVenue);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/ywgate/toAddPage";
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "闸机添加成功");
		return "redirect:/ywgate/list";
	}
	
	@WebAction(Permission.STAFF_RESET_PASSWORD)
	@RequestMapping("/delete")
	public String delete(String hwGateId, RedirectAttributes ra) {
		Long r = ywGateService.deleteYwGateByHwGateId(hwGateId);
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "闸机信息删除成功");
		return "redirect:/ywgate/list";
	}

	@WebAction(Permission.VENUE_MAINTAIN_UPDATE)
	@RequestMapping("/update")
	public String uodateUi(Model m, Integer p) {
		Result<PageInfo<YwVenue>> r = ywGateService.searchYwVenueByParams(new PageBounds(p, 10));
		m.addAttribute("pageInfo", r.getValue());
		m.addAttribute("roles", roleService.roleList());
		return "gate/update";
	}
	@WebAction(Permission.VENUE_MAINTAIN_UPDATE)
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(String hwGateId, Model m) {
		Result<YwGate> r = ywGateService.ywGateGetById(hwGateId);
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/ywgate/list";
		}
		m.addAttribute("item", r.getValue());
		return "gate/update";
	}
	
	@WebAction(Permission.VENUE_MAINTAIN_UPDATE)
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(YwGate ywGate, RedirectAttributes ra){
		Result<YwGate> r = ywGateService.update(ywGate);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/ywgate/update?id" + ywGate.getHwGateId();
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "闸机信息更新成功");
		return "redirect:/ywgate/list";
	}
	
	
	
	@WebAction(Permission.VENUE_MAINTAIN_SHOW)
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String show(String hwGateId, Model m) {
		Result<YwGate> r = ywGateService.ywGateGetById(hwGateId);
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/ywvenue/list";
		}
		m.addAttribute("item", r.getValue());
		return "gate/show";
	}
}
