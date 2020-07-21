package cn.lambochen.demo.rpc.example;

import cn.lambochen.demo.rpc.client.RpcClient;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/7/22 1:26
 * @Description TODO
 **/
public class Client {
    public static void main(String[] args) {
        RpcClient client = new RpcClient();
        CalcService service = client.getProxy(CalcService.class);

        int r1 = service.add(1,2);
        int r2 = service.minus(3, 1);

        System.out.println(r1);
        System.out.println(r2);
    }

}
