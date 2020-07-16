package cn.lambochen.demo.design.pattern.decorator;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/7/16 21:38
 * @Description 冰
 **/
public class Ice extends Decorator {
    public Ice(Drink drink) {
        super(drink);
    }

    @Override
    public float price() {
        return super.price() + 0.5f;
    }

    @Override
    public String desc() {
        return super.desc() + "+冰";
    }
}
