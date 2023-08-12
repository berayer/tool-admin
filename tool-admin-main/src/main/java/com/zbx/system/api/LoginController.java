package com.zbx.system.api;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.zbx.system.pojo.form.LoginForm;
import com.zbx.system.service.ILoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.login.LoginException;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final ILoginService loginService;

    @PostMapping("/login")
    public SaResult login(@Validated @RequestBody LoginForm loginForm) throws LoginException {
        String token = loginService.login(loginForm);
        return SaResult.data(token);
    }

    @PostMapping("/logout")
    public SaResult logout() {
        log.info("用户登出: {}", StpUtil.getLoginIdAsString());
        StpUtil.logout();
        return SaResult.ok();
    }

}
