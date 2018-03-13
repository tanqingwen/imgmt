package cn.happyworlds.imgmt.web;

import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import cn.happyworlds.imgmt.aop.WebHandleInterceptor;
import cn.happyworlds.imgmt.entity.TSysStaff;
import cn.happyworlds.imgmt.json.Jackson;
import cn.happyworlds.imgmt.service.RoleService;
import cn.happyworlds.imgmt.spring.mvc.HandlerExceptionView;
import cn.happyworlds.imgmt.util.Requests;
import cn.happyworlds.imgmt.util.Result;

@Component
public class SecurityCheckInterceptor implements WebHandleInterceptor {

	private static final Logger LOG = LoggerFactory.getLogger(SecurityCheckInterceptor.class);
	
	@Autowired
	private RoleService roleService;

	@Override
	public int getOrder() {
		return 0;
	}

	@Override
	public void preHandle(MethodSignature methodSignature) throws Exception {
		Method method = methodSignature.getMethod();
		RestAction ra = method.getAnnotation(RestAction.class);
		
		if(ra != null){
			String errMsg = WebContext.validSessionByToken();
			if(!StringUtils.isEmpty(errMsg))
				errorHandleByToken(errMsg, "PLEASE_LOGIN");
			TSysStaff staff = null;
			try {
				staff = WebContext.getCurrentStaffByToken();
				if(staff == null)
					errorHandleByToken("session is invalidated", "PLEASE_LOGIN");
				LOG.info("rest 用户staff:{}", staff);
			}catch(Exception e) {
				e.printStackTrace();
				errorHandleByToken("session is invalidated", "PLEASE_LOGIN");
			}
		}
		
		WebAction wa = method.getAnnotation(WebAction.class);
		if (wa == null) {
			return;
		}

		Permission permission = wa.value();
		if (LOG.isInfoEnabled()) {
			LOG.info("客户端：[{}] 功能：[{}] 描述：[{}]", Requests.getRequest().getRemoteHost(), permission.name(), permission.description());
		}
		
		WebContext.reloadRoles(roleService, false);
		if (WebContext.checkPermission(permission.name())) {
			return;
		}
		
		TSysStaff staff = WebContext.getCurrentStaff();
		if (staff == null) {
			errorHandle("请登录", "PLEASE_LOGIN", "redirect:/login");
		} else {
			errorHandle("授权失败", "AUTHORIZATION_FAILURE", "redirect:/auth_fail");
		}
	}
	
	private void errorHandle(String errorMessage, String errorCode, String errorView) {
		LOG.info(errorMessage);
		if (Requests.isAjaxRequest()) {
			Result<String> result = Result.create(errorCode, errorMessage);
			throw new HandlerExceptionView(errorMessage, new View() {
				@Override
				public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
						throws Exception {
					Jackson.writeJsonToStream(response.getOutputStream(), result);
				}

				@Override
				public String getContentType() {
					return MappingJackson2JsonView.DEFAULT_CONTENT_TYPE;
				}
			});
		} else {
			throw new HandlerExceptionView(errorMessage, errorView);
		}
	}
	
	private void errorHandleByToken(String errMsg, String errCode){
		Result<String> result = Result.create(errCode, errMsg);
		throw new HandlerExceptionView(errMsg, new View() {
			@Override
			public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
					throws Exception {
				Jackson.writeJsonToStream(response.getOutputStream(), result);
			}

			@Override
			public String getContentType() {
				return MappingJackson2JsonView.DEFAULT_CONTENT_TYPE;
			}
		});
	}

}
