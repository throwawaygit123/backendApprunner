//package com.quanbio.service;
//
//import com.baomidou.mybatisplus.extension.service.IService;
//import com.quanbio.model.User;
//import com.quanbio.model.pojo.param.UserRoleParam;
//import com.quanbio.model.pojo.po.UserPO;
//import com.quanbio.model.pojo.vo.UserVO;
//
//import java.util.List;
//
//public interface UserService extends IService<User> {
//    /**
//     * Query the identity information by email and password
//     */
//    UserVO queryUser(String email, String password);
//
//    List<UserPO> queryUserAndRole(Long page,Long pageSize);
//    void remove( long id);
//
//    /**
//     * Example Change a user role name
//     */
////    void updateUserRole(UserRoleParam param);
//
//    UserVO queryUserRoleOne(Integer userId);
//}
