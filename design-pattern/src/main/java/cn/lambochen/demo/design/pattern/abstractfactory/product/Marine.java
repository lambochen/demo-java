package cn.lambochen.demo.design.pattern.abstractfactory.product;

/**
 * @author lambochen
 * @date 2022-04-04 14:19
 *
 * 海军陆战队员类Marine
 */
public class Marine extends LowClassUnit {

    @Override
    public void show() {
        System.out.println("Marine.show");
    }

    @Override
    public void attack() {
        System.out.println("Marine.attack");
    }
}
