package cn.happyworlds.imgmt.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.AclUser;
import cn.happyworlds.imgmt.entity.CpPrdgrp;
import cn.happyworlds.imgmt.entity.Recharge;
import cn.happyworlds.imgmt.entity.TSysOrganization;
import cn.happyworlds.imgmt.entity.TSysStaff;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.service.AclUserService;
import cn.happyworlds.imgmt.service.OrganizationService;
import cn.happyworlds.imgmt.service.PrdgrpService;
import cn.happyworlds.imgmt.service.RechargeService;
import cn.happyworlds.imgmt.service.StatService;
import cn.happyworlds.imgmt.service.TicketService;
import cn.happyworlds.imgmt.util.Result;
import cn.happyworlds.imgmt.util.SysDateFormat;

@Controller
@RequestMapping("/recharge")
public class RechargeController {
	
	@Autowired
	private OrganizationService organizationService;
	@Autowired
	private PrdgrpService prdgrpService;	
	@Autowired
	private RechargeService rechargeService;
	@Autowired
	private AclUserService aclUserService;
	@Autowired
	private TicketService ticketService;
	@Autowired
	private StatService statService;
	
	//会员卡充值统计
	private void Condition(HttpServletRequest request, Model model,String nowtime,String nowtimeOnoneMonth) {
		String paras[] = {"cbEmbossname" ,"ctReversalFlag" ,"ctCardNumber" ,"prProdctGroup" ,"ctApproveTimeStart" ,"ctApproveTimeEnd" ,"ctUserCreate" ,"ctUserCreateNull"};
		for (int i = 0; i < paras.length; i++) {
			model.addAttribute(paras[i], request.getParameter(paras[i]));
		}
		String ctApproveTimeStart=request.getParameter("ctApproveTimeStart");
		String ctApproveTimeEnd=request.getParameter("ctApproveTimeEnd");
		String ctReversalFlag=request.getParameter("ctReversalFlag");
		if(ctApproveTimeStart==null&&ctApproveTimeEnd==null&&ctReversalFlag==null){
			model.addAttribute("ctApproveTimeStart", nowtimeOnoneMonth);
			model.addAttribute("ctApproveTimeEnd", nowtime);
			model.addAttribute("ctReversalFlag", "0");
		}
	}
	//会员卡充值统计
	@WebAction(Permission.RECHARGE_LIST)
	@RequestMapping("/list")
	public String list(HttpServletRequest  request, Integer p, Model m) {
		String nowtime = SysDateFormat.getNowDate("yyyyMMdd");
		String nowtimeOnoneMonth = ticketService.getSpecifiedDayAfterBynum(nowtime,-30);
		Condition(request, m,nowtime,nowtimeOnoneMonth);
		
		String cbEmbossname=request.getParameter("cbEmbossname");
		String ctReversalFlag=request.getParameter("ctReversalFlag");
		String ctCardNumber=request.getParameter("ctCardNumber");
		String prProdctGroup=request.getParameter("prProdctGroup");
		String ctApproveTimeStart=request.getParameter("ctApproveTimeStart");
		String ctApproveTimeEnd=request.getParameter("ctApproveTimeEnd");
		String ctUserCreate=request.getParameter("ctUserCreate");
		String ctUserCreateNull=request.getParameter("ctUserCreateNull");
		if (ctApproveTimeStart==null&&ctApproveTimeEnd==null&&ctReversalFlag==null) {
			ctApproveTimeStart=nowtimeOnoneMonth;
			ctApproveTimeEnd=nowtime;
			ctReversalFlag="0";
		}
		
		Result<PageInfo<Recharge>> recharge = rechargeService.RechargeList(cbEmbossname, ctReversalFlag,ctCardNumber, prProdctGroup,ctApproveTimeStart, ctApproveTimeEnd,ctUserCreate, ctUserCreateNull, new PageBounds(p,10));  
		Result<List<CpPrdgrp>> prdgrp = prdgrpService.prdGrpListAll();
		Result<List<AclUser>> aclUsers = aclUserService.AclUserListAll();
		if (recharge.isError() || prdgrp.isError() || aclUsers.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("pageInfo", recharge.getValue());
			m.addAttribute("prdgrp", prdgrp.getValue());
			m.addAttribute("aclUsers", aclUsers.getValue());
		}
		return "recharge/list";
	}
	
	//会员卡充值统计下载
	@WebAction(Permission.RECHARGE_LIST_DOWNLOAD)
	@RequestMapping(value = "/rechargeDownLoad", method = RequestMethod.POST)
	public String rechargeDownLoad(HttpServletRequest  request, HttpServletResponse resp,RedirectAttributes ra) {
		String cbEmbossname=request.getParameter("cbEmbossname");
		String ctReversalFlag=request.getParameter("ctReversalFlag");
		String ctCardNumber=request.getParameter("ctCardNumber");
		String prProdctGroup=request.getParameter("prProdctGroup");
		String ctApproveTimeStart=request.getParameter("ctApproveTimeStart");
		String ctApproveTimeEnd=request.getParameter("ctApproveTimeEnd");
		String ctUserCreate=request.getParameter("ctUserCreate");
		String ctUserCreateNull=request.getParameter("ctUserCreateNull");
		TSysStaff currentStaff = WebContext.getCurrentStaff();
		
		Result<String> result = statService.rechargeDownLoadMethod(cbEmbossname, ctReversalFlag,ctCardNumber, prProdctGroup,ctApproveTimeStart, ctApproveTimeEnd,ctUserCreate, ctUserCreateNull,currentStaff.getId(),resp);
		
		if (result!=null) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, result.getComment());
			return "redirect:/opeartion/list";
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "下载成功");
		return "redirect:/opeartion/list";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model m) {
		m.addAttribute("organizations", organizationService.organizationList());
		return "organization/add";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(TSysOrganization organization, RedirectAttributes ra) {
		organization.setCreatedBy(WebContext.getCurrentStaff().getId());
		Result<TSysOrganization> r = organizationService.organizationAdd(organization);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/organization/add";
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "机构添加成功");
		return "redirect:/organization/list";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(String id, RedirectAttributes ra) {
		Result<TSysOrganization> r = organizationService.organizationDelete(id);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/organization/list";
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "机构删除成功");
		return "redirect:/organization/list";
	}
	
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(String id, Model m) {
		Result<TSysOrganization> r =organizationService.organizationGetById(id);
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/organization/list";
		}
		m.addAttribute("organizations", organizationService.organizationList());
		m.addAttribute("item",r.getValue());
		return "organization/update";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(TSysOrganization organization, RedirectAttributes ra) {
		Result<TSysOrganization> r = organizationService.organizationUpdate(organization);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/organization/update?id" + organization.getId();
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "机构信息更新成功");
		return "redirect:/organization/list";
	}

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String show(String id, Model m) {
		Result<TSysOrganization> r = organizationService.searchOrganizationById(id);
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/organization/list";
		}
		m.addAttribute("organizations", organizationService.organizationList());
		m.addAttribute("item", r.getValue());		
		return "organization/show";
	}
	
	@RequestMapping(value = "/tree", method = RequestMethod.GET)
	public String tree(String parentId, Model m) {
		Result<TSysOrganization> r1 = organizationService.searchOrganizationById(parentId);
		m.addAttribute("parent", r1.getValue());
		return "organization/tree";
	}
	
	@RequestMapping(value = "/search_childrens", method = RequestMethod.POST)
	@ResponseBody
	public List<Map<String, String>> searchChildrens(String parentId, Model m) {
		Result<List<TSysOrganization>> r2 = organizationService.searchOrganizationByParentId(parentId);
		List<Map<String, String>> nodes = new ArrayList<>();
		// 子节点
		List<TSysOrganization> orgs = r2.getValue();
		if(null != orgs){
			for (TSysOrganization org : orgs) {
				Map<String, String> node = new HashMap<>();
				node.put("id", org.getId());
				node.put("pId", org.getParentId());
				node.put("name", org.getName());
				node.put("isParent", "true");
				nodes.add(node);
			}
		}
		return nodes;
	}
	
	  @RequestMapping(value="getorgid")  
      @ResponseBody  
      public String getOrgId(String parentId,String levelId){
		  Map<String,String> org = organizationService.getOrgIdByparentId(parentId);
		  String orgid = org.get("id");
           if("".equals(orgid)|| null==orgid){
        	   org = organizationService.getOrgIdBylevelId(levelId);
        	   orgid = org.get("id");
           }
           return orgid;  
      }
	
	  @RequestMapping(value="update_nodename",method = RequestMethod.POST)  
	  @ResponseBody  
	  public String updateOrgName(TSysOrganization organization, Model m) {  
	       TSysStaff staff = WebContext.getCurrentStaff();
	       return organizationService.addOrUpdateOrg(organization,staff);  
	  }

	  
	  @RequestMapping(value="delete_nodename")  
	  @ResponseBody  
	  public String deleteOrgName(String id, Model m) {  
	       return organizationService.deleteOrg(id);  
	  }
	  

}
