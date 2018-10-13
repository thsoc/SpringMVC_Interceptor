package com.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		String uri = arg0.getRequestURI();
		//判断是否是登陆登出请求
		if(!(uri.contains("Login") || uri.contains("login"))) {//不是登陆登出请求
			if(arg0.getSession().getAttribute("user") != null) {
				return true;
			}else {
				arg1.sendRedirect(arg0.getContextPath()+"/user/toLogin.action");
			}
		}else {//是登陆登出请求
			return true;
		}
		return false;
	}

}
