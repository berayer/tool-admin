package com.zbx.system.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.zbx.system.pojo.form.LoginForm;
import com.zbx.system.service.ILoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements ILoginService {

    @Override
    public String login(LoginForm loginForm) {
        // 用户登录
        StpUtil.login(1001, loginForm.isRememberMe());
        // 返回用户的token值
        return StpUtil.getTokenValue();
    }
}
