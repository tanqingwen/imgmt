package cn.happyworlds.imgmt.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpCsttbl;
import cn.happyworlds.imgmt.json.Jackson;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.service.AssociatorService;
import cn.happyworlds.imgmt.service.MemberService;
import cn.happyworlds.imgmt.util.Result;

/**
 * 
 * @author 2017-07-27
 */

@Controller
@RequestMapping("/associator")
public class AssociatorController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private AssociatorService associatorService;
	
	@RequestMapping("list")
	public String list(String hwMemberId, String cbCustomerIdno, String cbCardholderName, String cbMobileNo, Integer p, Model m) {
		Result<PageInfo<CpCsttbl>> r = associatorService.csttblList(hwMemberId, cbCustomerIdno, cbCardholderName, cbMobileNo, new PageBounds(p, 10));
		
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("pageInfo", r.getValue());
		}
		return "associator/list";
	}
	
	@WebAction(Permission.STAFF_ADD)
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model m) {
		m.addAttribute("getHwMemberId", associatorService.csttblList());
		return "associator/add";
	}
	
//	@WebAction(Permission.STAFF_ADD)
//	@RequestMapping(value = "/add", method = RequestMethod.POST)
//	public String add(CpCsttbl csttbl, RedirectAttributes ra) {
//		Result<CpCsttbl> r = associatorService.csttblcAdd(csttbl);
//		if (r.isError()) {
//			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
//			return "redirect:/associator/add?hwMemberId"+csttbl.getHwMemberId();
//		}
//		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "会员注册成功");
//		return "redirect:/associator/list";
//	}
	
//	@WebAction(Permission.STAFF_UPDATE)
//	@RequestMapping(value = "/update", method = RequestMethod.GET)
//	public String tempUpdate(String id, Model m) {
//		Result<CpCsttbl> r = associatorService.csttblGetById(id);
//		m.addAttribute("item", r.getValue());
//		return "associator/update";
//	}

//	@WebAction(Permission.STAFF_UPDATE)
//	@RequestMapping(value = "/update", method = RequestMethod.POST)
//	public String tempUpdate(CpCsttbl csttbl, RedirectAttributes ra) {
//		Result<CpCsttbl> r = associatorService.csttblUpdate(csttbl);
//		String hwMemberId = csttbl.getHwMemberId();
//		csttbl.setHwMemberId(hwMemberId);
//		if (r.isError()) {
//			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
//			return "redirect:/associator/update";
//		}
//		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "会员信息更新成功");
//		return "redirect:/associator/list";
//	}
	
//	@WebAction(Permission.STAFF_SHOW)
//	@RequestMapping(value = "/show", method = RequestMethod.GET)
//	public String tempShow(String id, Model m, RedirectAttributes ra) {
//		if (StringUtils.isEmpty(id)) {
//			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, "会员ID不能为空");
//			return "redirect:/associator/list";
//		}
//		Result<CpCsttbl> r1 = associatorService.csttblAdd(id);
//		if (r1.isError()) {
//			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r1.getComment());
//			return "redirect:/associator/list";
//		}
//		m.addAttribute("item", r1.getValue());
//		return "associator/show";
//	}
	
//	@WebAction(Permission.ROLE_DELETE)
//	@RequestMapping(value = "/delete", method = RequestMethod.GET)
//	public String tempDelete(String id, RedirectAttributes ra) {
//		Result<CpCsttbl> r = associatorService.csttblDelete(id);
//		if (r.isError()) {
//			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
//		} else {
//			ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "会员删除成功");
//		}
//		return "redirect:/associator/list";
//	}
	
//	@WebAction(Permission.STAFF_SHOW)
//	@RequestMapping(value = "/query_member_by_id", method = RequestMethod.GET)
//	public @ResponseBody String queryMemberById(String memberId) {
//		Result<CpCsttbl> r = memberService.csttblGetById(memberId);
//		return Jackson.writeJson(r.getValue());
//	}
	
}
