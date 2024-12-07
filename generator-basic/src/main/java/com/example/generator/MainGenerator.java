package com.example.generator;

import com.example.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.IOException;


import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * 核心生成器
 */
public class MainGenerator {

    /**
     * 生成
     *
     * @param model 数据模型
     * @throws TemplateException
     * @throws IOException
     */
    public static void doGenerate(Object model) throws TemplateException, IOException {
        String inputRootPath = "";
        String outputRootPath = "";

        String inPutPath = "";
        String outPutPath = "";

        inPutPath = new File(inputRootPath,"").getAbsolutePath();
        outPutPath = new File(outputRootPath,"").getAbsolutePath();
        DynamicGenerator.doGenerate(inPutPath, outPutPath, model);

        inPutPath = new File(inputRootPath,".gitignore").getAbsolutePath();
        outPutPath = new File(outputRootPath,".gitignore").getAbsolutePath();
        // 生成静态文件
        StaticGenerator.copyFilesByHutools(inPutPath, outPutPath);

        inPutPath = new File(inputRootPath,"README.md").getAbsolutePath();
        outPutPath = new File(outputRootPath,"README.md").getAbsolutePath();
        // 生成静态文件
        StaticGenerator.copyFilesByHutools(inPutPath, outPutPath);
    }

    public static void main(String[] args) throws TemplateException, IOException {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("yupi");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("求和结果：");
        doGenerate(mainTemplateConfig);
    }
}


