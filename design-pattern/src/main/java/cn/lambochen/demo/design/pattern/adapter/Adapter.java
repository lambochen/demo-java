package cn.lambochen.demo.design.pattern.adapter;

/**
 * @author lambochen
 * @date 2022-04-05 14:07
 */
public class Adapter implements TriplePin {

    private DualPin dualPinDevice;

    // 构造适配器，需要把两相插座设备接入进来
    public Adapter(DualPin dualPinDevice) {
        this.dualPinDevice = dualPinDevice;
    }

    @Override
    public void electrify(int l, int n, int e) {
        dualPinDevice.electrify(l, n);
    }
}
