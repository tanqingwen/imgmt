package cn.happyworlds.imgmt.web;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpPrdgrp;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.service.CpPrdgrpService;
import cn.happyworlds.imgmt.util.Result;

@Controller
@RequestMapping("/prdgrp")
public class PrdgrpController {
	
	@Autowired
	private CpPrdgrpService prdgrpService;
	
	
	@WebAction(Permission.PRDGRP_LIST)
	@RequestMapping("/list")
	public String list(String prProdctGroup, String prGroupDesc, Integer p, Model m) {
		System.out.println(prGroupDesc);
		Result<PageInfo<CpPrdgrp>> r = prdgrpService.prdgrpList(prProdctGroup, prGroupDesc, new PageBounds(p, 10));
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("prProdctGroup", prProdctGroup);
			m.addAttribute("prGroupDesc", prGroupDesc);
			m.addAttribute("pageInfo", r.getValue());
		}
		return "prdgrp/list";
	}
	
	@WebAction(Permission.PRDGRP_ADD)
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Integer prProdctGroup, RedirectAttributes ra, Model m) {
		CpPrdgrp grp=prdgrpService.maxPrProdctGroup();
		m.addAttribute("grp", grp);
		m.addAttribute("roles", prdgrpService.prdgrpList());
		return "prdgrp/add";
	}
	
	/**
	 * 添加
	 * @throws ParseException 
	 */
	
	@WebAction(Permission.PRDGRP_ADD)
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(CpPrdgrp prProdctGroup, RedirectAttributes ra){
		Result <CpPrdgrp> r = prdgrpService.prdgrpGetById(prProdctGroup);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/prdgrp/add";
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "折扣添加成功");
		return  "redirect:/prdgrp/list";
	}
	
	/**
	 * 查看
	 * @param prProdctGroup
	 * @param m
	 * @param request
	 * @return
	 */
	@WebAction(Permission.PRDGRP_SHOW)
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String show(CpPrdgrp prdgrp, String prProdctGroup, Model m, RedirectAttributes ra) {
		if (StringUtils.isEmpty(prProdctGroup)) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, "客户等级不能为空");
			return "redirect:/prdgrp/list";
		}
		Result<CpPrdgrp> r = prdgrpService.prdgrpAdd(prdgrp);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/prdgrp/list";
		}
		m.addAttribute("item", r.getValue());
		return "prdgrp/show";
	}
	
	@WebAction(Permission.PRDGRP_UPDATE)
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(CpPrdgrp prdgrp,  Model m, RedirectAttributes ra) {
		Result<CpPrdgrp> r = prdgrpService.prdgrpAdd(prdgrp);
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/prdgrp/list";
		}
		m.addAttribute("item", r.getValue());
		return "prdgrp/update";
	}
	
	/**
	 * 更新
	 */
	@WebAction(Permission.PRDGRP_UPDATE)
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(CpPrdgrp cpPrdgrp, RedirectAttributes ra){
		Result<CpPrdgrp> r = prdgrpService.update(cpPrdgrp);
		if(r.isError()){
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/prdgrp/update?prProdctGroup" + cpPrdgrp.getPrProdctGroup();
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "会员等级更新成功");
		return "redirect:/prdgrp/list";
	}
	
	/**
	 * 删除
	 */
//	@WebAction(Permission.PRDGRP_DELETE)
//	@RequestMapping("/delete")
//	public String delect(CpPrdgrp prdgrp, String prProdctGroup, RedirectAttributes ra){
//		if (StringUtils.isEmpty(prProdctGroup)) {
//			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, "客户等级不能为空");
//			return "redirect:/prdgrp/list";
//		}
//		Result<CpPrdgrp> r=prdgrpService.delect(prdgrp);
//		if(r.isError()){
//			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
//		}
//		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "会员删除成功");
//		
//		return "redirect:/prdgrp/list";
//	}

}
