package com.zbx.system.config.mybatisFlex;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.ReflectUtil;
import com.mybatisflex.annotation.UpdateListener;

import java.time.LocalDateTime;

/**
 * 数据修改时自动注入修改记录
 */
public class DataUpdateListener implements UpdateListener {

    @Override
    public void onUpdate(Object o) {
        Object username = StpUtil.getExtra("username");
        ReflectUtil.setFieldValue(o, "updateBy", username);
        ReflectUtil.setFieldValue(o, "updateTime", LocalDateTime.now());
    }
}
