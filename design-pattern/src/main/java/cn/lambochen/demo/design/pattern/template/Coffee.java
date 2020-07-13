package cn.lambochen.demo.design.pattern.template;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/7/13
 * @description 咖啡
 **/
public class Coffee extends Drink {

    protected void soakRawMaterial() {
        System.out.println("2. 将咖啡豆与水浸泡");
    }

    @Override
    protected void flavor() {
        System.out.println("4. 加入糖");
    }
}
