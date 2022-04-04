package cn.lambochen.demo.design.pattern.builder;

/**
 * @author lambochen
 * @date 2022-04-04 18:23
 */
public class Client {

    public static void main(String[] args) {
        Product product = Product.builder()
                .setId(1L)
                .setName("Bod")
                .build();

        System.out.println(product);
    }
}
