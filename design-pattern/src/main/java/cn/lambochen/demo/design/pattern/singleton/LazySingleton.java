package cn.lambochen.demo.design.pattern.singleton;

import javax.management.OperationsException;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/7/21
 * @description 懒汉式单例模式
 **/
public class LazySingleton {

    private LazySingleton() {
    }

    // volatile 禁止指令重排 https://www.zhihu.com/question/56606703
    private volatile static LazySingleton instance;

    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }

    public void doSomething() {
        System.out.println("懒汉式单例模式");
    }

}
