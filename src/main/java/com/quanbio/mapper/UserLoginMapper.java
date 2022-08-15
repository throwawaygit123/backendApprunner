package com.quanbio.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.quanbio.model.UserLogin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserLoginMapper extends BaseMapper<UserLogin> {
//    UserLogin queryUserLoginAndRole(UserLogin user);
}
