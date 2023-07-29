package com.zbx.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class BaseEntity implements Serializable {

    /**
     * id
     */
    @TableId(value = "Id", type = IdType.AUTO)
    private Integer id;

    /**
     * 创建人
     */
    @TableField(value = "CreateBy", fill = FieldFill.INSERT)
    private String createBy;

    /**
     * 创建时间
     */
    @TableField(value = "CreateTime", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 最后修改人
     */
    @TableField(value = "UpdateBy", fill = FieldFill.UPDATE)
    private String updateBy;

    /**
     * 最后修改时间
     */
    @TableField(value = "UpdateTime", fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

}
