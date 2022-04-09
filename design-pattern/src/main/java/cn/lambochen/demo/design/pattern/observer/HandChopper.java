package cn.lambochen.demo.design.pattern.observer;

/**
 * @author lambochen
 * @date 2022-04-09 20:24
 */
public class HandChopper extends Buyer{
    public HandChopper(String name) {
        super(name);
    }

    @Override
    public void inform(String product) {
        // to buy
    }
}
