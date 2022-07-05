package cn.lambochen.demo.design.pattern.singleton.blog;

/**
 * @author lambochen
 * @date 2022-07-04 23:16
 */
public class SingletonLazy {

    private static volatile SingletonLazy INSTANCE;

    public static SingletonLazy getInstance() {
        if (null == INSTANCE) {
            synchronized (SingletonLazy.class) {
                // double check，防止在拿锁过程中，其他线程已经实例化完成，重复工作
                if (null == INSTANCE) {
                    INSTANCE = new SingletonLazy();
                }
            }
        }

        return INSTANCE;
    }

    private SingletonLazy() {
    }
}


