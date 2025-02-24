package com.example.demo.service;

import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.UserRepository;
import com.example.demo.repository.entity.UserEntity;
import com.example.demo.vo.UserVO;

@Service
public class DemoService {
	
	@Autowired
	private UserRepository repository;
	
	public UserVO createUser(UserVO inVO) {
		
		UserEntity userEntity = new UserEntity();
		userEntity.setUserId(inVO.getUserId());
		userEntity.setUserName(inVO.getUserName()+"-docker-latest");

		repository.save(userEntity);
		
		return inVO;
	}
	
	
	public UserVO getUser(String userId) {
		
		UserEntity userEntity = new UserEntity();
		userEntity = repository.findByUserId(userId);
		
		UserVO outVO = new UserVO();
		outVO.setUserId(userEntity.getUserId());
		outVO.setUserName(userEntity.getUserName());
		
		return outVO;
	}
}
