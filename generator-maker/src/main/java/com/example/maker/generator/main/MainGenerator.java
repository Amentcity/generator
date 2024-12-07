package com.example.maker.generator.main;

import freemarker.template.TemplateException;

import java.io.IOException;

public class MainGenerator extends GenerateTemplates{

    @Override
    protected void buildDist(String outputPath, String sourceCopyDestPath, String jarPath, String shellOutputFilePath) throws IOException {
        System.out.println("不要给我输出 dist 啦！");
    }

    public static void main(String[] args) throws TemplateException, IOException, InterruptedException {
        MainGenerator generator = new MainGenerator();
        generator.doGenerate();
    }
}
