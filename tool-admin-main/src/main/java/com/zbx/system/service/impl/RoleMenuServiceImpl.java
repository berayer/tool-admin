package com.zbx.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zbx.system.mapper.SysRoleMenuMapper;
import com.zbx.system.pojo.entity.SysRoleMenu;
import com.zbx.system.service.IRoleMenuService;
import org.springframework.stereotype.Service;

@Service
public class RoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements IRoleMenuService {
}
