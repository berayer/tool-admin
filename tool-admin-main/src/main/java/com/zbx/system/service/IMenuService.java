package com.zbx.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zbx.system.pojo.entity.SysMenu;

import java.util.List;

public interface IMenuService extends IService<SysMenu> {

    /**
     * 获取当前登陆用户的菜单树
     */
    List<SysMenu> getUserMenuTree();

    /**
     * 获取当前菜单的下一级菜单,不递归
     *
     * @param id 当前菜单id
     * @return 子菜单列表
     */
    List<SysMenu> getChildMenu(Integer id);

    /**
     * 获取所有的菜单树
     */
    List<SysMenu> getAllMenuTree();
}
