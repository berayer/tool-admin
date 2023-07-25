package com.zbx.system.pojo.form;

import lombok.Data;

/**
 * 登录表单
 */
@Data
public class LoginForm {

    private String username;
    private String password;
    private boolean rememberMe = false;

}
