package cn.happyworlds.imgmt.web;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpAcqmer;
import cn.happyworlds.imgmt.entity.CpTktype;
import cn.happyworlds.imgmt.entity.MIdtypeDict;
import cn.happyworlds.imgmt.entity.TSysRole;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.service.CpAcqmerService;
import cn.happyworlds.imgmt.service.CpTktypeService;
import cn.happyworlds.imgmt.util.DateTimes;
import cn.happyworlds.imgmt.util.Result;
import cn.happyworlds.imgmt.util.StatusResult;
import cn.happyworlds.imgmt.util.SysDateFormat;

@Controller
@RequestMapping("/cptktype")
public class CpTktypeController {

	@Autowired
	private CpTktypeService cpTktypeService;
	@Autowired
	private CpAcqmerService cpAcqmerService;
	
	@WebAction(Permission.CPTKTYPE_LIST)
	@RequestMapping("/list")
	public String list(String ttTypeId, String ttTypeDesc, Integer p, Model m) {
		Result<PageInfo<CpTktype>> r = cpTktypeService.cpTktypeList(ttTypeId,ttTypeDesc,new PageBounds(p, 10));
		if (r.isError()) {
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		} else {
			m.addAttribute("ttTypeId", ttTypeId);
			m.addAttribute("ttTypeDesc", ttTypeDesc);
			m.addAttribute("pageInfo", r.getValue());
		}
		return "cptktype/list";
	}
	
	@WebAction(Permission.CPTKTYPE_ADD)
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addUi(Model m, Integer p) {
		
		//类型id自动生成
		CpTktype tktypeDto = cpTktypeService.searchMaxTktype();
		List<CpAcqmer> cpAcqmer = cpAcqmerService.cpAcqmerList();
		String nowTime = SysDateFormat.getNowDate("yyyy-MM-dd");
		
		m.addAttribute("ttTypeIdd", tktypeDto.getTtTypeId());
		m.addAttribute("cpAcqmer", cpAcqmer);
		m.addAttribute("nowTime", nowTime);
		
		return "cptktype/add";
	}
	
	/**
	 * 添加
	 * @throws ParseException 
	 */
	
	@WebAction(Permission.CPTKTYPE_ADD)
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(CpTktype cpTktype,RedirectAttributes ra) throws ParseException{
		cpTktype.setTtStartDate(cpTktype.getTtStartDate().replaceAll("-", ""));
		cpTktype.setTtEndDate(cpTktype.getTtEndDate().replaceAll("-", ""));
		Result<CpTktype> r = cpTktypeService.insertCpTktype(cpTktype);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/cptktype/add";
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "票劵添加成功");
		return  "redirect:/cptktype/list";
	}
	
	
	@WebAction(Permission.CPTKTYPE_UPDATE)
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(Integer ttTypeId, Model m) {
		//List<CpAcqgrp> cpAcqgrps = cpAcqgrpService.CpAcqgrpList();
		List<CpAcqmer> cpAcqmer = cpAcqmerService.cpAcqmerList();
		CpTktype cpTktype = cpTktypeService.searchCpTktypeByTtTypeId(ttTypeId);
		cpTktype.setTtStartDate(DateTimes.format(cpTktype.getTtStartDate(), DateTimes.DATE_PATTERN2));
		cpTktype.setTtEndDate(DateTimes.format(cpTktype.getTtEndDate(), DateTimes.DATE_PATTERN2));
		m.addAttribute("item", cpTktype);
		m.addAttribute("cpAcqmer", cpAcqmer);
		return "cptktype/update";
	}
	
	
	/**
	 * 更新
	 */
	@WebAction(Permission.CPTKTYPE_UPDATE)
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(CpTktype cpTktype,RedirectAttributes ra){
		cpTktype.setTtStartDate(DateTimes.format(cpTktype.getTtStartDate(), DateTimes.DATE_PATTERN));
		cpTktype.setTtEndDate(DateTimes.format(cpTktype.getTtEndDate(), DateTimes.DATE_PATTERN));
		Result<CpTktype> r = cpTktypeService.update(cpTktype);
		if (r.isError()) {
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/cptktype/update?ttTypeId=" + cpTktype.getTtTypeId();
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "票劵更新成功");
		return "redirect:/cptktype/list";
	}
	
	//查看
	@WebAction(Permission.CPTKTYPE_SHOW)
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String show(Integer ttTypeId, Model m) {
		List<CpAcqmer> cpAcqmer = cpAcqmerService.cpAcqmerList();
		CpTktype cpTktype = cpTktypeService.searchCpTktypeByTtTypeId(ttTypeId);
		cpTktype.setTtStartDate(DateTimes.format(cpTktype.getTtStartDate(), DateTimes.DATE_PATTERN2));
		cpTktype.setTtEndDate(DateTimes.format(cpTktype.getTtEndDate(), DateTimes.DATE_PATTERN2));
		m.addAttribute("item", cpTktype);
		m.addAttribute("cpAcqmer", cpAcqmer);
		return "cptktype/show";
	}
	
	
	@WebAction(Permission.CPTKTYPE_DELETE)
	@RequestMapping("/delete")
	public String delect(Integer ttTypeId, RedirectAttributes ra){
		CpTktype cpTktype = cpTktypeService.searchCpTktypeByTtTypeId(ttTypeId);
		Result<CpTktype> r=cpTktypeService.delect(cpTktype);
		if(r.isError()){
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
		}
		ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "票种删除成功");
		
		return "redirect:/cptktype/list";
	}
	
	
}
