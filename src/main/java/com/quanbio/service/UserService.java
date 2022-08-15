package com.quanbio.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.quanbio.model.User;
import com.quanbio.model.pojo.vo.UserVO;

public interface UserService extends IService<User> {

    UserVO queryUser(String email, String password);
}
