package cn.lambochen.demo.simple.proxy.dynamicproxy.jdk;

import java.lang.reflect.Proxy;

/**
 * @author lambo.chen
 * @date 2020/11/20
 * <p>
 * 动态代理对象
 **/
public class JdkProxyFactory {

    /**
     * 维护一个目标对象
     */
    private Object target;

    public JdkProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * 为目标对象生成代理对象
     *
     * @return
     */
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("jdk proxy: pre");

                    // 执行目标对象方法
                    Object value = method.invoke(target, args);

                    System.out.println("jdk proxy: after");

                    return value;
                });
    }
}
