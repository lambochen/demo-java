package cn.lambochen.demo.design.pattern.singleton;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/7/21
 * @description 饿汉式单例模式 【推荐】
 **/
public class Singleton {

    private static final Singleton instance = new Singleton();

    private Singleton() {

    }

    public static Singleton getInstance() {
        return instance;
    }

    public void doSomething() {
        System.out.println("饿汉式单例模式");
    }

}
