package com.spring.minjun.user.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.cookie;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.spring.minjun.user.model.UserVO;
import com.spring.minjun.user.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService service;
	
	
	
	@GetMapping("/log")
	public ModelAndView log() {
		
		return new ModelAndView("user/log");
	}
	
	@GetMapping("/login")
	public ModelAndView login() {
		
		return new ModelAndView("user/login");
	}
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, HttpSession session , HttpServletResponse response) {
		UserVO user = (UserVO)session.getAttribute("login");
		if(	session.getAttribute("login") != null) {
			session.removeAttribute("login");
			session.invalidate();
			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
			if(loginCookie != null) {
				loginCookie.setMaxAge(0);
				response.addCookie(loginCookie);
				service.keepLogin("none", new Date(), user.getAccount());
			}
		}
		
		
		return new ModelAndView("user/login");
	}
	
	
	@PostMapping("/")
	public String log(@RequestBody UserVO user) {
	
		service.register(user);
		
		String result = "joinSuccess";
		return result;
	}
	
	
	
	
	
	
	
	
	@PostMapping("/checkId")
	public String checkId(@RequestBody String id) {
		
		String result = null;
		  Integer check = service.checkId(id);
		if(check  == null) {
			result = "OK";
		}else if(check != null) {
			result = "no";
		}
		return result;
	}
	
	
	
	
	@PostMapping("/login")
	public String login(@RequestBody UserVO user , HttpSession session , HttpServletResponse response) {
		String result = null;
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		UserVO dbuser  = service.selectOne(user.getAccount());
		if(dbuser != null) {
		
		if(encoder.matches(user.getPassword(),dbuser.getPassword())){
		//if(user.getPassword().equals(dbuser.getPassword()))	{
	//	if(user.getPassword() == dbuser.getPassword()) { -- 떙..
			session.setAttribute("login",dbuser);
			result = "loginSuccess";
			
			long limitTime = 60 * 60 * 24 * 90;
			// date 날짜 시간으로 만들기 
			long expire = System.currentTimeMillis() + (limitTime * 1000);
			Date limitDate = new Date(expire);
			if(user.isAutoLogin()) {
				Cookie loginCookie = new Cookie("loginCookie", session.getId());
				//loginCookie.setPath("/"); // 저장 경로를 시작 uri에 담아서 
				loginCookie.setMaxAge((int)limitTime); // 수명 설정 3개월 
				response.addCookie(loginCookie); // -- 이러면 클라이언트에 쿠키가 생성 됨
				
				service.keepLogin(session.getId(),limitDate,user.getAccount());
			}
		} else {
			result = "pwFail";
		}
	} else {
		result = "idFail";
	}
	
	return result;
	
		
		
}
}
