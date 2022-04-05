package cn.lambochen.demo.design.pattern.chainofresponsibility;

/**
 * @author lambochen
 * @date 2022-04-05 22:03
 */
public class CFO extends Approver {
    public CFO(String name) {
        super(name);
    }

    @Override
    public void approve(int amount) {
        System.out.println("CFO.approve");
    }
}
