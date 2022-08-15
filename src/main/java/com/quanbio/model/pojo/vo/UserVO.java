package com.quanbio.model.pojo.vo;

import com.quanbio.model.Menu;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserVO implements Serializable {

    private Integer userId;

    private String userName;

    private String roleName;

    private String email;

    private List<Menu> menus;

}
