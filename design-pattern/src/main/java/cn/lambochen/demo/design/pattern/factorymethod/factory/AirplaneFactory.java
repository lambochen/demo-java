package cn.lambochen.demo.design.pattern.factorymethod.factory;

import cn.lambochen.demo.design.pattern.factorymethod.Airplane;
import cn.lambochen.demo.design.pattern.factorymethod.Enemy;

import java.util.Random;

/**
 * @author lambochen
 * @date 2022-04-04 14:04
 */
public class AirplaneFactory implements Factory {

    private final Random random = new Random();

    @Override
    public Enemy create() {
        return new Airplane(random.nextInt(), random.nextInt());
    }
}
