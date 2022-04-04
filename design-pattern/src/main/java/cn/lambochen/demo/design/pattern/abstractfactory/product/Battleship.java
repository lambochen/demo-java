package cn.lambochen.demo.design.pattern.abstractfactory.product;

/**
 * @author lambochen
 * @date 2022-04-04 14:22
 * 巨型战舰类Battleship
 */
public class Battleship extends HighClassUnit {

    @Override
    public void show() {
        System.out.println("Battleship.show");
    }

    @Override
    public void attack() {
        System.out.println("Battleship.attack");
    }
}
