package cn.lambochen.demo.rpc.proto;

import java.util.Arrays;
import java.util.Objects;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/7/21 23:03
 * @Description RPC 的一个请求
 **/
public class Request {

    /**
     * 请求的服务
     */
    private ServiceDescriptor service;

    /**
     * 参数
     */
    private Object[] parameters;

    public Request() {
    }

    public Request(ServiceDescriptor service, Object[] parameters) {
        this.service = service;
        this.parameters = parameters;
    }

    public ServiceDescriptor getService() {
        return service;
    }

    public void setService(ServiceDescriptor service) {
        this.service = service;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "Request{" +
                "service=" + service +
                ", parameters=" + Arrays.toString(parameters) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Request)) return false;
        Request request = (Request) o;
        return Objects.equals(getService(), request.getService()) &&
                Arrays.equals(getParameters(), request.getParameters());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getService());
        result = 31 * result + Arrays.hashCode(getParameters());
        return result;
    }
}
