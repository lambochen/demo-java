package cn.lambochen.demo.design.pattern.singleton.blog;

/**
 * @author lambochen
 * @date 2022-07-05 00:05
 */
public class SingletonEnumClass {

    // 对外访问接口
    public static Singleton getInstance() {
        return SingletonEnum.INSTANCE.instance;
    }

    // 单例类
    public static class Singleton {

    }

    // 枚举类，用于实例化单例对象
    public enum SingletonEnum {
        // 单例对象
        INSTANCE;

        private Singleton instance;

        SingletonEnum() {
            // 初始化逻辑
            this.instance = new Singleton();
        }
    }
}
