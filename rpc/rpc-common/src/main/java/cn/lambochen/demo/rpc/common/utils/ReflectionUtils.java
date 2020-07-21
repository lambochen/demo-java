package cn.lambochen.demo.rpc.common.utils;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/7/21 23:08
 * @Description 反射工具类
 **/
public abstract class ReflectionUtils {

    /**
     * 根据 class 创建对象
     *
     * @param clazz 待创建对象的类
     * @param <T>   对象类型
     * @return
     */
    public static <T> T newInstance(Class<T> clazz) {
        try {
            return clazz.newInstance();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * 获取 class 的 public 方法
     *
     * @param clazz
     * @return
     */
    public static Method[] getPublicMethods(Class clazz) {
        // 获取当前类所有的方法，包含 private，public, protected, default. 不包含父类方法
        Method[] methods = clazz.getDeclaredMethods();
        List<Method> pMethods = new ArrayList<>();
        for (Method method : methods) {
            if (Modifier.isPublic(method.getModifiers())) {
                pMethods.add(method);
            }
        }
        return pMethods.toArray(new Method[0]);
    }

    /**
     * 调用 obj 的 method 方法
     *
     * @param obj    被调用方法的对象
     * @param method 被调用方法
     * @param args   方法参数
     * @return 方法执行结果
     */
    public static Object invoke(Object obj, Method method, Object... args) {
        try {
            return method.invoke(obj, args);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

}
