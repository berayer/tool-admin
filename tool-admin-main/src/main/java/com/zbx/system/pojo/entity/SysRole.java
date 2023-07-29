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
@TableName(value = "SysRole")
public class SysRole extends BaseEntity {

    /**
     * 角色名称
     */
    @TableField("Name")
    private String name;

}
