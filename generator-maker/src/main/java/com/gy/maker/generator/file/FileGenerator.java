package com.gy.maker.generator.file;


import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * 核心生成器
 */
public class FileGenerator {

    /**
     * 生成
     *
     * @param model 数据模型
     * @throws TemplateException
     * @throws IOException
     */
    public static void doGenerate(Object model) throws IOException, TemplateException {
        String projectPath = System.getProperty("user.dir");
        // 整个项目的根路径
        File parentFile = new File(projectPath).getParentFile();
        // 输入路径
        String inputPath = new File(parentFile, "generator-demo-projects/acm-template").getAbsolutePath();
        String outputPath = projectPath;

        System.out.println("inputPath:"+inputPath);
        System.out.println("outputPath:"+outputPath);
        // 生成静态文件
        StaticFileGenerator.copyFilesByHutool(inputPath, outputPath);

        // 生成动态文件
        String inputDynamicFilePath = projectPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String outputDynamicFilePath = outputPath + File.separator + "acm-template/src/com/gy/acm/MainTemplate.java";


        System.out.println("inputDynamicFilePath:"+inputDynamicFilePath);
        System.out.println("outputDynamicFilePath:"+outputDynamicFilePath);

        DynamicFileGenerator.doGenerate(inputDynamicFilePath, outputDynamicFilePath, model);
    }


}
