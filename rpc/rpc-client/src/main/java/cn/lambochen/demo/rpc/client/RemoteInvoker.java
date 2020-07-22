package cn.lambochen.demo.rpc.client;

import cn.lambochen.demo.rpc.codec.Decoder;
import cn.lambochen.demo.rpc.codec.Encoder;
import cn.lambochen.demo.rpc.proto.Request;
import cn.lambochen.demo.rpc.proto.Response;
import cn.lambochen.demo.rpc.proto.ServiceDescriptor;
import cn.lambochen.demo.rpc.transport.TransportClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/7/22 1:12
 * @Description 调用远程服务的代理类
 **/
@Slf4j
public class RemoteInvoker implements InvocationHandler {

    private Class clazz;
    private RpcClientConfig config;
    private Encoder encoder;
    private Decoder decoder;
    private TransportSelector selector;

    RemoteInvoker(Class clazz, Encoder encoder, Decoder decoder, TransportSelector selector) {
        this.clazz = clazz;
        this.encoder = encoder;
        this.decoder = decoder;
        this.selector = selector;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Request request = new Request();
        request.setService(ServiceDescriptor.from(clazz, method));
        request.setParameters(args);

        Response response = invokeRemote(request);
        if (response == null || response.getCode() != 0) {
            throw new IllegalStateException("fail to invoke remote: " + request);
        }
        return response.getData();
    }

    private Response invokeRemote(Request request) {
        TransportClient client = null;
        Response response = null;
        try {
            try {
                client = selector.select();

                byte[] outBytes = encoder.encode(request);
                InputStream receive = client.write(new ByteArrayInputStream(outBytes));

                byte[] inBytes = IOUtils.readFully(receive, receive.available());
                response = decoder.decoder(inBytes, Response.class);
            } catch (IOException e) {
                log.warn(e.getMessage(), e);

                response = new Response();
                response.setCode(1);
                response.setMessage("RpcClient got error:" + e.getClass() + " : " + e.getMessage());
            }
        } finally {
            if (client != null) {
                selector.release(client);
            }
        }
        return response;
    }
}
