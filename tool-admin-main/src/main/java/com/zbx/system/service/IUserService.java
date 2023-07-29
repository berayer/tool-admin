package com.zbx.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zbx.system.pojo.entity.SysUser;

public interface IUserService extends IService<SysUser> {

    /**
     * 通过username获取SysUser
     * @param username 用户名
     * @return 用户对象
     */
    SysUser getByUsername(String username);

}
