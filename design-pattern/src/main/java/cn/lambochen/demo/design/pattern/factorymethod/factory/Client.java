package cn.lambochen.demo.design.pattern.factorymethod.factory;

/**
 * @author lambochen
 * @date 2022-04-04 14:06
 */
public class Client {

    /**
     * 劳动分工，不同的工厂生产不同的机器
     */
    public static void main(String[] args) {
        Factory factory = new AirplaneFactory();
        factory.create().show();

        factory = new TankFactory();
        factory.create().show();
    }

}
