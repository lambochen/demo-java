package cn.lambochen.demo.design.pattern.command;

/**
 * @author lambochen
 * @date 2022-04-07 22:45
 */
public class TV {

    public void on() {
        System.out.println("电视机开启");
    }

    public void off() {
        System.out.println("电视机关闭");
    }

    public void channelUp() {
        System.out.println("电视机频道+");
    }

    public void channelDown() {
        System.out.println("电视机频道-");
    }

    public void volumeDown() {
        System.out.println("电视机音量-");
    }
}
