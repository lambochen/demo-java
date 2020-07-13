package cn.lambochen.demo.design.pattern.template;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/7/13
 * @description TODO
 **/
public class TemplateMain {

    /**
     * 1. 将水煮沸
     * 2. 将咖啡豆与水浸泡
     * 3. 倒入水杯
     * 4. 加入糖
     * ------------------
     *
     * 1. 将水煮沸
     * 2. 将茶叶与水浸泡
     * 3. 倒入水杯
     * 钩子 flavorHook() 函数执行
     */
    public static void main(String[] args) {
        Drink coffee = new Coffee();
        coffee.buildDrinkTemplate();

        System.out.println("------------------\n");

        Drink tea = new Tea();
        tea.buildDrinkTemplate();
    }
}
