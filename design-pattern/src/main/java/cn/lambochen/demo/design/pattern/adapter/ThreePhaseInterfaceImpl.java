package cn.lambochen.demo.design.pattern.adapter;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/7/14
 * @description 三相插座
 **/
public class ThreePhaseInterfaceImpl implements ThreePhaseInterface {
    public void powerWithThree() {
        System.out.println("三相插座。。。。充电。。。。");
    }
}
