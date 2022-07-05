package cn.lambochen.demo.design.pattern.singleton.blog;

/**
 * @author lambochen
 * @date 2022-07-04 23:10
 */
public class SingletonImmediately {

    private static final SingletonImmediately INSTANCE;

    static {
        INSTANCE = new SingletonImmediately();
    }

    public static SingletonImmediately getInstance() {
        return INSTANCE;
    }

    private SingletonImmediately() {
    }
}
