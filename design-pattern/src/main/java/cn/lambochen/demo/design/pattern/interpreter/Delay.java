package cn.lambochen.demo.design.pattern.interpreter;

/**
 * @author lambochen
 * @date 2022-04-09 20:36
 */
public class Delay implements Expression {

    private int seconds;

    public Delay(int seconds) {
        this.seconds = seconds;
    }

    public int getSeconds() {
        return seconds;
    }

    @Override
    public void interpret() {
        try {
            System.out.println("delay: " + seconds);
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
