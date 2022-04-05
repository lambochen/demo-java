package cn.lambochen.demo.design.pattern.adapter;

/**
 * @author lambochen
 * @date 2022-04-05 14:06
 *
 * 电视机类
 */
public class TV implements DualPin {
    @Override
    public void electrify(int l, int n) {
        System.out.println("TV.electrify");
    }
}
