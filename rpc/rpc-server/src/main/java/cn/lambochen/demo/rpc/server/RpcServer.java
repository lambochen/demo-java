package cn.lambochen.demo.rpc.server;

import cn.lambochen.demo.rpc.codec.Decoder;
import cn.lambochen.demo.rpc.codec.Encoder;
import cn.lambochen.demo.rpc.common.utils.ReflectionUtils;
import cn.lambochen.demo.rpc.proto.Request;
import cn.lambochen.demo.rpc.proto.Response;
import cn.lambochen.demo.rpc.transport.RequestHandler;
import cn.lambochen.demo.rpc.transport.TransportServer;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/7/22 0:44
 * @Description RPC Server
 **/
@Slf4j
public class RpcServer {
    private RpcServerConfig config;

    private TransportServer net;
    private Encoder encoder;
    private Decoder decoder;
    private ServiceManager serviceManager;
    private ServiceInvoker serviceInvoker;

    private RequestHandler handler = new RequestHandler() {
        @Override
        public void onRequest(InputStream receive, OutputStream toResponse) {
            Response response = new Response();
            try {
                byte[] inBytes = IOUtils.readFully(receive, receive.available());
                Request request = decoder.decoder(inBytes, Request.class);
                log.info("get request: {}", request);

                ServiceInstance service = serviceManager.lookup(request);
                Object ret = serviceInvoker.invoke(service, request);

                response.setData(ret);
            } catch (IOException e) {
                log.warn(e.getMessage(), e);

                response.setCode(1);
                response.setMessage(e.getMessage());
            } finally {
                byte[] outBytes = encoder.encode(response);
                try {
                    toResponse.write(outBytes);
                } catch (IOException e) {
                    log.warn(e.getMessage(), e);
                }
            }
        }
    };

    public RpcServer() {
        this(new RpcServerConfig());
    }

    public RpcServer(RpcServerConfig config) {
        this.config = config;

        // net
        this.net = ReflectionUtils.newInstance(config.getTransportClass());
        this.net.init(config.getPort(), handler);

        // codec
        this.encoder = ReflectionUtils.newInstance(config.getEncoderClass());
        this.decoder = ReflectionUtils.newInstance(config.getDecoderClass());

        // service
        this.serviceManager = new ServiceManager();
        this.serviceInvoker = new ServiceInvoker();
    }

    public <T> void register(Class<T> interfaceClass, T bean) {
        serviceManager.register(interfaceClass, bean);
    }

    public void start() {
        this.net.start();
    }

    public void stop() {
        this.net.stop();
    }
}
