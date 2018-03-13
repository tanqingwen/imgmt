package cn.happyworlds.imgmt.web;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpAcqgrp;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.service.CpAcqgrpService;
import cn.happyworlds.imgmt.util.Result;

@Controller
@RequestMapping("/cpacqgrp")
public class CpAcqgrpController {

	@Autowired
	private CpAcqgrpService cpAcqgrpService;
	
	@WebAction(Permission.VENUE_GROUP_LIST)
	@RequestMapping("/list")
	public String list(String alGroupId, String alDesc, Integer p, Model m) {
		Result<PageInfo<CpAcqgrp>> r = cpAcqgrpService.CpAcqgrpAll(alGroupId,alDesc,new PageBounds(p, 10));
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("alGroupId", alGroupId);
			m.addAttribute("alDesc", alDesc);
			m.addAttribute("pageInfo", r.getValue());
		}
		return "cpacqgrp/list";
	}
	
	
	@WebAction(Permission.VENUE_GROUP_ADD)
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addUi(Model m) {

		// 分组号自动获取
		String maxGroupId = cpAcqgrpService.maxGroupId();
		m.addAttribute("maxGroupId", maxGroupId);
		return "cpacqgrp/add";
	}
	

	@WebAction(Permission.VENUE_GROUP_ADD)
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(CpAcqgrp cpAcqgrp,RedirectAttributes ra) throws ParseException{
		Result<CpAcqgrp> r = cpAcqgrpService.insertCpAcqgrp(cpAcqgrp);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/cpacqgrp/add";
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "场馆添加成功");
		return  "redirect:/cpacqgrp/list";
	}
	
	
	
	@WebAction(Permission.VENUE_GROUP_UPDATE)
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(Integer alGroupId, Model m) {
		CpAcqgrp cpAcqgrp = cpAcqgrpService.searchCpAcqgrpByAlGroupId(alGroupId);
		m.addAttribute("cpAcqgrp",cpAcqgrp);
		return "cpacqgrp/update";
	}
	
	
	
	/**
	 * 场馆组更新
	 * 
	 * @author Hugh
	 */
	@WebAction(Permission.VENUE_GROUP_UPDATE)
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(CpAcqgrp cpAcqgrp,RedirectAttributes ra){
		Result<CpAcqgrp> r = cpAcqgrpService.update(cpAcqgrp);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/cpacqgrp/update?alGroupId=" + cpAcqgrp.getAlGroupId();
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "场馆组更新成功");
		return "redirect:/cpacqgrp/list";
	}
	
	
	/**
	 * 场馆组查看
	 * 
	 * @author Hugh
	 */
	@WebAction(Permission.VENUE_GROUP_SHOW)
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String show(Integer alGroupId, Model m) {
		CpAcqgrp cpAcqgrp = cpAcqgrpService.searchCpAcqgrpByAlGroupId(alGroupId);
		m.addAttribute("cpAcqgrp", cpAcqgrp);
		return "cpacqgrp/show";
	}
	
	
	/**
	 * 场馆组删除
	 * 
	 * @author Hugh
	 */
	@WebAction(Permission.VENUE_GROUP_DELETE)
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(Integer alGroupId, RedirectAttributes ra) {

		CpAcqgrp cpAcqgrp = cpAcqgrpService.searchCpAcqgrpByAlGroupId(alGroupId);
		// 状态: 0
		cpAcqgrp.setStatus(new Long(0));
		Result<CpAcqgrp> r = cpAcqgrpService.update(cpAcqgrp);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/cpacqgrp/list";
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, r.getComment());
		return "redirect:/cpacqgrp/list";
	}
	
}
