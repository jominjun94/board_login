package com.spring.minjun.user.repository;

import java.util.Date;
import java.util.Map;

import com.spring.minjun.user.model.UserVO;

public interface IUserMapper {

	//회원 가입 
	public void register(UserVO user);
	
	//회원탈퇴 
	public void delete();
	
	public Integer checkId(String id);
	
	public UserVO selectOne(String id);
	
	//자동 로그인 쿠키값 db저장처리
	
	void keepLogin(Map<String,Object> datas);
	
	//session을 가져와 보자 ㅎㅎ
	UserVO getUserWithSessionId(String sessionId);
}
