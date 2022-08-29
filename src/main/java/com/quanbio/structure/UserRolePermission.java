package com.quanbio.structure;

import java.util.List;

import com.quanbio.model.Menu;

import com.quanbio.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRolePermission {
	
	private User user; 
	private List<Menu> menu; 

}
