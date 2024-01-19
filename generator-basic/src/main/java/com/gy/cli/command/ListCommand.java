package com.gy.cli.command;


import picocli.CommandLine.Command;

/**
 * list 子命令
 * list 是一个辅助命令，作用是遍历输出所有要生成的文件列表
 */
@Command(name = "list", description = "代码生成", mixinStandardHelpOptions = true)
public class ListCommand implements Runnable{
    @Override
    public void run() {

    }
}
