package cn.happyworlds.imgmt.web;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpMermst;
import cn.happyworlds.imgmt.entity.CpTrmmst;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.service.MachineService;
import cn.happyworlds.imgmt.util.Result;

/**list
 *
 * @author Hugh
 *  
 * 2017-07-27
 */
@Controller
@RequestMapping("/trmmstgate")
public class TrmmstgateController {
	
	@Autowired
	private MachineService machineService;
	
	
	//闸机管理-场馆列表
	@WebAction(Permission.TRMMST_GATE_LIST)
	@RequestMapping("/list")
	public String list(HttpServletRequest  request, Integer p, Model m) {
		Condition(request, m);
		String mm_merchant_no=request.getParameter("mm_merchant_no");
		String mm_biz_name=request.getParameter("mm_biz_name");
		String mm_dba_name=request.getParameter("mm_dba_name");
		String mm_pmt_mode=request.getParameter("mmPmtMode");
		
		Result<PageInfo<CpMermst>> mermst = machineService.machineList(mm_merchant_no,mm_biz_name,mm_dba_name,"1",mm_pmt_mode,new PageBounds(p, 8)); 
		
		if (mermst.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("mm_merchant_no", mm_merchant_no);
			m.addAttribute("mm_biz_name", mm_biz_name);
			m.addAttribute("mm_dba_name", mm_dba_name);
			m.addAttribute("mm_pmt_mode", mm_pmt_mode);
			m.addAttribute("pageInfo", mermst.getValue());
		}
		return "trmmstgate/list";
	}
	
	private void Condition(HttpServletRequest request, Model model) {
		String paras[] = {"mm_merchant_no","mm_biz_name","mm_dba_name","mm_phy_state","mm_pmt_mode"};
		for (int i = 0; i < paras.length; i++) {
			model.addAttribute(paras[i], request.getParameter(paras[i]));
		}
	}
	
	
	//闸机管理-闸机列表
	@WebAction(Permission.TRMMST_GATE_LIST)
	@RequestMapping("/viewlist/{machineNo}")
	public String list(@PathVariable("machineNo")String id,Integer p, Model m) {
	
		Result<PageInfo<CpTrmmst>> trmmst = machineService.trmList(id,new PageBounds(p, 8));
		if (trmmst.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
			return "redirect:/trmmstgate/list";
		}
		
		m.addAttribute("merchantId", id);
		m.addAttribute("pageInfo", trmmst.getValue());
		return "machine/list";
	}
	
	
	//场馆管理-商户管理
	@WebAction(Permission.VENUEALL_MERMST_LIST)
	@RequestMapping("/mermstlist")
	public String mermstlist(HttpServletRequest  request, Integer p, Model m) {
		Condition(request, m);
		String mm_merchant_no=request.getParameter("mm_merchant_no");
		String mm_biz_name=request.getParameter("mm_biz_name");
		String mm_stmt_name=request.getParameter("mm_stmt_name");
		String mm_pmt_mode=request.getParameter("mmPmtMode");
		
		Result<PageInfo<CpMermst>> mermst = machineService.machineList(mm_merchant_no,mm_biz_name,mm_stmt_name,"1",mm_pmt_mode,new PageBounds(p, 8)); 
		
		if (mermst.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("mm_merchant_no", mm_merchant_no);
			m.addAttribute("mm_biz_name", mm_biz_name);
			m.addAttribute("mm_stmt_name", mm_stmt_name);
			m.addAttribute("mm_pmt_mode", mm_pmt_mode);
			m.addAttribute("pageInfo", mermst.getValue());
		}
		return "trmmstgate/mermstlist";
	}
	
	
	
	//场馆管理-场馆下商户列表
	@WebAction(Permission.VENUEALL_TRMMST_LIST)
	@RequestMapping("/viewmermstlist/{machineNo}")
	public String viewmermstlist(@PathVariable("machineNo")String id,Integer p, Model m) {
	
		Result<PageInfo<CpMermst>> mermst = machineService.mermList(id,new PageBounds(p, 8));
		if (mermst.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
			return "redirect:/trmmstgate/mermstlist";
		}
		
		m.addAttribute("merchantId", id); //场馆编号
		m.addAttribute("pageInfo", mermst.getValue());
		return "machine/mermstlist";
	}
	
	
	//现场管理-场馆下商户列表-终端列表
	@WebAction(Permission.VENUEALL_TRMMST_LIST)
	@RequestMapping("/viewTrmmstlist/{machineNo}")
	public String viewTrmmstlist(@PathVariable("machineNo")String id,Integer p, Model m) {
	
		Result<PageInfo<CpTrmmst>> trmmst = machineService.merTrmList(id,new PageBounds(p, 8));
		if (trmmst.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
			return "redirect:/trmmstgate/viewmermstlist";
		}
		
		//右上角回退页面会用到场馆号
		CpMermst cpmermstDto = machineService.searchCpMermstByMmMerchantNo(id);
		
		m.addAttribute("merchantId", id);
		m.addAttribute("pageInfo", trmmst.getValue());
		m.addAttribute("chainNo", cpmermstDto.getMmChainAccno()); // 场馆编号
		return "machine/trmmstlist";
	}
	
	
	//现场管理-场馆下商户列表
	@WebAction(Permission.TRMMST_GATE_LIST)
	@RequestMapping("/venmerlist")
	public String venmerlist(HttpServletRequest request, Integer p, Model m) {

		Condition1(request, m);
		String tm_merchant_id = request.getParameter("tm_merchant_id");
		
		Result<PageInfo<CpMermst>> mermst = machineService.merOneList(tm_merchant_id,new PageBounds(p, 8));

		if (mermst.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("merchantId", tm_merchant_id);
		}
		
		m.addAttribute("merchantId", tm_merchant_id); //场馆编号
		m.addAttribute("pageInfo", mermst.getValue());
		return "machine/mermstlist";
	}
	
	
	private void Condition1(HttpServletRequest request, Model model) {
		String paras[] = { "tm_merchant_id"};
		for (int i = 0; i < paras.length; i++) {
			model.addAttribute(paras[i], request.getParameter(paras[i]));
		}
	}
	
	
	//现场管理-场馆下商户列表-终端列表(查询按钮)
	@WebAction(Permission.VENUEALL_TRMMST_LIST)
	@RequestMapping("/findTrmmstlist")
	public String findTrmmstlist(HttpServletRequest request, Integer p, Model m) {
	
		String tm_terminal_id = request.getParameter("tm_terminal_id");
		String tm_merchant_id = request.getParameter("tm_merchant_id");
		
		Result<PageInfo<CpTrmmst>> trmmst = machineService.findTrmList(tm_terminal_id,tm_merchant_id,new PageBounds(p, 8));
		
		if (trmmst.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} 
		//右上角回退页面会用到场馆号
		CpMermst cpmermstDto = machineService.searchCpMermstByMmMerchantNo(tm_merchant_id);
		
		m.addAttribute("merchantId", tm_merchant_id);
		m.addAttribute("pageInfo", trmmst.getValue());
		m.addAttribute("chainNo", cpmermstDto.getMmChainAccno()); // 场馆编号
		return "machine/trmmstlist";
	}
	
}
