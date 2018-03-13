package cn.happyworlds.imgmt.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.AppTicket;
import cn.happyworlds.imgmt.entity.CpVerkey;
import cn.happyworlds.imgmt.entity.TSysOrganization;
import cn.happyworlds.imgmt.entity.TSysStaff;
import cn.happyworlds.imgmt.entity.YwVenue;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.service.AppTicketService;
import cn.happyworlds.imgmt.service.CpVerkeyService;
import cn.happyworlds.imgmt.service.OrganizationService;
import cn.happyworlds.imgmt.util.Result;

@Controller
@RequestMapping("/appticket")
public class AppTicketController {
	
	@Autowired
	private AppTicketService appticketService;
	
/*	@WebAction(Permission.ORGANIZATION_ADD)
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list() {
		return "order/list";
	}*/
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(String mobileNumber,String ticketId, Integer p, Model m) {
		Result<PageInfo<AppTicket>> r = appticketService.appticketList(mobileNumber,ticketId,new PageBounds(p,10));
		if (r.isError()){
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("pageInfo", r.getValue());
		}
		return "order/list";
	}
	
	@WebAction(Permission.STAFF_RESET_PASSWORD)
	@RequestMapping("/delete")
	public String delete(String ticketId, RedirectAttributes ra) {
		Long r = appticketService.deleteAppTicketByTicketId(ticketId);
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "订单信息删除成功");
		return "redirect:/appticket/list";
	}
	/*@WebAction(Permission.ORGANIZATION_ADD)
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(String id, Model m) {
		Result<CpVerkey> r = cpverkeyService.cpVerkeyGetById(id);
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/fahang/list";
		}
		m.addAttribute("cpverkeys", cpverkeyService.cpverkeyList());
		m.addAttribute("item",r.getValue());
		return "fahang/update";
	}
	
	@WebAction(Permission.ORGANIZATION_ADD)
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(RedirectAttributes ra,HttpServletRequest request) {
		String newvkDesc = request.getParameter("newvkDesc");
		String vkValue = request.getParameter("vkValue");
		CpVerkey cpverkey = cpverkeyService.cpVerkeyGetByVKValue(vkValue);
		if("".equals(newvkDesc)){
			ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "新密匙不能为空");
			return "redirect:/cpverkey/update?id=" + cpverkey.getVkValue();
		}
		cpverkey.setVkDesc(newvkDesc);
		Result<CpVerkey> r = cpverkeyService.cpVerkeyUpdate(cpverkey);
		
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/cpverkey/update?id=" + cpverkey.getVkValue();
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "密匙值更新成功");
		return "redirect:/cpverkey/list";
	}*/
	  

}
