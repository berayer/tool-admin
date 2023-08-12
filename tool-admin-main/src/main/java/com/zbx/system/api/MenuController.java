package com.zbx.system.api;

import cn.dev33.satoken.util.SaResult;
import com.zbx.system.service.IMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/menu")
public class MenuController {

    private final IMenuService menuService;

    /**
     * 获取登陆用户的菜单列表
     */
    @GetMapping("/userMenu")
    public SaResult userMenu() {
        return SaResult.data(menuService.getUserMenuTree());
    }

    /**
     * 获取所有的菜单
     */
    @GetMapping("/search")
    public SaResult search() {
        return SaResult.data(menuService.getAllMenuTree());
    }
}
