package cn.lambochen.demo.design.pattern.simplefactory;

import cn.lambochen.demo.design.pattern.simplefactory.product.Airplane;
import cn.lambochen.demo.design.pattern.simplefactory.product.Enemy;

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
