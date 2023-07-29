package com.zbx.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zbx.system.mapper.SysUserMapper;
import com.zbx.system.pojo.entity.SysUser;
import com.zbx.system.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class UserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements IUserService {

    @Override
    public SysUser getByUsername(String username) {
        Assert.notNull(username, "username不能为空");
        return this.getOne(new LambdaQueryWrapper<SysUser>()
                .eq(SysUser::getUsername, username));
    }

}
