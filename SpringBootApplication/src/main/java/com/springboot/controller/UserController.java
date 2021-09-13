package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.UserEntity;
import com.springboot.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/getAllUsers")
	public List<UserEntity> getAllUser() {
		System.out.println("get All User Controller");
		return userService.getAllUsers();
	}

	@PostMapping("/createUser")
	public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity entity) {
		UserEntity uEntity = userService.saveUser(entity);
		return ResponseEntity.status(200).body(uEntity);
	}
	
	@GetMapping("/getUser/{userLogin}")
	public List<UserEntity> getUser(@PathVariable("userLogin") String  userLogin ) {
		System.out.println("get User By ID");
		return userService.getUserByUserName(userLogin);
	}


}
