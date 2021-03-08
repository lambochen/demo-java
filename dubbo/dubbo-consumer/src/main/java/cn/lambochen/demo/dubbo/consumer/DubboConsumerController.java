package cn.lambochen.demo.dubbo.consumer;

import cn.lambochen.demo.dubbo.service.client.DubboService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lambo.chen
 * @date 2021/3/8
 **/
@RestController
public class DubboConsumerController {

    @Reference
    private DubboService dubboService;

    @GetMapping("/hello")
    public String hello(String name) {
        return dubboService.hello(name);
    }

}
