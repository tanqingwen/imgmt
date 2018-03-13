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

import cn.happyworlds.imgmt.entity.CpVerkey;
import cn.happyworlds.imgmt.entity.TSysOrganization;
import cn.happyworlds.imgmt.entity.TSysStaff;
import cn.happyworlds.imgmt.entity.YwGate;
import cn.happyworlds.imgmt.entity.YwMember;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.service.CpVerkeyService;
import cn.happyworlds.imgmt.service.OrganizationService;
import cn.happyworlds.imgmt.service.YwGateService;
import cn.happyworlds.imgmt.service.YwMemberService;
import cn.happyworlds.imgmt.util.Result;

@Controller
@RequestMapping("/ywmember")
public class YwMemberController {
	
	@Autowired
	private YwMemberService ywMemberService;
	
	
//	@WebAction(Permission.YWMEMBER_LIST)
	@RequestMapping("/list")
	public String list(String userId, String username, String idNo, String mobile, Integer p, Model m){
		Result<PageInfo<YwMember>> r = ywMemberService.YwMemberList(userId, username, mobile, idNo, new PageBounds(p, 1));
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("pageInfo", r.getValue());
		}
		return "ywmember/list";
		
	}
	
//	@WebAction(Permission.YWMEMBER_ADD)
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(){
		return "ywmember/add";
		
	}
	  

}
