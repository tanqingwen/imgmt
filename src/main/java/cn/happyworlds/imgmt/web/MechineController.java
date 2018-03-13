package cn.happyworlds.imgmt.web;

import java.lang.reflect.InvocationTargetException;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpGateip;
import cn.happyworlds.imgmt.entity.CpMermst;
import cn.happyworlds.imgmt.entity.CpPosprm;
import cn.happyworlds.imgmt.entity.CpTrmacc;
import cn.happyworlds.imgmt.entity.CpTrmmst;
import cn.happyworlds.imgmt.entity.TSysStaff;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.service.MachineService;
import cn.happyworlds.imgmt.util.Result;

/**
 * @author Hugh
 *  
 * 2017-02-07
 */
@Controller
@RequestMapping("/machine")
public class MechineController {
	
	@Autowired
	private MachineService machineService;
	
	
	
	/**
	 * 场馆管理-闸机列表-添加
	 * 
	 * @author Hugh
	 */
	@WebAction(Permission.TRMMST_GATE_ADD)
	@RequestMapping(value = "/addUI/{merchantId}")
	public String addUI(@PathVariable("merchantId") String id, Map<String, Object> map, Model m) {

		//场馆等级
		CpMermst mermstDto = machineService.getMermstDto(id);
		
		// 初始化品牌
		List<CpPosprm> cpPosprmList = machineService.cpPosprmToppBrand();

		// 初始化闸机IP
		List<CpGateip> gateIpList = machineService.cpGateIpList();

		// 根据场馆号查询场馆名称
		CpMermst mermst = machineService.searchCpMermstByMmMerchantNo(id);

		// 闸机ID获取最大值
		CpTrmacc trmacc = machineService.searchMaxGateTrmaccTerminalId();
		CpTrmmst trmmst = machineService.searchMaxGateTrmmstTerminalId();

		String tmTerminalId = "";
		if (trmmst.getTmTerminalId().compareTo(trmacc.getTmTerminalId()) > 0) {
			tmTerminalId = trmmst.getTmTerminalId().trim();
		} else {
			tmTerminalId = trmacc.getTmTerminalId().trim();
		}

		m.addAttribute("merchantId", id);
		m.addAttribute("mmPmtMode", mermstDto.getMmPmtMode());	//场馆等级
		m.addAttribute("tmTerminalId", tmTerminalId);
		m.addAttribute("mm_biz_name", mermst.getMmBizName()); // 场馆名称
		m.addAttribute("mm_phy_state", mermst.getMmPhyState()); // 商户|场馆 == 1|0
		map.put("cpPosprmList", cpPosprmList);
		map.put("cpTrmmst", new CpTrmmst());
		map.put("gateIpList", gateIpList);

		return "machine/addUI";
	}
	
	
	/**
	 * 闸机管理-场馆列表-添加实现
	 *
	 * @author Hugh
	 */
	@WebAction(Permission.TRMMST_GATE_ADD)
	@RequestMapping("/add")
	public String add(CpTrmacc cpTrmacc, RedirectAttributes ra, Integer p, Model m, Map<String, Object> map) {

		TSysStaff currentStaff = WebContext.getCurrentStaff();
		String currentStaffId = currentStaff.getId();

		Date sysDate = new Date();
		SimpleDateFormat formatSysDate = new SimpleDateFormat("yyyyMMdd hhdd");

		String dateInst = cpTrmacc.getTmDateInst().replace("-", "");
		cpTrmacc.setTmDateInst(dateInst);
		System.out.println("-------------------" + dateInst + "+-----");
		cpTrmacc.setTmSetupUser(currentStaffId);
		cpTrmacc.setTmApplStatus("A");
		// 录入时间
		cpTrmacc.setTmSetupTimestamp(formatSysDate.format(sysDate));

		// 插入终端闸机记录
		Long l = machineService.insertCpTrmacc(cpTrmacc);
		if (l != 1) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, "添加失败");
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "添加成功");

		// 分配闸机IP，对闸机IP表处理
		CpGateip gateipDto = machineService.getGateIpDto(cpTrmacc.getTmHostSerial());
		gateipDto.setGaTm(cpTrmacc.getTmTerminalId()); // 更新闸机ID
		gateipDto.setGaState(0);
		Result<CpGateip> r = machineService.update(gateipDto);
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "更新出现异常");
		}

		// 查询列表
		Result<PageInfo<CpTrmacc>> trmmacc = machineService.cpTrmaccList(cpTrmacc.getTmMerchantId(), null,
				new PageBounds(p, 8));
		if (trmmacc.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("pageInfo", trmmacc.getValue());
		}

		map.put("currentStaffId", currentStaffId);
		m.addAttribute("merchantId", cpTrmacc.getTmMerchantId());

		return "/machine/unexamineList";
	}
	
	
	
	/**
	 * 闸机管理-待复核列表
	 * 
	 * @author Hugh
	 */
	@WebAction(Permission.TRMMST_GATE_LIST)
	@RequestMapping("/unexamineList/{merchantId}")
	public String unexamineList(@PathVariable("merchantId") String id, HttpServletRequest request, Integer p, Model m,
			Map<String, Object> map) {
		
		Condition(request, m);
		String tm_merchant_id = request.getParameter("tm_merchant_id");
		String tm_terminal_id = request.getParameter("tm_terminal_id");
		if (null == tm_merchant_id || "".equals(tm_merchant_id)) {
			tm_merchant_id = id;
		}

		Result<PageInfo<CpTrmacc>> trmmacc = machineService.cpTrmaccList(tm_merchant_id, tm_terminal_id,
				new PageBounds(p, 8));
		if (trmmacc.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("pageInfo", trmmacc.getValue());
		}

		TSysStaff currentStaff = WebContext.getCurrentStaff();
		String currentStaffId = currentStaff.getId();

		map.put("currentStaffId", currentStaffId);
		m.addAttribute("merchantId", id);
		return "/machine/unexamineList";
	}
	
	
	@WebAction(Permission.TRMMST_GATE_LIST)
	@RequestMapping(value = "/unexamineList1", method = { RequestMethod.POST, RequestMethod.GET })
	public String searchVenueResultList1(String tm_merchant_id, String tm_terminal_id, Integer p,
			Map<String, Object> map, Model m, HttpSession session) {

		Result<PageInfo<CpTrmacc>> trmmacc = machineService.cpTrmaccList(tm_merchant_id, tm_terminal_id,
				new PageBounds(p, 8));
		if (trmmacc.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("pageInfo", trmmacc.getValue());
		}

		TSysStaff currentStaff = WebContext.getCurrentStaff();
		String currentStaffId = currentStaff.getId();

		map.put("currentStaffId", currentStaffId);
		m.addAttribute("merchantId", tm_merchant_id);
		return "/machine/unexamineList";
	}
	
	
	
	/**
	 * 闸机更新
	 * 
	 * @author Hugh
	 */
	@WebAction(Permission.TRMMST_GATE_UPDATE)
	@RequestMapping("/updateUI/{machineNo}")
	public String updateUI(@PathVariable("machineNo") String id, Model m) {

				
		List<CpPosprm> cpPosprmList = machineService.cpPosprmToppBrand();
		Result<CpTrmmst> r = machineService.cpTrmmstGetById(id);

		//场馆等级
		CpMermst mermstDto = machineService.getMermstDto(r.getValue().getTmMerchantId());

		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/machine/list";
		}

		if (null != r.getValue().getTmDateInst()) {
			StringBuffer sb = new StringBuffer(r.getValue().getTmDateInst());
			sb.insert(4, "-");
			sb.insert(7, "-");
			String a = sb.toString();
			r.getValue().setTmDateInst(a);
		}
		
		m.addAttribute("mmPmtMode", mermstDto.getMmPmtMode());	//场馆等级
		m.addAttribute("item", r.getValue());
		m.addAttribute("cpPosprmList", cpPosprmList);
		m.addAttribute("merchantId", r.getValue().getTmMerchantId());
		return "machine/update";
	}
	
	
	/**
	 * 闸机更新-实现
	 * 
	 * @author Hugh
	 */
	@WebAction(Permission.TRMMST_GATE_UPDATE)
	@RequestMapping(value = "/update")
	public String update(CpTrmacc cpTrmacc, RedirectAttributes ra) {

		TSysStaff currentStaff = WebContext.getCurrentStaff();
		String currentStaffId = currentStaff.getId();
		String dateInst = cpTrmacc.getTmDateInst().replace("-", "");

		Result<CpTrmmst> r = machineService.cpTrmmstGetById(cpTrmacc.getTmTerminalId());

		
		System.out.println("cpTrmacc： " +cpTrmacc.getTmStatus());
		cpTrmacc.setTmSetupUser(currentStaffId);
		cpTrmacc.setTmDateInst(dateInst); // 安装日期
		cpTrmacc.setTmApplStatus("U");

		// 修改:cp_trmacc
		Result<CpTrmacc> r1 = machineService.updateGate(cpTrmacc);
		System.out.println("r1: " +r1.getValue().getTmStatus());
		if (r1.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r1.getComment());
			return "redirect:/machine/list";
		}

		// 修改:cp_trmmst
		Result<CpTrmmst> r2 = machineService.updateGateTrmmst(r.getValue());

		if (r2.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r2.getComment());
			return "redirect:/machine/list";
		}

		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "闸机更新成功");
		return "redirect:/machine/gaunexamineList?tm_merchant_id="+r.getValue().getTmMerchantId();
	}
	
	
	/**
	 * 闸机详情
	 * 
	 * @author Hugh
	 */
	@WebAction(Permission.TRMMST_GATE_SHOW)
	@RequestMapping("/show/{machineNo}")
	public String show(@PathVariable("machineNo") String id, Model m) {
		
		Result<CpTrmmst> r = machineService.cpTrmmstGetById(id);
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/trmmstgate/list";
		}
		StringBuffer sb = new StringBuffer(r.getValue().getTmDateInst());
		sb.insert(4, "-");
		sb.insert(7, "-");
		String a = sb.toString();
		r.getValue().setTmDateInst(a);
		m.addAttribute("item", r.getValue());
		m.addAttribute("merchantId", r.getValue().getTmMerchantId());
		return "machine/show";
	}
		
	
	/**
	 * 闸机删除
	 * 
	 * @author Hugh
	 */
	@WebAction(Permission.TRMMST_GATE_DELETE)
	@RequestMapping("/delete/{machineNo}")
	public String delete(@PathVariable("machineNo") String id, Model m ,RedirectAttributes ra) {
		
		//查询闸机对象
		CpTrmmst trmmstDto = machineService.trmmstDto(id);
		Long r = machineService.delete(id);
		if (r < 0) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, "更新失败");
			return "redirect:/machine/viewGatelist?machineNo="+trmmstDto.getTmMerchantId();
		} else {
			ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "更新成功");
		}
		return "redirect:/machine/viewGatelist?machineNo="+trmmstDto.getTmMerchantId();
		
	}
	
	
	private void Condition(HttpServletRequest request, Model model) {
		String paras[] = { "tm_merchant_id", "tm_terminal_id" };
		for (int i = 0; i < paras.length; i++) {
			model.addAttribute(paras[i], request.getParameter(paras[i]));
		}
	}
	
	
	// 闸机列表-查询按钮
	@WebAction(Permission.TRMMST_GATE_LIST)
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Integer p, Model m) {

		Condition(request, m);
		String tm_merchant_id = request.getParameter("tm_merchant_id");
		String tm_terminal_id = request.getParameter("tm_terminal_id");
		Result<PageInfo<CpTrmmst>> trmmst = machineService.trmOneList(tm_merchant_id, tm_terminal_id,
				new PageBounds(p, 8));

		if (trmmst.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("merchantId", tm_merchant_id);
			m.addAttribute("tmTerminalId", tm_terminal_id);
			m.addAttribute("pageInfo", trmmst.getValue());
		}
		return "machine/list";
	}
	
	
	
	/**
	 *添加验证
	 */
	@ResponseBody
	@RequestMapping(value = "/getMachineByNo",method=RequestMethod.POST)
	public String getMachineByNo(String machineNo){
		return machineService.addMachineValidate(machineNo);
	}
	
	
	
	/**
	 * 获取当前闸机添加者
	 * 
	 * @author Hugh
	 */
	@ResponseBody
	@RequestMapping(value = "/getMachineSetUser",method=RequestMethod.POST)
	public String getMachineSetUser(String machineNo){
		CpTrmacc  cpTrmacc =machineService.getCpTrmaccGetById(machineNo);
		String setUser = cpTrmacc.getTmSetupUser();
		return setUser;
	}
	
	
	/**
	 * 闸机管理-待复核列表
	 * 
	 * @param 闸机编号
	 * 
	 * @author Hugh
	 */
	@WebAction(Permission.TRMMST_GATE_VIEW)
	@RequestMapping("/unexamineshow/{machineNo}")
	public String unexamineshow(@PathVariable("machineNo") String id, Model m) {

		Result<CpTrmacc> r = machineService.cpTrmaccGetById(id);
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/machine/unexamineList";
		}
		if (null != r.getValue().getTmDateInst()) {
			StringBuffer sb = new StringBuffer(r.getValue().getTmDateInst());
			sb.insert(4, "-");
			sb.insert(7, "-");
			String a = sb.toString();
			r.getValue().setTmDateInst(a);
		}

		// 根据场馆号查询商户名称
		CpMermst mermst = machineService.searchCpMermstByMmMerchantNo(r.getValue().getTmMerchantId());

		m.addAttribute("mm_biz_name", mermst.getMmBizName()); // 商户场馆名称
		m.addAttribute("mm_phy_state", mermst.getMmPhyState()); // 商户|场馆 == 1|0
		m.addAttribute("item", r.getValue());
		m.addAttribute("merchantId", r.getValue().getTmMerchantId());
		return "machine/unexamineshow";
	}
	
	
	/**
	 * 闸机管理-待复核列表-复核
	 * 
	 * @param 闸机编号
	 * @author Hugh
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@WebAction(Permission.TRMMST_GATE_UPDATE)
	@RequestMapping("/examine/{machineNo}")
	public String examine(@PathVariable("machineNo") String id, Integer p, Model m) throws IllegalAccessException, InvocationTargetException {

		// 根据闸机编号找到商户场馆号
		Result<CpTrmacc> r = machineService.cpTrmaccGetById(id);
		String tm_merchantId = r.getValue().getTmMerchantId();

		TSysStaff currentStaff = WebContext.getCurrentStaff();
		String currentStaffId = currentStaff.getId();

		// 复核
		machineService.examine(id, currentStaffId);

		// 根据商户场馆号找到对应下边所有终端闸机未授权
		Result<PageInfo<CpTrmacc>> trmmacc = machineService.cpTrmaccList(tm_merchantId, null, new PageBounds(p, 8));
		if (trmmacc.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("pageInfo", trmmacc.getValue());
		}
		return "redirect:/machine/viewTrmmstGlist?machineNo="+tm_merchantId;
	}

	
	/**
	 * 闸机管理-待复核列表-删除
	 * 
	 * @param 闸机编号
	 * 
	 * @author Hugh
	 * 
	 */
	@WebAction(Permission.TRMMST_GATE_DELETE)
	@RequestMapping("/unexamineDelete/{machineNo}")
	public String unexamineDelete(@PathVariable("machineNo") String id, Integer p, Model m) {

		// 根据终端闸机ID找到商户场馆号
		Result<CpTrmacc> r = machineService.cpTrmaccGetById(id);
		String tm_merchantId = r.getValue().getTmMerchantId();

		// 删除终端
		machineService.unexamineDelete(id);

		// 根据商户场馆号找到对应下边所有终端闸机未授权
		Result<PageInfo<CpTrmacc>> trmmacc = machineService.cpTrmaccList(tm_merchantId, null, new PageBounds(p, 8));
		if (trmmacc.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("pageInfo", trmmacc.getValue());
		}
		m.addAttribute("merchantId", tm_merchantId);
		return "/machine/unexamineList";
	}
	
	
	/*****************************闸机管理-start****************************************/

	//闸机复核以后删除记录页面跳转处理
	@WebAction(Permission.VENUEALL_TRMMST_LIST)
	@RequestMapping("/viewGatelist")
	public String viewGatelist(Integer p, Model m,HttpServletRequest request) {
		
		String machineNo = request.getParameter("machineNo");
	
		Result<PageInfo<CpTrmmst>> trmmst = machineService.trmList(machineNo,new PageBounds(p, 8));
		if (trmmst.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
			return "redirect:/trmmstgate/viewlist";
		}
		
		m.addAttribute("merchantId", machineNo);
		m.addAttribute("pageInfo", trmmst.getValue());
		return "machine/list";
	}
	
	
	//闸机复核跳转页面处理
	@WebAction(Permission.VENUEALL_TRMMST_LIST)
	@RequestMapping(value = "/viewTrmmstGlist")
	public String viewTrmmstGlist(Integer p, Map<String,Object> map,HttpServletRequest request,HttpSession session,Model m) {
		
		String machineNo = request.getParameter("machineNo");
		Result<PageInfo<CpTrmmst>> trmmst = machineService.trmAllList(new PageBounds(p, 8));
		if (trmmst.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
			return "redirect:/trmmstgate/list";
		}
		
		m.addAttribute("merchantId", machineNo);
		m.addAttribute("pageInfo", trmmst.getValue());
		return "machine/list";
	}
	
	
	/**
	 * 闸机复核以后修改页面跳转处理
	 * 
	 * @author Hugh
	 */
	@WebAction(Permission.VENUEALL_TRMMST_LIST)
	@RequestMapping("/gaunexamineList")
	public String gaunexamineList(HttpServletRequest request, Integer p, Model m,
			Map<String, Object> map) {
		
		Condition(request, m);
		String tm_merchant_id = request.getParameter("tm_merchant_id");
		String tm_terminal_id = request.getParameter("tm_terminal_id");

		Result<PageInfo<CpTrmacc>> trmmacc = machineService.cpTrmaccList(tm_merchant_id, tm_terminal_id,
				new PageBounds(p, 8));
		if (trmmacc.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("pageInfo", trmmacc.getValue());
		}

		TSysStaff currentStaff = WebContext.getCurrentStaff();
		String currentStaffId = currentStaff.getId();

		map.put("currentStaffId", currentStaffId);
		m.addAttribute("merchantId", tm_merchant_id);
		return "/machine/unexamineList";
	}
	
	/*****************************闸机管理-end**************************************/
	/**
	 * 场馆管理-商户列表-终端列表-添加
	 * 
	 * @author Hugh
	 */
	@WebAction(Permission.VENUEALL_TRMMST_ADD)
	@RequestMapping(value = "/addTeUI/{merchantId}")
	public String addTeUI(@PathVariable("merchantId") String id, Map<String, Object> map, Model m) {

		// 初始化品牌
		List<CpPosprm> cpPosprmList = machineService.cpPosprmToppBrand();

		// 根据商户号查询商户名称
		CpMermst mermst = machineService.searchCpMermstByMmMerchantNo(id);

		// 终端编号获取最大值
		CpTrmacc trmacc = machineService.searchMaxTrmaccTerminalId();
		CpTrmmst trmmst = machineService.searchMaxTrmmstTerminalId();

		String tmTerminalId = "";
		if (trmmst.getTmTerminalId().compareTo(trmacc.getTmTerminalId()) > 0) {
			tmTerminalId = trmmst.getTmTerminalId().trim();
		} else {
			tmTerminalId = trmacc.getTmTerminalId().trim();
		}

		m.addAttribute("merchantId", id);
		m.addAttribute("chainNo", mermst.getMmChainAccno());
		m.addAttribute("tmTerminalId", tmTerminalId);
		m.addAttribute("mm_biz_name", mermst.getMmBizName()); // 场馆名称
		m.addAttribute("mm_phy_state", mermst.getMmPhyState()); // 商户|场馆 == 1|0
		map.put("cpPosprmList", cpPosprmList);
		map.put("cpTrmmst", new CpTrmmst());

		return "machine/addTeUI";
	}
	
	
	/**
	 * 场馆管理-商户列表-终端列表-添加实现
	 *
	 * @author Hugh
	 */
	@WebAction(Permission.VENUEALL_TRMMST_ADD)
	@RequestMapping("/addTe")
	public String addTe(CpTrmacc cpTrmacc, RedirectAttributes ra, Integer p, Model m, Map<String, Object> map) {

		TSysStaff currentStaff = WebContext.getCurrentStaff();
		String currentStaffId = currentStaff.getId();

		Date sysDate = new Date();
		SimpleDateFormat formatSysDate = new SimpleDateFormat("yyyyMMdd hhdd");

		String dateInst = cpTrmacc.getTmDateInst().replace("-", "");
		cpTrmacc.setTmDateInst(dateInst);
		System.out.println("-------------------" + dateInst + "+-----");
		cpTrmacc.setTmSetupUser(currentStaffId);
		cpTrmacc.setTmApplStatus("A");
		// 录入时间
		cpTrmacc.setTmSetupTimestamp(formatSysDate.format(sysDate));
		//闸机状态。（0为正常，1为停用）
		cpTrmacc.setTmStatus("0");
		// 插入终端记录
		Long l = machineService.insertCpTrmacc(cpTrmacc);
		if (l != 1) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, "添加失败");
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "添加成功");

		// 查询列表
		Result<PageInfo<CpTrmacc>> trmmacc = machineService.cpTeTrmaccList(cpTrmacc.getTmMerchantId(), null,
				new PageBounds(p, 8));
		if (trmmacc.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("pageInfo", trmmacc.getValue());
		}

		map.put("currentStaffId", currentStaffId);
		m.addAttribute("merchantId", cpTrmacc.getTmMerchantId());

		return "/machine/teunexamineList";
	}
	
		
	//根据条件查询待复核终端列表数据
	@WebAction(Permission.VENUEALL_TRMMST_LIST)
	@RequestMapping(value = "/upunexamineList/{machineNo}")
	public String upunexamineList(@PathVariable("machineNo")String id,Integer p,
			Map<String, Object> map, Model m, HttpSession session) {

		Result<PageInfo<CpTrmacc>> trmmacc = machineService.cpWaTrmaccList(id, null,
				new PageBounds(p, 8));
		if (trmmacc.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("pageInfo", trmmacc.getValue());
		}
		
		//右上角回退页面会用到场馆号
		CpMermst cpmermstDto = machineService.searchCpMermstByMmMerchantNo(id);

		TSysStaff currentStaff = WebContext.getCurrentStaff();
		String currentStaffId = currentStaff.getId();

		map.put("currentStaffId", currentStaffId);
		m.addAttribute("merchantId", id);
		m.addAttribute("chainNo", cpmermstDto.getMmChainAccno());
		return "/machine/teunexamineList";
	}
	
	
	//终端管理-待复核列表-查询回退功能右上角
	@WebAction(Permission.VENUEALL_TRMMST_LIST)
	@RequestMapping(value = "/waunexamineList", method = { RequestMethod.POST, RequestMethod.GET })
	public String waunexamineList(String tm_merchant_id, String tm_terminal_id, Integer p,
			Map<String, Object> map, Model m, HttpSession session) {

		Result<PageInfo<CpTrmacc>> trmmacc = machineService.cpWaTrmaccList(tm_merchant_id, tm_terminal_id,
				new PageBounds(p, 8));
		if (trmmacc.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("pageInfo", trmmacc.getValue());
		}
		

		TSysStaff currentStaff = WebContext.getCurrentStaff();
		String currentStaffId = currentStaff.getId();

		map.put("currentStaffId", currentStaffId);
		m.addAttribute("merchantId", tm_merchant_id);
		return "/machine/teunexamineList";
	}
	
	
	/**
	 * 终端管理-待复核列表
	 * 
	 * @param  终端编号
	 * 
	 * @author Hugh
	 */
	@WebAction(Permission.VENUEALL_TRMMST_SHOW)
	@RequestMapping("/teunexamineshow/{machineNo}")
	public String teunexamineshow(@PathVariable("machineNo") String id, Model m) {

		Result<CpTrmacc> r = machineService.cpTrmaccGetById(id);
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/machine/teunexamineList";
		}
		if (null != r.getValue().getTmDateInst()) {
			StringBuffer sb = new StringBuffer(r.getValue().getTmDateInst());
			sb.insert(4, "-");
			sb.insert(7, "-");
			String a = sb.toString();
			r.getValue().setTmDateInst(a);
		}

		// 根据商户号查询商户名称
		CpMermst mermst = machineService.searchCpMermstByMmMerchantNo(r.getValue().getTmMerchantId());

		m.addAttribute("mm_biz_name", mermst.getMmBizName());
		m.addAttribute("mm_phy_state", mermst.getMmPhyState());
		m.addAttribute("item", r.getValue());
		m.addAttribute("merchantId", r.getValue().getTmMerchantId());
		m.addAttribute("chainNo", mermst.getMmChainAccno());
		return "machine/teunexamineshow";
	}
	
	
	
	/**
	 * 商户管理-终端列表-待复核列表
	 * 
	 * @author Hugh
	 */
	@WebAction(Permission.VENUEALL_TRMMST_LIST)
	@RequestMapping("/trunexamineList/{merchantId}")
	public String trunexamineList(@PathVariable("merchantId") String id, HttpServletRequest request, Integer p, Model m,
			Map<String, Object> map) {
		
		Condition(request, m);
		String tm_merchant_id = request.getParameter("tm_merchant_id");
		String tm_terminal_id = request.getParameter("tm_terminal_id");
		if (null == tm_merchant_id || "".equals(tm_merchant_id)) {
			tm_merchant_id = id;
		}

		//场馆编号
		CpMermst mermstDto = machineService.searchCpMermstByMmMerchantNo(tm_merchant_id);
		
		Result<PageInfo<CpTrmacc>> trmmacc = machineService.cpWaTrmaccList(tm_merchant_id, tm_terminal_id,
				new PageBounds(p, 8));
		if (trmmacc.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("pageInfo", trmmacc.getValue());
		}

		TSysStaff currentStaff = WebContext.getCurrentStaff();
		String currentStaffId = currentStaff.getId();

		map.put("currentStaffId", currentStaffId);
		m.addAttribute("merchantId", id);
		m.addAttribute("chainNo", mermstDto.getMmChainAccno());
		return "/machine/teunexamineList";
	}
	
	
	/**
	 * 商户管理-待复核列表-终端删除 
	 *  
	 * @param 闸机编号
	 * 
	 * @author Hugh
	 * 
	 */
	@WebAction(Permission.VENUEALL_TRMMST_DELETE)
	@RequestMapping("/teunexamineDelete/{machineNo}")
	public String teunexamineDelete(@PathVariable("machineNo") String id, Integer p, Model m) {

		// 根据终端ID找到商户场馆号
		Result<CpTrmacc> r = machineService.cpTrmaccGetById(id);
		String tm_merchantId = r.getValue().getTmMerchantId();

		// 删除终端
		machineService.unexamineDelete(id);

		// 根据商户场馆号找到对应下边所有终端未授权
		Result<PageInfo<CpTrmacc>> trmmacc = machineService.cpTeTrmaccList(tm_merchantId, null, new PageBounds(p, 8));
		if (trmmacc.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("pageInfo", trmmacc.getValue());
		}
		m.addAttribute("merchantId", tm_merchantId);
		return "/machine/teunexamineList";
	}
	
	
	/**
	 * 终端管理-待复核列表-复核
	 * 
	 * @param 终端编号
	 * @author Hugh
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	@WebAction(Permission.VENUEALL_TRMMST_AUTH)
	@RequestMapping("/trexamine/{machineNo}")
	public String trexamine(@PathVariable("machineNo") String id, Integer p, Model m) throws IllegalAccessException, InvocationTargetException {

		// 根据终端编号找到商户场馆号
		Result<CpTrmacc> r = machineService.cpTrmaccGetById(id);
		String tm_merchantId = r.getValue().getTmMerchantId();

		TSysStaff currentStaff = WebContext.getCurrentStaff();
		String currentStaffId = currentStaff.getId();

		// 复核
		machineService.examine(id, currentStaffId);

		// 根据商户场馆号找到对应下边所有终端未授权
		Result<PageInfo<CpTrmacc>> trmmacc = machineService.cpTeTrmaccList(tm_merchantId, null, new PageBounds(p, 8));
		if (trmmacc.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("pageInfo", trmmacc.getValue());
		}
		return "redirect:/machine/viewTrmmstDlist?machineNo="+tm_merchantId;
	}
	
	
	/**
	 * 终端更新
	 * 
	 * @author Hugh
	 */
	@WebAction(Permission.VENUEALL_TRMMST_UPDATE)
	@RequestMapping("/updateTrUI/{machineNo}")
	public String updateTrUI(@PathVariable("machineNo") String id, Model m) {

		List<CpPosprm> cpPosprmList = machineService.cpPosprmToppBrand();
		Result<CpTrmmst> r = machineService.cpTrmmstGetById(id);

		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/machine/trmmstlist";
		}

		if (null != r.getValue().getTmDateInst()) {
			StringBuffer sb = new StringBuffer(r.getValue().getTmDateInst());
			sb.insert(4, "-");
			sb.insert(7, "-");
			String a = sb.toString();
			r.getValue().setTmDateInst(a);
		}
		
		//回退页面时用到
		CpMermst mermst = machineService.searchCpMermstByMmMerchantNo(r.getValue().getTmMerchantId());
		
		m.addAttribute("item", r.getValue());
		m.addAttribute("cpPosprmList", cpPosprmList);
		m.addAttribute("chainNo", mermst.getMmChainAccno());
		m.addAttribute("merchantId", r.getValue().getTmMerchantId());
		
		return "machine/trmmstupdate";
	}
	
	
	/**
	 * 终端详情
	 * 
	 * @author Hugh
	 */
	@WebAction(Permission.VENUEALL_TRMMST_SHOW)
	@RequestMapping("/showTe/{machineNo}")
	public String showTe(@PathVariable("machineNo") String id, Model m) {
		
		Result<CpTrmmst> r = machineService.cpTrmmstGetById(id);
		CpMermst mermst = machineService.searchCpMermstByMmMerchantNo(r.getValue().getTmMerchantId());
		
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/trmmstgate/viewmermstlist";
		}
		StringBuffer sb = new StringBuffer(r.getValue().getTmDateInst());
		sb.insert(4, "-");
		sb.insert(7, "-");
		String a = sb.toString();
		r.getValue().setTmDateInst(a);
		m.addAttribute("item", r.getValue());
		
		m.addAttribute("chainNo", mermst.getMmChainAccno());
		m.addAttribute("merchantId", r.getValue().getTmMerchantId());
		
		return "machine/trmmstshow";
	}
	
	
	/**
	 * 终端删除
	 * 
	 * @author Hugh
	 */
	@WebAction(Permission.VENUEALL_TRMMST_DELETE)
	@RequestMapping("/deleteTr/{machineNo}")
	public String deleteTr(@PathVariable("machineNo") String id, Model m) {
		//查询终端对象
		CpTrmmst trmmstDto = machineService.trmmstDto(id);
		machineService.delete(id);
		return "redirect:/machine/viewTrmmstlist?machineNo="+trmmstDto.getTmMerchantId();
	}
	
	
	/**
	 * 终端更新-实现
	 * 
	 * @author Hugh
	 */
	@WebAction(Permission.VENUEALL_TRMMST_UPDATE)
	@RequestMapping(value = "/updateTe")
	public String updateTe(CpTrmacc cpTrmacc, RedirectAttributes ra) {

		TSysStaff currentStaff = WebContext.getCurrentStaff();
		String currentStaffId = currentStaff.getId();
		String dateInst = cpTrmacc.getTmDateInst().replace("-", "");

		Result<CpTrmmst> r = machineService.cpTrmmstGetById(cpTrmacc.getTmTerminalId());

		cpTrmacc.setTmSetupUser(currentStaffId);
		cpTrmacc.setTmDateInst(dateInst); // 安装日期
		cpTrmacc.setTmApplStatus("U");

		// 修改:cp_trmacc
		Result<CpTrmacc> r1 = machineService.updateTrmmst(cpTrmacc);
		if (r1.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r1.getComment());
			return "redirect:/machine/trmmstlist";
		}

		// 修改:cp_trmmst
		Result<CpTrmmst> r2 = machineService.updateTrmmst(r.getValue());

		if (r2.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r2.getComment());
			return "redirect:/machine/trmmstlist";
		}

		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "终端更新成功");
		return "redirect:/machine/jnunexamineList?tm_merchant_id="+r.getValue().getTmMerchantId();
	}
	
	
	//终端复核跳转页面处理
	@WebAction(Permission.VENUEALL_TRMMST_LIST)
	@RequestMapping(value = "/viewTrmmstDlist")
	public String viewTrmmstDlist( Integer p, Map<String,Object> map,HttpServletRequest request,HttpSession session,Model m) {
		
		String machineNo = request.getParameter("machineNo");
		Result<PageInfo<CpTrmmst>> trmmst = machineService.merTrmAllList(new PageBounds(p, 8));
		if (trmmst.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
			return "redirect:/trmmstgate/viewmermstlist";
		}
		m.addAttribute("merchantId", machineNo);
		m.addAttribute("pageInfo", trmmst.getValue());
		return "machine/trmmstlist";
	}
	
	
	
	//终端复核以后删除记录页面跳转处理
	@WebAction(Permission.VENUEALL_TRMMST_LIST)
	@RequestMapping("/viewTrmmstlist")
	public String viewTrmmstlist(Integer p, Model m,HttpServletRequest request) {
		
		String machineNo = request.getParameter("machineNo");
	
		Result<PageInfo<CpTrmmst>> trmmst = machineService.merTrmList(machineNo,new PageBounds(p, 8));
		if (trmmst.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
			return "redirect:/trmmstgate/viewmermstlist";
		}
		
		m.addAttribute("merchantId", machineNo);
		m.addAttribute("pageInfo", trmmst.getValue());
		return "machine/trmmstlist";
	}
	
	
	/**
	 * 终端复核以后修改页面跳转处理
	 * 
	 * @author Hugh
	 */
	@WebAction(Permission.VENUEALL_TRMMST_LIST)
	@RequestMapping("/jnunexamineList")
	public String jnunexamineList(HttpServletRequest request, Integer p, Model m,
			Map<String, Object> map) {
		
		Condition(request, m);
		String tm_merchant_id = request.getParameter("tm_merchant_id");
		String tm_terminal_id = request.getParameter("tm_terminal_id");

		Result<PageInfo<CpTrmacc>> trmmacc = machineService.cpWaTrmaccList(tm_merchant_id, tm_terminal_id,
				new PageBounds(p, 8));
		if (trmmacc.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("pageInfo", trmmacc.getValue());
		}

		TSysStaff currentStaff = WebContext.getCurrentStaff();
		String currentStaffId = currentStaff.getId();

		map.put("currentStaffId", currentStaffId);
		m.addAttribute("merchantId", tm_merchant_id);
		return "/machine/teunexamineList";
	}
}
