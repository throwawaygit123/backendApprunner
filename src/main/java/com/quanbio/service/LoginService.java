package com.quanbio.service;

import com.quanbio.model.UserLogin;

public interface LoginService {
    UserLogin getByEmailAndPassword(String email, String password);
}
