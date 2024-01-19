package com.gy.cli.command;
import picocli.CommandLine.Command;

/**
 * config 子命令
 * 查看允许用户传入的动态参数信息
 */
@Command(name = "qiuqiu", description = "查看参数信息", mixinStandardHelpOptions = true)
public class ConfigCommand implements Runnable{
    @Override
    public void run() {
        //通过反射动态获取参数信息

    }
}
