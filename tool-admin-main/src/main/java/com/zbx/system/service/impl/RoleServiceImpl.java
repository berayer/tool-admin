package com.zbx.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zbx.system.mapper.SysRoleMapper;
import com.zbx.system.pojo.entity.SysRole;
import com.zbx.system.service.IRoleService;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class RoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements IRoleService {
    @Override
    public SysRole getByName(String name) {
        Assert.notNull(name, "name不能为空");
        LambdaQueryWrapper<SysRole> query = new LambdaQueryWrapper<SysRole>()
                .eq(SysRole::getName, name);
        return this.getOne(query);
    }
}
