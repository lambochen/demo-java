package cn.lambochen.demo.design.pattern.command;

import cn.lambochen.demo.design.pattern.builder.Product;

/**
 * @author lambochen
 * @date 2022-04-07 22:21
 *
 * 开关命令类
 */
public class SwitchCommand implements Command {

    private Bulb bulb;

    public SwitchCommand(Bulb bulb) {
        this.bulb = bulb;
    }

    @Override
    public void exe() {
        bulb.on();
    }

    @Override
    public void unexe() {
        bulb.off();
    }

}
