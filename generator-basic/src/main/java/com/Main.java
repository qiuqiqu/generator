package com;

import java.io.File;

import static com.gygenerator.StaticGenerator.copyFilesByHutool;

public class Main {
    public static void main(String[] args) {
        // 获取整个项目的根路径
        String outputPath = System.getProperty("user.dir");
        String outputPath2=outputPath+"\\generator-basic";
        File projectFile = new File(outputPath);
        // 输入路径：ACM 示例代码模板目录
        String inputPath = new File(projectFile, "generator-demo-projects/acm-template").getAbsolutePath();
        System.out.println("inputPath:"+inputPath);
        System.out.println("outputPath:"+outputPath2);
        copyFilesByHutool(inputPath, outputPath2);
    }
}
