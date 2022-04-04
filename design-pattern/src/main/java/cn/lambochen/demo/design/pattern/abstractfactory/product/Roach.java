package cn.lambochen.demo.design.pattern.abstractfactory.product;

/**
 * @author lambochen
 * @date 2022-04-04 14:19
 *
 * 蟑螂类
 */
public class Roach extends LowClassUnit {

    @Override
    public void show() {
        System.out.println("Roach.show");
    }

    @Override
    public void attack() {
        System.out.println("Roach.attack");
    }
}
