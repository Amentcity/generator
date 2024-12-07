package com.example.maker.meta.enums;

import lombok.Getter;

/**
 * 文件生成类型枚举
 */
@Getter
public enum FileGenerateEnum {

    DYNAMIC("动态","dynamic"),

    STATIC("静态","static");

    private final String text;
    private final String value;

    FileGenerateEnum(String text, String value) {
        this.text = text;
        this.value = value;
    }

}
