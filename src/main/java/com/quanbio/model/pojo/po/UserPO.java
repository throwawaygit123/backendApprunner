package com.quanbio.model.pojo.po;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserPO  implements Serializable {

    private Integer userId;

    private String userName;

    private String email;

    private String roleName;

    private Integer menuId;

    private String menuName;

    private String menuIcon;
}
