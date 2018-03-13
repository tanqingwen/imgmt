package cn.happyworlds.imgmt.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.PageInfo;

import cn.happyworlds.imgmt.entity.CpMemberPoint;
import cn.happyworlds.imgmt.mybatis.PageBounds;
import cn.happyworlds.imgmt.service.MemberPointsService;
import cn.happyworlds.imgmt.util.Result;

@Controller
@RequestMapping("/member_points")
public class MemberPointsController {
	

	@Autowired
	private MemberPointsService pointsService;
	
//	积分规则加载
	@WebAction(Permission.MEMBERPOINTS_LIST)
	@RequestMapping("/list")
	public String List(String pointsId,String pointsName,Integer p,Model m){
		Result<PageInfo<CpMemberPoint>> r=pointsService.pointList(pointsId, pointsName,new PageBounds(p,10));
		if(r.isError()){
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, "查询出现异常");
		}else{
			m.addAttribute("pageInfo", r.getValue());
		}
		return "member_points/list";
	}
	
	@WebAction(Permission.MEMBERPOINTS_ADD)
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(String id, Model m, RedirectAttributes ra){
		return "member_points/add";
	}
	
//	积分添加
	@WebAction(Permission.MEMBERPOINTS_ADD)
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(CpMemberPoint point,RedirectAttributes ra){
		Result<String> r=pointsService.memberPointsAdd(point);
		if(r.isError()){
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP,r.getComment());
			return "redirect:/member_points/add";
		}else{
			ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP,"添加成功");
		}
		return "redirect:/member_points/list";
	}
	
//	查看单个积分规则
	@WebAction(Permission.MEMBERPOINTS_SHOW)
	@RequestMapping("/show")
	public String show(String id,Model m){
		Result<CpMemberPoint> r=pointsService.memberPointsById(id);
		if(r.isError()){
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
		}else{
			m.addAttribute("memberPoints", r.getValue());
		}
		return "member_points/show";
	}
	
	@WebAction(Permission.MEMBERPOINTS_UPDATE)
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update(String id,Model m){
		Result<CpMemberPoint> r=pointsService.memberPointsById(id);
		if(r.isError()){
			m.addAttribute(WebContext.ACTION_FAILURE_TIP, r.getComment());
			return "redirect:/member_points/update";
		}
		m.addAttribute("memberPoints",r.getValue());
		return "member_points/update";
	}
	
//	积分配置更新
	@WebAction(Permission.MEMBERPOINTS_UPDATE)
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(CpMemberPoint point,RedirectAttributes ra){
		Result<String> r=pointsService.memberPointsUpdate(point);
		if(r.isError()){
			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP,r.getComment());
		}else{
			ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "更新成功!");
		}
		return "redirect:/member_points/list";
	}
	
//	删除某条积分配置
//	@WebAction(Permission.MEMBERPOINTS_DELETE)
//	@RequestMapping("/delete")
//	public String delete(String id,RedirectAttributes ra){
//		Result<String> r=pointsService.memberPointsDelete(id);
//		if(r.isError()){
//			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP,r.getComment());
//		}else{
//			ra.addFlashAttribute(WebContext.ACTION_SUCCESS_TIP, "删除成功!");
//		}
//		return "redirect:/member_points/list";
//	}
}
