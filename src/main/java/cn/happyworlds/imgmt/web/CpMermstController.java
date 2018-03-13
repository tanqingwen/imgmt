package cn.happyworlds.imgmt.web;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpActpcd;
import cn.happyworlds.imgmt.entity.CpBrchid;
import cn.happyworlds.imgmt.entity.CpMermst;
import cn.happyworlds.imgmt.entity.CpMerupd;
import cn.happyworlds.imgmt.entity.CpTrmmst;
import cn.happyworlds.imgmt.entity.TSysStaff;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.service.CpMermstService;
import cn.happyworlds.imgmt.service.MerchantService;
import cn.happyworlds.imgmt.service.StaffService;
import cn.happyworlds.imgmt.util.Result;
import cn.happyworlds.imgmt.util.StatusResult;

@Controller
@RequestMapping("/cpmermst")
public class CpMermstController {
	
	@Autowired
	private CpMermstService cpMermstService;
	@Autowired
	private MerchantService merchantService;
	@Autowired
	private StaffService staffService;  
	
	/**
	 * 场馆查询列表
	 * @param p
	 * @param map
	 * @param session
	 * @return
	 */
	@WebAction(Permission.VENUE_LIST)
	@RequestMapping(value = "/venuePreserve")
	public String toSearchPage1(String mmMerchantNo,String mmDbaName,String mmBizName,String mmPmtMode, Integer p,
			Map<String,Object> map,HttpSession session) {
		
		Result<PageInfo<CpMermst>> result = cpMermstService.venueList(mmMerchantNo, mmDbaName, mmBizName, mmPmtMode,new PageBounds(p, 10));
		map.put("pageInfo", result.getValue());
		return "cpmermst/venuePreserve_page";
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

		return "cpmermst/venuePreserve_page";
	}
	
	// 场馆维护页面
	@WebAction(Permission.VENUE_MAINTAIN_LIST)
	@RequestMapping(value = "/vmerupdPreserve")
	public String vmerupdPreserve() {
		return "cpmermst/vmerupd_page";
	}
	
	//场馆维护根据条件查询mermst
	@RequestMapping(value = "/searchVmermstResultList", method = { RequestMethod.POST, RequestMethod.GET })
	public String searchVmermstResultList(String mmMerchantNo, String mmBizName, Integer p, Map<String, Object> map,
			HttpSession session) {

		Result<PageInfo<CpMermst>> result = cpMermstService.venueMermstList(mmMerchantNo, mmBizName,
				new PageBounds(p, 10));

		map.put("mmMerchantNo", mmMerchantNo);
		map.put("mmBizName", mmBizName);
		map.put("pageInfo", result.getValue());

		return "cpmermst/vmermstPreserve_page";
	}
	
	//场馆维护更新
	@WebAction(Permission.VENUE_MAINTAIN_UPDATE)
	@RequestMapping(value = "/vmermstPreserve_update/{merchantNo}")
	public String vmermstPreserve_update(@PathVariable("merchantNo") String merchantNo, Map<String, Object> map) {

		List<CpBrchid> cpBrchIdList = cpMermstService.getCpBrchIdList();
		List<CpActpcd> cpActpcdList = cpMermstService.getCpActpcdList();

		CpMermst mermstDto = cpMermstService.getCpMermstById(merchantNo);
		map.put("cpMermst", mermstDto);
		map.put("cpBrchIdList", cpBrchIdList);
		map.put("cpActpcdList", cpActpcdList);
		map.put("mmOldAccNumber", mermstDto.getMmOldAccNumber());
		map.put("mmPmtMode", mermstDto.getMmPmtMode());										
		return "cpmermst/vmermstPreserve_update";
	}
	
	//场馆维护更新插入或者更新merupd表
	@WebAction(Permission.VENUE_MAINTAIN_UPDATE)
	@RequestMapping(value = "/submitForVenuePreserver_update", method = RequestMethod.POST)
	public String submitForVenuePreserver_update(CpMermst cpMermst, RedirectAttributes ra) throws IllegalAccessException, InvocationTargetException {

		TSysStaff currentStaff = WebContext.getCurrentStaff();
		String currentStaffId = currentStaff.getId();
		String currentStaffPassword = currentStaff.getPassword();
		cpMermst.setMmModUser(currentStaffId);
		cpMermst.setMmPassword(currentStaffPassword);

		CpMerupd merupd = new CpMerupd();
		BeanUtils.copyProperties(merupd, cpMermst);

		CpMerupd oldMerupd = cpMermstService.findMerupd(cpMermst.getMmMerchantNo());
		merupd.setMmRiskStatus("1");
		if (null != oldMerupd) {
			Result<CpMerupd> r = cpMermstService.updateMerupd(merupd);
			if (r.isError()) {
				ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
				return "redirect:/cpmermst/searchVmermstResultList";
			}
			ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, r.getComment());
		} else {
			cpMermstService.insertMerupd(merupd);
			ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "场馆维护插入失败");
		}
		return "redirect:/cpmermst/searchVmermstResultList";
	}
	
	//场馆维护待授权页面
	@RequestMapping(value = "/searchVmermstWaitAuth", method = { RequestMethod.POST, RequestMethod.GET })
	public String searchVmermstWaitAuth(String mmMerchantNo, String mmBizName, Integer p, Map<String, Object> map) {

		TSysStaff currentStaff = WebContext.getCurrentStaff();
		String currentStaffId = currentStaff.getId();
		
		Result<PageInfo<CpMerupd>> result = cpMermstService.venueMerupdAuthList(mmMerchantNo, mmBizName,
				new PageBounds(p, 10));
		map.put("mmMerchantNo", mmMerchantNo);
		map.put("mmBizName", mmBizName);
		map.put("pageInfo", result.getValue());
		map.put("currentStaffId", currentStaffId);

		return "cpmermst/vmerupdPreserve_page";
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
		
		return "cpmermst/merchantPreserve_page";
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
	
	
	
	
	//场馆维护待授权详情页面
	@WebAction(Permission.VENUE_MAINTAIN_SHOW)
	@RequestMapping(value = "/vmerupdPreserve_search/{merchantNo}")
	public String vmerupdPreserve_search(@PathVariable("merchantNo") String merchantNo, Map<String, Object> map) {

		List<CpBrchid> cpBrchIdList = cpMermstService.getCpBrchIdList();

		CpMerupd merupdDto = cpMermstService.getMerupdById(merchantNo);
		map.put("merchantNo", merchantNo);
		map.put("cpBrchIdList", cpBrchIdList);
		map.put("cpMerupd", merupdDto);
		map.put("mmOldAccNumber", merupdDto.getMmOldAccNumber());
		return "cpmermst/venueMerupd_search";
	}
	
	//查找是否为当前用户录入
	@WebAction(Permission.VENUE_MAINTAIN_AUTH)
	@ResponseBody
	@RequestMapping(value = "/getCurrentVenueStaffId", method = RequestMethod.POST)
	public String getCurrentVenueStaffId(String merchantNo) {
		CpMerupd merupd = cpMermstService.getMerupdById(merchantNo);
		String currentStaffId = merupd.getMmModUser();
		return currentStaffId;
	}
	
	
	//场馆维护授权
	@WebAction(Permission.VENUE_MAINTAIN_AUTH)
	@RequestMapping(value = "/venueDataMerupdEntering_authorize/{merchantNo}")
	public String doAuthorizeVenueMerupd(@PathVariable("merchantNo") String merchantNo, RedirectAttributes ra) {

		CpMerupd merupd = cpMermstService.getMerupdById(merchantNo);
		Result<CpMerupd> r = cpMermstService.doAuthorizeVenue(merchantNo, merupd);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/cpmermst/searchVmermstWaitAuth?mmMerchantNo=" + merchantNo;
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, r.getComment());
		//return "redirect:/staff/searchVmermstWaitAuth?mmMerchantNo=" + merchantNo;
		return "redirect:/cpmermst/searchVmermstWaitAuth";
	}
	
	//商户场馆授权后查询列表
	@WebAction(Permission.MERMST_LIST)
	@RequestMapping(value = "/merchantPreserve")
	public String toSearchPage(String mmMerchantNo,String mmDbaName,String mmBizName,String mmChainAccno,String mmPmtMode,Integer p,
			Map<String,Object> map,HttpSession session) {
		Result<PageInfo<CpMermst>> result = cpMermstService.merchantList1(mmMerchantNo, mmDbaName, mmBizName, mmChainAccno,new PageBounds(p, 10));
		map.put("pageInfo", result.getValue());
		map.put("mmPmtMode", mmPmtMode);				
		return "cpmermst/merchantPreserve_page";
	}
	
	//商户授权后查看
	@WebAction(Permission.MERMST_SHOW)
	@RequestMapping(value="/merchantPreserve_view/{merchantNo}")
	public String searchMermst(@PathVariable("merchantNo") String merchantNo,Map<String,Object> map){
		
		List<CpBrchid> cpBrchIdList = cpMermstService.getCpBrchIdList();
		CpMermst cpMermst = cpMermstService.getCpMermstById(merchantNo);
		map.put("cpMermst", cpMermstService.getCpMermstById(merchantNo));
		map.put("cpBrchIdList", cpBrchIdList);
		map.put("mmChainAccno",cpMermst.getMmChainAccno());
		map.put("mmOldAccNumber",cpMermst.getMmOldAccNumber());
		return "cpmermst/merchantPreserve_search";
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
		return "cpmermst/gatePreserve_all";
	}
	
	//商户授权后下边终端
	@WebAction(Permission.MERMST_TERMINAL_LIST)
	@RequestMapping(value="/trmmstPreserve_view/{merchantNo}")
	public String searchTrmmst(@PathVariable("merchantNo") String merchantNo,Integer p,Map<String,Object> map){
		
		CpMermst mermst = cpMermstService.getCpMermstById(merchantNo);
		map.put("mmMerchantNo", mermst.getMmMerchantNo());
		map.put("mmBizName", mermst.getMmBizName());
		
		Result<PageInfo<CpTrmmst>> result = cpMermstService.getTrmmstList(merchantNo,new PageBounds(p, 10));
		List<CpBrchid> cpBrchIdList = cpMermstService.getCpBrchIdList();
		
		map.put("pageInfo", result.getValue());
		map.put("cpBrchIdList", cpBrchIdList);
		return "cpmermst/mtrmmstPreserve_all";
	}
	
	//商户维护
	@WebAction(Permission.MERUPD_MAINTAIN_LIST)
	@RequestMapping(value = "/merupdPreserve")
	public String merupdPreserve() {
		return "cpmermst/merupd_page";
	}
	
	//商户维护查询页面
	@WebAction(Permission.MERUPD_MAINTAIN_SHOW)
	@RequestMapping(value = "/searchMermstResultList", method = { RequestMethod.POST, RequestMethod.GET })
	public String searchMermstResultList(String mmMerchantNo, String mmBizName, Integer p, Map<String, Object> map,
			HttpSession session) {

		Result<PageInfo<CpMermst>> result = cpMermstService.mermstList(mmMerchantNo, mmBizName,
				new PageBounds(p, 10));

		map.put("mmMerchantNo", mmMerchantNo);
		map.put("mmBizName", mmBizName);
		map.put("pageInfo", result.getValue());

		return "cpmermst/mermstPreserve_page";
	}
	
	//商户维护更新页面
	@WebAction(Permission.MERUPD_MAINTAIN_UPDARE)
	@RequestMapping(value = "/mermstPreserve_update/{merchantNo}")
	public String mermstPreserve_update(@PathVariable("merchantNo") String merchantNo, Map<String, Object> map) {

		List<CpBrchid> cpBrchIdList = cpMermstService.getCpBrchIdList();
		List<CpActpcd> cpActpcdList = cpMermstService.getCpActpcdList();
		CpMermst cpMermst = cpMermstService.getCpMermstById(merchantNo);
		map.put("cpMermst", cpMermstService.getCpMermstById(merchantNo));
		map.put("cpBrchIdList", cpBrchIdList);
		map.put("cpActpcdList", cpActpcdList);
		map.put("mmPmtMode", cpMermst.getMmPmtMode());
		map.put("mmChainAccno", cpMermst.getMmChainAccno());									  
		return "cpmermst/mermstPreserve_update";
	}
	
	//商户维护更新插入或者更新merupd表
	@WebAction(Permission.MERUPD_MAINTAIN_UPDARE)
	@RequestMapping(value = "/submitForMerchantPreserver_update", method = RequestMethod.POST)
	public String submitForMerchantPreserver_update(CpMermst cpMermst, RedirectAttributes ra) throws IllegalAccessException, InvocationTargetException {

		TSysStaff currentStaff = WebContext.getCurrentStaff();
		String currentStaffId = currentStaff.getId();
		String currentStaffPassword = currentStaff.getPassword();
		cpMermst.setMmModUser(currentStaffId);
		cpMermst.setMmPassword(currentStaffPassword);

		CpMerupd merupd = new CpMerupd();
		BeanUtils.copyProperties(merupd, cpMermst);

		CpMerupd oldMerupd = cpMermstService.findMerupd(cpMermst.getMmMerchantNo());
		merupd.setMmRiskStatus("1");
		if (null != oldMerupd) {
			Result<CpMerupd> r = cpMermstService.updateMerupd(merupd);
			if (r.isError()) {
				ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
				return "redirect:/cpmermst/searchMermstResultList";
			}
			ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, r.getComment());
		} else {
			cpMermstService.insertMerupd(merupd);
			ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "商户维护插入失败");
		}
		return "redirect:/cpmermst/searchMermstResultList";
	}
	
	//商户维护待授权页面
	@WebAction(Permission.MERUPD_MAINTAIN_AUTHOH)
	@RequestMapping(value = "/searchMermstWaitAuth", method = { RequestMethod.POST, RequestMethod.GET })
	public String searchMermstWaitAuth(String mmMerchantNo, String mmBizName, Integer p, Map<String, Object> map) {

		TSysStaff currentStaff = WebContext.getCurrentStaff();
		String currentStaffId = currentStaff.getId();
		
		Result<PageInfo<CpMerupd>> result = cpMermstService.merupdAuthList(mmMerchantNo, mmBizName,
				new PageBounds(p, 10));
		System.out.println("+++++++++"+result.getValue().getSize());
		map.put("mmMerchantNo", mmMerchantNo);
		map.put("mmBizName", mmBizName);
		map.put("pageInfo", result.getValue());
		map.put("currentStaffId", currentStaffId);

		return "cpmermst/merupdPreserve_page";
	}
	
	//商户维护待授权查看详情页面
	@WebAction(Permission.MERUPD_MAINTAIN_SHOW)
	@RequestMapping(value = "/merupdPreserve_search/{merchantNo}")
	public String merupdPreserve_search(@PathVariable("merchantNo") String merchantNo, Map<String, Object> map) {

		List<CpBrchid> cpBrchIdList = cpMermstService.getCpBrchIdList();

		map.put("merchantNo", merchantNo);
		map.put("cpMerupd", cpMermstService.getMerupdById(merchantNo));
		map.put("cpBrchIdList", cpBrchIdList);
		return "cpmermst/merupd_search";
	}
	
	//商户维护待授权查询是否为当前用户录入
	@WebAction(Permission.MERUPD_MAINTAIN_SHOW)
	@ResponseBody
	@RequestMapping(value = "/getCurrentMerupdStaffId", method = RequestMethod.POST)
	public String getCurrentMerupdStaffId(String merchantNo) {

		CpMerupd merupd = cpMermstService.getMerupdById(merchantNo);
		String currentStaffId = merupd.getMmModUser();
		return currentStaffId;
	}

	
	@ResponseBody
	@RequestMapping(value = "/search_mermst_Data1", method = RequestMethod.POST)
	public StatusResult<List<CpMermst>> searchMermstData1(String mmPmtMode) {		
		List<CpMermst> mermstList = cpMermstService.getCpMermstList1(mmPmtMode);
		return StatusResult.create(mermstList);
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
		return "cpmermst/venuePreserve_search";
	}
	
}