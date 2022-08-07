package cn.lambochen.demo.javaagent.test;

/**
 * @author lambochen
 * @date 2022-08-06 19:41
 */
public class LogAgentTest {

    /**
     * 运行命令：
     * javac LogAgentTest.java
     * java -javaagent:./logagent.jar LogAgentTest.class
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("LogAgentTest args:" + args);
    }
}
