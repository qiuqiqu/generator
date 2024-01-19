package com.gy.cli.command;
import cn.hutool.core.util.ReflectUtil;
import com.gy.model.MainTemplateConfig;
import picocli.CommandLine.Command;

import java.lang.reflect.Field;

/**
 * config 子命令
 * 查看允许用户传入的动态参数信息
 */
@Command(name = "config", description = "查看参数信息", mixinStandardHelpOptions = true)
public class ConfigCommand implements Runnable{
    @Override
    public void run() {
        //通过反射动态获取参数信息
        Field[] fields = ReflectUtil.getFields(MainTemplateConfig.class);
        for (Field field : fields) {
            System.out.println("字段名称:"+field.getName());
            System.out.println("字段类型:"+field.getType());
        }

    }
}
