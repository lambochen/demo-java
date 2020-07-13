package cn.lambochen.demo.design.pattern.strategy.impl;

import cn.lambochen.demo.design.pattern.strategy.FlyStrategy;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/7/13 21:40
 * @Description 无法飞行
 **/
public class FlyNoWay implements FlyStrategy {
    @Override
    public void fly() {
        System.out.println("呜呜呜。。。不能飞行哟。。。");
    }
}
