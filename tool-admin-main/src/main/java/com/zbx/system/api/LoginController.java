package com.zbx.system.api;

import cn.dev33.satoken.util.SaResult;
import com.zbx.system.pojo.form.LoginForm;
import com.zbx.system.service.ILoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.login.LoginException;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final ILoginService loginService;

    @PostMapping("/login")
    public SaResult login(@Validated LoginForm loginForm) throws LoginException {
        String token = loginService.login(loginForm);
        return SaResult.ok(token);
    }

}
