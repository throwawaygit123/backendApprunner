package com.quanbio.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.quanbio.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper extends BaseMapper<User> {

    void addAccount(User user);
}
