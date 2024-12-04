package com.example.generator;

import com.example.model.MainTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 动态文件生成器
 */
public class DynamicGenerator {
    public static void main(String[] args) throws IOException, TemplateException {
        String inputPath="src/main/resources/templates/MainTemplate.java.ftl";
        String outputPath="src/main/resources/templates/MainTemplate.java";
        // 创建模板对象，加载指定模板
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setLoop(false);
        doGenerate(inputPath, outputPath, mainTemplateConfig);
    }

    /**
     * 生成文件
     * @param inputPath 模板文件输入路径
     * @param outputPath 模板文件输出路径
     * @param model 数据模型
     * @throws IOException io异常
     * @throws TemplateException 模板异常
     */
    public static void doGenerate(String inputPath,String outputPath,Object model) throws IOException, TemplateException {
        File templateDir = new File(inputPath).getParentFile();
        // new 出 Configuration 对象，参数为 FreeMarker 版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);

        // 指定模板文件所在的路径
        configuration.setDirectoryForTemplateLoading(templateDir);

        // 设置模板文件使用的字符集
        configuration.setDefaultEncoding("UTF-8");
        configuration.setNumberFormat("0.######");

        // 创建模板对象，加载指定模板
        String templateName = new File(inputPath).getName();
        Template template = configuration.getTemplate(templateName);

        // 数据模型
        Writer out = new FileWriter(outputPath);
        template.process(model, out);
        out.close();
    }
}
