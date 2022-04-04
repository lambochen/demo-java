package cn.lambochen.demo.design.pattern.abstractfactory.product;

/**
 * @author lambochen
 * @date 2022-04-04 14:22
 *
 * 猛犸
 */
public class Mammoth extends HighClassUnit {

    @Override
    public void show() {
        System.out.println("Mammoth.show");
    }

    @Override
    public void attack() {
        System.out.println("Mammoth.attack");
    }
}
