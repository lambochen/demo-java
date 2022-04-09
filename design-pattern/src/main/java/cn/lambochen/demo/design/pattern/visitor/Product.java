package cn.lambochen.demo.design.pattern.visitor;

import java.time.LocalDate;

/**
 * @author lambochen
 * @date 2022-04-09 19:54
 */
public abstract class Product {


    private String name;
    private LocalDate producedDate; // 生产日期
    private float price;

    public Product(String name, LocalDate producedDate, float price) {
        this.name = name;
        this.producedDate = producedDate;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getProducedDate() {
        return producedDate;
    }

    public void setProducedDate(LocalDate producedDate) {
        this.producedDate = producedDate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
