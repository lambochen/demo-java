package cn.lambochen.demo.design.pattern.abstractfactory;

import cn.lambochen.demo.design.pattern.abstractfactory.product.HighClassUnit;
import cn.lambochen.demo.design.pattern.abstractfactory.product.LowClassUnit;
import cn.lambochen.demo.design.pattern.abstractfactory.product.MidClassUnit;

/**
 * @author lambochen
 * @date 2022-04-04 14:25
 *
 * 抽象兵工厂
 */
public interface AbstractFactory {

    // 初级兵种制造标准
    LowClassUnit createLowClass();

    // 中级兵种制造标准
    MidClassUnit createMidClass();

    // 高级兵种制造标准
    HighClassUnit createHighClass();

}
