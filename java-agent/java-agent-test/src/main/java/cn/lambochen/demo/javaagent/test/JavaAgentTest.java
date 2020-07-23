package cn.lambochen.demo.javaagent.test;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/7/23
 * @description JavaAgent test
 **/
public class JavaAgentTest {

    public static void main(String[] args) throws InterruptedException {
        JavaAgentTest instance = new JavaAgentTest();
        instance.execute();
        Thread.sleep((long) (Math.random() * 100));
    }

    public void execute() throws InterruptedException {
        System.out.println("I'm JavaAgentTest.");
        Thread.sleep((long) (Math.random() * 1000));
    }

}
