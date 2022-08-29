package com.quanbio.controller;


import com.quanbio.jwttoken.JwtToken;
import com.quanbio.mapper.LoginRepository;
import com.quanbio.model.UserLogin;
import com.quanbio.model.pojo.vo.UserVO;
import com.quanbio.service.UserService;
//import com.quanbio.util.MyMD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/userlogin")
public class LoginController {

    @Autowired
    private LoginRepository loginRepository  ;

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

//    @PostMapping("/login")
//    public UserLogin login(@RequestBody UserLogin login) {
//
//        UserLogin user =this.loginRepository.findByEmailAndPassword(login.getEmail(),login.getPassword())
//                .orElseThrow(() -> new RecordNotFoundException("Email and Password do not match ! "));
//
//            return user;
//
//    }

    @GetMapping("/user")
    public Map<String,Object> login(String email, String password) {
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            UserVO userVO = userService.queryUser(email,password);
//            UserLogin login =loginRepository.findByEmailAndPassword(user.getEmail(),user.getPassword());
//            UserLogin login1 = new UserLogin();
//            login1.setEmail(login.getEmail());
//            login1.setId(login.getId());
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

}
