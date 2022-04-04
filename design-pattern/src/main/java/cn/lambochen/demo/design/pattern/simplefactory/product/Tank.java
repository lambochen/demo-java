package cn.lambochen.demo.design.pattern.simplefactory.product;

/**
 * @author lambochen
 * @date 2022-04-04 13:53
 *
 * 坦克类Tank
 */
public class Tank extends Enemy {

    public Tank(int x, int y) {
        super(x, y);
    }

    @Override
    public void show() {
        System.out.println("敌机类Airplane: x,y = " + x + "," + y);
    }
}
