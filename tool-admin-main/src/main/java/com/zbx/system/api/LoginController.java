package com.zbx.system.api;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.zbx.system.pojo.form.LoginForm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/login")
    public SaResult login(LoginForm loginForm) {
        StpUtil.login(loginForm);
        return SaResult.ok();
    }

}
