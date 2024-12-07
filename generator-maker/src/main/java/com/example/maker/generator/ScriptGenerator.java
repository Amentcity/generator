package com.example.maker.generator;

import cn.hutool.core.io.FileUtil;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

public class ScriptGenerator {

    public static void doGenerate(String outputPath, String JarPath) {
        // Linux 脚本
        StringBuilder sb = new StringBuilder();
        // #!bin/bash
        // java -jar target/generated-1.0-jar-with-dependencies.jar "$@"
        sb.append("#!bin/bash").append("\n");
        sb.append(String.format("java -jar %s \"$@\"", JarPath)).append("\n");
        FileUtil.writeBytes(sb.toString().getBytes(StandardCharsets.UTF_8), outputPath);
        // 添加可执行权限
        try {
            Set<PosixFilePermission> permissions = PosixFilePermissions.fromString("rwxrwxrwx");
            Files.setPosixFilePermissions(Paths.get(JarPath), permissions);
        } catch (Exception e) {

        }

        // windows 脚本
        sb=new StringBuilder();
        // @echo off
        // java -jar target/generated-1.0-jar-with-dependencies.jar %*
        sb.append("@echo off").append("\n");
        sb.append(String.format("java -jar %s %%*", JarPath)).append("\n");
        FileUtil.writeBytes(sb.toString().getBytes(StandardCharsets.UTF_8), outputPath + ".bat");
    }

}
