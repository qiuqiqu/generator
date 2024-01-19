package com.gy.cli.pattern;

/**
 * 具体命令
 * 相当于遥控器的某个操作按钮
 */
public class TurnOnCommand implements Command {
    private Device device;

    public TurnOnCommand(Device device) {
        this.device = device;
    }

    public void execute() {
        device.turnOn();
    }
}