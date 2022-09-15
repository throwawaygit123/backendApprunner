package com.quanbio.model.pojo.param;

/**
 * 用户角色入参
 */

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRoleParam implements Serializable {

    private Integer userId;

    private String roleName;

    private String roleId;
}
