package com.zbx.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zbx.system.mapper.SysUserRoleMapper;
import com.zbx.system.pojo.entity.SysUserRole;
import com.zbx.system.service.IUserRoleService;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements IUserRoleService {
}
