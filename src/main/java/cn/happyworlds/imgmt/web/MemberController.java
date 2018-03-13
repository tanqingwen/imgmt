package cn.happyworlds.imgmt.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpCrdtbl;
import cn.happyworlds.imgmt.entity.CpCsttbl;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.service.MemberService;
import cn.happyworlds.imgmt.util.Result;

/**
 * 
 * @author 2017-07-27
 */

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@RequestMapping("list")
	public String list(String hwMemberId, String cbCustomerIdno, String cbCardholderName, String cbMobileNo, Integer p, Model m) {
		Result<PageInfo<CpCsttbl>> r = memberService.csttblList(hwMemberId, cbCustomerIdno, cbCardholderName, cbMobileNo, new PageBounds(p, 10));
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("pageInfo", r.getValue());
		}
		return "member/list";
	}
	
	@RequestMapping("list_card")
	public String listsard(String hwMemberId, String cbCustomerIdno, String cbCardholderName, String cbMobileNo, Integer p, Model m) {
		Result<PageInfo<CpCsttbl>> r = memberService.csttblList(hwMemberId, cbCustomerIdno, cbCardholderName, cbMobileNo, new PageBounds(p, 10));
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("pageInfo", r.getValue());
		}
		return "member/list_card";
	}
	
	@WebAction(Permission.STAFF_ADD)
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model m) {
		m.addAttribute("getHwMemberId", memberService.csttblList());
		return "member/add";
	}
	
	@WebAction(Permission.STAFF_ADD)
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(CpCsttbl csttbl, CpCrdtbl crdtbl, RedirectAttributes ra) {
		Result<CpCsttbl> r = memberService.csttblcAdd(csttbl);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/member/add";
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "会员添加成功");
		return "redirect:/member/list";
	}
	
//	@WebAction(Permission.STAFF_UPDATE)
//	@RequestMapping(value = "/update", method = RequestMethod.GET)
//	public String tempUpdate(String id, Model m, RedirectAttributes ra) {
//		Result<CpCsttbl> r = memberService.csttblGetById(id);
//		if (r.isError()) {
//			m.addAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
//			return "redirect:/member/list";
//		}
//		m.addAttribute("item", r.getValue());
//		return "member/update";
//	}

//	@WebAction(Permission.STAFF_UPDATE)
//	@RequestMapping(value = "/update", method = RequestMethod.POST)
//	public String tempUpdate(CpCsttbl csttbl, RedirectAttributes ra) {
//		Result<CpCsttbl> r = memberService.csttblUpdate(csttbl);
//		if (r.isError()) {
//			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
//			return "redirect:/member/update?hwMemberId" + csttbl.getHwMemberId();
//		}
//		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "会员信息更新成功");
//		return "redirect:/member/list";
//	}
	
//	@WebAction(Permission.STAFF_SHOW)
//	@RequestMapping(value = "/show", method = RequestMethod.GET)
//	public String tempShow(String id, Model m, RedirectAttributes ra) {
//		if (StringUtils.isEmpty(id)) {
//			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, "会员ID不能为空");
//			return "redirect:/member/list";
//		}
//		Result<CpCsttbl> r1 = memberService.csttblAdd(id);
//		if (r1.isError()) {
//			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r1.getComment());
//			return "redirect:/member/list";
//		}
//		m.addAttribute("item", r1.getValue());
//		return "member/show";
//	}
	
//	@WebAction(Permission.ROLE_DELETE)
//	@RequestMapping(value = "/delete", method = RequestMethod.GET)
//	public String tempDelete(String id, RedirectAttributes ra) {
//		if (StringUtils.isEmpty(id)) {
//			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, "会员ID不能为空");
//			return "redirect:/member/list";
//		}
//		Result<CpCsttbl> r = memberService.csttblDelete(id);
//		if (r.isError()) {
//			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
//		} else {
//			ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "会员删除成功");
//		}
//		return "redirect:/member/list";
//	}
	
}
