package cn.lambochen.demo.design.pattern.command;

import java.util.Arrays;

/**
 * @author lambochen
 * @date 2022-04-07 22:24
 */
public class Client {

    public static void main(String[] args) throws InterruptedException {

        Bulb bulb = new Bulb();
        Switcher switcher = new Switcher();

        switcher.setCommand(new SwitchCommand(bulb));
        switcher.buttonPush();
        switcher.buttonPop();

        switcher.setCommand(new FlashCommand(bulb));
        switcher.buttonPush();
        Thread.sleep(10000);
        switcher.buttonPop();

        Keyboard keyboard = new Keyboard();
        TV tv = new TV();
        keyboard.bindKeyCommand(Keyboard.KeyCode.F1, Arrays.asList(new TVOnCommand(tv)));
        keyboard.bindKeyCommand(Keyboard.KeyCode.LEFT, Arrays.asList(new TVChannelUpCommand(tv)));
        keyboard.bindKeyCommand(Keyboard.KeyCode.ESC, Arrays.asList(new TVOffCommand(tv)));
        keyboard.onKeyPressed(Keyboard.KeyCode.F1);
        keyboard.onKeyPressed(Keyboard.KeyCode.LEFT);
        keyboard.onKeyPressed(Keyboard.KeyCode.UP);
        keyboard.onKeyPressed(Keyboard.KeyCode.ESC);
    }
}
