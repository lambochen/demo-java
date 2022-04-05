package cn.lambochen.demo.design.pattern.chainofresponsibility;

/**
 * @author lambochen
 * @date 2022-04-05 22:02
 * <p>
 * 财务经理
 */
public class Manager extends Approver {
    public Manager(String name) {
        super(name);
    }

    @Override
    public void approve(int amount) {
        if (amount <= 5000) {
            System.out.println("Manager.approve");
            return;
        }

        this.nextApprover.approve(amount);
    }
}
