package com.quanbio.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.quanbio.model.User;



public interface AccountService extends IService<User> {
    void addAccount(User user);

}
