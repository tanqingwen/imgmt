package cn.happyworlds.imgmt.util;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Created by jia on 2015/7/26.
 */
public class Requests {

    public static HttpServletRequest getRequest() {
        RequestAttributes ra = RequestContextHolder.currentRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        return sra.getRequest();
    }

    public static HttpSession getSession() {
        return getRequest().getSession();
    }

    public static HttpSession getSession(boolean isCreate) {
        return getRequest().getSession(isCreate);
    }
    
    public static ServletContext getServletContext() {
    	return getSession().getServletContext();
    }

    public static boolean isAjaxRequest() {
    	return getRequest().getHeader("X-REQUESTED-WITH") == null ? false : true;
    }
    
    public static String getRequestAddr() {
    	HttpServletRequest req = getRequest();
    	
//    	Enumeration<String> headers = req.getHeaderNames();
//    	while(headers.hasMoreElements()) {
//    		String name = headers.nextElement();
//    		System.out.println("header name :" + name + "; header value :" + req.getHeader(name));
//    	}
//    	System.out.println("remote addr : "+ req.getRemoteAddr());
    	
    	String ip = req.getHeader("x-forwarded-for");
    	if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
    		ip = req.getHeader("Proxy-Client-IP");
    		System.out.println("ip1:" + ip);
    	}
    	if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
    		ip = req.getHeader("WL-Proxy-Client-IP");
    		System.out.println("ip2:" + ip);
    	}
    	if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
    		ip = req.getRemoteAddr();
    		System.out.println("ip3:" + ip);
    	}
    	if(ip==null || ip.split("\\.").length != 4)
    		return null;
    	return ip;
    }
}
