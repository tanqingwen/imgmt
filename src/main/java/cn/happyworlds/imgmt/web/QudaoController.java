package cn.happyworlds.imgmt.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bouncycastle.ocsp.Req;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpChannels;
import cn.happyworlds.imgmt.entity.CpTuiPiao;
import cn.happyworlds.imgmt.entity.TSysStaff;
import cn.happyworlds.imgmt.mapper.CpChannelsMapper;
import cn.happyworlds.imgmt.mapper.CpTuiPiaoMapper;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.service.CpChannelsService;
import cn.happyworlds.imgmt.service.CpTuiPiaoService;
import cn.happyworlds.imgmt.util.Result;

@Controller
@RequestMapping(value="/qudao")
public class QudaoController {
	@Autowired
	private CpChannelsMapper channelsMapper;
	@Autowired
	private CpChannelsService channelsService;
	@Autowired
	private CpTuiPiaoMapper cpTuiPiaoMapper;
	@Autowired
	private CpTuiPiaoService cpTuiPiaoService;
	
	/**
	 * 渠道报表
	 * @param request
	 * @param m
	 * @param date
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/list")
	public String getAllOrder(HttpServletRequest request,Model m,String date,Map<String,Object> map){
		String startTime= request.getParameter("startTime");
		String endTimes=request.getParameter("endTime");
		String endTime=endTimes+" 235959";
		List<CpChannels> list=channelsMapper.findAllOrder(startTime,endTime);
		m.addAttribute("list",list);
		Result<PageInfo<CpChannels>> result=channelsService.findAllOrder(date,startTime,endTime, new PageBounds(0,10));
		map.put("cpChannels", result.getValue());
		m.addAttribute("startTimes",startTime);
		m.addAttribute("endTimes",endTimes);
		return "qudao/list";
	}
	/**
	 * 导出excel接口
	 */
	@RequestMapping(value="/isDownLoad",method = RequestMethod.POST )
	public String listDownLoad(HttpServletRequest request,HttpServletResponse resp,RedirectAttributes ra){
		TSysStaff staff=WebContext.getCurrentStaff();
		String startTime= request.getParameter("startTime");
		String endTime= request.getParameter("endTime");
		request.getParameter("endTime");
		Result<String> result=channelsService.listDownLoadMethod(startTime,endTime,staff.getId(), resp);
		if (result!=null) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, result.getComment());
			return "redirect:/qudao/list";
		}
		return null;
	}
	/**
	 * 非实名退票
	 * @param m
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/listtp")
	public String getAllReturnTicket(HttpServletRequest request, Model m,Map<String, Object> map){
		String startTime= request.getParameter("startTime");
		String endTimes=request.getParameter("endTime");
		String endTime=endTimes+" 235959";
		List<CpTuiPiao> list=cpTuiPiaoMapper.getAllReturnTicket(startTime,endTime);
		m.addAttribute("list",list);
		m.addAttribute("startTimes",startTime);
		m.addAttribute("endTimes",endTimes);
		return "qudao/listtp";
	}
	/**
	 * 非实名退票excel
	 */
	@RequestMapping(value="/isDownLoad2",method = RequestMethod.POST )
	public String listDownLoad2(HttpServletRequest request,HttpServletResponse resp,RedirectAttributes ra){
		TSysStaff staff=WebContext.getCurrentStaff();
		String startTime= request.getParameter("startTime");
		String endTime=request.getParameter("endTime");
		Result<String> result=cpTuiPiaoService.listDownLoadMethod(startTime,endTime,staff.getId(), resp);
		if (result!=null) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, result.getComment());
			return "redirect:/qudao/listtp";
		}
		return null;
	}
	
}
