package com.zbx.system.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zbx.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@TableName(value = "SysRoleMenu")
public class SysRoleMenu extends BaseEntity {

    @TableField("RoleId")
    private Integer roleId;

    @TableField("MenuId")
    private Integer menuId;

}
