package com.spring.minjun.user.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.minjun.user.model.UserVO;
import com.spring.minjun.user.repository.IUserMapper;

@Service
public class UserService implements IUserService {

	
	@Autowired
	IUserMapper mapper;
	
	@Override
	public void register(UserVO user) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		
		mapper.register(user);
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		mapper.delete();
	}

	@Override
	public Integer checkId(String id) {
		// TODO Auto-generated method stub
		return mapper.checkId(id);
	}

	@Override
	public UserVO selectOne(String id){
		// TODO Auto-generated method stub
		return mapper.selectOne(id);
	}

	@Override
	public void keepLogin(String sessionId, Date limitDate, String account) {
		
		Map<String, Object> datas = new HashMap<>();
		datas.put("sessionId", sessionId);
		datas.put("limitDate", limitDate);
		datas.put("account", account);
		
		mapper.keepLogin(datas);		
	}

	@Override
	public UserVO getUserWithSessionId(String sessionId) {
		// TODO Auto-generated method stub
		return mapper.getUserWithSessionId(sessionId);
	}




}
