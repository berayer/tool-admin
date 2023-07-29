package com.zbx.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zbx.system.pojo.entity.SysRole;

public interface IRoleService extends IService<SysRole> {

    /**
     * 通过角色获取角色信息
     * @param name 角色名称
     * @return SysRole
     */
    SysRole getByName(String name);
}
