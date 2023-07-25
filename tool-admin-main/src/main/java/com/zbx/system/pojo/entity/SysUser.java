package com.zbx.system.pojo.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Table;
import com.zbx.entity.BaseEntity;
import com.zbx.system.config.mybatisFlex.DataCreateListener;
import com.zbx.system.config.mybatisFlex.DataUpdateListener;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 系统用户信息
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
@Table(value = "SysUser", onInsert = DataCreateListener.class, onUpdate = DataUpdateListener.class)
public class SysUser extends BaseEntity {

    /**
     * 用户名
     */
    @Column("Username")
    private String username;

    /**
     * 密码
     */
    @Column("Password")
    private String password;

}
