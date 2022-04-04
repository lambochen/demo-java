package cn.lambochen.demo.design.pattern.abstractfactory;

/**
 * @author lambochen
 * @date 2022-04-04 14:30
 */
public class Client {

    public static void main(String[] args) {
        AbstractFactory alienFactory = new AlienFactory();
        alienFactory.createLowClass().show();
        alienFactory.createMidClass().show();
        alienFactory.createHighClass().show();

        AbstractFactory humanFactory = new HumanFactory();
        humanFactory.createLowClass().show();
        humanFactory.createMidClass().show();
        humanFactory.createHighClass().show();
    }
}
