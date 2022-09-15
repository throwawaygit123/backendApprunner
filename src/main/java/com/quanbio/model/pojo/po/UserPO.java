package com.quanbio.model.pojo.po;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import java.io.Serializable;
/**
 *
 * hxl
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPO  implements Serializable {

    private Integer userId;

    private String userName;

    private String email;

    private String roleName;

    private Integer menuId;

    private String menuName;

    private String menuIcon;
}
