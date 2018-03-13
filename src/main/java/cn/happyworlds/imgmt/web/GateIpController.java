package cn.happyworlds.imgmt.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpGateip;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.service.GateIpService;
import cn.happyworlds.imgmt.util.Result;

@Controller
@RequestMapping("/gateip")
public class GateIpController {

	@Autowired
	private GateIpService gateIpService;
	
	@WebAction(Permission.GATE_IP_LIST)
	@RequestMapping("/list")
	public String list(String gaTm, String gaIp, Integer p, Model m) {
		Result<PageInfo<CpGateip>> r = gateIpService.gateIpList(gaTm, gaIp, new PageBounds(p, 10));
		
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("gaTm", gaTm);
			m.addAttribute("gaIp", gaIp);
			m.addAttribute("pageInfo", r.getValue());
		}
		return "gate_Ip/bindIp";
	}
	
	//添加
	@WebAction(Permission.GATE_IP_ADD)
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(String id, Model m, RedirectAttributes ra) {
		CpGateip gateIp = gateIpService.maxGateIpId();
		m.addAttribute("gateId",gateIp.getGaId());
		return "gate_Ip/add";
	}
	
	//添加-实现
	@WebAction(Permission.GATE_IP_ADD)
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(CpGateip gateIp, RedirectAttributes ra) {
		Result<String> r = gateIpService.gateIpAdd(gateIp);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/gateip/add";
		} else {
			ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "更新成功");
		}
		return "redirect:/gateip/list";
	}

	//更新
	@WebAction(Permission.GATE_IP_UPDATE)
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(String id, Model m, RedirectAttributes ra) {
		Result<CpGateip> r = gateIpService.gateIpGetById(id);
		
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/gateip/list";
		}
		m.addAttribute("gateIpDto", r.getValue());
		return "gate_Ip/update";
	}
	
	//更新-实现
	@WebAction(Permission.GATE_IP_UPDATE)
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(CpGateip gateIp, RedirectAttributes ra) {
		Result<String> r = gateIpService.gateIpUpdate(gateIp);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
		} else {
			ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "更新成功");
		}
		return "redirect:/gateip/list";
	}
	
	
	//闸机详情
	@WebAction(Permission.GATE_IP_SHOW)
	@RequestMapping("/show")
	public String show(String id, Model m) {
		Result<CpGateip> r = gateIpService.gateIpGetById(id);

		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
		} else {
			m.addAttribute("gateIPDto", r.getValue());
		}
		return "gate_Ip/show";
	} 
	
	
	//闸机删除
	@WebAction(Permission.GATE_IP_DELETE)
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(String id, Model m, RedirectAttributes ra) {
		Result<String> r = gateIpService.gateIpDelete(id);
		
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
		}else{
			ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "删除成功");
		}
		return "redirect:/gateip/list";
	}

}
