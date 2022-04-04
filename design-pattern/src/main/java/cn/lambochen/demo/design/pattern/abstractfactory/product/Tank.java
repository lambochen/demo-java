package cn.lambochen.demo.design.pattern.abstractfactory.product;

/**
 * @author lambochen
 * @date 2022-04-04 14:21
 *
 * 变形坦克类Tank
 */
public class Tank extends MidClassUnit {

    @Override
    public void show() {
        System.out.println("Tank.show");
    }

    @Override
    public void attack() {
        System.out.println("Tank.attack");
    }
}
