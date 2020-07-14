package cn.lambochen.demo.design.pattern.adapter;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/7/14
 * @description 两相插座适配器 采用继承方式实现
 **/
public class TwoPhaseInterfaceExtendsAdapter extends ThreePhaseInterfaceImpl implements TwoPhaseInterface {
    @Override
    public void powerWithTwo() {
        super.powerWithThree();
    }
}
