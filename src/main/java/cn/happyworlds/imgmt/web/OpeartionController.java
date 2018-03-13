package cn.happyworlds.imgmt.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.AclUser;
import cn.happyworlds.imgmt.entity.Consumption;
import cn.happyworlds.imgmt.entity.CpPrdgrp;
import cn.happyworlds.imgmt.entity.FillCard;
import cn.happyworlds.imgmt.entity.Opeartion;
import cn.happyworlds.imgmt.entity.TSysStaff;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.service.AclUserService;
import cn.happyworlds.imgmt.service.ConsumptionService;
import cn.happyworlds.imgmt.service.OpeartionService;
import cn.happyworlds.imgmt.service.PrdgrpService;
import cn.happyworlds.imgmt.service.StatService;
import cn.happyworlds.imgmt.service.TicketService;
import cn.happyworlds.imgmt.util.Result;
import cn.happyworlds.imgmt.util.SysDateFormat;



@Controller
@RequestMapping("/opeartion")
public class OpeartionController {
	@Autowired
	private OpeartionService opeartionService;
	@Autowired
	private TicketService ticketService;
	@Autowired
	private ConsumptionService consumptionServer;
	@Autowired
	private AclUserService aclUserService;
	@Autowired
	private PrdgrpService prdgrpService;
	@Autowired
	private StatService statService;
	
	//会员卡操作查询页面字段，起始时间，结束时间，卡号，操作类型，操作员
	private void OpeartionStatCondition(HttpServletRequest request, Model model,String nowtime,String nowtimeOnoneMonth) {
		String paras[] = {"ctApproveTimeStart" ,"ctApproveTimeEnd" ,"cbCardholderNo","ctCardNumber","ctTranCode","ctUserCreate"};
		for (int i = 0; i < paras.length; i++) {
			model.addAttribute(paras[i], request.getParameter(paras[i]));
		}
		String ctApproveTimeStart=request.getParameter("ctApproveTimeStart");
		String ctApproveTimeEnd=request.getParameter("ctApproveTimeEnd");
		String ctTranCode=request.getParameter("ctTranCode");
		if(ctApproveTimeStart==null&&ctApproveTimeEnd==null&&ctTranCode==null){
			model.addAttribute("ctApproveTimeStart", nowtimeOnoneMonth);
			model.addAttribute("ctApproveTimeEnd", nowtime);
			model.addAttribute("ctTranCode", "OPENCARD");
		}
	}
	
	//会员卡操作查询，返回查询字段卡号,姓名，卡类型，日期，时间，金额
	@WebAction(Permission.OPEARTION_LIST)
	@RequestMapping("/list")
	public String opeartionStat(HttpServletRequest  request, Integer p, Model m) {
		String nowtime = SysDateFormat.getNowDate("yyyyMMdd");
		String nowtimeOnoneMonth = ticketService.getSpecifiedDayAfterBynum(nowtime,-30);
		String ctApproveTimeStart=request.getParameter("ctApproveTimeStart");
		String ctApproveTimeEnd=request.getParameter("ctApproveTimeEnd");
		String ctCardNumber=request.getParameter("ctCardNumber");
		String ctTranCode=request.getParameter("ctTranCode");
		String ctUserCreate=request.getParameter("ctUserCreate");
		
		OpeartionStatCondition(request, m,nowtime,nowtimeOnoneMonth);
		if(ctApproveTimeStart==null&&ctApproveTimeEnd==null&&ctTranCode==null){
			ctApproveTimeStart = nowtimeOnoneMonth;
			ctApproveTimeEnd = nowtime;
			ctTranCode="OPENCARD";
		}
		Result<List<AclUser>> aclUsers = aclUserService.AclUserListAll();
		Result<PageInfo<Opeartion>> r = opeartionService.OpeartionList(ctApproveTimeStart, ctApproveTimeEnd, ctCardNumber, ctTranCode, ctUserCreate,request,new PageBounds(p,10));  
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("aclUsers", aclUsers.getValue());
			m.addAttribute("pageInfo", r.getValue());
		}
		return "opeartion/list";
	}
	//会员卡补卡
	@RequestMapping("/suppl")
	public String suppllist(HttpServletRequest request,Integer p, Model m) {
		String nowtime = SysDateFormat.getNowDate("yyyyMMdd");
		String nowtimeOnoneMonth = ticketService.getSpecifiedDayAfterBynum(nowtime,-30);
		keepFillCard(request, m,nowtime,nowtimeOnoneMonth);

		String cl_old_card = request.getParameter("cl_old_card");
		String cl_new_card = request.getParameter("cl_new_card");
		String cl_timestampStart = request.getParameter("cl_timestampStart");
		String cl_timestampEnd = request.getParameter("cl_timestampEnd");
		String cl_auth_user_id = request.getParameter("cl_auth_user_id");
		if(cl_timestampStart==null&&cl_timestampEnd==null){
			cl_timestampStart = nowtimeOnoneMonth;
			cl_timestampEnd = nowtime;
		}
		
		Result<List<AclUser>> aclUsers = aclUserService.AclUserListAll();
		Result<PageInfo<FillCard>> r = consumptionServer.FillCardList(cl_old_card, cl_new_card, cl_timestampStart, cl_timestampEnd, cl_auth_user_id, new PageBounds(p,10));  
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("pageInfo", r.getValue());
			m.addAttribute("queryString", request.getQueryString());
			m.addAttribute("aclUsers", aclUsers.getValue());
		}
		return "opeartion/suppl";
	}
	//会员卡补卡
	private void keepFillCard(HttpServletRequest request, Model model,String nowtime,String nowtimeOnoneMonth) {
		String pageInfo[] = { "cl_old_card", "cl_new_card", "cl_timestampStart", "cl_timestampEnd", "cl_auth_user_id"};
		for (int i = 0; i < pageInfo.length; i++) {
			model.addAttribute(pageInfo[i], request.getParameter(pageInfo[i]));
		}
		String cl_timestampStart=request.getParameter("cl_timestampStart");
		String cl_timestampEnd=request.getParameter("cl_timestampEnd");
		if(cl_timestampStart==null&&cl_timestampEnd==null){
			model.addAttribute("cl_timestampStart", nowtimeOnoneMonth);
			model.addAttribute("cl_timestampEnd", nowtime);
		}
	}
	
	//会员卡消费查询，返回查询字段卡号,卡种，姓名，终端号，场馆号，交易时间，上送时间，交易金额，余额
	@WebAction(Permission.OPEARTION_EXPENSE)
	@RequestMapping("/expense")
	public String expenselist(HttpServletRequest request,Integer p, Model m) {
		String nowtime = SysDateFormat.getNowDate("yyyyMMdd");
		String nowtimeOnoneMonth = ticketService.getSpecifiedDayAfterBynum(nowtime,-30);
		keepConsumption(request, m,nowtime,nowtimeOnoneMonth);

		String cbEmbossname = request.getParameter("cbEmbossname");
		String tmDbaName = request.getParameter("tmDbaName");
		String ctCardNumber = request.getParameter("ctCardNumber");
		String prProdctGroup = request.getParameter("prProdctGroup");
		String ctDisputeDateStart = request.getParameter("ctDisputeDateStart");		
		String ctDisputeDateEnd = request.getParameter("ctDisputeDateEnd");
		String ctDisputeDateStatus = request.getParameter("ctDisputeDateStatus");
		if(ctDisputeDateStart==null&&ctDisputeDateEnd==null){
			ctDisputeDateStart=nowtimeOnoneMonth;
			ctDisputeDateEnd=nowtime;
		}
		
		Result<List<CpPrdgrp>> rr = prdgrpService.prdGrpListAll();	
		Result<PageInfo<Consumption>> r = consumptionServer.ConsumptionList(cbEmbossname,tmDbaName,ctCardNumber,prProdctGroup,ctDisputeDateStart,ctDisputeDateEnd,ctDisputeDateStatus,new PageBounds(p,10));
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("prdgrp", rr.getValue());
			m.addAttribute("pageInfo", r.getValue());
			m.addAttribute("queryString", request.getQueryString());
		}
		return "opeartion/expense";
	}
	
	//会员卡消费统计下载
	@WebAction(Permission.OPEARTION_EXPENSE_DOWNLOAD)
	@RequestMapping(value = "/expenseDownLoad", method = RequestMethod.POST)
	public String expenseDownLoad(HttpServletRequest  request, HttpServletResponse resp,RedirectAttributes ra) {
		String cbEmbossname = request.getParameter("cbEmbossname");
		String tmDbaName = request.getParameter("tmDbaName");
		String ctCardNumber = request.getParameter("ctCardNumber");
		String prProdctGroup = request.getParameter("prProdctGroup");
		String ctDisputeDateStart = request.getParameter("ctDisputeDateStart");		
		String ctDisputeDateEnd = request.getParameter("ctDisputeDateEnd");
		String ctDisputeDateStatus = request.getParameter("ctDisputeDateStatus");
		TSysStaff currentStaff = WebContext.getCurrentStaff();
		
		Result<String> result = statService.expenseDownLoadMethod(cbEmbossname,tmDbaName,ctCardNumber,prProdctGroup,ctDisputeDateStart,ctDisputeDateEnd,ctDisputeDateStatus,currentStaff.getId(),resp);
		
		if (result!=null) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, result.getComment());
			return "redirect:/opeartion/expense";
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "下载成功");
		return "redirect:/opeartion/expense";
	}
	
	//会员卡操作统计下载
	@WebAction(Permission.OPEARTION_LIST_DOWNLOAD)
	@RequestMapping(value = "/listDownLoad", method = RequestMethod.POST)
	public String listDownLoad(HttpServletRequest  request, HttpServletResponse resp,RedirectAttributes ra) {
		String ctApproveTimeStart=request.getParameter("ctApproveTimeStart");
		String ctApproveTimeEnd=request.getParameter("ctApproveTimeEnd");
		String ctCardNumber=request.getParameter("ctCardNumber");
		String ctTranCode=request.getParameter("ctTranCode");
		String ctUserCreate=request.getParameter("ctUserCreate");
		TSysStaff currentStaff = WebContext.getCurrentStaff();
		
		Result<String> result = statService.listDownLoadMethod(ctApproveTimeStart, ctApproveTimeEnd, ctCardNumber, ctTranCode, ctUserCreate,currentStaff.getId(),resp);
		
		if (result!=null) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, result.getComment());
			return "redirect:/opeartion/list";
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "下载成功");
		return "redirect:/opeartion/list";
	}

	//会员卡消费查询页面字段，姓名，场馆号，卡号，卡种，交易起始时间，交易结束时间，数据上传时间
	private void keepConsumption(HttpServletRequest request, Model model,String nowtime,String nowtimeOnoneMonth) {
		String pageInfo[] = { "cbEmbossname", "tmDbaName","ctCardNumber", "prProdctGroup", "ctDisputeDateStart","ctDisputeDateEnd","ctDisputeDateStatus"};
		for (int i = 0; i < pageInfo.length; i++) {
			model.addAttribute(pageInfo[i], request.getParameter(pageInfo[i]));
		}
		String ctDisputeDateStart=request.getParameter("ctDisputeDateStart");
		String ctDisputeDateEnd=request.getParameter("ctDisputeDateEnd");
		if(ctDisputeDateStart==null&&ctDisputeDateEnd==null){
			model.addAttribute("ctDisputeDateStart", nowtimeOnoneMonth);
			model.addAttribute("ctDisputeDateEnd", nowtime);
		}
	}
	
	
	
	/*@WebAction(Permission.ORGANIZATION_ADD)
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model m) {
		m.addAttribute("organizations", organizationService.organizationList());
		return "organization/add";
	}
	
	@WebAction(Permission.ORGANIZATION_ADD)
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
	
	@WebAction(Permission.ORGANIZATION_DELETE)
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
	
	
	@WebAction(Permission.ORGANIZATION_UPDATE)
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
	
	@WebAction(Permission.ORGANIZATION_UPDATE)
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

	@WebAction(Permission.ORGANIZATION_SHOW)
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
	
	@WebAction(Permission.ORGANIZATION_SHOW)
	@RequestMapping(value = "/tree", method = RequestMethod.GET)
	public String tree(String parentId, Model m) {
		Result<TSysOrganization> r1 = organizationService.searchOrganizationById(parentId);
		m.addAttribute("parent", r1.getValue());
		return "organization/tree";
	}
	
	@WebAction(Permission.ORGANIZATION_SHOW)
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
	  */

}
