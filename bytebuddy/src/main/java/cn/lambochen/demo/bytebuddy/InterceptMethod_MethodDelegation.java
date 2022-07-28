package cn.lambochen.demo.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.matcher.ElementMatchers;

/**
 * @author lambochen
 * @date 2022-07-29 00:27
 *
 * 方法拦截 - 方法委派
 *
 *
 */
public class InterceptMethod_MethodDelegation {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Source dynamicSource = new ByteBuddy()
                .subclass(Source.class)
                .method(ElementMatchers.named("hello"))
                // 使用MethodDelegation可以将方法调用委托给任意POJO。Byte Buddy不要求Source（被委托类）、Target类的方法名一致
                .intercept(MethodDelegation.to(Target.class))
                .make()
                .load(InterceptMethod_MethodDelegation.class.getClassLoader())
                .getLoaded()
                .newInstance();

        System.out.println(dynamicSource.hello("world"));
    }


    public static class Source {
        public String hello(String name) {
            return "source..string.." + name;
        }
    }

    /**
     * Byte Buddy遵循一个最接近原则：
     *
     * intercept(int) 因为参数类型不匹配，直接Pass
     * 另外两个方法参数都匹配，但是 intercept(String)类型更加接近，因此会委托给它
     *
     * 同时需要注意的是被拦截的方法需要声明为 public，否则没法进行拦截增强。除此之外，还可以使用 @RuntimeType 注解来标注方法
     */
    public static class Target {

        public static String intercept(String name) {
            return "target..string.." + name;
        }
        public static String intercept(int name) {
            return "target..int.." + name;
        }

        public static String intercept(Object name) {
            return "target..object.." + name;
        }
    }

}
