package com.gy.maker;

import com.gy.maker.generator.main.GenerateTemplate;
import com.gy.maker.generator.main.MainGenerator;
import com.gy.maker.generator.main.ZipGenerator;
import freemarker.template.TemplateException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws TemplateException, IOException, InterruptedException {
        GenerateTemplate generateTemplate = new ZipGenerator();
        generateTemplate.doGenerate();
    }
}
