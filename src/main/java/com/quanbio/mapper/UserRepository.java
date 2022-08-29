package com.quanbio.mapper;

import com.quanbio.model.User;
import com.quanbio.structure.UserRolePermission;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {
	
	 public Optional<User> findByEmailAndPassword(String email, String password);
	
	 // Another function to return user and role menu together 
	 //public Optional<UserRolePermission> function(User user);
	// Query 
	// SELECT quanbiodb_dev.menu.*  FROM quanbiodb_dev.menu JOIN quanbiodb_dev.role_menu on role_menu.role_id=user.getRoleID() where role_menu.menu_id=menu.id;

}
