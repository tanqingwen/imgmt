package cn.happyworlds.imgmt.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.happyworlds.imgmt.entity.TSysStaff;
import cn.happyworlds.imgmt.service.StaffService;
import cn.happyworlds.imgmt.util.CheckMobile;
import cn.happyworlds.imgmt.util.Result;

@Controller
public class RootController {
	
	@Autowired
	private StaffService staffService;
	
	@WebAction(Permission.ROOT_INDEX)
	@RequestMapping("/")
	public String index(Model m) {
		return "index";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model m) {
		return "dashboard";
	}
	
	@WebAction(Permission.ROOT_LOGIN)
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model m) {
		if (WebContext.getCurrentStaff() != null) {
			return "redirect:/";
		}
		return "login";
	}
	
	@WebAction(Permission.ROOT_LOGIN)
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String staffId, String passwd, RedirectAttributes ra, HttpServletRequest request) {
		boolean isFromMobile=false;
		Result<TSysStaff> r1 = staffService.staffLogin(staffId, passwd);
		HttpSession session= request.getSession();
		if (r1.isError()) {
			ra.addFlashAttribute("Comment", r1.getComment());
//			ra.addFlashAttribute(WebContext.ACTION_FAILURE_TIP, r1.getComment());
			if(null==session.getAttribute("ua")){  
		        try{  
		            //获取ua，用来判断是否为移动端访问  
		            String userAgent = request.getHeader( "USER-AGENT" ).toLowerCase();    
		            if(null == userAgent){    
		                userAgent = "";    
		            }  
		            isFromMobile=CheckMobile.check(userAgent);  
		            //判断是否为移动端访问  
		            if(isFromMobile){  
		            	 
		                session.setAttribute("ua","mobile"); 
		                return "ticket/feishiming"; 
		            } else {  		            	  
		                session.setAttribute("ua","pc");
		                return "redirect:/";
		            }  
		        }catch(Exception e){}  
		    }else{  
		        isFromMobile=session.getAttribute("ua").equals("mobile");  
		    }
			return "redirect:/login";
		}
		TSysStaff priviousStaff = WebContext.getCurrentStaff();
		
		if(priviousStaff != null && priviousStaff.getId().equals(r1.getValue().getId())){
			//用户异地登录，退出之前用户，更新登录时间，保存交接班信息
		}
		WebContext.setCurrentStaff(r1.getValue());
		   //检查是否已经记录访问方式（移动端或pc端）      
		    return "redirect:/";
	}
	
	@WebAction(Permission.ROOT_LOGOUT)
	@RequestMapping(value = "/logout")
	public String logout() {
		//退出前保存登出时间，保存交接班信息
		
		WebContext.removeCurrentStaff();
		return "redirect:/login";
	}
	
	@WebAction(Permission.ROOT_LOCKSCREEN)
	@RequestMapping("/lockscreen")
	public String lockscreen(Model m) {
		return "lockscreen";
	}
	
	@WebAction(Permission.ROOT_AUTH_FAIL)
	@RequestMapping("/auth_fail")
	public String authFail(Model m) {
		return "auth_fail";
	}
	
	@RequestMapping(value="/startTreeviewDetail/{Detail}")
	public String startTreeviewDetail(@PathVariable("Detail") String Detail,Model m) {
		if(Detail.equals("xcgl")){
			m.addAttribute("item", "现场管理");
			return "startTreeview";
		}else if(Detail.equals("cggl")){
			m.addAttribute("item", "场馆管理");
			return "startTreeview2";
		}else if(Detail.equals("pwzy")){
			m.addAttribute("item", "票务作业");
			return "startTreeview";
		}else if(Detail.equals("hykzy")){
			m.addAttribute("item", "会员卡作业");
			return "startTreeview";
		}else if(Detail.equals("hygl")){
			m.addAttribute("item", "会员管理");
			return "startTreeview";
		}else if(Detail.equals("ywgl")){
			m.addAttribute("item", "业务管理");
			return "startTreeview";
		}else if(Detail.equals("ywcx")){
			m.addAttribute("item", "业务查询");
			return "startTreeview";
		}else if(Detail.equals("tjbb")){
			m.addAttribute("item", "统计报表");
			return "startTreeview";
		}else if(Detail.equals("webwh")){
			m.addAttribute("item", "web维护");
			return "startTreeview";
		}else if(Detail.equals("xtgl")){
			m.addAttribute("item", "系统管理");
			return "startTreeview";
		}else if(Detail.equals("jbcsgl")){
			m.addAttribute("item", "基本参数管理");
			return "startTreeview3";
		}else{
			return "index";
		}
	}
}
