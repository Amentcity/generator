package com.example.maker.generator;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.util.StrUtil;
import com.example.maker.generator.file.DynamicFileGenerator;
import com.example.maker.meta.Meta;
import com.example.maker.meta.MetaManager;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class MainGenerator {
    public static void main(String[] args) throws TemplateException, IOException, InterruptedException {
        Meta meta = MetaManager.getObjectMeta();
        System.out.println(meta);

        // 输出的根路径
        String projectPath = System.getProperty("user.dir");
        String outputPath = projectPath + File.separator + "generated";
        if (!FileUtil.exist(outputPath)) {
            FileUtil.mkdir(outputPath);
        }

        // 从原始模板文件路径复制到生成的代码包中
        String sourceRootPath = meta.getFileConfig().getSourceRootPath();
        String sourceCopyDestPath = outputPath + File.separator + "./source";
        FileUtil.copy(sourceRootPath,sourceCopyDestPath,false);

        // 读取resource目录
        ClassPathResource classPathResource = new ClassPathResource("");
        String inputResourcePath = classPathResource.getAbsolutePath();


        // Java包的基础路径
        // com.example
        String outputBasePackage = meta.getBasePackage();
        // com/example
        String outputBasePackagePath = StrUtil.join("/", StrUtil.split(outputBasePackage, "."));
        String outputBaseJavaPackagePath = outputPath+File.separator+"src/main/java/"+outputBasePackagePath;

        String inputFilePath;
        String outputFilePath;

        // model.DataModel
        inputFilePath = inputResourcePath+File.separator+"templates/java/model/DataModel.java.ftl";
        outputFilePath = outputBaseJavaPackagePath+File.separator+"model/DataModel.java";
        DynamicFileGenerator.doGenerate(inputFilePath,outputFilePath,meta);

        // cli.Command.GenerateCommand
        inputFilePath = inputResourcePath+File.separator+ "templates/java/cli/command/GenerateCommand.java.ftl";
        outputFilePath = outputBaseJavaPackagePath+File.separator+"cli/command/GenerateCommand.java";
        DynamicFileGenerator.doGenerate(inputFilePath,outputFilePath,meta);

        // cli.Command.ConfigCommand
        inputFilePath = inputResourcePath+File.separator+"templates/java/cli/command/ConfigCommand.java.ftl";
        outputFilePath = outputBaseJavaPackagePath+File.separator+"cli/command/ConfigCommand.java";
        DynamicFileGenerator.doGenerate(inputFilePath,outputFilePath,meta);

        // cli.Command.ListCommand
        inputFilePath = inputResourcePath+File.separator+"templates/java/cli/command/ListCommand.java.ftl";
        outputFilePath = outputBaseJavaPackagePath+File.separator+"cli/command/ListCommand.java";
        DynamicFileGenerator.doGenerate(inputFilePath,outputFilePath,meta);

        // cli.CommandExecutor
        inputFilePath = inputResourcePath+File.separator+"templates/java/cli/CommandExecutor.java.ftl";
        outputFilePath = outputBaseJavaPackagePath+File.separator+"cli/CommandExecutor.java";
        DynamicFileGenerator.doGenerate(inputFilePath,outputFilePath,meta);

        // Main
        inputFilePath = inputResourcePath+File.separator+"templates/java/Main.java.ftl";
        outputFilePath = outputBaseJavaPackagePath+File.separator+"Main.java";
        DynamicFileGenerator.doGenerate(inputFilePath,outputFilePath,meta);

        // generator.DynamicGenerator
        inputFilePath = inputResourcePath+File.separator+ "templates/java/generator/DynamicGenerator.java.ftl";
        outputFilePath = outputBaseJavaPackagePath+File.separator+"generator/DynamicGenerator.java";
        DynamicFileGenerator.doGenerate(inputFilePath,outputFilePath,meta);

        // generator.MainGenerator
        inputFilePath = inputResourcePath+File.separator+"templates/java/generator/MainGenerator.java.ftl";
        outputFilePath = outputBaseJavaPackagePath+File.separator+"generator/MainGenerator.java";
        DynamicFileGenerator.doGenerate(inputFilePath,outputFilePath,meta);

        // generator.StaticGenerator
        inputFilePath = inputResourcePath+File.separator+"templates/java/generator/StaticGenerator.java.ftl";
        outputFilePath = outputBaseJavaPackagePath+File.separator+"generator/StaticGenerator.java";
        DynamicFileGenerator.doGenerate(inputFilePath,outputFilePath,meta);

        // pom.xml
        inputFilePath = inputResourcePath+File.separator+"templates/pom.xml.ftl";
        outputFilePath = outputPath+File.separator+"pom.xml";
        DynamicFileGenerator.doGenerate(inputFilePath,outputFilePath,meta);

        // 构建 jar 包
        JarGenerator.doGenerate(outputPath);

        // 封装脚本
        String shellOutputFilePath = outputPath+File.separator+"generator";
        String jarName = String.format("%s-%s-jar-with-dependencies.jar",meta.getName(),meta.getVersion());
        String jarPath = "target/"+jarName;
        ScriptGenerator.doGenerate(shellOutputFilePath, jarPath);


    }
}
