package com.zbx.system.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zbx.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@TableName(value = "SysMenu")
public class SysMenu extends BaseEntity {

    /**
     * 父级菜单id
     */
    @TableField("Pid")
    private Integer pid;

    /**
     * 菜单名称
     */
    @TableField("Name")
    private String name;

    /**
     * 菜单路径
     */
    @TableField("Path")
    private String path;

    /**
     * 菜单图标
     */
    @TableField("Icon")
    private String icon;

    /**
     * 菜单类型: 1=路由;2=iframe;3=_blank;
     */
    @TableField("Type")
    private Integer type;

    /**
     * 子菜单
     */
    @TableField(exist = false)
    private List<SysMenu> children;

}
