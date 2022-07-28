package cn.lambochen.demo.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.implementation.FieldAccessor;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

/**
 * @author lambochen
 * @date 2022-07-29 00:39
 * <p>
 * 方法拦截 - 字段属性
 */
public class InterceptMethod_Field {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Class<? extends UserType> dynamicUserType = new ByteBuddy()
                .subclass(UserType.class)
                // 非父类 Object 声明的方法
                .method(ElementMatchers.not(ElementMatchers.isDeclaredBy(Object.class)))
                // 拦截委托给属性字段 interceptor
                .intercept(MethodDelegation.toField("interceptor"))
                // 定义属性字段
                .defineField("interceptor", Interceptor.class, Visibility.PRIVATE)
                // 实现 InterceptionAccessor 接口
                .implement(InterceptionAccessor.class)
                .intercept(FieldAccessor.ofBeanProperty())
                .make()
                .load(InterceptMethod_Field.class.getClassLoader())
                .getLoaded();

        InstanceCreator factory = new ByteBuddy()
                .subclass(InstanceCreator.class)
                .method(ElementMatchers.not(ElementMatchers.isDeclaredBy(Object.class)))
                // 委托拦截的方法来调用 dynamicUserType 的构造函数
                .intercept(MethodDelegation.toConstructor(dynamicUserType))
                .make()
                .load(dynamicUserType.getClassLoader())
                .getLoaded()
                .newInstance();

        UserType userType = (UserType) factory.create();
        ((InterceptionAccessor) userType).setInterceptor(new HelloWorldInterceptor());
        System.out.println(userType.fun()); // 输出： HelloWorldInterceptor.intercept
    }

    public static class UserType {
        public String fun() {
            return "usertype.fun";
        }
    }

    public interface Interceptor {
        String intercept();
    }

    public interface InterceptionAccessor {
        Interceptor getInterceptor();

        void setInterceptor(Interceptor interceptor);
    }

    public interface InstanceCreator {
        Object create();
    }

    public static class HelloWorldInterceptor implements Interceptor {

        @Override
        public String intercept() {
            return "HelloWorldInterceptor.intercept";
        }
    }

}
