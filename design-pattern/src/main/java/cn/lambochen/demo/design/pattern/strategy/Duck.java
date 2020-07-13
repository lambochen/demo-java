package cn.lambochen.demo.design.pattern.strategy;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/7/13 21:34
 * @Description 鸭子类，抽象类
 **/
public abstract class Duck {

    /**
     * 飞行策略对象
     */
    FlyStrategy flyStrategy;

    /**
     * 叫
     */
    public void roar() {
        // 默认实现
        System.out.println("嘎嘎嘎");
    }

    public void fly() {
        // 飞行的动作不由当前类提供，而由子类实现
        flyStrategy.fly();
    }

    protected void setFlyStrategy(FlyStrategy flyStrategy) {
        this.flyStrategy = flyStrategy;
    }
}
