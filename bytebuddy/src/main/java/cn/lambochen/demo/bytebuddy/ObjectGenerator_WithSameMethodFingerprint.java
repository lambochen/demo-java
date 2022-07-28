package cn.lambochen.demo.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

/**
 * @author lambochen
 * @date 2022-07-28 00:12
 */
public class ObjectGenerator_WithSameMethodFingerprint {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Class<? extends People> clazz = generateSubclassWithSameMethodFingerprint();
        People people = clazz.newInstance();

        System.out.println(clazz.getName());
        System.out.println(people.say());

        /**
         * 输出：
         *
         * cn.lambochen.demo.bytebuddy.WithSameMethodFingerprint
         * 你好，ByteBuddy
         */
    }

    /**
     * 将拦截后到方法具体逻辑，委派到其它类执行
     *
     * 几点要求：
     * 1、People接口和Chinese类必须是公共的可访问的
     * 2、Chinese 的方法除了名字外，其它定义必须同 People
     * 3、该方式仅支持 Chinese 中只有一个相同签名的函数，否则会报错
     *
     *
     * @return
     */
    static Class<? extends People> generateSubclassWithSameMethodFingerprint() {
        return new ByteBuddy()
                .subclass(People.class)
                .name("cn.lambochen.demo.bytebuddy.WithSameMethodFingerprint")
                // 此处指明了需要拦截的方法
                .method(ElementMatchers.named("say"))
                // 委派到其它类实现
                .intercept(MethodDelegation.to(new Chinese()))
                // make 创建一个 unloaded 尚未加载的类，即生成了类的字节码
                .make()
                .load(ObjectGenerator_WithSameMethodFingerprint.class.getClassLoader())
                .getLoaded();
    }

    public interface People {
        String say();
    }

    public static class Chinese {
        /**
         * 签名（除方法名外）必须和 People 的相同
         * @return
         */
        public String sayChinese() {
            return "你好，ByteBuddy";
        }

//        public String sayChinese1() {
//            return "你好，ByteBuddy";
//        }
    }
}
