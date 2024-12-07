package com.example.maker.generator;

import java.io.*;

public class JarGenerator {

    public static void doGenerate(String projectDir) throws IOException, InterruptedException {

        // 调用 Process 类执行 Maven打包命令
        String winMavenCommand = "E:\\data\\download\\apache-maven-3.9.9\\bin\\mvn.cmd clean package";
        String otherMavenCommand = "mvn clean package";

        ProcessBuilder processBuilder = new ProcessBuilder(winMavenCommand.split(" "));
        processBuilder.directory(new File(projectDir));

        Process process = processBuilder.start();

        // 读取命令的输出
        InputStream inputStream = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        int waitFor = process.waitFor();
        System.out.println("命令执行结束,退出码:"+waitFor);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        String property = System.getProperty("user.dir");
        doGenerate(property+"\\generated");
    }

}
