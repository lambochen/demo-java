package cn.lambochen.demo.rpc.proto;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/7/21 23:01
 * @Description 表示服务
 **/
public class ServiceDescriptor {

    /**
     * 类、类名
     */
    private String clazz;

    /**
     * 方法名
     */
    private String method;

    /**
     * 返回类型
     */
    private String returnType;

    /**
     * 参数类型
     */
    private String[] parameterTypes;

    public static ServiceDescriptor from(Class clazz, Method method) {
        ServiceDescriptor descriptor = new ServiceDescriptor();

        descriptor.setClazz(clazz.getName());
        descriptor.setMethod(method.getName());
        descriptor.setReturnType(method.getReturnType().getName());

        Class[] parameterClasses = method.getParameterTypes();
        String[] parameterTypes = new String[parameterClasses.length];
        for (int i = 0; i < parameterClasses.length; i++) {
            parameterTypes[i] = parameterClasses[i].getName();
        }
        descriptor.setParameterTypes(parameterTypes);

        return descriptor;
    }

    public ServiceDescriptor() {
    }

    public ServiceDescriptor(String clazz, String method, String returnType, String[] parameterTypes) {
        this.clazz = clazz;
        this.method = method;
        this.returnType = returnType;
        this.parameterTypes = parameterTypes;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public String[] getParameterTypes() {
        return parameterTypes;
    }

    public void setParameterTypes(String[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServiceDescriptor)) return false;
        ServiceDescriptor that = (ServiceDescriptor) o;
        return Objects.equals(getClazz(), that.getClazz()) &&
                Objects.equals(getMethod(), that.getMethod()) &&
                Objects.equals(getReturnType(), that.getReturnType()) &&
                Arrays.equals(getParameterTypes(), that.getParameterTypes());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getClazz(), getMethod(), getReturnType());
        result = 31 * result + Arrays.hashCode(getParameterTypes());
        return result;
    }

    @Override
    public String toString() {
        return "ServiceDescriptor{" +
                "clazz='" + clazz + '\'' +
                ", method='" + method + '\'' +
                ", returnType='" + returnType + '\'' +
                ", parameterTypes=" + Arrays.toString(parameterTypes) +
                '}';
    }
}
