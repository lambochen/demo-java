package cn.lambochen.demo.design.pattern.template;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/7/13
 * @description 茶
 **/
public class Tea extends Drink {

    protected void soakRawMaterial() {
        System.out.println("2. 将茶叶与水浸泡");
    }

    @Override
    protected boolean flavorHook() {
        // 不需要加入调味品
        System.out.println("钩子 flavorHook() 函数执行");
        return false;
    }
}
