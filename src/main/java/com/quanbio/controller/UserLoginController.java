package com.quanbio.controller;

import com.quanbio.model.UserLogin;
import com.quanbio.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/userlogin")
public class UserLoginController {
    @Autowired(required=false)
    private LoginService loginService;
    @RequestMapping("login")
    public UserLogin login(@RequestBody UserLogin userLogin) {
        UserLogin user = loginService.getByEmailAndPassword(userLogin.getEmail(), userLogin.getPassword());
        System.out.println(user);
        if(user == null){
            System.out.println(user);
            return null;
        }else{
            return user;
        }

    }

}
