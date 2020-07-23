package cn.lambochen.demo.javaagent.agent;

import java.lang.instrument.Instrumentation;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/7/23
 * @description Java Agent demo
 **/
public class MyAgent {

    public static void premain(String args, Instrumentation instrumentation) {
        System.out.println("I'm Agent! premain");
        instrumentation.addTransformer(new MyTransformer());
    }

//    public static void agentmain(String args, Instrumentation instrumentation) {
//        System.out.println("I'm Agent! agentmain");
//        instrumentation.addTransformer(new MyTransformer());
//    }

}
