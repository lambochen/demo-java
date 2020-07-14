package cn.lambochen.demo.design.pattern.cor;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/7/14
 * @description 责任链模式
 **/
public class CorMain {

    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setHandler(PriceHandlerFactory.create());

        customer.request(0.4f);
    }
}
