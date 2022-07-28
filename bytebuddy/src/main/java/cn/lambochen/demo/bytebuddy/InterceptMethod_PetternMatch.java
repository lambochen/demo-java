package cn.lambochen.demo.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

/**
 * @author lambochen
 * @date 2022-07-29 00:17
 * <p>
 * 方法拦截 - 通过匹配模式拦截
 */
public class InterceptMethod_PetternMatch {


    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Foo dynamicFoo = new ByteBuddy()
                .subclass(Foo.class)
                // 匹配由 Foo.class 声明的方法
                .method(ElementMatchers.isDeclaredBy(Foo.class))
                .intercept(FixedValue.value("one"))
                // 匹配名为 fun 的方法
                .method(ElementMatchers.named("fun"))
                .intercept(FixedValue.value("fun...intercept"))
                // 匹配名为 fun，入参数量为 1 的方法
                .method(ElementMatchers.named("fun").and(ElementMatchers.takesArguments(1)))
                .intercept(FixedValue.value("fun...1...intercept"))
                .make()
                .load(InterceptMethod_PetternMatch.class.getClassLoader())
                .getLoaded()
                .newInstance();

        System.out.println(dynamicFoo.fun());
        System.out.println(dynamicFoo.fun("aaaa"));
        System.out.println(dynamicFoo.fun("bbbb", 1));
        System.out.println(dynamicFoo.funOne());
    }


    public static class Foo {
        public String fun() {
            return "foo";
        }

        public String funOne() {
            return "foo_one";
        }

        public String fun(String data) {
            return "foo_two" + data;
        }

        public String fun(String data, int a) {
            return "foo_two" + data + a;
        }
    }

}
