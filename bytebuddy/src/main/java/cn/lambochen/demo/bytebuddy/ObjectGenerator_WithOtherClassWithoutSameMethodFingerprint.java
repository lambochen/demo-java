package cn.lambochen.demo.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

/**
 * @author lambochen
 * @date 2022-07-28 00:24
 */
public class ObjectGenerator_WithOtherClassWithoutSameMethodFingerprint {


    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Class<? extends People> sayClazz = generateWithOtherClassWithoutSameMethodFingerprint("sayChinese");
        People sayPeople = sayClazz.newInstance();
        System.out.println(sayClazz.getName());
        System.out.println(sayPeople.say());
        /**
         * cn.lambochen.demo.bytebuddy.WithOtherClassWithoutSameMethodFingerprint
         * 你好，ByteBuddy
         */


        Class<? extends People> runClazz = generateWithOtherClassWithoutSameMethodFingerprint("run");
        People runPeople = runClazz.newInstance();
        System.out.println(runClazz.getName());
        System.out.println(runPeople.say());
        /**
         * cn.lambochen.demo.bytebuddy.WithOtherClassWithoutSameMethodFingerprint
         * this is Chinese.run
         */
    }

    static Class<? extends People> generateWithOtherClassWithoutSameMethodFingerprint(String methodForIntercept) {
        return new ByteBuddy()
                .subclass(People.class)
                .name("cn.lambochen.demo.bytebuddy.WithOtherClassWithoutSameMethodFingerprint")
                // 此处指明了需要拦截的方法
                .method(ElementMatchers.named("say"))
                // 委派到其它类实现
                .intercept(
                        MethodDelegation
                                .withDefaultConfiguration()
                                // 手动指定需要用哪个 method 来作为执行者
                                .filter(ElementMatchers.named(methodForIntercept))
                                .to(new Chinese())
                )
                .make()
                .load(ObjectGenerator_WithOtherClassWithoutSameMethodFingerprint.class.getClassLoader())
                .getLoaded();
    }

    public interface People {
        String say();
    }

    public static class Chinese {

        public String sayChinese() {
            return "你好，ByteBuddy";
        }

        public String run() {
            return "this is Chinese.run";
        }
    }

}
