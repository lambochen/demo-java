package cn.lambochen.demo.javassist;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;

/**
 * @author lambochen
 * @date 2022-08-07 18:08
 */
public class MonitorAgent {

    public static void premain(String args, Instrumentation instrumentation) {
        System.out.println("MonitorAgent: " + args);

        ClassFileTransformer transformer = new PerformMonitorTransformer();
        instrumentation.addTransformer(transformer);
    }

}
