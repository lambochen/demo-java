package cn.lambochen.demo.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

/**
 * @author lambochen
 * @date 2022-07-27 23:57
 */
public class ObjectGenerator_SubclassForObjectAndOverrideToString {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Class<? extends Object> subclassForObjectClass = generateSubclassForObjectAndOverrideToString();

        Object subclassForObject = subclassForObjectClass.newInstance();

        System.out.println(subclassForObject.toString());
        System.out.println(subclassForObject.getClass().getName());
    }

    /**
     * 创建一个 Object 的子类，并且重写 toString 方法
     *
     * @return
     */
    public static Class<? extends Object> generateSubclassForObjectAndOverrideToString() {
        String clazzName = "cn.lambochen.demo.bytebyddy.SubclassForObjectAndOverrideToString";
        return new ByteBuddy()
                // 指定是哪个类的子类
                .subclass(Object.class)
                // 指定类名
                .name(clazzName)
                // 注名要拦截的方法（拦截后即进行字节码重写）
                .method(ElementMatchers.named("toString"))
                // 拦截后的处理逻辑，此处返回固定值
                .intercept(FixedValue.value("this is bytebuddy intercept result."))
                .make()
                .load(ObjectGenerator_SubclassForObjectAndOverrideToString.class.getClassLoader())
                .getLoaded();
    }

}
