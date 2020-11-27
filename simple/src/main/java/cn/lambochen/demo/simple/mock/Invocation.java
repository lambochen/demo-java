package cn.lambochen.demo.simple.mock;

import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author lambo.chen
 * @date 2020/11/27
 **/
public class Invocation {

    private final Object mock;
    private final Method method;
    private final Object[] arguments;
    private final MethodProxy proxy;

    public Invocation(Object mock, Method method, Object[] arguments, MethodProxy proxy) {
        this.mock = mock;
        this.method = method;
        this.arguments = copyArgs(arguments);
        this.proxy = proxy;
    }

    private Object[] copyArgs(Object[] args) {
        Object[] newArgs = new Object[args.length];
        System.arraycopy(args, 0, newArgs, 0, args.length);
        return newArgs;
    }

    /**
     * 重点在于 equals, hashCode 的重写，需要保证 map key 能够 match
     * <p>
     * 此处仅作简单演示
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !obj.getClass().equals(this.getClass())) {
            return false;
        }
        Invocation other = (Invocation) obj;
        return this.method.getName().equals(other.method.getName())
                && this.proxy.getSignature().getName().equals((other).proxy.getSignature().getName())
                && Arrays.deepEquals(arguments, other.arguments);
    }

    @Override
    public int hashCode() {
        return 1;
    }

    public Object getMock() {
        return mock;
    }

    public Method getMethod() {
        return method;
    }

    public Object[] getArguments() {
        return arguments;
    }

    public MethodProxy getProxy() {
        return proxy;
    }
}
