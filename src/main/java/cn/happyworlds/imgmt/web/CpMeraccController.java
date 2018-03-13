package cn.happyworlds.imgmt.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpBrchid;
import cn.happyworlds.imgmt.entity.CpMeracc;
import cn.happyworlds.imgmt.entity.CpMermst;
import cn.happyworlds.imgmt.entity.TSysStaff;
import cn.happyworlds.imgmt.service.CpMeraccService;
import cn.happyworlds.imgmt.util.Result;
import cn.happyworlds.imgmt.util.StatusResult;

@Controller
@RequestMapping("/cpmeracc")
public class CpMeraccController {
	
	@Autowired
	private CpMeraccService cpMeraccService;
	
	/**
	 * 场馆录入列表
	 * @param p
	 * @param map
	 * @param session
	 * @return
	 */
	@WebAction(Permission.VENUE_ENTRY_LIST)
	@RequestMapping(value = "/venueDataEntering")
	public String VenueList( Integer p, Map<String,Object> map,HttpSession session) {		
		PageInfo<CpMeracc> pageInfo = cpMeraccService.getPageForCurrent1(p,session);		
		TSysStaff currentStaff = WebContext.getCurrentStaff();
		String currentStaffId = currentStaff.getId();		
		map.put("pageInfo", pageInfo);
		map.put("CpMeraccSize", cpMeraccService.getCpMeraccList().size());
		map.put("currentStaffId", currentStaffId);
		return "cpmeracc/venueDataEntering";
	}
	
	/**
	 * 商户录入列表
	 * @param p
	 * @param map
	 * @param session
	 * @return
	 */
	@WebAction(Permission.MERACC_ENTRY_LIST)
	@RequestMapping(value = "/merchantDataEntering")
	public String MerchantList( Integer p, Map<String,Object> map,HttpSession session) {
		PageInfo<CpMeracc> pageInfo = cpMeraccService.getPageForCurrent(p,session);
		TSysStaff currentStaff = WebContext.getCurrentStaff();
		String currentStaffId = currentStaff.getId();		
		map.put("CpMeraccSize", cpMeraccService.getCpMeraccList().size());
		map.put("currentStaffId", currentStaffId);
		map.put("pageInfo", pageInfo);
		return "cpmeracc/merchantDataEntering";
	}
	
	/**
	 * 场馆查看
	 * @param merchantNo
	 * @param map
	 * @return
	 */
	@WebAction(Permission.VENUE_ENTRY_SHOW)
	@RequestMapping(value="/venueDataEntering_search/{merchantNo}")
	public String searchVenue(@PathVariable("merchantNo") String merchantNo,Map<String,Object> map){
		
		List<CpBrchid> cpBrchIdList = cpMeraccService.getCpBrchIdList();
		CpMeracc meraccDto = cpMeraccService.getMerchantById(merchantNo);
		map.put("cpMeracc", meraccDto);
		//上级的场馆编号
		map.put("mmOldAccNumber", meraccDto.getMmOldAccNumber());
		map.put("cpBrchIdList", cpBrchIdList);
		map.put("mmOldAccNumber", meraccDto.getMmOldAccNumber());
		map.put("mmChainAccno", meraccDto.getMmChainAccno());		
		return "cpmeracc/venueDataEnteringAdd_search";
	}
	
	/**
	 * 商户录入查看
	 * @param merchantNo
	 * @param map
	 * @return
	 */
	@WebAction(Permission.MERACC_ENTRY_SHOW)
	@RequestMapping(value="/merchantDataEntering_search/{merchantNo}")
	public String searchMerchant(@PathVariable("merchantNo") String merchantNo,Map<String,Object> map){
		CpMeracc cpMeracc = cpMeraccService.getMerchantById(merchantNo);
		map.put("cpMeracc", cpMeraccService.getMerchantById(merchantNo));
		map.put("cpMeracc", cpMeracc);								
		List<CpBrchid> cpBrchIdList = cpMeraccService.getCpBrchIdList();
		map.put("cpBrchIdList", cpBrchIdList);
		map.put("mmOldAccNumber",cpMeracc.getMmOldAccNumber());
		map.put("mmChainAccno",cpMeracc.getMmChainAccno());										  
		return "cpmeracc/merchantDataEnteringSearchNew";
	}
	
	/**
	 * 场馆录入添加页面
	 * @param cpMeracc
	 * @param map
	 * @return
	 */
	@WebAction(Permission.VENUE_ENTRY_ADD)
	@RequestMapping(value = "/venueDataEntering_add")
	public String VenueListAdd(@ModelAttribute("cpMeracc") CpMeracc cpMeracc, Map<String, Object> map) {		
		List<CpBrchid> cpBrchIdList = cpMeraccService.getCpBrchIdList();		
		map.put("cpMeracc", new CpMeracc());
		map.put("cpBrchId", cpBrchIdList.get(0).getBrBranchId());
		map.put("cpMeracc", cpMeracc);
		return "cpmeracc/venueDataEnteringAdd";
	}
	
	/**
	 * 商户录入添加页面
	 * @param cpMeracc
	 * @param map
	 * @return
	 */
	@WebAction(Permission.MERACC_ENTRY_ADD)
	@RequestMapping(value = "/merchantDataEntering_add")
	public String MerchantListAdd(@ModelAttribute("cpMeracc") CpMeracc cpMeracc, Map<String, Object> map) {
		
		List<CpBrchid> cpBrchIdList = cpMeraccService.getCpBrchIdList();
		map.put("cpMeracc", new CpMeracc());
		map.put("cpBrchIdList", cpBrchIdList);
		map.put("cpMeracc", cpMeracc);
		return "cpmeracc/merchantDataEnteringAddNew";
	}
		
	/**
	 * 场馆录入添加提交
	 * @param cpMeracc
	 * @param ra
	 * @return
	 */
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
		Result<CpMeracc> r = cpMeraccService.insertVenue(cpMeracc);		
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			ra.addFlashAttribute("cpMeracc",cpMeracc);
			return "redirect:/cpmeracc/venueDataEntering_add";
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, r.getComment());
		return "redirect:/cpmeracc/venueDataEntering";
	}
	
	/**
	 * 商户录入添加提交
	 * @param cpMeracc
	 * @param ra
	 * @return
	 */
	@WebAction(Permission.MERACC_ENTRY_ADD)
	@RequestMapping(value = "/submitForMerchantEnteringAdd")
	public String MerchantListAddSubmit(CpMeracc cpMeracc, RedirectAttributes ra){
		
		TSysStaff currentStaff = WebContext.getCurrentStaff();
		String currentStaffId = currentStaff.getId();
		String currentStaffPassword = currentStaff.getPassword();
		cpMeracc.setMmModUser(currentStaffId);
		cpMeracc.setMmPassword(currentStaffPassword);
		Result<CpMeracc> r = cpMeraccService.insertMerchant(cpMeracc);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			ra.addFlashAttribute("cpMeracc",cpMeracc);
			return "redirect:/cpmeracc/merchantDataEntering_add";
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, r.getComment());
		return "redirect:/cpmeracc/merchantDataEntering";
	}
	
	/**
	 * 场馆录入修改页面
	 * @param merchantNo
	 * @param map
	 * @return
	 */
	@WebAction(Permission.VENUE_ENTRY_UPDATE)
	@RequestMapping(value="/venueDataEntering_update/{merchantNo}")
	public String updateVenue(@PathVariable("merchantNo") String merchantNo,Map<String,Object> map){
		
		List<CpBrchid> cpBrchIdList = cpMeraccService.getCpBrchIdList();
		CpMeracc meraccDto = cpMeraccService.getMerchantById(merchantNo);
		
		map.put("cpMeracc", meraccDto);
		map.put("cpBrchIdList", cpBrchIdList);
		map.put("mmOldAccNumber", meraccDto.getMmOldAccNumber());
		map.put("mmChainAccno", meraccDto.getMmChainAccno());
		return "cpmeracc/venueDataEnteringAdd_update";
	}
		
	/**
	 * 商户录入修改页面
	 * @param merchantNo
	 * @param map
	 * @return
	 */
	@WebAction(Permission.MERACC_ENTRY_UPDATE)
	@RequestMapping(value="/merchantDataEntering_update/{merchantNo}")
	public String updateMerchant(@PathVariable("merchantNo") String merchantNo,Map<String,Object> map){		
		List<CpBrchid> cpBrchIdList = cpMeraccService.getCpBrchIdList();
		CpMeracc cpMeracc = cpMeraccService.getMerchantById(merchantNo);
		map.put("cpMeracc", cpMeracc);
		map.put("cpBrchIdList", cpBrchIdList);
		map.put("cpBrchIdList", cpBrchIdList);
		map.put("mmOldAccNumber", cpMeracc.getMmOldAccNumber());
		map.put("mmChainAccno", cpMeracc.getMmChainAccno());
		return "cpmeracc/merchantDataEnteringUpdateNew";
	}
	
	/**
	 * 场馆录入更新
	 * @param cpMeracc
	 * @param ra
	 * @return
	 */
	@WebAction(Permission.VENUE_ENTRY_UPDATE)
	@RequestMapping(value = "/submitForVenueEnteringUpdate")
	public String submitForVenueEnteringUpdate(CpMeracc cpMeracc, RedirectAttributes ra) {

		TSysStaff currentStaff = WebContext.getCurrentStaff();
		String currentStaffId = currentStaff.getId();
		String currentStaffPassword = currentStaff.getPassword();
		cpMeracc.setMmModUser(currentStaffId);
		cpMeracc.setMmPassword(currentStaffPassword);

		Result<CpMeracc> r = cpMeraccService.updateMerchant(cpMeracc);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			Object mmMerchantNo = cpMeracc.getMmMerchantNo();
			return "redirect:/cpmeracc/venueDataEntering_update/" + mmMerchantNo;
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, r.getComment());
		return "redirect:/cpmeracc/venueDataEntering";
	}
	
	/**
	 * 商户录入更新
	 * @param cpMeracc
	 * @param ra
	 * @return
	 */
	@WebAction(Permission.VENUE_ENTRY_UPDATE)
	@RequestMapping(value = "/submitForMerchantEnteringUpdate")
	public String submitForMerchantEnteringUpdate(CpMeracc cpMeracc,RedirectAttributes ra){
		TSysStaff currentStaff = WebContext.getCurrentStaff();
		String currentStaffId = currentStaff.getId();
		String currentStaffPassword = currentStaff.getPassword();
		cpMeracc.setMmModUser(currentStaffId);
		cpMeracc.setMmPassword(currentStaffPassword);
		Result<CpMeracc> r = cpMeraccService.updateMerchant(cpMeracc);
		if(r.isError()){
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			Object mmMerchantNo = cpMeracc.getMmMerchantNo();
			return "redirect:/cpmeracc/merchantDataEntering_update/"+mmMerchantNo;
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, r.getComment());
		return "redirect:/cpmeracc/merchantDataEntering";
	}
	
	/**
	 * 场馆录入删除
	 * @param merchantNo
	 * @param ra
	 * @return
	 */
	@WebAction(Permission.VENUE_ENTRY_DELETE)
	@RequestMapping(value="/venueDataEntering_del/{merchantNo}")
	public String delVenue(@PathVariable("merchantNo") String merchantNo,RedirectAttributes ra){
		
		CpMeracc meracc = cpMeraccService.getMerchantById(merchantNo);
		meracc.setMmRiskStatus("0");
		Result<CpMeracc> r = cpMeraccService.deleteMerchant(meracc);
		if(r.isError()){
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/cpmeracc/venueDataEntering";
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, r.getComment());
		return "redirect:/cpmeracc/venueDataEntering";
	}
	
	/**
	 * 商户录入删除
	 * @param merchantNo
	 * @param ra
	 * @return
	 */
	@WebAction(Permission.MERACC_ENTRY_DELETE)
	@RequestMapping(value="/merchantDataEntering_del/{merchantNo}")
	public String delMerchant(@PathVariable("merchantNo") String merchantNo,RedirectAttributes ra){
		
		CpMeracc meracc = cpMeraccService.getMerchantById(merchantNo);
		meracc.setMmRiskStatus("0");
		Result<CpMeracc> r = cpMeraccService.deleteMerchant1(meracc);
		if(r.isError()){
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/cpmeracc/merchantDataEntering";
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, r.getComment());
		return "redirect:/cpmeracc/merchantDataEntering";
	}
	
	/**
	 * 场馆录入授权查询是否同一用户
	 * @param merchantNo
	 * @return
	 */
	@WebAction(Permission.VENUE_ENTRY_AUTH)
	@ResponseBody
	@RequestMapping(value = "/getCurrentStaffId1",method=RequestMethod.POST)
	public String getCurrentStaffId1(String merchantNo) {
		
		CpMeracc cpMeracc = cpMeraccService.getMerchantById(merchantNo);
		String currentStaffId = cpMeracc.getMmModUser();
		return currentStaffId;
	}
	
	/**
	 * 商户录入授权查询是否同一用户
	 * @param merchantNo
	 * @return
	 */
	@WebAction(Permission.MERACC_ENTRY_AUTH)
	@ResponseBody
	@RequestMapping(value = "/getCurrentStaffId",method=RequestMethod.POST)
	public String getCurrentStaffId(String merchantNo) {
		
		CpMeracc cpMeracc = cpMeraccService.getMerchantById(merchantNo);
		String currentStaffId = cpMeracc.getMmModUser();
		return currentStaffId;
	}
	
	/**
	 * 场馆录入授权提交
	 * @param merchantNo
	 * @param ra
	 * @return
	 */
	@WebAction(Permission.VENUE_ENTRY_AUTH)
	@RequestMapping(value = "/venueDataEntering_authorize/{merchantNo}")
	public String doAuthorize1(@PathVariable("merchantNo") String merchantNo, RedirectAttributes ra) {

		CpMeracc meracc = cpMeraccService.getMerchantById(merchantNo);
		Result<CpMeracc> r = cpMeraccService.doAuthorize1(merchantNo,meracc);
		if(r.isError()){
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/cpmeracc/venueDataEntering";
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, r.getComment());
		return "redirect:/cpmeracc/venueDataEntering";
	}
	
	//商户录入授权提交
	@WebAction(Permission.MERACC_ENTRY_AUTH)
	@RequestMapping(value = "/merchantDataEntering_authorize/{merchantNo}")
	public String doAuthorize(@PathVariable("merchantNo") String merchantNo, RedirectAttributes ra) {
		CpMeracc meracc = cpMeraccService.getMerchantById(merchantNo);		
		Result<CpMeracc> r = cpMeraccService.doAuthorize(merchantNo,meracc);
		if(r.isError()){
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/cpmeracc/merchantDataEntering";
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, r.getComment());
		return "redirect:/cpmeracc/merchantDataEntering";
	}
	
	//选择场馆等级 - 跳动归属场馆
	@ResponseBody
	@RequestMapping(value = "/search_mermst_Data", method = RequestMethod.POST)
	public StatusResult<List<CpMermst>> searchMermstData(String mmPmtMode) {
		
		List<CpMermst> mermstList = cpMeraccService.getCpMermstList(mmPmtMode);
		return StatusResult.create(mermstList);
	}
	/* 商户选择场馆列表
	 * @param mmPmtMode
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/search_mermst_Data_by_mode", method = RequestMethod.POST)
	public StatusResult<List<CpMermst>> searchMermstDataByMode(String mmPmtMode) {
		List<CpMermst> mermstList = cpMeraccService.getCpMermstListByMode(mmPmtMode);
		return StatusResult.create(mermstList);
	}		  
	
	
	
}