//package com.quanbio.service.impl;
//
//import cn.hutool.json.JSONArray;
//import cn.hutool.json.JSONUtil;
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
//import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
//import com.quanbio.mapper.UserMapper;
//import com.quanbio.mapper.UserRepository;
//import com.quanbio.model.Menu;
//import com.quanbio.model.User;
//import com.quanbio.model.pojo.param.UserRoleParam;
//import com.quanbio.model.pojo.po.UserPO;
//import com.quanbio.model.pojo.vo.UserVO;
//import com.quanbio.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.Objects;
//import java.util.stream.Collectors;
//
//import static net.sf.jsqlparser.parser.feature.Feature.delete;
//
///**
// * @author Lenovo
// */
//@Service
//public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
//
//    @Autowired
//    private UserRepository userRepository;
//    @Override
//    public UserVO queryUser(String email, String password) {
//        List<Map<String, String>> byEmailAndPassword = userRepository.findByEmailAndPassword(email, password);
//        if(CollectionUtils.isEmpty(byEmailAndPassword)){
//            return new UserVO();
//        }
//        JSONArray objects = JSONUtil.parseArray(JSONUtil.toJsonStr(byEmailAndPassword));
//        List<UserPO> userPOS1 = JSONUtil.toList(objects, UserPO.class);
//        UserVO user = new UserVO();
//        Map<Integer, List<UserPO>> collect = userPOS1.stream().collect(Collectors.groupingBy(UserPO::getUserId));
//        collect.forEach((k,v) ->{
//            List<Menu> menus = new ArrayList<Menu>();
//            v.forEach(userPO -> {
//                Menu menu = new Menu();
//                menu.setId(Long.valueOf(userPO.getMenuId()));
//                menu.setName(userPO.getMenuName());
//                menu.setIcon(userPO.getMenuIcon());
//                menus.add(menu);
//                user.setUserId(userPO.getUserId());
//                user.setRoleName(userPO.getRoleName());
//                user.setUserName(userPO.getUserName());
//                user.setEmail(userPO.getEmail());
//           });
//            user.setMenus(menus);
//        });
//        return user;
//    }
//
//    @Override
//    public  List<UserPO>queryUserAndRole(Long page,Long pageSize) {
//
//       return getBaseMapper().queryUserAndRole(page,pageSize);
//
//    }
//
//    @Override
//    public void remove(long id) {
//        getBaseMapper().delete(id);
//    }
//
////    @Override
////    @Transactional(rollbackFor = Exception.class)
////    public void updateUserRole(UserRoleParam param) {
////        if(param.getUserId() == null){
////            throw new IllegalArgumentException("The current user failed to modify the role because an incorrect parameter was passed");
////        }
////        QueryWrapper<User> queryUser = new QueryWrapper<>();
////        queryUser.eq("id",param.getUserId());
////        User one = getOne(queryUser);
////        one.setRoleid(param.getRoleId());
////        updateById(one);
////    }
//
//    @Override
//    public UserVO queryUserRoleOne(Integer userId) {
//        UserVO userVO = getBaseMapper().queryUserRoleOne(userId);
//        if(Objects.isNull(userVO)){
//            return new UserVO();
//        }
//        return userVO;
//    }
//}
