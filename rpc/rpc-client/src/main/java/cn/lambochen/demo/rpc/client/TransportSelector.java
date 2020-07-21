package cn.lambochen.demo.rpc.client;

import cn.lambochen.demo.rpc.proto.Peer;
import cn.lambochen.demo.rpc.transport.TransportClient;

import java.util.List;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/7/22 0:55
 * @Description 表示选择哪个 server 去连接
 **/
public interface TransportSelector {

    /**
     * 初始化 selector
     *
     * @param peers 可以连接 server 端点信息
     * @param count client 与 server 建立多少个连接
     * @param clazz client 实现
     */
    void init(List<Peer> peers, int count, Class<? extends TransportClient> clazz);

    /**
     * 选择一个 transport 与 server 做交互
     *
     * @return
     */
    TransportClient select();

    /**
     * 释放用完的 client
     *
     * @param client
     */
    void release(TransportClient client);

    void close();

}
