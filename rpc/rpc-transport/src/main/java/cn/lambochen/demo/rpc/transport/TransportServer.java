package cn.lambochen.demo.rpc.transport;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/7/21 23:30
 * @Description 服务端
 *
 * 1. 启动，监听端口
 * 2. 接受请求
 * 3. 关闭监听
 **/
public interface TransportServer {

    void init(int port, RequestHandler handler);

    /**
     * 启动服务器
     */
    void start();

    /**
     * 关闭
     */
    void stop();
}
