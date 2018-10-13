package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vo.User;

@Controller
@RequestMapping("/user")
public class UserController {
	@RequestMapping(value = "getUser")
	public ModelAndView getUser(@RequestParam(name = "id") Integer id) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", id);
		mv.setViewName("welcome");
		return mv;
	}
	
	/**
	 * 跳转登陆页面
	 * @return
	 */
	@RequestMapping(value="toLogin")
	public String toLogin() {
		return "/user/login";
	}
	
	/**
	 * 登陆
	 * @param model
	 * @param req
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/login")
	public String login(Model model,HttpServletRequest req,User user) {
		boolean flag = checkUser(user);
		if(flag) {
			req.getSession().setAttribute("user", user);
		}else {
			model.addAttribute("errorMsg", "账号或者密码错误！");
			return "/user/login";
		}
		return "/user/loginSuccess";
	}

	private boolean checkUser(User user) {
		if(StringUtils.equals(user.getUsername(), "张三")
				&& StringUtils.equals(user.getPassword(), "123")) {
			return true;
		}
		return false;
	}
	
	@RequestMapping(value="/loginout")
	public String loginout(Model model,HttpServletRequest req) {
		if(req.getSession().getAttribute("user") != null) {
			req.getSession().removeAttribute("user");
		}else {
			model.addAttribute("errorMsg", "用户已经退出");
		}
		return "/user/login";
	}
	
	@RequestMapping(value="/success")
	public String success(Model model) {
		return "/user/loginSuccess";
	}
	
}
