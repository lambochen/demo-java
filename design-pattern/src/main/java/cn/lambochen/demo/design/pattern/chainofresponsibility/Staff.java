package cn.lambochen.demo.design.pattern.chainofresponsibility;

/**
 * @author lambochen
 * @date 2022-04-05 22:01
 * <p>
 * 财务专员
 */
public class Staff extends Approver {

    public Staff(String name) {
        super(name);
    }

    @Override
    public void approve(int amount) {
        if (amount <= 1000) {
            System.out.println("Staff.approve");
            return;
        }

        this.nextApprover.approve(amount);
    }
}
