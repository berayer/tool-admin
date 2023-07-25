package com.zbx.system.config.mybatisFlex;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.ReflectUtil;
import com.mybatisflex.annotation.InsertListener;

import java.time.LocalDateTime;

/**
 * 数组创建是自动注入创建信息
 */
public class DataCreateListener implements InsertListener {

    @Override
    public void onInsert(Object o) {
        Object username = StpUtil.getLoginIdAsString();
        ReflectUtil.setFieldValue(o, "createBy", username);
        ReflectUtil.setFieldValue(o, "createTime", LocalDateTime.now());
    }

}
