package com.gy.cli.pattern;

/**
 * 具体命令(相当于遥控器的某个操作按钮)
 */
public class TurnOffCommand implements Command {
    private Device device;

    public TurnOffCommand(Device device) {
        this.device = device;
    }

    public void execute() {
        device.turnOff();
    }
}