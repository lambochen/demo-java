package cn.lambochen.demo.design.pattern.command;

/**
 * @author lambochen
 * @date 2022-04-07 22:43
 *
 * 电视开机命令
 */
public class TVOnCommand implements Command {

    private TV tv;

    public TVOnCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void exe() {
        tv.on();
    }

    @Override
    public void unexe() {
        tv.off();
    }

}
