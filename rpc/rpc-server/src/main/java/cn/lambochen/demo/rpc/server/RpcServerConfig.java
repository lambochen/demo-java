package cn.lambochen.demo.rpc.server;

import cn.lambochen.demo.rpc.codec.Decoder;
import cn.lambochen.demo.rpc.codec.Encoder;
import cn.lambochen.demo.rpc.codec.json.JsonDecoder;
import cn.lambochen.demo.rpc.codec.json.JsonEncoder;
import cn.lambochen.demo.rpc.transport.TransportServer;
import cn.lambochen.demo.rpc.transport.http.HttpTransportServer;

import java.util.Objects;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/7/21 23:58
 * @Description RPC Server 配置
 **/
public class RpcServerConfig {

    /**
     * 服务端网络类
     */
    private Class<? extends TransportServer> transportClass = HttpTransportServer.class;
    /**
     * 序列化类
     */
    private Class<? extends Encoder> encoderClass = JsonEncoder.class;
    /**
     * 反序列化类
     */
    private Class<? extends Decoder> decoderClass = JsonDecoder.class;
    /**
     * 监听端口
     */
    private int port = 8888;

    public RpcServerConfig() {
    }

    public RpcServerConfig(Class<? extends TransportServer> transportClass, Class<? extends Encoder> encoderClass, Class<? extends Decoder> decoderClass, int port) {
        this.transportClass = transportClass;
        this.encoderClass = encoderClass;
        this.decoderClass = decoderClass;
        this.port = port;
    }

    @Override
    public String toString() {
        return "RpcServerConfig{" +
                "transportClass=" + transportClass +
                ", encoderClass=" + encoderClass +
                ", decoderClass=" + decoderClass +
                ", port=" + port +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RpcServerConfig)) return false;
        RpcServerConfig that = (RpcServerConfig) o;
        return getPort() == that.getPort() &&
                Objects.equals(getTransportClass(), that.getTransportClass()) &&
                Objects.equals(getEncoderClass(), that.getEncoderClass()) &&
                Objects.equals(getDecoderClass(), that.getDecoderClass());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTransportClass(), getEncoderClass(), getDecoderClass(), getPort());
    }

    public Class<? extends TransportServer> getTransportClass() {
        return transportClass;
    }

    public void setTransportClass(Class<? extends TransportServer> transportClass) {
        this.transportClass = transportClass;
    }

    public Class<? extends Encoder> getEncoderClass() {
        return encoderClass;
    }

    public void setEncoderClass(Class<? extends Encoder> encoderClass) {
        this.encoderClass = encoderClass;
    }

    public Class<? extends Decoder> getDecoderClass() {
        return decoderClass;
    }

    public void setDecoderClass(Class<? extends Decoder> decoderClass) {
        this.decoderClass = decoderClass;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
