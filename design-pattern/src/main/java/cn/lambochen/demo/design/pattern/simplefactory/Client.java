package cn.lambochen.demo.design.pattern.simplefactory;

/**
 * @author lambochen
 * @date 2022-04-04 14:06
 */
public class Client {

    public static void main(String[] args) {
        // 方案A：一个工厂
        EnemyFactory enemyFactory = new EnemyFactory();
        enemyFactory.create("Airplane").show();
        enemyFactory.create("Tank").show();

        // 方案B：劳动分工，不同的工厂生产不同的机器
        Factory factory = new AirplaneFactory();
        factory.create().show();
        factory = new TankFactory();
        factory.create().show();
    }

}
