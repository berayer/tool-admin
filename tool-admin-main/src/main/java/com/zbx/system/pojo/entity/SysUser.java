package com.zbx.system.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zbx.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 系统用户信息
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@TableName(value = "SysUser")
public class SysUser extends BaseEntity {

    /**
     * 用户名
     */
    @TableField("Username")
    private String username;

    /**
     * 密码
     */
    @TableField("Password")
    private String password;

}
