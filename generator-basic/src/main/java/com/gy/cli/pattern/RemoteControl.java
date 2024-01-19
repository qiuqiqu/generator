package com.gy.cli.pattern;

/**
 * 调用者(相当于遥控器)
 */
public class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}