package com.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 拦截器
 * @author mzg
 *
 */
public class HandlerInterceptorDemo2 implements HandlerInterceptor{
	Log log = LogFactory.getLog(this.getClass());

	/**
	 * handler执行之后
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		log.info("Demo2's afterCompletion method start");
	}
	
	/**
	 * 返回ModelAndView之前
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		log.info("Demo2's postHandle method start");
	}

	/**
	 * handler方法执行之前
	 * true放行
	 */
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		log.info("Demo2's preHandler method start");
		return true;
	}
	
}
