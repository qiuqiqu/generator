package com.gygenerator;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ArrayUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class StaticGenerator {
    /**
     *拷贝文件
     * @param srcPath 源文件或目录
     * @param destPath 目标文件或目录
     */
    public static void copyFilesByHutool(String srcPath,String destPath){
        FileUtil.copy(srcPath,destPath,false);
    }

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

    /**
     * 文件 A => 目录 B，则文件 A 放在目录 B 下
     * 文件 A => 文件 B，则文件 A 覆盖文件 B
     * 目录 A => 目录 B，则目录 A 放在目录 B 下
     *
     * 核心思路：先创建目录，然后遍历目录内的文件，依次复制
     * @param inputFile
     * @param outputFile
     * @throws IOException
     */
    private static void copyFileByRecursive(File inputFile, File outputFile) throws IOException {
        // 区分是文件还是目录
        if (inputFile.isDirectory()) {
            System.out.println(inputFile.getName());
            File destOutputFile = new File(outputFile, inputFile.getName());
            // 如果是目录，首先创建目标目录
            if (!destOutputFile.exists()) {
                destOutputFile.mkdirs();
            }
            // 获取目录下的所有文件和子目录
            File[] files = inputFile.listFiles();
            // 无子文件，直接结束
            if (ArrayUtil.isEmpty(files)) {
                return;
            }
            for (File file : files) {
                // 递归拷贝下一层文件
                copyFileByRecursive(file, destOutputFile);
            }
        } else {
            // 是文件，直接复制到目标目录下
            Path destPath = outputFile.toPath().resolve(inputFile.getName());
            Files.copy(inputFile.toPath(), destPath, StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
