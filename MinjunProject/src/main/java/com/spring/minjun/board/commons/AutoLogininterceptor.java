package com.spring.minjun.board.commons;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.spring.minjun.user.model.UserVO;
import com.spring.minjun.user.service.IUserService;

public class AutoLogininterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private IUserService service;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		 HttpSession session = request.getSession();
		//cookie가 잇는지 확인 
		Cookie logincookie = WebUtils.getCookie(request,"loginCookie");
		//쿠카가 잇다면 쿠키 벨류 값으로 일치하는 회원의 정보를 가지고 온다 uservo를 불러온다 
		if(logincookie != null) {
			 UserVO user = service.getUserWithSessionId(logincookie.getValue());
			if(user != null) {
				session.setAttribute("login", user);
			}
		}
		return true;
	}
}
