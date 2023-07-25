package com.zbx.system.service.impl;

import cn.dev33.satoken.secure.BCrypt;
import cn.dev33.satoken.stp.StpUtil;
import com.mybatisflex.core.query.QueryWrapper;
import com.zbx.system.mapper.SysUserMapper;
import com.zbx.system.pojo.entity.SysUser;
import com.zbx.system.pojo.entity.table.SysUserTableDef;
import com.zbx.system.pojo.form.LoginForm;
import com.zbx.system.service.ILoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements ILoginService {

    private final SysUserMapper userMapper;

    @Override
    public String login(LoginForm loginForm) throws LoginException {
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();

        // 查询用户信息
        QueryWrapper query = new QueryWrapper();
        query.where(SysUserTableDef.SYS_USER.USERNAME.eq(username));
        SysUser user = userMapper.selectOneByQuery(query);

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
        // 返回用户的token值
        return StpUtil.getTokenValue();
    }
}
