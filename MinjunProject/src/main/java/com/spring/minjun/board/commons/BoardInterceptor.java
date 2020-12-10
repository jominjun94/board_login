package com.spring.minjun.board.commons;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class BoardInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//session을 불러오기
		HttpSession session = request.getSession();
		
		if(session.getAttribute("login") == null) {
			response.sendRedirect("/board/list");
			return false;
		}
		
		// TODO Auto-generated method stub
		return true;
	}
}
