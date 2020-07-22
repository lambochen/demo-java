package cn.lambochen.demo.rpc.client;

import cn.lambochen.demo.rpc.codec.Decoder;
import cn.lambochen.demo.rpc.codec.Encoder;
import cn.lambochen.demo.rpc.common.utils.ReflectionUtils;

import java.lang.reflect.Proxy;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/7/22 1:08
 * @Description TODO
 **/
public class RpcClient {

    private RpcClientConfig config;
    private Encoder encoder;
    private Decoder decoder;
    private TransportSelector selector;

    public RpcClient() {
        this(new RpcClientConfig());
    }

    public RpcClient(RpcClientConfig config) {
        this.config = config;

        this.encoder = ReflectionUtils.newInstance(config.getEncoderClass());
        this.decoder = ReflectionUtils.newInstance(config.getDecoderClass());
        this.selector = ReflectionUtils.newInstance(config.getSelectorClass());

        this.selector.init(config.getServers(), config.getConnectCount(), config.getTransportClass());
    }

    public <T> T getProxy(Class<T> clazz) {
        return (T) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{clazz}, new RemoteInvoker(clazz, encoder, decoder, selector));
    }
}
