package cn.lambochen.demo.design.pattern.singleton.blog;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * @author lambochen
 * @date 2022-07-04 23:54
 */
public class SingletonStaticInnerClass implements Serializable {

    public static Singleton getInstance() {
        return Singleton.INSTANCE;
    }

    private static class Singleton {
        private static Singleton INSTANCE = new Singleton();
    }

    private SingletonStaticInnerClass() {
    }

    protected Object readResolve() throws ObjectStreamException {
        return Singleton.INSTANCE;
    }
}
