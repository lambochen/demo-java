package cn.lambochen.demo.design.pattern.decorator.old;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/7/16 21:29
 * @Description 饮品, 抽象接口
 **/
public interface Drink {

    /**
     * 价钱
     * @return
     */
    float price();

    /**
     * 描述
     * @return
     */
    String desc();
}
