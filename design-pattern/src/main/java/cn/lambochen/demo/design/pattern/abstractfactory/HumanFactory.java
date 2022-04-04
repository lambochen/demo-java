package cn.lambochen.demo.design.pattern.abstractfactory;

import cn.lambochen.demo.design.pattern.abstractfactory.product.Battleship;
import cn.lambochen.demo.design.pattern.abstractfactory.product.HighClassUnit;
import cn.lambochen.demo.design.pattern.abstractfactory.product.LowClassUnit;
import cn.lambochen.demo.design.pattern.abstractfactory.product.Marine;
import cn.lambochen.demo.design.pattern.abstractfactory.product.MidClassUnit;
import cn.lambochen.demo.design.pattern.abstractfactory.product.Tank;

/**
 * @author lambochen
 * @date 2022-04-04 14:27
 *
 * 人类兵工厂
 */
public class HumanFactory implements AbstractFactory {
    @Override
    public LowClassUnit createLowClass() {
        return new Marine();
    }

    @Override
    public MidClassUnit createMidClass() {
        return new Tank();
    }

    @Override
    public HighClassUnit createHighClass() {
        return new Battleship();
    }
}
