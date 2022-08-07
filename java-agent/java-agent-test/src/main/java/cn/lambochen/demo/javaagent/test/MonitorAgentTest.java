package cn.lambochen.demo.javaagent.test;

/**
 * @author lambochen
 * @date 2022-08-07 18:26
 */
public class MonitorAgentTest {

    /**
     * java -javaagent:monitoragent.jar MonitorAgentTest
     */
    public static void main(String[] args) {
        fun();
    }

    private static void fun() {
        System.out.println("MonitorAgentTest.fun");

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
