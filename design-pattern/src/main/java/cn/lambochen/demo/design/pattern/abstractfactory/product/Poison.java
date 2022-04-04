package cn.lambochen.demo.design.pattern.abstractfactory.product;

/**
 * @author lambochen
 * @date 2022-04-04 14:21
 *
 * 毒液
 */
public class Poison extends MidClassUnit {

    @Override
    public void show() {
        System.out.println("Poison.show");
    }

    @Override
    public void attack() {
        System.out.println("Poison.attack");
    }
}
