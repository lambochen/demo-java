package cn.lambochen.demo.design.pattern.abstractfactory;

import cn.lambochen.demo.design.pattern.abstractfactory.product.HighClassUnit;
import cn.lambochen.demo.design.pattern.abstractfactory.product.LowClassUnit;
import cn.lambochen.demo.design.pattern.abstractfactory.product.Mammoth;
import cn.lambochen.demo.design.pattern.abstractfactory.product.MidClassUnit;
import cn.lambochen.demo.design.pattern.abstractfactory.product.Poison;
import cn.lambochen.demo.design.pattern.abstractfactory.product.Roach;

/**
 * @author lambochen
 * @date 2022-04-04 14:28
 *
 * 外星母巢（外星是动物类，所以是 巢）
 */
public class AlienFactory implements AbstractFactory {

    @Override
    public LowClassUnit createLowClass() {
        return new Roach();
    }

    @Override
    public MidClassUnit createMidClass() {
        return new Poison();
    }

    @Override
    public HighClassUnit createHighClass() {
        return new Mammoth();
    }
}
