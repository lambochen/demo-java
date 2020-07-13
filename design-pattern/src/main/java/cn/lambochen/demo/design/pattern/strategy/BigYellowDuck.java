package cn.lambochen.demo.design.pattern.strategy;

import cn.lambochen.demo.design.pattern.strategy.impl.FlyNoWay;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/7/13 21:42
 * @Description TODO
 **/
public class BigYellowDuck extends Duck {

    public BigYellowDuck() {
        super();
        super.setFlyStrategy(new FlyNoWay());
    }

}
