package com.example.model;

import lombok.Data;

@Data
public class MainTemplateConfig {

    // 我们先声明几个动态生成的需求
    // 1. 在代码开头添加 @Author 注解 （增加代码）
    // 2. 修改程序输出的信息提示 （替换代码）
    // 3. 将循环读取输入改为单次读取 （可选代码）、

    /*
     * 作者 （字符串，填充值）
     */
    private String author;

    /**
     * 输出信息
     */
    private String outputText;

    /**
     * 是否循环 （开关）
     */
    private Boolean loop;

    @Override
    public String toString() {
        return "MainTemplateConfig{" +
                "author='" + author + '\'' +
                ", outputText='" + outputText + '\'' +
                ", loop=" + loop +
                '}';
    }
}
