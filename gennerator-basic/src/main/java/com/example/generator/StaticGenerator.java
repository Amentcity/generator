package com.example.generator;

import cn.hutool.core.io.FileUtil;

import java.io.File;

public class StaticGenerator {

    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        // 输入路径
        String separator = File.separator;
        // 输出路径
        String inputPath=projectPath+separator+"generator-test"+separator+"src"+separator+"main"+separator+"java";
        // 复制
        copyFilesByHutools(inputPath, projectPath);
    }

    /**
     * 拷贝文件（HuTools实现 会将输入目录完整拷贝的输出目录下）
     * @param inputPath
     * @param outputPath
     */
    public static void copyFilesByHutools(String inputPath, String outputPath) {
        FileUtil.copy(inputPath,outputPath,false);
    }
}
