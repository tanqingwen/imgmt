package cn.happyworlds.imgmt.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpActpcd;
import cn.happyworlds.imgmt.entity.CpMermst;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.service.MerchantService;
import cn.happyworlds.imgmt.service.StaffService;
import cn.happyworlds.imgmt.util.Result;

@Controller
@RequestMapping("/merchant")
public class MerchantController {

	@Autowired
	private MerchantService merchantService;
	
	
	@Autowired
	private StaffService staffService;
	
	@RequestMapping(value="/list",method={RequestMethod.POST, RequestMethod.GET})
	public String list(String mmMerchantNo, String mmDbaName, String mmBizName, Integer p, Model m) {
		Result<PageInfo<CpMermst>> r = merchantService.merchantList(mmMerchantNo, mmDbaName, mmBizName, new PageBounds(p, 10));
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("mmMerchantNo", mmMerchantNo);
			m.addAttribute("mmDbaName", mmDbaName);
			m.addAttribute("mmBizName", mmBizName);
			m.addAttribute("pageInfo", r.getValue());
		}
		return "merchant/list";
	}
	
//	@WebAction(Permission.MERCHANT_INQUIRELIST)
//	@RequestMapping("/merchant_inquirelist")
//	public String show(String id, Model m) {
//		Result<CpMermst> r = merchantService.merchantGetById(id);
//		if (r.isError()) {
//			m.addAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
//			return "redirect:/merchant/list";
//		}
//		m.addAttribute("cpMermst", r.getValue());
//		List<CpActpcd> cpActpcdList = staffService.getCpActpcdList();
//		m.addAttribute("cpActpcdList", cpActpcdList);
//		return "merchant/merchantInfoShow";
//	}
	
//	@WebAction(Permission.MERCHANT_TERMINALLIST)
//	@RequestMapping("/merchant_terminallist")
//	public String showTerminalList(String id, Integer p, Model m) {
//		Result<PageInfo<CpTrmmst>> r = machineService.machineList(id, null, new PageBounds(p, 8));
//		if (r.isError()) {
//			m.addAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
//			return "redirect:/merchant/list";
//		}
//		m.addAttribute("pageInfo", r.getValue());
//		return "merchant/merchantTerminalShow";
//	}
	
//	@WebAction(Permission.MERCHANT_HISDEALDATA)
//	@RequestMapping("/merchant_hisdealdata")
//	public String showHisDealData(String id, Model m) {
//		Result<CpMermst> r = merchantService.merchantGetById(id);
//		if (r.isError()) {
//			m.addAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
//			return "redirect:/merchant/list";
//		}
//		m.addAttribute("pageInfo", r.getValue());
//		return "merchant/merchantHisShow";
//	}
	
}
