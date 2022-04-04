package cn.lambochen.demo.design.pattern.factorymethod;

import java.util.Random;

/**
 * @author lambochen
 * @date 2022-04-04 13:54
 * <p>
 * 简单工厂类
 */
public class EnemyFactory {

    private Random random = new Random();

    public Enemy create(String type) {
        int x = random.nextInt();

        Enemy enemy = null;
        switch (type) {
            case "Airplane":
                enemy = new Airplane(x, 0);
                break;
            case "Tank":
                enemy = new Tank(x, 0);
                break;
        }

        return enemy;
    }

}
