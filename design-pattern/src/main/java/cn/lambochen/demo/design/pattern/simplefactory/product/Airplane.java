package cn.lambochen.demo.design.pattern.simplefactory.product;

/**
 * @author lambochen
 * @date 2022-04-04 13:51
 * <p>
 * 敌机类Airplane
 */
public class Airplane extends Enemy {

    public Airplane(int x, int y) {
        super(x, y);
    }

    @Override
    public void show() {
        System.out.println("敌机类Airplane: x,y = " + x + "," + y);
    }
}
