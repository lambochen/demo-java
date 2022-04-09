package cn.lambochen.demo.design.pattern.visitor;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * @author lambochen
 * @date 2022-04-09 20:02
 */
public class Client {

    public static void main(String[] args) {
        Visitor discountVisitor = new DiscountVisitor(LocalDate.of(2022, 2, 1));

        Candy candy = new Candy("奶糖", LocalDate.of(2022, 1, 1), 20f);
        discountVisitor.visit(candy);

        List<Acceptable> products = Arrays.asList(
                new Candy("奶糖", LocalDate.of(2018, 10, 1), 20),
                new Wine("泸州老窖", LocalDate.of(2000, 1, 1), 10000),
                new Fruit("苹果", LocalDate.of(2022, 2, 2), 10)
        );
        for (Acceptable product : products) {
            product.accept(discountVisitor);
        }
    }
}
