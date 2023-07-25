package com.zbx.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseEntity {

    /**
     * id
     */
    private Integer id;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 最后修改人
     */
    private String updateBy;

    /**
     * 最后修改时间
     */
    private LocalDateTime updateTime;

}
