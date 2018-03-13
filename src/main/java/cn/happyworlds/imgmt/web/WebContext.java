package cn.happyworlds.imgmt.web;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import cn.happyworlds.imgmt.entity.TSysRole;
import cn.happyworlds.imgmt.entity.TSysStaff;
import cn.happyworlds.imgmt.service.RoleService;
import cn.happyworlds.imgmt.util.Requests;

final class WebContext {
	
	public static final String ACTION_SUCCESS_TIP = "__ACTION_SUCCESS_TIP__";
	public static final String ACTION_FAILURE_TIP = "__ACTION_FAILURE_TIP__";
	
	public static final String GUEST_PERMISSIONS = ",ROOT_LOGIN,ROOT_LOGOUT,ROOT_AUTH_FAIL,CALLCENTER_LOGIN,";
	
	public static final String OPTION_LOGIN_CONFIG = "LOGIN_CONFIG";
	
	public static final String CURRENT_STAFF = "currentStaff";
	
	private static final String TOKEN_SUFF = "token";
	
	private static volatile Map<String, String> ROLE_FUNCTION_MAP;
	private static volatile Map<String, HttpSession> USER_SESSION_MAP = new ConcurrentHashMap<>();
	
	/**
	 * 根据提交的参数前缀获取请求值并转换成 Map 返回，转换过程中会删除参数前缀
	 * 
	 * @param perifx 参数的前缀
	 * @return Map
	 */
	public static Map<String, String> getParametersMap(String perifx) {
		HttpServletRequest req = Requests.getRequest();
		Map<String, String> params = new HashMap<>();
		Enumeration<String> names = req.getParameterNames();
		String name = null;
		while (names.hasMoreElements()) {
			name = names.nextElement();
			if (name.startsWith(perifx)) {
				params.put(name.substring(perifx.length() + 1), req.getParameter(name));
			}
		}
		return params;
	}

	/**
	 * 把当前登录员工对像放到会话中，会先让会话失效再创建一个新的会话
	 * 
	 * @param staff 当前登录的员工
	 */
	public static void setCurrentStaff(TSysStaff staff) {
		HttpSession priviSession = USER_SESSION_MAP.get(staff.getId() + TOKEN_SUFF);
		if(priviSession != null){
			USER_SESSION_MAP.remove(staff.getId() + TOKEN_SUFF);
		}
		Requests.getSession().invalidate();
		HttpSession session = Requests.getSession(true);
		session.setAttribute(CURRENT_STAFF, staff);
		HttpSession priSession = USER_SESSION_MAP.get(staff.getId());
		if(priSession != null) {
			priSession.invalidate();
		}
		USER_SESSION_MAP.put(staff.getId(), session);
	}
	
	/**
	 * 重新设置当前登录的员工
	 * 
	 * @param staff 当前登录的员工
	 */
	public static void resetCurrentStaff(TSysStaff staff) {
		HttpSession session = USER_SESSION_MAP.get(staff.getId());
		if (null == session) {
			return;
		}
		session.setAttribute(CURRENT_STAFF, staff);
	}
	
	/**
	 * 获取当前登录的员工，没有登录返回 null
	 * 
	 * @return
	 */
	public static TSysStaff getCurrentStaff() {
		Object staff = Requests.getSession().getAttribute(CURRENT_STAFF);
		return staff == null ? null : (TSysStaff) staff;
	}
	
	public static void removeCurrentStaff() {
		HttpSession session = Requests.getSession();
		removeCurrentStaff(session);
		session.invalidate();
	}
	
	/**
	 * 获取当前登录的员工，没有登录返回 null
	 * 
	 * @return
	 */
	public static void removeCurrentStaff(HttpSession session) {
		Object usrObj = session.getAttribute(CURRENT_STAFF);
		if (null == usrObj) {
			return;
		}
		TSysStaff staff = (TSysStaff) usrObj;
		session.removeAttribute(CURRENT_STAFF);
		USER_SESSION_MAP.remove(staff.getId());
		USER_SESSION_MAP.remove(staff.getId() + TOKEN_SUFF);
	}
	
	public static boolean checkPermission(final String permission) {
		String fn = "," + permission + ",";
		if (WebContext.GUEST_PERMISSIONS.indexOf(fn) >= 0) {
			return true;
		}

		TSysStaff staff = getCurrentStaff();
		if (null == staff) {
			return false;
		}
		String[] staffRoles = staff.getRoles() == null ? null : staff.getRoles().split(",");
		if (null == staffRoles || staffRoles.length == 0) {
			return false;
		}

		for (int i = 0; i < staffRoles.length; i++) {
			String fns = ROLE_FUNCTION_MAP.get(staffRoles[i]);
			if (fns != null && fns.indexOf(fn) >= 0) {
				return true;
			}
		}
		return false;
	}
	
	public static void reloadRoles(RoleService roleService, boolean forced) {
		if (forced || null == ROLE_FUNCTION_MAP) {
			List<TSysRole> roles = roleService.roleList();
			ROLE_FUNCTION_MAP = new ConcurrentHashMap<>(roles.size());
			for (TSysRole role : roles) {
				ROLE_FUNCTION_MAP.put(role.getId(), "," + role.getFunctions() + ",");
			}
		}
	}
	
	/**
	 * 设置rest session用户
	 * @param staff
	 */
	public static void setCurrentStaffByToken(TSysStaff staff){
		HttpSession priviSession = USER_SESSION_MAP.get(staff.getId());
		if(priviSession != null){
			priviSession.invalidate();
			USER_SESSION_MAP.remove(staff.getId());
		}
		HttpSession session = Requests.getRequest().getSession(true);
		session.setAttribute(CURRENT_STAFF, staff);
		USER_SESSION_MAP.put(staff.getId() + TOKEN_SUFF, session);
	}
	/**
	 * 获取rest session用户
	 * @param staffId
	 * @return
	 */
	public static TSysStaff getCurrentStaffByToken(String staffId){
		HttpSession session = USER_SESSION_MAP.get(staffId + TOKEN_SUFF);
		if(session != null){
			return (TSysStaff) session.getAttribute(CURRENT_STAFF);
		}
		return null;
	}
	/**
	 * 获取rest session用户
	 * @return
	 */
	public static TSysStaff getCurrentStaffByToken(){
		String staffId = Requests.getRequest().getHeader("userId");
		System.out.println("header id:" + staffId);
		if(staffId == null)
			return null;
		HttpSession session = USER_SESSION_MAP.get(staffId + TOKEN_SUFF);
		if(session != null){
			return (TSysStaff) session.getAttribute(CURRENT_STAFF);
		}
		return null;
	}
	
	public static void removeCurrentStaffByToken(){
		String staffId = Requests.getRequest().getHeader("userId");
		if(staffId != null){
			HttpSession session = USER_SESSION_MAP.get(staffId + TOKEN_SUFF);
			if(session != null)
				session.invalidate();
			USER_SESSION_MAP.remove(staffId + TOKEN_SUFF);
		}
	}
	
	public static String validSessionByToken(){
		String staffId = Requests.getRequest().getHeader("userId");
		if(StringUtils.isEmpty(staffId))
			return "安全校验失败";
		return null;
	}
}
