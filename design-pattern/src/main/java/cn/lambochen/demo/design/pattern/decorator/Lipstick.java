package cn.lambochen.demo.design.pattern.decorator;

/**
 * @author lambochen
 * @date 2022-04-05 13:55
 *
 * 口红类
 */
public class Lipstick extends Decorator {

    public Lipstick(Showable showable) {
        super(showable);
    }

    @Override
    public void show() {
        System.out.println("Lipstick.show.pre");
        super.show();
        System.out.println("Lipstick.show.pre");
    }
}
