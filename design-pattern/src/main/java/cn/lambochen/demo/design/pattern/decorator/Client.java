package cn.lambochen.demo.design.pattern.decorator;

import sun.security.provider.MD2;

/**
 * @author lambochen
 * @date 2022-04-05 13:52
 */
public class Client {

    public static void main(String[] args) {

        // 先粉底、再口红
        Showable madeupGirl =
                new Lipstick(
                        new FoundationMakeup(
                                new Girl()
                        )
                );

        madeupGirl.show();
    }
}
