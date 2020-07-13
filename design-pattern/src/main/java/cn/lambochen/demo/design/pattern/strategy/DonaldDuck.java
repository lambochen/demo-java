package cn.lambochen.demo.design.pattern.strategy;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/7/13 21:43
 * @Description 唐老鸭
 **/
public class DonaldDuck extends Duck {
    public DonaldDuck() {
        super();
        super.setFlyStrategy(() -> System.out.println("意念飞行，哈哈哈哈。。。"));
    }
}
