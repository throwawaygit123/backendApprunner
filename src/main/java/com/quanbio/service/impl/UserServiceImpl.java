package com.quanbio.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quanbio.mapper.UserMapper;
import com.quanbio.model.Menu;
import com.quanbio.model.User;
import com.quanbio.model.pojo.po.UserPO;
import com.quanbio.model.pojo.vo.UserVO;
import com.quanbio.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Lenovo
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public UserVO queryUser(String email, String password) {
        List<UserPO> userPOS = getBaseMapper().queryList(email, password);
        if(CollectionUtils.isEmpty(userPOS)){
            return new UserVO();
        }
        UserVO user = new UserVO();
        Map<Integer, List<UserPO>> collect = userPOS.stream().collect(Collectors.groupingBy(UserPO::getUserId));
        collect.forEach((k,v) ->{
            List<Menu> menus = new ArrayList<Menu>();
            v.forEach(userPO -> {
                Menu menu = new Menu();
                menu.setId(Long.valueOf(userPO.getMenuId()));
                menu.setName(userPO.getMenuName());
                menu.setIcon(userPO.getMenuIcon());
                menus.add(menu);
                user.setUserId(userPO.getUserId());
                user.setRoleName(userPO.getRoleName());
                user.setUserName(userPO.getUserName());
                user.setEmail(userPO.getEmail());
           });
            user.setMenus(menus);
        });
        return user;
    }
}
