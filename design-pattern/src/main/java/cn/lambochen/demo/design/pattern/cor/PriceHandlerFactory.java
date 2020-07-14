package cn.lambochen.demo.design.pattern.cor;

import cn.lambochen.demo.design.pattern.cor.handler.CEO;
import cn.lambochen.demo.design.pattern.cor.handler.Director;
import cn.lambochen.demo.design.pattern.cor.handler.Manager;
import cn.lambochen.demo.design.pattern.cor.handler.PriceHandler;
import cn.lambochen.demo.design.pattern.cor.handler.Sales;
import cn.lambochen.demo.design.pattern.cor.handler.VicePresident;

import java.util.regex.Matcher;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/7/14
 * @description PriceHandler 工厂类
 **/
public class PriceHandlerFactory {

    public static PriceHandler create() {
        PriceHandler sales = new Sales();
        PriceHandler manager = new Manager();
        PriceHandler director = new Director();
        PriceHandler vicePresident = new VicePresident();
        PriceHandler ceo = new CEO();

        sales.setSuccessor(manager);
        manager.setSuccessor(director);
        director.setSuccessor(vicePresident);
        vicePresident.setSuccessor(ceo);

        return sales;
    }

}
