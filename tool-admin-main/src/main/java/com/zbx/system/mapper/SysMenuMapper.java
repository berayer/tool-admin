package com.zbx.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zbx.system.pojo.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * 获取当前用户授权的菜单id集合
     */
    List<Integer> getUserMenuIds(Integer userId);
}
