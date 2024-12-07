package com.example.maker.meta;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.json.JSONUtil;

public class MetaManager {

    private static volatile Meta meta;

    public static Meta getObjectMeta() {
        if (meta == null) {
            synchronized (MetaManager.class) {
                if (meta == null) {
                    meta = initMate();
                }
            }
        }
        return meta;
    }

    public static Meta initMate() {
        String mateJson = ResourceUtil.readUtf8Str("meta.json");
        Meta newMeta = JSONUtil.toBean(mateJson, Meta.class);
        //TODO 校验配置文件，处理默认值
        return newMeta;
    }

}
