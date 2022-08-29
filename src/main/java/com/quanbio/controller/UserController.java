package com.quanbio.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.quanbio.mapper.UserRepository;
import com.quanbio.model.User;
import com.quanbio.structure.UserRolePermission;

@CrossOrigin
@RestController 
@RequestMapping("/api/userr")
public class UserController {
	
	@Autowired 
	private UserRepository userRepository;
	
	@PostMapping
	public User addUser(@RequestBody User user) {
		return this.userRepository.save(user);
	}
	
//	
//	@GetMapping("/user_role")
//	    public UserRolePermission login(String email, String password) {
//		
//		UserRolePermission user_role; 
//		
//		//Optional<User> user = userRepository.findByEmailAndPassword(email, password); 
//		return user_role; 
//	 }
//	 
	

}
