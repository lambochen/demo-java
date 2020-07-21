package cn.lambochen.demo.rpc.client;

import cn.lambochen.demo.rpc.codec.Decoder;
import cn.lambochen.demo.rpc.codec.Encoder;
import cn.lambochen.demo.rpc.codec.json.JsonDecoder;
import cn.lambochen.demo.rpc.codec.json.JsonEncoder;
import cn.lambochen.demo.rpc.proto.Peer;
import cn.lambochen.demo.rpc.transport.TransportClient;
import cn.lambochen.demo.rpc.transport.http.HttpTransportClient;

import java.util.Arrays;
import java.util.List;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/7/22 1:05
 * @Description TODO
 **/
public class RpcClientConfig {

    private Class<? extends TransportClient> transportClass = HttpTransportClient.class;
    private Class<? extends Encoder> encoderClass = JsonEncoder.class;
    private Class<? extends Decoder> decoderClass = JsonDecoder.class;
    private Class<? extends TransportSelector> selectorClass = RandomTransportSelector.class;
    private int connectCount = 1;
    private List<Peer> servers = Arrays.asList(new Peer("127.0.0.1", 8888));

    public RpcClientConfig() {
    }

    public Class<? extends TransportClient> getTransportClass() {
        return transportClass;
    }

    public void setTransportClass(Class<? extends TransportClient> transportClass) {
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

    public Class<? extends TransportSelector> getSelectorClass() {
        return selectorClass;
    }

    public void setSelectorClass(Class<? extends TransportSelector> selectorClass) {
        this.selectorClass = selectorClass;
    }

    public int getConnectCount() {
        return connectCount;
    }

    public void setConnectCount(int connectCount) {
        this.connectCount = connectCount;
    }

    public List<Peer> getServers() {
        return servers;
    }

    public void setServers(List<Peer> servers) {
        this.servers = servers;
    }
}
