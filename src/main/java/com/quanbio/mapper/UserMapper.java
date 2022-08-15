package com.quanbio.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.quanbio.model.User;
import com.quanbio.model.pojo.po.UserPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据 email ，password 查询
     * @param email
     * @param password
     * @return
     */
    List<UserPO> queryList(String email, String password);
}
