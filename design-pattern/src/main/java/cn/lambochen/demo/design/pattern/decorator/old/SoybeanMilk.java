package cn.lambochen.demo.design.pattern.decorator.old;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/7/16 21:29
 * @Description 纯豆浆
 **/
public class SoybeanMilk implements Drink {
    @Override
    public float price() {
        return 2;
    }

    @Override
    public String desc() {
        return "纯豆浆";
    }
}
