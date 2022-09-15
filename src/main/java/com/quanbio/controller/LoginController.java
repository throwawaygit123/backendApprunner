package com.quanbio.controller;


import com.quanbio.jwttoken.JwtToken;
import com.quanbio.mapper.LoginRepository;
import com.quanbio.mapper.UserRepository;
import com.quanbio.model.User;
import com.quanbio.model.UserLogin;
import com.quanbio.model.pojo.po.UserPO;
import com.quanbio.model.pojo.vo.UserVO;
import com.quanbio.service.UserService;
//import com.quanbio.util.MyMD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/api/userlogin")
public class LoginController {

    @Autowired
    private LoginRepository loginRepository  ;

    @Autowired
    private UserRepository userRepository  ;

    @Autowired
    private UserService userService ;


    @GetMapping
    public List<UserLogin> getLogin() {
        return this.loginRepository.findAll();
    }

    @PostMapping
    public UserLogin addLogin(@RequestBody UserLogin login) {
        return this.loginRepository.save(login);
    }


    @GetMapping("/user")
    public Map<String,Object> login(String email, String password) {
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            UserVO userVO = userService.queryUser(email,password);
            Map<String,String> payload = new HashMap<>();
            payload.put("id",userVO.getUserId()+"");
            payload.put("email",userVO.getEmail());
            String token = JwtToken.getToken(payload);
            map.put("state",true);
            map.put("msg","Authentication success");
            map.put("token",token);
            map.put("data",userVO);
        }catch (Exception e){
            map.put("state",false);
            map.put("msg",e.toString());
        }
        return map;

    }

    @GetMapping("/userone")
    public Optional<User> queryUserone(Long id){
        return userRepository.findById(id);
    }


    @GetMapping("/userRole")
    public  List<UserPO> queryUserAndRole(@RequestParam("page") Long page,@RequestParam("pageSize")Long pageSize) {
        List<UserPO> list= userService.queryUserAndRole(page,pageSize);
        return list;
    }

    @DeleteMapping("/delete")
    public void DeleteUserAndRole(long id){
        userService.removeById(id);
    }

    @PostMapping("/add")
    public void AddUser(User user){
        userService.save(user);
    }

}
