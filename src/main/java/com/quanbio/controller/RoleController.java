//package com.quanbio.controller;
//
//import com.quanbio.model.UserLogin;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//
//import com.quanbio.mapper.RoleRepository;
//
//import com.quanbio.model.Role;
//
//import java.util.List;
//
//@CrossOrigin
//@RestController
//@RequestMapping("/api/role")
//public class RoleController {
//
//	@Autowired
//	private RoleRepository roleRepository;
//
//	@PostMapping
//	public Role addRole(@RequestBody Role role) {
//		return this.roleRepository.save(role);
//	}
//
////	@GetMapping("queryrole")
////	public Role getRole(Long id) {
////		return this.roleRepository.getById(id);
////	}
//
//}
