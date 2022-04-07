package cn.lambochen.demo.design.pattern.command;

/**
 * @author lambochen
 * @date 2022-04-07 22:23
 */
public class Switcher {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void buttonPush() {
        command.exe();
    }

    public void buttonPop() {
        command.unexe();
    }

}
