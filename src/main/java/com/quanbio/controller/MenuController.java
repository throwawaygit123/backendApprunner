package com.quanbio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quanbio.mapper.MenuRepository;
import com.quanbio.model.Menu;



@CrossOrigin
@RestController 
@RequestMapping("/api/menu")
public class MenuController {
	
	@Autowired 
	private MenuRepository menuRepository;
	
	
	@PostMapping
	public Menu addMenu(@RequestBody Menu menu) {
		return this.menuRepository.save(menu);
	}

}
