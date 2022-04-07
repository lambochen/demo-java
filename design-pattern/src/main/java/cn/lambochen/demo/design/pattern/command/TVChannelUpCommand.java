package cn.lambochen.demo.design.pattern.command;

/**
 * @author lambochen
 * @date 2022-04-07 22:48
 *
 * 电视频道上调
 */
public class TVChannelUpCommand implements Command {

    private TV tv;

    public TVChannelUpCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void exe() {
        tv.channelUp();
    }

    @Override
    public void unexe() {
        tv.channelDown();
    }
}
