package com.quanbio.service.impl;

import com.quanbio.mapper.LoginMapper;
import com.quanbio.model.UserLogin;
import com.quanbio.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;

    @Override
    public UserLogin getByEmailAndPassword(String email, String password) {
        UserLogin login = loginMapper.getByEmailAndPassword(email, password);
        return login;
    }
}
