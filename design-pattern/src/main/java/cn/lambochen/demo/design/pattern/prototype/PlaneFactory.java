package cn.lambochen.demo.design.pattern.prototype;

import java.util.Random;

/**
 * @author lambochen
 * @date 2022-04-04 13:41
 * <p>
 * 飞机工厂
 */
public class PlaneFactory {

    // 单例饿汉模式造一个飞机原型
    private static Plane protoType = new Plane();

    // 获取飞机克隆实例
    public static Plane getInstance(String name) throws CloneNotSupportedException {
        // 注意此处是复制，而非构造。
        // 克隆操作时Java虚拟机会进行内存操作，直接拷贝原型对象数据流生成新的副本对象，
        // 绝不会拖泥带水地触发一些多余的复杂操作（如类加载、实例化、初始化等），
        // 所以其效率远远高于“new”关键字所触发的实例化操作
        Plane clone = protoType.clone();

        clone.setName(name);

        return clone;
    }
}
