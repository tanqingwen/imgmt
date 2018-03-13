package cn.happyworlds.imgmt.web;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpActpcd;
import cn.happyworlds.imgmt.entity.CpBrchid;
import cn.happyworlds.imgmt.entity.CpMeracc;
import cn.happyworlds.imgmt.entity.CpMermst;
import cn.happyworlds.imgmt.entity.CpMerupd;
import cn.happyworlds.imgmt.entity.CpTrmmst;
import cn.happyworlds.imgmt.entity.TSysStaff;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.service.DepartmentService;
import cn.happyworlds.imgmt.service.MerchantService;
import cn.happyworlds.imgmt.service.RoleService;
import cn.happyworlds.imgmt.service.StaffService;
import cn.happyworlds.imgmt.util.Result;
import cn.happyworlds.imgmt.util.StatusResult;
@Controller
@RequestMapping("/staff")
public class StaffController {
	@Autowired
	private StaffService staffService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private MerchantService merchantService;
	@Autowired
	private DepartmentService departmentService;
	
	
	//场馆录入列表
	public PageInfo<CpMeracc> getPageForCurrent1(Integer p,HttpSession session){
		PageBounds pageBounds = null;
		Integer session_p = (Integer) session.getAttribute("session_p");
		if(p == null){
			pageBounds = new PageBounds(session_p, 10);
		}else{
			pageBounds = new PageBounds(p, 10);
		}
		Result<PageInfo<CpMeracc>> r = staffService.getMerchantList1(pageBounds);
		
		PageInfo<CpMeracc> pageInfo = r.getValue();
		Integer page_size = pageInfo.getSize();
		if(!(page_size>0)){
			if(null!=session_p){ //空记录情况
				pageBounds = new PageBounds(session_p-1, 10);
				r = staffService.getMerchantList1(pageBounds);
				pageInfo = r.getValue();
			}
		}
		session.setAttribute("session_p", pageBounds.getOffset());
		return pageInfo;
	}
	
	
	//场馆录入添加
	@WebAction(Permission.VENUE_ENTRY_ADD)
	@RequestMapping(value = "/venueDataEntering_add")
	public String VenueListAdd(@ModelAttribute("cpMeracc") CpMeracc cpMeracc, Map<String, Object> map) {
		
		List<CpBrchid> cpBrchIdList = staffService.getCpBrchIdList();
		
		map.put("cpMeracc", new CpMeracc());
		map.put("cpBrchId", cpBrchIdList.get(0).getBrBranchId());
		map.put("cpMeracc", cpMeracc);
		return "staff/venueDataEnteringAdd";
	}
	
	
	//场馆录入添加提交
	@WebAction(Permission.VENUE_ENTRY_ADD)
	@RequestMapping(value = "/submitForVenueEnteringAdd")
	public String VenueListAddSubmit(CpMeracc cpMeracc, RedirectAttributes ra){
		
		TSysStaff currentStaff = WebContext.getCurrentStaff();
		String currentStaffId = currentStaff.getId();
		String currentStaffPassword = currentStaff.getPassword();
		cpMeracc.setMmModUser(currentStaffId);
		cpMeracc.setMmPassword(currentStaffPassword);
		//添加记录标识(添加/删除:1/0)
		cpMeracc.setMmRiskStatus("1");
		Result<CpMeracc> r = staffService.insertVenue(cpMeracc);
		
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			ra.addFlashAttribute("cpMeracc",cpMeracc);
			return "redirect:/staff/venueDataEntering_add";
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, r.getComment());
		return "redirect:/staff/venueDataEntering";
	}
	
	
	//场馆录入修改
	@WebAction(Permission.VENUE_ENTRY_UPDATE)
	@RequestMapping(value="/venueDataEntering_update/{merchantNo}")
	public String updateVenue(@PathVariable("merchantNo") String merchantNo,Map<String,Object> map){
		
		List<CpBrchid> cpBrchIdList = staffService.getCpBrchIdList();
		CpMeracc meraccDto = staffService.getMerchantById(merchantNo);
		map.put("cpMeracc", meraccDto);
		map.put("cpBrchIdList", cpBrchIdList);
		map.put("mmOldAccNumber", meraccDto.getMmOldAccNumber());
		return "staff/venueDataEnteringAdd_update";
	}
	
	//场馆更新
	@WebAction(Permission.VENUE_ENTRY_UPDATE)
	@RequestMapping(value = "/submitForVenueEnteringUpdate")
	public String submitForVenueEnteringUpdate(CpMeracc cpMeracc, RedirectAttributes ra) {

		TSysStaff currentStaff = WebContext.getCurrentStaff();
		String currentStaffId = currentStaff.getId();
		String currentStaffPassword = currentStaff.getPassword();
		cpMeracc.setMmModUser(currentStaffId);
		cpMeracc.setMmPassword(currentStaffPassword);

		Result<CpMeracc> r = staffService.updateMerchant(cpMeracc);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			Object mmMerchantNo = cpMeracc.getMmMerchantNo();
			return "redirect:/staff/venueDataEntering_update/" + mmMerchantNo;
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, r.getComment());
		return "redirect:/staff/venueDataEntering";
	}
	
	//场馆查看
	@WebAction(Permission.VENUE_ENTRY_SHOW)
	@RequestMapping(value="/venueDataEntering_search/{merchantNo}")
	public String searchVenue(@PathVariable("merchantNo") String merchantNo,Map<String,Object> map){
		
		List<CpBrchid> cpBrchIdList = staffService.getCpBrchIdList();
		CpMeracc meraccDto = staffService.getMerchantById(merchantNo);
		map.put("cpMeracc", meraccDto);
		//上级的场馆编号
		map.put("mmOldAccNumber", meraccDto.getMmOldAccNumber());
		map.put("cpBrchIdList", cpBrchIdList);
		return "staff/venueDataEnteringAdd_search";
	}
	
	
	//场馆删除
	@WebAction(Permission.VENUE_ENTRY_DELETE)
	@RequestMapping(value="/venueDataEntering_del/{merchantNo}")
	public String delVenue(@PathVariable("merchantNo") String merchantNo,RedirectAttributes ra){
		
		CpMeracc meracc = staffService.getMerchantById(merchantNo);
		meracc.setMmRiskStatus("0");
		Result<CpMeracc> r = staffService.deleteMerchant(meracc);
		if(r.isError()){
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/staff/venueDataEntering";
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, r.getComment());
		return "redirect:/staff/venueDataEntering";
	}
	
	//场馆授权1
	@WebAction(Permission.VENUE_ENTRY_AUTH)
	@ResponseBody
	@RequestMapping(value = "/getCurrentStaffId1",method=RequestMethod.POST)
	public String getCurrentStaffId1(String merchantNo) {
		
		CpMeracc cpMeracc = staffService.getMerchantById(merchantNo);
		String currentStaffId = cpMeracc.getMmModUser();
		return currentStaffId;
	}
	
	//场馆授权2
	@WebAction(Permission.VENUE_ENTRY_AUTH)
	@RequestMapping(value = "/venueDataEntering_authorize/{merchantNo}")
	public String doAuthorize1(@PathVariable("merchantNo") String merchantNo, RedirectAttributes ra) {

		CpMeracc meracc = staffService.getMerchantById(merchantNo);
		Result<CpMeracc> r = staffService.doAuthorize1(merchantNo,meracc);
		if(r.isError()){
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/staff/venueDataEntering";
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, r.getComment());
		return "redirect:/staff/venueDataEntering";
	}
	
	
	/**===========================商户录入start=================================**/
	
	//商户录入列表
	@WebAction(Permission.MERACC_ENTRY_LIST)
	@RequestMapping(value = "/merchantDataEntering")
	public String MerchantList( Integer p, Map<String,Object> map,HttpSession session) {
		PageInfo<CpMeracc> pageInfo = this.getPageForCurrent(p,session);
		TSysStaff currentStaff = WebContext.getCurrentStaff();
		String currentStaffId = currentStaff.getId();
		
		map.put("CpMeraccSize", staffService.getCpMeraccList().size());
		map.put("currentStaffId", currentStaffId);
		map.put("pageInfo", pageInfo);
		return "staff/merchantDataEntering";
	}
	
	
	//商户录入列表
	public PageInfo<CpMeracc> getPageForCurrent(Integer p,HttpSession session){
		PageBounds pageBounds = null;
		Integer session_p = (Integer) session.getAttribute("session_p");
		if(p == null){
			pageBounds = new PageBounds(session_p, 10);
		}else{
			pageBounds = new PageBounds(p, 10);
		}
		Result<PageInfo<CpMeracc>> r = staffService.getMerchantList(pageBounds);
		
		PageInfo<CpMeracc> pageInfo = r.getValue();
		Integer page_size = pageInfo.getSize();
		if(!(page_size>0)){
			if(null!=session_p){ //空记录情况
				pageBounds = new PageBounds(session_p-1, 10);
				r = staffService.getMerchantList(pageBounds);
				pageInfo = r.getValue();
			}
		}
		session.setAttribute("session_p", pageBounds.getOffset());
		return pageInfo;
	}
	
	//商户录入添加
	@WebAction(Permission.MERACC_ENTRY_ADD)
	@RequestMapping(value = "/merchantDataEntering_add")
	public String MerchantListAdd(@ModelAttribute("cpMeracc") CpMeracc cpMeracc, Map<String, Object> map) {
		
		List<CpBrchid> cpBrchIdList = staffService.getCpBrchIdList();
		map.put("cpMeracc", new CpMeracc());
		map.put("cpBrchIdList", cpBrchIdList);
		map.put("cpMeracc", cpMeracc);
		return "staff/merchantDataEnteringAddNew";
	}

	//商户录入添加提交
	@WebAction(Permission.MERACC_ENTRY_ADD)
	@RequestMapping(value = "/submitForMerchantEnteringAdd")
	public String MerchantListAddSubmit(CpMeracc cpMeracc, RedirectAttributes ra){
		
		TSysStaff currentStaff = WebContext.getCurrentStaff();
		String currentStaffId = currentStaff.getId();
		String currentStaffPassword = currentStaff.getPassword();
		cpMeracc.setMmModUser(currentStaffId);
		cpMeracc.setMmPassword(currentStaffPassword);
		Result<CpMeracc> r = staffService.insertMerchant(cpMeracc);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			ra.addFlashAttribute("cpMeracc",cpMeracc);
			return "redirect:/staff/merchantDataEntering_add";
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, r.getComment());
		return "redirect:/staff/merchantDataEntering";
	}
	
	//商户录入修改
	@RequestMapping(value="/merchantDataEntering_update/{merchantNo}")
	public String updateMerchant(@PathVariable("merchantNo") String merchantNo,Map<String,Object> map){
		
		List<CpBrchid> cpBrchIdList = staffService.getCpBrchIdList();
		map.put("cpMeracc", staffService.getMerchantById(merchantNo));
		map.put("cpBrchIdList", cpBrchIdList);
		return "staff/merchantDataEnteringUpdateNew";
	}
	
	//商户录入查看
	@WebAction(Permission.MERACC_ENTRY_SHOW)
	@RequestMapping(value="/merchantDataEntering_search/{merchantNo}")
	public String searchMerchant(@PathVariable("merchantNo") String merchantNo,Map<String,Object> map){
		map.put("cpMeracc", staffService.getMerchantById(merchantNo));
		List<CpBrchid> cpBrchIdList = staffService.getCpBrchIdList();
		map.put("cpBrchIdList", cpBrchIdList);
		return "staff/merchantDataEnteringSearchNew";
	}
	
	//商户录入删除
	@WebAction(Permission.MERACC_ENTRY_DELETE)
	@RequestMapping(value="/merchantDataEntering_del/{merchantNo}")
	public String delMerchant(@PathVariable("merchantNo") String merchantNo,RedirectAttributes ra){
		
		CpMeracc meracc = staffService.getMerchantById(merchantNo);
		meracc.setMmRiskStatus("0");
		Result<CpMeracc> r = staffService.deleteMerchant1(meracc);
		if(r.isError()){
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/staff/merchantDataEntering";
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, r.getComment());
		return "redirect:/staff/merchantDataEntering";
	}
	
	//商户录入授权1
	@WebAction(Permission.MERACC_ENTRY_AUTH)
	@ResponseBody
	@RequestMapping(value = "/getCurrentStaffId",method=RequestMethod.POST)
	public String getCurrentStaffId(String merchantNo) {
		
		CpMeracc cpMeracc = staffService.getMerchantById(merchantNo);
		String currentStaffId = cpMeracc.getMmModUser();
		return currentStaffId;
	}
	
	//商户录入授权2
	@WebAction(Permission.MERACC_ENTRY_AUTH)
	@RequestMapping(value = "/merchantDataEntering_authorize/{merchantNo}")
	public String doAuthorize(@PathVariable("merchantNo") String merchantNo, RedirectAttributes ra) {
		CpMeracc meracc = staffService.getMerchantById(merchantNo);
		
		Result<CpMeracc> r = staffService.doAuthorize(merchantNo,meracc);
		if(r.isError()){
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/staff/merchantDataEntering";
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, r.getComment());
		return "redirect:/staff/merchantDataEntering";
	}
	
	/**===========================商户录入end===================================================**/
	
	
	/**===========================场馆查询===================================================**/
	//场馆授权查询
	@WebAction(Permission.VENUE_LIST)
	@RequestMapping(value = "/venuePreserve")
	public String toSearchPage1(String mmMerchantNo,String mmDbaName,String mmBizName,String mmPmtMode, Integer p,
			Map<String,Object> map,HttpSession session) {
		
		Result<PageInfo<CpMermst>> result = merchantService.venueList(mmMerchantNo, mmDbaName, mmBizName, mmPmtMode,new PageBounds(p, 10));
		map.put("pageInfo", result.getValue());
		return "staff/venuePreserve_page";
		
	}
	
	//场馆授权后根据条件查询
	@WebAction(Permission.VENUE_LIST)
	@RequestMapping(value = "/searchVenueResultList", method = { RequestMethod.POST, RequestMethod.GET })
	public String searchVenueResultList(String mmMerchantNo, String mmDbaName,  String mmBizName,String mmPmtMode,
			Integer p, Map<String, Object> map, HttpSession session) {

		Result<PageInfo<CpMermst>> result = merchantService.venueList(mmMerchantNo, mmDbaName, mmBizName, mmPmtMode,
				new PageBounds(p, 10));

		map.put("mmMerchantNo", mmMerchantNo);
		map.put("mmDbaName", mmDbaName);
		map.put("mmBizName", mmBizName);
		map.put("mmPmtMode", mmPmtMode);
		/*map.put("mmStmtName", mmStmtName);*/
		
		map.put("pageInfo", result.getValue());

		return "staff/venuePreserve_page";
	}
	
	//场馆授权详情
	@WebAction(Permission.VENUE_LIST)
	@RequestMapping(value="/venuePreserve_view/{merchantNo}")
	public String searchVenue1(@PathVariable("merchantNo") String merchantNo,Map<String,Object> map){
		
		List<CpBrchid> cpBrchIdList = staffService.getCpBrchIdList();
		CpMermst mermstDto = staffService.getCpMermstById(merchantNo);
		map.put("cpMermst", mermstDto);
		map.put("cpBrchIdList", cpBrchIdList);
		//场馆等级
		map.put("mmPmtMode", mermstDto.getMmPmtMode());
		//上级的场馆编号
		map.put("mmOldAccNumber", mermstDto.getMmOldAccNumber());
		return "staff/venuePreserve_search";
	}
	
	//场馆授权后商户列表
	@WebAction(Permission.VENUE_LIST)
	@RequestMapping(value="/venuePreserve_list/{merchantNo}")
	public String searchMermstList(@PathVariable("merchantNo") String merchantNo,Map<String,Object> map, Integer p){
		
		List<CpBrchid> cpBrchIdList = staffService.getCpBrchIdList();
		//场馆授权后商户列表
		CpMermst mermstDto = staffService.getMermstById(merchantNo);
		Result<PageInfo<CpMermst>> result = staffService.getMermstList(merchantNo,new PageBounds(p, 10));
		
		map.put("cpBrchIdList", cpBrchIdList);
		map.put("mmMerchantNo", merchantNo);
		map.put("mmBizName", mermstDto.getMmBizName());
		map.put("pageInfo", result.getValue());
		return "staff/mermstPreserve_all";
	}
	
	
	//场馆授权后商户列表返回
	@WebAction(Permission.VENUE_LIST)
	@RequestMapping(value = "/venuePreserve_list1", method = { RequestMethod.POST, RequestMethod.GET })
	public String searchVenueResultList(String merchantNo,Map<String,Object> map,Integer p) {

		Result<PageInfo<CpMermst>> result = staffService.getMermstList1(merchantNo,new PageBounds(p, 10));
		//获取场馆名称
		CpMermst mermstDto = staffService.getMermstById(merchantNo);
		map.put("mmMerchantNo", merchantNo);
		map.put("mmBizName", mermstDto.getMmBizName());
		map.put("pageInfo", result.getValue());
		return "staff/mermstPreserve_all";
	}
	
	
	//场馆授权后商户下终端列表
	@WebAction(Permission.VENUE_LIST)
	@RequestMapping(value="/trmmstPreserve_list/{merchantNo}")
	public String searchTrmmstlist(@PathVariable("merchantNo") String merchantNo,Integer p,Map<String,Object> map){
		
		Result<PageInfo<CpTrmmst>> result = staffService.getMTrmmstList(merchantNo,new PageBounds(p, 10));
		List<CpBrchid> cpBrchIdList = staffService.getCpBrchIdList();
		CpMermst mermst = staffService.getCpMermstById(merchantNo);
		map.put("cpBrchIdList", cpBrchIdList);
		map.put("mmMerchantNo", mermst.getMmMerchantNo());
		map.put("mmBizName", mermst.getMmBizName());
		map.put("pageInfo", result.getValue());
		
		return "staff/trmmstPreserve_all";
	}
	
	//场馆授权后闸机列表
	@WebAction(Permission.VENUE_LIST)
	@RequestMapping(value="/gatePreserve_list/{merchantNo}")
	public String searchGatelist(@PathVariable("merchantNo") String merchantNo,Integer p,Map<String,Object> map){
		
		Result<PageInfo<CpTrmmst>> result = staffService.getTrmmstList1(merchantNo,new PageBounds(p, 10));
		List<CpBrchid> cpBrchIdList = staffService.getCpBrchIdList();
		
		map.put("cpMermst", staffService.getCpMermstById(merchantNo));
		map.put("pageInfo", result.getValue());
		map.put("cpBrchIdList", cpBrchIdList);
		return "staff/gatePreserve_all";
	}
	
	
	/*****************************商户授权查询******************************************************/
	
	//商户场馆授权后查询列表
	@WebAction(Permission.VENUE_LIST)
	@RequestMapping(value = "/merchantPreserve")
	public String toSearchPage(String mmMerchantNo,String mmDbaName,String mmBizName,String mmChainAccno,Integer p,
			Map<String,Object> map,HttpSession session) {
		Result<PageInfo<CpMermst>> result = merchantService.merchantList1(mmMerchantNo, mmDbaName, mmBizName, mmChainAccno,new PageBounds(p, 10));
		map.put("pageInfo", result.getValue());
		return "staff/merchantPreserve_page";
	}
	
	//商户授权后根据条件查询
	@RequestMapping(value = "/searchResultList", method={RequestMethod.POST, RequestMethod.GET})
	public String searchResultList(String mmMerchantNo,String mmDbaName,String mmBizName,String mmChainAccno,Integer p,
			Map<String,Object> map,HttpSession session) {
		Result<PageInfo<CpMermst>> result = merchantService.merchantList1(mmMerchantNo, mmDbaName, mmBizName,mmChainAccno, new PageBounds(p, 10));
		map.put("mmMerchantNo", mmMerchantNo);
		map.put("mmDbaName", mmDbaName);
		map.put("mmBizName", mmBizName);
		map.put("mmChainAccno", mmChainAccno);
		map.put("pageInfo", result.getValue());
		
		return "staff/merchantPreserve_page";
	}
	
	//商户授权后查看
	@WebAction(Permission.MERMST_LIST)
	@RequestMapping(value="/merchantPreserve_view/{merchantNo}")
	public String searchMermst(@PathVariable("merchantNo") String merchantNo,Map<String,Object> map){
		
		List<CpBrchid> cpBrchIdList = staffService.getCpBrchIdList();
		map.put("cpMermst", staffService.getCpMermstById(merchantNo));
		map.put("cpBrchIdList", cpBrchIdList);
		return "staff/merchantPreserve_search";
	}
	
	//商户授权后下边终端
	@WebAction(Permission.MERMST_TERMINAL_LIST)
	@RequestMapping(value="/trmmstPreserve_view/{merchantNo}")
	public String searchTrmmst(@PathVariable("merchantNo") String merchantNo,Integer p,Map<String,Object> map){
		
		CpMermst mermst = staffService.getCpMermstById(merchantNo);
		map.put("mmMerchantNo", mermst.getMmMerchantNo());
		map.put("mmBizName", mermst.getMmBizName());
		
		Result<PageInfo<CpTrmmst>> result = staffService.getTrmmstList(merchantNo,new PageBounds(p, 10));
		List<CpBrchid> cpBrchIdList = staffService.getCpBrchIdList();
		
		map.put("pageInfo", result.getValue());
		map.put("cpBrchIdList", cpBrchIdList);
		return "staff/mtrmmstPreserve_all";
	}
	
	
	/*****************************场馆维护start**************************************/
	

	
	
	//场馆维护根据条件查询mermst
	@RequestMapping(value = "/searchVmermstResultList", method = { RequestMethod.POST, RequestMethod.GET })
	public String searchVmermstResultList(String mmMerchantNo, String mmBizName, Integer p, Map<String, Object> map,
			HttpSession session) {

		Result<PageInfo<CpMermst>> result = merchantService.venueMermstList(mmMerchantNo, mmBizName,
				new PageBounds(p, 10));

		map.put("mmMerchantNo", mmMerchantNo);
		map.put("mmBizName", mmBizName);
		map.put("pageInfo", result.getValue());

		return "staff/vmermstPreserve_page";
	}

	//场馆维护更新
	@WebAction(Permission.VENUE_LIST)
	@RequestMapping(value = "/vmermstPreserve_update/{merchantNo}")
	public String vmermstPreserve_update(@PathVariable("merchantNo") String merchantNo, Map<String, Object> map) {

		List<CpBrchid> cpBrchIdList = staffService.getCpBrchIdList();
		List<CpActpcd> cpActpcdList = staffService.getCpActpcdList();

		CpMermst mermstDto = staffService.getCpMermstById(merchantNo);
		map.put("cpMermst", mermstDto);
		map.put("cpBrchIdList", cpBrchIdList);
		map.put("cpActpcdList", cpActpcdList);
		map.put("mmOldAccNumber", mermstDto.getMmOldAccNumber());
		return "staff/vmermstPreserve_update";
	}

	//场馆维护更新插入或者更新merupd表
	@RequestMapping(value = "/submitForVenuePreserver_update", method = RequestMethod.POST)
	public String submitForVenuePreserver_update(CpMermst cpMermst, RedirectAttributes ra) throws IllegalAccessException, InvocationTargetException {

		TSysStaff currentStaff = WebContext.getCurrentStaff();
		String currentStaffId = currentStaff.getId();
		String currentStaffPassword = currentStaff.getPassword();
		cpMermst.setMmModUser(currentStaffId);
		cpMermst.setMmPassword(currentStaffPassword);

		CpMerupd merupd = new CpMerupd();
		BeanUtils.copyProperties(merupd, cpMermst);

		CpMerupd oldMerupd = staffService.findMerupd(cpMermst.getMmMerchantNo());
		merupd.setMmRiskStatus("1");
		if (null != oldMerupd) {
			Result<CpMerupd> r = staffService.updateMerupd(merupd);
			if (r.isError()) {
				ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
				return "redirect:/staff/searchVmermstResultList";
			}
			ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, r.getComment());
		} else {
			staffService.insertMerupd(merupd);
			ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "场馆维护插入失败");
		}
		return "redirect:/staff/searchVmermstResultList";
	}

	
	@RequestMapping(value = "/searchVmermstWaitAuth", method = { RequestMethod.POST, RequestMethod.GET })
	public String searchVmermstWaitAuth(String mmMerchantNo, String mmBizName, Integer p, Map<String, Object> map) {

		TSysStaff currentStaff = WebContext.getCurrentStaff();
		String currentStaffId = currentStaff.getId();
		
		Result<PageInfo<CpMerupd>> result = merchantService.venueMerupdAuthList(mmMerchantNo, mmBizName,
				new PageBounds(p, 10));
		map.put("mmMerchantNo", mmMerchantNo);
		map.put("mmBizName", mmBizName);
		map.put("pageInfo", result.getValue());
		map.put("currentStaffId", currentStaffId);

		return "staff/vmerupdPreserve_page";
	}

	
	@WebAction(Permission.VENUE_LIST)
	@RequestMapping(value = "/vmerupdPreserve_search/{merchantNo}")
	public String vmerupdPreserve_search(@PathVariable("merchantNo") String merchantNo, Map<String, Object> map) {

		List<CpBrchid> cpBrchIdList = staffService.getCpBrchIdList();

		CpMerupd merupdDto = staffService.getMerupdById(merchantNo);
		map.put("merchantNo", merchantNo);
		map.put("cpBrchIdList", cpBrchIdList);
		map.put("cpMerupd", merupdDto);
		map.put("mmOldAccNumber", merupdDto.getMmOldAccNumber());
		return "staff/venueMerupd_search";
	}


	@WebAction(Permission.VENUE_LIST)
	@ResponseBody
	@RequestMapping(value = "/getCurrentVenueStaffId", method = RequestMethod.POST)
	public String getCurrentVenueStaffId(String merchantNo) {

		CpMerupd merupd = staffService.getMerupdById(merchantNo);
		String currentStaffId = merupd.getMmModUser();
		return currentStaffId;
	}

	
	@WebAction(Permission.VENUE_LIST)
	@RequestMapping(value = "/venueDataMerupdEntering_authorize/{merchantNo}")
	public String doAuthorizeVenueMerupd(@PathVariable("merchantNo") String merchantNo, RedirectAttributes ra) {

		CpMerupd merupd = staffService.getMerupdById(merchantNo);
		Result<CpMerupd> r = staffService.doAuthorizeVenue(merchantNo, merupd);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/staff/searchVmermstWaitAuth?mmMerchantNo=" + merchantNo;
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, r.getComment());
		//return "redirect:/staff/searchVmermstWaitAuth?mmMerchantNo=" + merchantNo;
		return "redirect:/staff/searchVmermstWaitAuth";
	}

	/*************************场馆维护end*****************************************/
	
	
	/*************************商户维护start****************************************/
	@WebAction(Permission.MERUPD_MAINTAIN_LIST)
	@RequestMapping(value = "/merupdPreserve")
	public String merupdPreserve() {
		return "staff/merupd_page";
	}
	
	
	@WebAction(Permission.MERUPD_MAINTAIN_LIST)
	@RequestMapping(value = "/searchMermstResultList", method = { RequestMethod.POST, RequestMethod.GET })
	public String searchMermstResultList(String mmMerchantNo, String mmBizName, Integer p, Map<String, Object> map,
			HttpSession session) {

		Result<PageInfo<CpMermst>> result = merchantService.mermstList(mmMerchantNo, mmBizName,
				new PageBounds(p, 10));

		map.put("mmMerchantNo", mmMerchantNo);
		map.put("mmBizName", mmBizName);
		map.put("pageInfo", result.getValue());

		return "staff/mermstPreserve_page";
	}

	
	@WebAction(Permission.MERUPD_MAINTAIN_UPDARE)
	@RequestMapping(value = "/mermstPreserve_update/{merchantNo}")
	public String mermstPreserve_update(@PathVariable("merchantNo") String merchantNo, Map<String, Object> map) {

		List<CpBrchid> cpBrchIdList = staffService.getCpBrchIdList();
		List<CpActpcd> cpActpcdList = staffService.getCpActpcdList();

		map.put("cpMermst", staffService.getCpMermstById(merchantNo));
		map.put("cpBrchIdList", cpBrchIdList);
		map.put("cpActpcdList", cpActpcdList);
		return "cpmermst/mermstPreserve_update";
	}
	
	
	@WebAction(Permission.MERUPD_MAINTAIN_UPDARE)
	@RequestMapping(value = "/submitForMerupdPreserver_update", method = RequestMethod.POST)
	public String submitForMerupdPreserver_update(CpMermst cpMermst, RedirectAttributes ra) throws IllegalAccessException, InvocationTargetException {

		TSysStaff currentStaff = WebContext.getCurrentStaff();
		String currentStaffId = currentStaff.getId();
		String currentStaffPassword = currentStaff.getPassword();
		cpMermst.setMmModUser(currentStaffId);
		cpMermst.setMmPassword(currentStaffPassword);
		
		CpMerupd merupd = new CpMerupd();
		BeanUtils.copyProperties(merupd, cpMermst);
		
		CpMerupd oldMerupd = staffService.findMerupd(cpMermst.getMmMerchantNo());
		if (null != oldMerupd) {
			Result<CpMerupd> r = staffService.updateMerupd(merupd);
			if (r.isError()) {
				ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
				return "redirect:/staff/searchMermstResultList";
			}
			ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, r.getComment());
		} else {
			staffService.insertMerupd(merupd);
			ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "商户更新成功");
		}
		return "redirect:/staff/searchMermstResultList";
	}
	
	
	@WebAction(Permission.MERUPD_MAINTAIN_AUTHOH)
	@RequestMapping(value = "/searchMermstWaitAuth", method = { RequestMethod.POST, RequestMethod.GET })
	public String searchMermstWaitAuth(String mmMerchantNo, String mmBizName, Integer p, Map<String, Object> map) {

		TSysStaff currentStaff = WebContext.getCurrentStaff();
		String currentStaffId = currentStaff.getId();
		
		Result<PageInfo<CpMerupd>> result = merchantService.merupdAuthList(mmMerchantNo, mmBizName,
				new PageBounds(p, 10));
		
		map.put("mmMerchantNo", mmMerchantNo);
		map.put("mmBizName", mmBizName);
		map.put("pageInfo", result.getValue());
		map.put("currentStaffId", currentStaffId);

		return "staff/merupdPreserve_page";
	}
	
	@WebAction(Permission.MERUPD_MAINTAIN_SHOW)
	@RequestMapping(value = "/merupdPreserve_search/{merchantNo}")
	public String merupdPreserve_search(@PathVariable("merchantNo") String merchantNo, Map<String, Object> map) {

		List<CpBrchid> cpBrchIdList = staffService.getCpBrchIdList();

		map.put("merchantNo", merchantNo);
		map.put("cpMerupd", staffService.getMerupdById(merchantNo));
		map.put("cpBrchIdList", cpBrchIdList);
		return "staff/merupd_search";
	}
	
	
	@WebAction(Permission.MERUPD_MAINTAIN_SHOW)
	@ResponseBody
	@RequestMapping(value = "/getCurrentMerupdStaffId", method = RequestMethod.POST)
	public String getCurrentMerupdStaffId(String merchantNo) {

		CpMerupd merupd = staffService.getMerupdById(merchantNo);
		String currentStaffId = merupd.getMmModUser();
		return currentStaffId;
	}

	@WebAction(Permission.MERUPD_MAINTAIN_AUTHOH)
	@RequestMapping(value = "/dataMerupdEntering_authorize/{merchantNo}")
	public String doAuthorizeMerupd(@PathVariable("merchantNo") String merchantNo, RedirectAttributes ra) {

		CpMerupd merupd = staffService.getMerupdById(merchantNo);
		Result<CpMerupd> r = staffService.doAuthorizeMerupd(merchantNo, merupd);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/staff/searchMermstWaitAuth?mmMerchantNo=" + merchantNo;
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, r.getComment());
		//return "redirect:/staff/searchMermstWaitAuth?mmMerchantNo=" + merchantNo;
		return "redirect:/staff/searchMermstWaitAuth";
	}
	
	/*************************商户维护end****************************************/
	
	@RequestMapping(value = "/submitForMerchantPreserver_update",method=RequestMethod.POST)
	public String submitForMerchantPreserver_update(CpMermst cpMermst,RedirectAttributes ra){
		TSysStaff currentStaff = WebContext.getCurrentStaff();
		String currentStaffId = currentStaff.getId();
		String currentStaffPassword = currentStaff.getPassword();
		cpMermst.setMmModUser(currentStaffId);
		cpMermst.setMmPassword(currentStaffPassword);
		Result<CpMermst> r = staffService.updateMermst(cpMermst);
		if(r.isError()){
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/staff/searchResultListForBackPerfect";
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, r.getComment());
		return "redirect:/staff/searchResultListForBackPerfect";
	}
	
	
	@WebAction(Permission.STAFF_LIST)
	@RequestMapping("/list")
	public String list(String staffId, String staffName, Integer p, Model m) {
		Result<PageInfo<TSysStaff>> r = staffService.staffList(staffId, staffName, new PageBounds(p, 10));
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "鏌ヨ鍑虹幇寮傚父");
		} else {
			m.addAttribute("pageInfo", r.getValue());
		}
		return "staff/list";	
	}
	
	
	@WebAction(Permission.STAFF_SHOW)
	@RequestMapping("/show")
	public String show(String id, Model m) {
		Result<TSysStaff> r = staffService.staffGetById(id);
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/staff/list";
		}
		m.addAttribute("item", r.getValue());
		m.addAttribute("roles", roleService.roleList());
		return "staff/show";
	}

	@WebAction(Permission.STAFF_ADD)
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model m) {
		m.addAttribute("roles", roleService.roleList());
		m.addAttribute("organizations",departmentService.organizationList());
		return "staff/add";
	}

	@WebAction(Permission.STAFF_ADD)
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(TSysStaff staff, RedirectAttributes ra) {
		staff.setCreatedBy(WebContext.getCurrentStaff().getId());
		Result<TSysStaff> r = staffService.staffAdd(staff);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/staff/add";
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "员工添加成功");
		return "redirect:/staff/list";
	}

	@WebAction(Permission.STAFF_UPDATE)
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(String id, Model m) {
		Result<TSysStaff> r = staffService.staffGetById(id);
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/staff/list";
		}
		m.addAttribute("item", r.getValue());
		m.addAttribute("organizations",departmentService.organizationList() );
		m.addAttribute("roles", roleService.roleList());
		return "staff/update";
	}

	@WebAction(Permission.STAFF_UPDATE)
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(TSysStaff staff, RedirectAttributes ra) {
		if(!"LOCK".equals(staff.getStatus()))
			staff.setPwdFailCnt(0);
		Result<TSysStaff> r = staffService.staffUpdate(staff);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/staff/update?id" + staff.getId();
		}
		WebContext.resetCurrentStaff(r.getValue());
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "员工信息更新成功");
		return "redirect:/staff/list";
	}
	
	@WebAction(Permission.STAFF_CHANGE_PASSWORD)
	@RequestMapping(value = "/change_password", method = RequestMethod.GET)
	public String changePassword() {
		return "staff/change_password";
	}
	
	@WebAction(Permission.STAFF_CHANGE_PASSWORD)
	@RequestMapping(value = "/change_password", method = RequestMethod.POST)
	public String changePassword(String newPassword, RedirectAttributes ra) {
		String userId = WebContext.getCurrentStaff().getId();
		Result<TSysStaff> r = staffService.staffChangePassword(userId, newPassword);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/staff/change_password";
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "密码修改成功，请重新登录");
		WebContext.removeCurrentStaff();
		return "redirect:/login";
	}

	@WebAction(Permission.STAFF_RESET_PASSWORD)
	@RequestMapping(value = "/reset_password", method = RequestMethod.GET)
	public String resetPassword(String id, Model m) {
		Result<TSysStaff> r = staffService.staffGetById(id);
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/staff/list";
		}
		m.addAttribute("user", r.getValue());
		return "staff/reset_password";
	}
	
	@WebAction(Permission.STAFF_RESET_PASSWORD)
	@RequestMapping(value = "/reset_password", method = RequestMethod.POST)
	public String resetPassword(String userId, String newPassword,String renewPassword, RedirectAttributes ra) {
		Result<TSysStaff> r = staffService.staffChangePassword(userId, newPassword);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/staff/reset_password?id" + userId;
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "员工信息更新成功");
		return "redirect:/staff/list";
	}
	
	
	@WebAction(Permission.VENUE_LIST)
	@RequestMapping(value = "/submitForMerchantEnteringUpdate")
	public String submitForMerchantEnteringUpdate(CpMeracc cpMeracc,RedirectAttributes ra){
		TSysStaff currentStaff = WebContext.getCurrentStaff();
		String currentStaffId = currentStaff.getId();
		String currentStaffPassword = currentStaff.getPassword();
		cpMeracc.setMmModUser(currentStaffId);
		cpMeracc.setMmPassword(currentStaffPassword);
		Result<CpMeracc> r = staffService.updateMerchant(cpMeracc);
		if(r.isError()){
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			Object mmMerchantNo = cpMeracc.getMmMerchantNo();
			return "redirect:/staff/merchantDataEntering_update/"+mmMerchantNo;
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, r.getComment());
		return "redirect:/staff/merchantDataEntering";
	}
	

	
	
	@RequestMapping(value = "/merchantPreserve2")
	public String toSearchPage2(String mmMerchantNo,String mmDbaName,String mmBizName,Integer p,
			Map<String,Object> map,HttpSession session) {
		Result<PageInfo<CpMermst>> result = merchantService.merchantList(mmMerchantNo, mmDbaName, mmBizName, new PageBounds(p, 10));
		map.put("pageInfo", result.getValue());
		return "staff/merchantPreserve_page2";
	}
	
	@RequestMapping(value = "/searchResultListForBackPerfect")
	public String searchResultListForBackPerfect(Integer p,Map<String,Object> map,HttpSession session) {
		String mmMerchantNo = (String) session.getAttribute("mmMerchantNo");
		String mmDbaName = (String) session.getAttribute("mmDbaName");
		String mmBizName = (String) session.getAttribute("mmBizName");
		Result<PageInfo<CpMermst>> result = merchantService.merchantList(mmMerchantNo, mmDbaName, mmBizName, new PageBounds(p, 10));
		map.put("pageInfo", result.getValue());
		
		return "staff/merchantPreserve_page";
	}
	
	
	//绾у埆鍦洪鍒楄〃
	@ResponseBody
	@RequestMapping(value = "/search_mermst_Data", method = RequestMethod.POST)
	public StatusResult<List<CpMermst>> searchMermstData(String mmPmtMode) {
		
		List<CpMermst> mermstList = staffService.getCpMermstList(mmPmtMode);
		return StatusResult.create(mermstList);
	}
	
	
	//
	@ResponseBody
	@RequestMapping(value = "/search_mermst_Data1", method = RequestMethod.POST)
	public StatusResult<List<CpMermst>> searchMermstData1(String mmPmtMode) {
		
		List<CpMermst> mermstList = staffService.getCpMermstList1(mmPmtMode);
		return StatusResult.create(mermstList);
	}

	
}
