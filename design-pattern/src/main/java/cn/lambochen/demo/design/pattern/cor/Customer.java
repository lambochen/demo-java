package cn.lambochen.demo.design.pattern.cor;

import cn.lambochen.demo.design.pattern.cor.handler.PriceHandler;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/7/14
 * @description 顾客, client
 **/
public class Customer {

    PriceHandler handler;

    public void setHandler(PriceHandler handler) {
        this.handler = handler;
    }

    public void request(float discount) {
        handler.process(discount);
    }

}
