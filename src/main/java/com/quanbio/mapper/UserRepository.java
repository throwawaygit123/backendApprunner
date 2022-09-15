package com.quanbio.mapper;

import cn.hutool.json.JSONArray;
import com.quanbio.model.User;
import com.quanbio.model.pojo.po.UserPO;
import com.quanbio.model.pojo.vo.UserVO;
import com.quanbio.structure.UserRolePermission;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
@Mapper
public interface UserRepository  extends JpaRepository<User, Long> {
	
//	 public Optional<User> findByEmailAndPassword(String email, String password);
	
	 // Another function to return user and role menu together 
	 //public Optional<UserRolePermission> function(User user);
	// Query 
	// SELECT quanbiodb_dev.menu.*  FROM quanbiodb_dev.menu JOIN quanbiodb_dev.role_menu on role_menu.role_id=user.getRoleID() where role_menu.menu_id=menu.id;

     @Query(value = "SELECT u.username AS userName,u.id AS userId,u.email AS email,role.name AS roleName,menu.id AS menuId,menu.name AS menuName,menu.icon AS menuIcon from " +
             " user  u " +
             "left join role role on role.id = u.roleid left join role_menu roleMenu on u.roleid = roleMenu.roleid left join menu menu on menu.id = roleMenu.menuid "
             +
             "where u.email = :email and u.password =:password"
            ,nativeQuery=true)
     List<Map<String,String>> findByEmailAndPassword(@Param("email")String email, @Param("password")String password);


     @Query(value = "SELECT u.username AS userName,u.id AS userId,u.email AS email,role.name AS roleName,u.roleid from " +
             " user  u " +
             "left join role role on role.id = u.roleid "
             +
             "where u.id =:id"
             ,nativeQuery=true)
     User findById(@Param("id") long Id);

}
