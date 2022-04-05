package cn.lambochen.demo.design.pattern.decorator.old;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/7/16 21:31
 * @Description 装饰器抽象类
 **/
public abstract class Decorator implements Drink {

    /**
     * 需要持有被装饰着的引用
     */
    protected Drink drink;

    public Decorator(Drink drink) {
        this.drink = drink;
    }

    @Override
    public float price() {
        return drink.price();
    }

    @Override
    public String desc() {
        return drink.desc();
    }
}
