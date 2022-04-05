package cn.lambochen.demo.design.pattern.adapter;

/**
 * @author lambochen
 * @date 2022-04-05 14:08
 */
public class Client {

    public static void main(String[] args) {
        DualPin dualPinDevice = new TV();
        TriplePin triplePinDevice = new Adapter(dualPinDevice);
        triplePinDevice.electrify(1, 0, -1);

        // 专属适配器
        TriplePin tvAdapter = new TVAdapter();
        tvAdapter.electrify(1, 0, -1);
    }
}
