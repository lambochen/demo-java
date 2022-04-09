package cn.lambochen.demo.design.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lambochen
 * @date 2022-04-09 20:19
 */
public class Shop {

    private String product;

    private List<Buyer> buyers;

    public Shop() {
        this.product = "无商品";
        this.buyers = new ArrayList<>();
    }

    public void register(Buyer buyer) {
        this.buyers.add(buyer);
    }

    public void notifyBuyers() {
        buyers.stream().forEach(b -> b.inform(this.getProduct()));
    }
    // 出货
    public String getProduct() {
        return product;
    }

    // 进货
    public void setProduct(String product) {
        this.product = product;
    }
}
