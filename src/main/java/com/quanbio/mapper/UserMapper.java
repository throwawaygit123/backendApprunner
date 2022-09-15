package com.quanbio.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.quanbio.model.User;
import com.quanbio.model.pojo.po.UserPO;
import com.quanbio.model.pojo.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据 email ，password 查询
     * Query by email and password
     * @param email
     * @param password
     * @return
     */
    List<UserPO> queryList(String email, String password);

    /**
     *
     */
    List<UserPO> queryUserAndRole(Long page,Long pageSize);

    void delete(long id);

    UserVO queryUserRoleOne(Integer userId);
}
