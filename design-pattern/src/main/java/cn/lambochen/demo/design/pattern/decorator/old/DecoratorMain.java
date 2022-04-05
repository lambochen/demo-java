package cn.lambochen.demo.design.pattern.decorator.old;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/7/16 21:42
 * @Description TODO
 **/
public class DecoratorMain {

    public static void main(String[] args) {
        Drink soybeanMilk = new SoybeanMilk();
        System.out.println("price=" + soybeanMilk.price());
        System.out.println("desc=" + soybeanMilk.desc());

        System.out.println("---------------");
        Drink sugarSm = new Sugar(soybeanMilk);
        System.out.println("price=" + sugarSm.price());
        System.out.println("desc=" + sugarSm.desc());

        System.out.println("---------------");
        Drink iceSugarSM = new Ice(sugarSm);
        System.out.println("price=" + iceSugarSM.price());
        System.out.println("desc=" + iceSugarSM.desc());
    }

}
