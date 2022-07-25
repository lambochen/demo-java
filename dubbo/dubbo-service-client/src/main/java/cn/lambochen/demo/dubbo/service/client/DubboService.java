package cn.lambochen.demo.dubbo.service.client;

import java.util.concurrent.CompletableFuture;

/**
 * @author lambo.chen
 * @date 2021/3/8
 **/
public interface DubboService {

    String hello(String name);

    default CompletableFuture<String> helloAsync(String name) {
        return CompletableFuture.completedFuture(hello(name));
    }

}
