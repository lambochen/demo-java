package cn.lambochen.demo.rpc.server;

import cn.lambochen.demo.rpc.common.utils.ReflectionUtils;
import cn.lambochen.demo.rpc.proto.Request;
import cn.lambochen.demo.rpc.proto.ServiceDescriptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/7/22 0:07
 * @Description 管理 RPC 暴露的服务
 **/
public class ServiceManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceManager.class);

    /**
     * 服务实例
     */
    private Map<ServiceDescriptor, ServiceInstance> services;

    public ServiceManager() {
        services = new ConcurrentHashMap<>();
    }

    /**
     * 注册服务
     *
     * @param interfaceClass 接口类
     * @param bean           接口的实现类
     * @param <T>            类型
     */
    public <T> void register(Class<T> interfaceClass, T bean) {
        Method[] methods = ReflectionUtils.getPublicMethods(interfaceClass);
        for (Method method : methods) {
            ServiceInstance instance = new ServiceInstance(bean, method);
            ServiceDescriptor descriptor = ServiceDescriptor.from(interfaceClass, method);

            services.put(descriptor, instance);
            LOGGER.info("register service: {} {}", descriptor.getClazz(), instance.getMethod());
        }
    }

    /**
     * 查找服务
     * @param request
     * @return
     */
    public ServiceInstance lookup(Request request) {
        ServiceDescriptor descriptor = request.getService();
        return services.get(descriptor);
    }
}
