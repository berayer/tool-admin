package com.zbx.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class BaseEntity implements Serializable {

    /**
     * id
     */
    @Id(keyType = KeyType.Auto)
    private Integer id;

    /**
     * 创建人
     */
    @Column("CreateBy")
    private String createBy;

    /**
     * 创建时间
     */
    @Column("CreateTime")
    private LocalDateTime createTime;

    /**
     * 最后修改人
     */
    @Column("UpdateBy")
    private String updateBy;

    /**
     * 最后修改时间
     */
    @Column("UpdateTime")
    private LocalDateTime updateTime;

}
