package com.example.generator;

import com.example.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.IOException;

public class MainGenerator {
    public static void main(String[] args) throws TemplateException, IOException {

        // 1.静态文件生成
        String projectPath = System.getProperty("user.dir");
        // 2.输入路径
        String inputPath = projectPath + "/src/main/resources/templates/myweb.html.ftl";
        // 3.输出路径
        String outputPath = projectPath + "/src/main/resources/output/myweb.html";
        // 复制
        StaticGenerator.copyFilesByHutools(inputPath, outputPath);
        String dynamicInputPath="src/main/resources/templates/MainTemplate.java.ftl";
        String dynamicOutputPath="src/main/resources/output/MainTemplate.java";
        // 创建模板对象，加载指定模板
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setLoop(false);
        DynamicGenerator.doGenerate(dynamicInputPath,dynamicOutputPath,mainTemplateConfig);
    }
}
