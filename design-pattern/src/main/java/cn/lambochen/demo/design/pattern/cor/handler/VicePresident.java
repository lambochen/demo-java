package cn.lambochen.demo.design.pattern.cor.handler;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/7/14
 * @description 副总裁
 **/
public class VicePresident extends PriceHandler {
    @Override
    public void process(float discount) {
        if (discount < 0.35) {
            System.out.println("handler:" + this.getClass().getSimpleName() + ", discount=" + discount);
        } else {
            successor.process(discount);
        }
    }
}
