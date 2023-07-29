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
@TableName(value = "SysUserRole")
public class SysUserRole extends BaseEntity {

    /**
     * 用户id
     */
    @TableField("UserId")
    private Integer userId;

    /**
     * 角色id
     */
    @TableField("RoleId")
    private Integer roleId;
}
