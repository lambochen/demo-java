package cn.lambochen.demo.design.pattern.chainofresponsibility;

/**
 * @author lambochen
 * @date 2022-04-05 22:04
 */
public class Client {

    public static void main(String[] args) {
        Approver flightJohn = new Staff("Alice");
        flightJohn.setNextApprover(new Manager("Bob")).setNextApprover(new CFO("Tom"));

        flightJohn.approve(10000);
    }
}
