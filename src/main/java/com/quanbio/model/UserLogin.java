package com.quanbio.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("userlogin")
public class UserLogin {
    private Long id;
    private String username;
    private String password;
    private String email;
}
