package com.zbx.system.service;

import com.zbx.system.pojo.form.LoginForm;

import javax.security.auth.login.LoginException;

public interface ILoginService {

    String login(LoginForm loginForm) throws LoginException;
}
