package ${basePackage}.generator;

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
        String inputRootPath = "${fileConfig.inputRootPath}";
        String outputRootPath = "${fileConfig.outputRootPath}";

        String inPutPath = "";
        String outPutPath = "";

<#list fileConfig.files as fileInfo>
        inPutPath = new File(inputRootPath,"${fileInfo.inputPath}").getAbsolutePath();
        outPutPath = new File(outputRootPath,"${fileInfo.outputPath}").getAbsolutePath();
    <#if fileInfo.generateType == "static">
        DynamicGenerator.doGenerate(inPutPath, outPutPath, model);
    <#else>
        // 生成静态文件
        StaticGenerator.copyFilesByHutools(inPutPath, outPutPath);
    </#if>

</#list>
    }
}


