package com.quanbio.mapper;

import com.quanbio.model.UserLogin;


public interface LoginMapper{
     UserLogin getByEmailAndPassword(String email, String password);
}
