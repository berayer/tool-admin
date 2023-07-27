package com.zbx.system.pojo.form;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * 登录表单
 */
@Data
public class LoginForm {

    @NotNull(message = "用户名不能为空")
    private String username;

    @NotNull(message = "密码不能为空")
    @Size(min = 6, message = "长度不能小于6位")
    private String password;
    private boolean rememberMe = false;

}
