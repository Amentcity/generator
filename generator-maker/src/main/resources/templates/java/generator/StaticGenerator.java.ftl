package ${basePackage}.generator;

import cn.hutool.core.io.FileUtil;

public class StaticGenerator {

    /**
     * 拷贝文件（HuTools实现 会将输入目录完整拷贝的输出目录下）
     * @param inputPath
     * @param outputPath
     */
    public static void copyFilesByHutools(String inputPath, String outputPath) {
        FileUtil.copy(inputPath,outputPath,false);
    }
}
