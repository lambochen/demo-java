package cn.lambochen.demo.design.pattern.decorator;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/7/16 21:35
 * @Description 糖
 **/
public class Sugar extends Decorator {
    public Sugar(Drink drink) {
        super(drink);
    }

    @Override
    public float price() {
        return super.price() + 1f;
    }

    @Override
    public String desc() {
        return super.desc() + "+糖";
    }
}
