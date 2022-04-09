package cn.lambochen.demo.design.pattern.visitor;

import java.text.NumberFormat;
import java.time.LocalDate;

/**
 * @author lambochen
 * @date 2022-04-09 19:57
 *
 * 折扣计价访问者
 */
public class DiscountVisitor implements Visitor {

    // 结算日期
    private LocalDate billDate;

    public DiscountVisitor(LocalDate billDate) {
        this.billDate = billDate;
    }

    @Override
    public void visit(Candy candy) {
        float rate = 0;
        long days = billDate.toEpochDay() - candy.getProducedDate().toEpochDay();

        if (days > 180) {
            System.out.println("超过半年的糖果，请勿食用");
        } else {
            // 九折
            rate = 0.9f;
        }

        float discountPrice = candy.getPrice() * rate;
        System.out.println(NumberFormat.getCurrencyInstance().format(discountPrice));
    }

    @Override
    public void visit(Wine wine) {
        // 酒无折扣
        System.out.println(NumberFormat.getCurrencyInstance().format(wine.getPrice()));
    }

    @Override
    public void visit(Fruit fruit) {
        float rate = 0;
        long days = billDate.toEpochDay() - fruit.getProducedDate().toEpochDay();
        if (days > 7) {
            System.out.println("超过七天的水果，请勿食用");
        } else if (days > 3){
            rate = 0.5f;
        } else {
            rate = 1;
        }

        float discountPrice = fruit.getPrice() * fruit.getWeight() * rate;
        System.out.println(NumberFormat.getCurrencyInstance().format(discountPrice));
    }
}
