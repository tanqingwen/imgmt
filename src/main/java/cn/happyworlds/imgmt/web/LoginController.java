package cn.happyworlds.imgmt.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.happyworlds.imgmt.bean.StaffTokenBean;
import cn.happyworlds.imgmt.entity.TSysStaff;
import cn.happyworlds.imgmt.service.StaffService;
import cn.happyworlds.imgmt.util.Digests;
import cn.happyworlds.imgmt.util.JwtTokenUtils;
import cn.happyworlds.imgmt.util.Result;

@RestController
@ResponseBody
@CrossOrigin
@RequestMapping("/rest/")
public class LoginController {

	private static Logger log = LoggerFactory.getLogger(LoginController.class); 
	@Autowired
	private StaffService staffService;

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public Object login(HttpServletRequest request){
		try{
			String staffId = request.getParameter("staffId");
			String password = request.getParameter("password");
			password = Digests.md5DigestAsHex(password);
			String token = request.getParameter("token");
			log.info("REST登录请求staffId:{},password:{},token:{}", staffId,password,token);
			Result<TSysStaff> r1 = staffService.staffLogin(staffId, password);
			if(r1.isError())
				return r1;
			TSysStaff staff = r1.getValue();
			WebContext.setCurrentStaffByToken(staff);
			StaffTokenBean subject = new StaffTokenBean(staff.getId(),staff.getRoles(),staff.getStatus());
			subject.setToken(JwtTokenUtils.createJwtToken(staff.getId(), subject, JwtTokenUtils.defaultExpPeriod));
			return Result.create(subject);
		}catch(Exception e){
			log.error("rest登录请求系统异常", e);
			return Result.create("error", "系统异常");
		}
	}
	@RestAction
	@RequestMapping(value = "loginout", method = RequestMethod.POST)
	public Object loginOut(HttpServletRequest request){
		try{
			WebContext.removeCurrentStaffByToken();
			return Result.create("注销成功");
		}catch(Exception e){
			log.error("rest登录请求系统异常", e);
			return Result.create("error", "系统异常");
		}
	}
}
