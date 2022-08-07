package cn.lambochen.demo.javaagent.test;

/**
 * @author lambochen
 * @date 2022-08-07 18:26
 */
public class MonitorAgentByByteBuddyTest {

    /**
     * java -javaagent:monitoragentbybytebuddy.jar MonitorAgentByByteBuddyTest
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
