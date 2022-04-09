package cn.lambochen.demo.design.pattern.visitor;

import java.time.LocalDate;

/**
 * @author lambochen
 * @date 2022-04-09 19:55
 *
 * 糖果
 */
public class Candy extends Product implements Acceptable {
    public Candy(String name, LocalDate producedDate, float price) {
        super(name, producedDate, price);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
