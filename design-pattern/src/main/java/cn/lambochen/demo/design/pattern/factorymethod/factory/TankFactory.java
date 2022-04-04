package cn.lambochen.demo.design.pattern.factorymethod.factory;

import cn.lambochen.demo.design.pattern.factorymethod.Enemy;
import cn.lambochen.demo.design.pattern.factorymethod.Tank;

import java.util.Random;

/**
 * @author lambochen
 * @date 2022-04-04 14:05
 */
public class TankFactory implements Factory {
    private final Random random = new Random();

    @Override
    public Enemy create() {
        return new Tank(random.nextInt(), random.nextInt());
    }
}
