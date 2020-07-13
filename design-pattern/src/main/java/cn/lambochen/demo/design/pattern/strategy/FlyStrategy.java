package cn.lambochen.demo.design.pattern.strategy;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/7/13 21:37
 * @Description 飞行 策略接口
 **/
@FunctionalInterface
public interface FlyStrategy {

    /**
     * 飞行
     */
    void fly();
}
