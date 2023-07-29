package com.zbx.system.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zbx.system.mapper.SysMenuMapper;
import com.zbx.system.mapper.SysUserMapper;
import com.zbx.system.pojo.entity.SysMenu;
import com.zbx.system.service.IMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements IMenuService {

    private final SysUserMapper userMapper;

    @Override
    public List<SysMenu> getUserMenuTree() {
        String username = StpUtil.getLoginIdAsString();
        Integer userId = userMapper.selectIdByUsername(username);
        List<Integer> userMenuIds = this.baseMapper.getUserMenuIds(userId);
        List<SysMenu> list = getChildMenu(0);
        return this.fillMenuTree(list, userMenuIds);
    }

    @Override
    public List<SysMenu> getChildMenu(Integer id) {
        LambdaQueryWrapper<SysMenu> query = new LambdaQueryWrapper<SysMenu>()
                .eq(SysMenu::getPid, id);
        return this.list(query);
    }

    /**
     * 填充菜单树
     *
     * @param list 需要递归填充的菜单
     * @param ids  排除掉ids中没有菜单, 如果为null则不排除任何菜单, 空集合则会排除所有菜单
     */
    private List<SysMenu> fillMenuTree(List<SysMenu> list, List<Integer> ids) {
        List<SysMenu> res = new ArrayList<>();
        for (SysMenu menu : list) {
            // ids不为空,则排除其他菜单
            if (ids != null) {
                // 不在列表内,直接跳过
                if (!ids.contains(menu.getId())) {
                    continue;
                }
            }
            // 查询填充子菜单
            List<SysMenu> childMenu = getChildMenu(menu.getId());
            if (CollUtil.isNotEmpty(childMenu)) {
                fillMenuTree(childMenu, ids);
                menu.setChildren(childMenu);
            }
            res.add(menu);
        }
        return res;
    }

}
