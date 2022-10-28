//package com.quanbio.controller;
//
//import com.quanbio.jwttoken.JwtToken;
//import com.quanbio.model.Menu;
//import com.quanbio.model.pojo.po.UserPO;
//import com.quanbio.model.pojo.vo.UserVO;
//import com.quanbio.structure.UserRolePermission;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//
//import com.quanbio.mapper.UserRepository;
//import com.quanbio.model.User;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//@CrossOrigin
//@RestController
//@RequestMapping("/api/userr")
//public class UserController {
//
//	@Autowired
//	private UserRepository userRepository;
//
////	@PostMapping
////	public User addUser(@RequestBody User user) {
////		return this.userRepository.save(user);
////	}
//
//
////	@GetMapping("/user_role")
////	    public UserRolePermission login(String email, String password) {
////
////		UserRolePermission user_role;
////
////		//Optional<User> user = userRepository.findByEmailAndPassword(email, password);
////		return user_role;
////	 }
////@GetMapping("/user_role")
////public Map<String,Object> login(String email, String password) {
////	Map<String,Object> map = new HashMap<String,Object>();
////	try {
////		List<User> list = userRepository.findByEmailAndPassword(email,password);
//////		list.forEach((k,v) ->{
//////			List<Menu> menus = new ArrayList<Menu>();
//////			v.forEach(User -> {
//////				Menu menu = new Menu();
//////				menu.setId(Long.valueOf(User.getMenuId()));
//////				menu.setName(userPO.getMenuName());
//////				menu.setIcon(userPO.getMenuIcon());
//////				menus.add(menu);
//////				user.setUserId(userPO.getUserId());
//////				user.setRoleName(userPO.getRoleName());
//////				user.setUserName(userPO.getUserName());
//////				user.setEmail(userPO.getEmail());
//////			});
//////			user.setMenus(menus);
//////		});
//////		for (User user : list) {
//////			List<Menu> menus = new ArrayList<Menu>();
//////			for (Menu menu : menus) {
//////			user.setMenus((List<Menu>) menu);
//////			}
//////			Map<String,String> payload = new HashMap<>();
//////			payload.put("id",user.getId()+"");
//////			payload.put("email",user.getEmail());
//////			String token = JwtToken.getToken(payload);
//////			map.put("state",true);
//////			map.put("msg","Authentication success");
//////			map.put("token",token);
//////			map.put("data",user);
//////		}
//////	}catch (Exception e){
//////		map.put("state",false);
//////		map.put("msg",e.toString());
////	}
////	return map;
////
////}
//
//
//
//}
