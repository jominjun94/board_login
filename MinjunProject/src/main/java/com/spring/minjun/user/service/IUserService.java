package com.spring.minjun.user.service;

import java.util.Date;
import java.util.Map;

import com.spring.minjun.user.model.UserVO;

public interface IUserService {

	
	//회원 가입 
		public void register(UserVO user);
		
		//회원탈퇴 
		public void delete();

		// 아이디 중복 확인 검사 로직 
		public Integer checkId(String id);
		
		public UserVO selectOne(String id);
		
		
		void keepLogin(String sessionId, Date limitDate, String account);
		
		UserVO getUserWithSessionId(String sessionId);
}
