package com.zbx.system.api;

import cn.dev33.satoken.util.SaResult;
import cn.hutool.core.util.StrUtil;
import com.zbx.system.pojo.entity.SysRole;
import com.zbx.system.service.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/role")
public class RoleController {

    private final IRoleService roleService;

    @GetMapping("/search")
    public SaResult search() {
        List<SysRole> list = roleService.list();
        return SaResult.data(list);
    }

    /**
     * 新增一个角色
     * @param role 用户信息
     */
    @PostMapping("/add")
    public SaResult add(@RequestBody SysRole role) {
        // 1. 检查角色是否存在
        if (StrUtil.isBlank(role.getName())) {
            return SaResult.error("角色名不能为空");
        }
        SysRole exist = roleService.getByName(role.getName());
        if (exist != null) {
            return SaResult.error("角色已经存在");
        }
        // 2. 检测其他合法性
        // 防止传入id
        role.setId(null);
        // 4. 插入新用户
        roleService.save(role);
        return SaResult.ok();
    }

    /**
     * 根据角色id修改角色信息
     * {role.id} 不能为空
     * @param role 角色信息
     */
    @PutMapping("/edit")
    public SaResult edit(@RequestBody SysRole role) {
        // 1. 检测用户id是否合法
        if (role.getId() == null) {
            return SaResult.error("角色id不能为空");
        }
        // 2. 修改用户信息
        roleService.updateById(role);
        return SaResult.ok();
    }

    /**
     * 根据角色id删除角色
     * @param role 用户信息
     */
    @DeleteMapping("/del")
    public SaResult del(@RequestBody SysRole role) {
        // 1. 检测用户id是否合法
        if (role.getId() == null) {
            return SaResult.error("角色id不能为空");
        }
        // 2. 根据用户id删除用户
        roleService.removeById(role.getId());
        return SaResult.ok();
    }
}
