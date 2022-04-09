package cn.lambochen.demo.design.pattern.observer;

/**
 * @author lambochen
 * @date 2022-04-09 20:24
 */
public class PhoneFans extends Buyer{

    public PhoneFans(String name) {
        super(name);
    }

    @Override
    public void inform(String product) {
        if (product.contains("手机")) {
            // to buy
        }
    }
}
