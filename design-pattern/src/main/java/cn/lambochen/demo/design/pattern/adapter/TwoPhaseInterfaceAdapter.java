package cn.lambochen.demo.design.pattern.adapter;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/7/14
 * @description 两相插座适配器
 **/
public class TwoPhaseInterfaceAdapter implements TwoPhaseInterface {

    ThreePhaseInterface three;

    public void setThree(ThreePhaseInterface three) {
        this.three = three;
    }

    public void powerWithTwo() {
        three.powerWithThree();
    }

}
