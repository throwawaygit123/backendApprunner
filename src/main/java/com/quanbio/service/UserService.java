package com.quanbio.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.quanbio.model.User;
import com.quanbio.model.pojo.param.UserRoleParam;
import com.quanbio.model.pojo.po.UserPO;
import com.quanbio.model.pojo.vo.UserVO;

import java.util.List;

public interface UserService extends IService<User> {

    UserVO queryUser(String email, String password);

    List<UserPO> queryUserAndRole(Long page,Long pageSize);
    void remove( long id);

    /**
     * 修改用户角色名称
     */
    void updateUserRole(UserRoleParam param);

    UserVO queryUserRoleOne(Integer userId);
}
