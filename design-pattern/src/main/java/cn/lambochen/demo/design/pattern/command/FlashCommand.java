package cn.lambochen.demo.design.pattern.command;

/**
 * @author lambochen
 * @date 2022-04-07 22:27
 * <p>
 * 闪烁命令类
 */
public class FlashCommand implements Command {

    private Bulb bulb;
    private volatile boolean neonRun = false; // 闪烁命令运行状态

    public FlashCommand(Bulb bulb) {
        this.bulb = bulb;
    }

    @Override
    public void exe() {
        if (!neonRun) {
            neonRun = true;
            System.out.println("霓虹灯闪烁任务启动");

            new Thread(() -> {
                try {
                    while (neonRun) {
                        bulb.on();
                        Thread.sleep(100);
                        bulb.off();
                        Thread.sleep(100);
                    }
                } catch (InterruptedException e) {
                    // todo
                }
            }).start();
        }
    }

    @Override
    public void unexe() {
        neonRun = false;
        System.out.println("霓虹灯闪烁结束");
    }
}
