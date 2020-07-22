package cn.lambochen.demo.rpc.server;

import cn.lambochen.demo.rpc.common.utils.ReflectionUtils;
import cn.lambochen.demo.rpc.proto.Request;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/7/22 0:42
 * @Description 调用具体服务
 **/
public class ServiceInvoker {

    public Object invoke(ServiceInstance service, Request request) {
        return ReflectionUtils.invoke(service.getTarget(), service.getMethod(), request.getParameters());
    }
}
