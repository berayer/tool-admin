package com.zbx.system.api;

import cn.dev33.satoken.secure.BCrypt;
import cn.dev33.satoken.util.SaResult;
import cn.hutool.core.util.StrUtil;
import com.zbx.system.pojo.entity.SysUser;
import com.zbx.system.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final IUserService userService;

    @GetMapping("/search")
    public SaResult search() {
        List<SysUser> list = userService.list();
        return SaResult.data(list);
    }

    /**
     * 新增一个用户
     * @param user 用户信息
     */
    @PostMapping("/add")
    public SaResult add(@RequestBody SysUser user) {
        // 1. 检查用户是否存在
        if (StrUtil.isBlank(user.getUsername())) {
            return SaResult.error("用户名不能为空");
        }
        SysUser exist = userService.getByUsername(user.getUsername());
        if (exist != null) {
            return SaResult.error("用户名已经存在");
        }
        // 2. 密码编码
        if (StrUtil.isBlank(user.getPassword())) {
            return SaResult.error("密码不能为空");
        }
        user.setPassword(BCrypt.hashpw(user.getPassword()));
        // 3. 检测其他合法性
        // 防止传入id
        user.setId(null);
        // 4. 插入新用户
        userService.save(user);
        return SaResult.ok();
    }

    /**
     * 根据用户id修改用户信息
     * {user.id} 不能为空
     * @param user 用户信息
     */
    @PutMapping("/edit")
    public SaResult edit(@RequestBody SysUser user) {
        // 1. 检测用户id是否合法
        if (user.getId() == null) {
            return SaResult.error("用户id不能为空");
        }
        // 2. 修改用户信息
        userService.updateById(user);
        return SaResult.ok();
    }

    /**
     * 根据用户id删除目标用户
     * @param user 用户信息
     */
    @DeleteMapping("/del")
    public SaResult del(@RequestBody SysUser user) {
        // 1. 检测用户id是否合法
        if (user.getId() == null) {
            return SaResult.error("用户id不能为空");
        }
        // 2. 根据用户id删除用户
        userService.removeById(user.getId());
        return SaResult.ok();
    }

}
