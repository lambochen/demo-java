package cn.lambochen.demo.design.pattern.visitor;

import java.time.LocalDate;

/**
 * @author lambochen
 * @date 2022-04-09 19:55
 *
 * 水果
 */
public class Fruit extends Product implements Acceptable {

    private float weight;

    public Fruit(String name, LocalDate producedDate, float price) {
        super(name, producedDate, price);
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
