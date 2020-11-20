package cn.lambochen.demo.simple.proxy.dynamicproxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author lambo.chen
 * @date 2020/11/20
 * <p>
 * 代理对象工厂
 **/
public class CglibProxyFactory implements MethodInterceptor {

    /**
     * 目标对象
     */
    private Object target;

    public CglibProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * 为目标对象生成代理对象
     *
     * @return
     */
    public Object getProxyInstance() {
        Enhancer enhancer = new Enhancer();

        // 设置超类
        enhancer.setSuperclass(target.getClass());

        // 设置回调函数
        enhancer.setCallback(this);

        // 创建子类对象代理
        return enhancer.create();
    }

    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglid proxy: pre");

        // 执行目标对象的方法
        Object value = method.invoke(target, args);

        System.out.println("cglib proxy: after");

        return value;
    }
}
