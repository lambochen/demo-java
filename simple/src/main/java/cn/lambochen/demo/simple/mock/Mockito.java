package cn.lambochen.demo.simple.mock;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lambo.chen
 * @date 2020/11/27
 **/
public class Mockito {

    private static Map<Invocation, Object> results = new HashMap<Invocation, Object>();
    private static Invocation lastInvocation;

    /**
     * 根据 Class 创建该类对象的代理对象
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T mock(Class<T> clazz) {
        Enhancer enhancer = new Enhancer();
        // 设置父类
        enhancer.setSuperclass(clazz);
        // 设置回调函数，此处是实现 mock 关键
        enhancer.setCallback(new MockInterceptor());
        return (T) enhancer.create();
    }

    public static <T> When<T> when(T o) {
        return new When<T>();
    }

    public static class When<T> {
        public void thenReturn(T retObj) {
            results.put(lastInvocation, retObj);
        }
    }

    private static class MockInterceptor implements MethodInterceptor {

        @Override
        public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
            Invocation invocation = new Invocation(methodProxy, method, args, methodProxy);
            lastInvocation = invocation;
            if (results.containsKey(invocation)) {
                return results.get(invocation);
            }
            return null;
        }

    }
}
