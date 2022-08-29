package com.quanbio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.quanbio.mapper.RoleRepository;

import com.quanbio.model.Role;

@CrossOrigin
@RestController 
@RequestMapping("/api/role")
public class RoleController {
	
	@Autowired 
	private RoleRepository roleRepository;
	
	@PostMapping
	public Role addRole(@RequestBody Role role) {
		return this.roleRepository.save(role);
	}

}
