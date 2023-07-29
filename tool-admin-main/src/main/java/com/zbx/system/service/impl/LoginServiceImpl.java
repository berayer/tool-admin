package com.zbx.system.service.impl;

import cn.dev33.satoken.secure.BCrypt;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zbx.system.mapper.SysUserMapper;
import com.zbx.system.pojo.entity.SysUser;
import com.zbx.system.pojo.form.LoginForm;
import com.zbx.system.service.ILoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements ILoginService {

    private final SysUserMapper userMapper;

    @Override
    public String login(LoginForm loginForm) throws LoginException {
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();
        log.info("用户尝试登陆: username={}, password={}, rememberMe={}", username, password, loginForm.isRememberMe());

        // 查询用户信息
        LambdaQueryWrapper<SysUser> query = new LambdaQueryWrapper<>();
        query.eq(SysUser::getUsername, username);
        SysUser user = userMapper.selectOne(query);

        // 检测用户是否存在
        if (user == null) {
            throw new LoginException("用户名或密码错误");
        }

        // 检测密码
        if (!BCrypt.checkpw(password, user.getPassword())) {
            throw new LoginException("用户名或密码错误");
        }

        // 用户登录
        StpUtil.login(user.getUsername(), loginForm.isRememberMe());
        String token = StpUtil.getTokenValue();
        // 返回用户的token值
        log.info("用户登陆成功: username={}, token={}", username, token);
        return token;
    }
}
