package cn.lambochen.demo.design.pattern.chainofresponsibility;

/**
 * @author lambochen
 * @date 2022-04-05 21:59
 *
 * 审批人
 */
public abstract class Approver {

    protected String name;
    protected Approver nextApprover;

    public Approver(String name) {
        this.name = name;
    }

    public Approver setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
        // 返回下一个审批人，支持链式编程
        return this.nextApprover;
    }

    public abstract void approve(int amount);
}
