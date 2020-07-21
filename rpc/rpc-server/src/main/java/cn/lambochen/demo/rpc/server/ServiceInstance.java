package cn.lambochen.demo.rpc.server;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/7/22 0:06
 * @Description 表示一个具体服务
 **/
public class ServiceInstance {

    /**
     * 服务由什么对象提供
     */
    private Object target;

    /**
     * 服务方法
     */
    private Method method;

    public ServiceInstance() {
    }

    public ServiceInstance(Object target, Method method) {
        this.target = target;
        this.method = method;
    }

    @Override
    public String toString() {
        return "ServiceInstance{" +
                "target=" + target +
                ", method=" + method +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServiceInstance)) return false;
        ServiceInstance instance = (ServiceInstance) o;
        return Objects.equals(getTarget(), instance.getTarget()) &&
                Objects.equals(getMethod(), instance.getMethod());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTarget(), getMethod());
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }
}
