package cn.lambochen.demo.design.pattern.factorymethod;

/**
 * @author lambochen
 * @date 2022-04-04 13:57
 */
public class Client {

    public static void main(String[] args) {
        EnemyFactory factory = new EnemyFactory();

        factory.create("Airplane").show();
        factory.create("Tank").show();
    }

}
