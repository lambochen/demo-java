package cn.lambochen.demo.rpc.example;

import cn.lambochen.demo.rpc.server.RpcServer;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/7/22 1:26
 * @Description TODO
 **/
public class Server {

    public static void main(String[] args) {
        RpcServer server = new RpcServer();
        server.register(CalcService.class, new CalcServiceImpl());
        server.start();
    }
}
