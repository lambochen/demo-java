package cn.lambochen.demo.javaagent.demo;

import java.lang.instrument.Instrumentation;

/**
 * @author lambochen
 * @date 2022-08-06 19:38
 *
 * https://www.jianshu.com/p/3bbfa22ec7f5
 */
public class LogAgent {

    public static void premain(String args, Instrumentation instrumentation) {
        System.out.println("this is a agent");
        System.out.println("args: " + args);
    }
}
