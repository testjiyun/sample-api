package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.DemoService;
import com.example.demo.vo.UserVO;

@RestController
@RequestMapping(value = DemoController.CONTEXT_ROOT, produces = MediaType.APPLICATION_JSON_VALUE)
public class DemoController {

	public static final String CONTEXT_ROOT = "v1/demo";
	
	@Autowired
	private DemoService demoService;
	
	
	@PostMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserVO createUser(@RequestBody UserVO inVO) {
		
		demoService.createUser(inVO);
		return inVO;
	}
	
	@GetMapping(value="/user/{userId}")
	public UserVO getUser(@PathVariable("userId") String userId) {
		
		UserVO outVO = new UserVO();
		outVO = demoService.getUser(userId);
		
		return outVO;
	}
	
}
