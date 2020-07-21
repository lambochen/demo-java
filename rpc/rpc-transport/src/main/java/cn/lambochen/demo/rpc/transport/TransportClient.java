package cn.lambochen.demo.rpc.transport;

import cn.lambochen.demo.rpc.proto.Peer;

import java.io.InputStream;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/7/21 23:28
 * @Description 客户端
 * <p>
 * 1. 创建链接
 * 2. 发送数据，并且等待响应
 * 3. 关闭连接
 **/
public interface TransportClient {

    /**
     * 创建连接
     *
     * @param peer 网络端点
     */
    void connect(Peer peer);

    /**
     * 写数据
     *
     * @param data 传输数据
     * @return
     */
    InputStream write(InputStream data);

    /**
     * 关闭连接
     */
    void close();
}
