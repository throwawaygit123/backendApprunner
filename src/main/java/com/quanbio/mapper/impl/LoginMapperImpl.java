package com.quanbio.mapper.impl;


import com.quanbio.mapper.LoginMapper;
import com.quanbio.model.UserLogin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
@Mapper
public class LoginMapperImpl  implements LoginMapper {
    @Autowired
    private LoginMapper loginMapper;
    @Override
    public UserLogin getByEmailAndPassword(String email, String password) {
        return loginMapper.getByEmailAndPassword(email, password);
    }


}
