package cn.lambochen.demo.dubbo.provider;

import cn.lambochen.demo.dubbo.service.client.DubboService;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * @author lambo.chen
 * @date 2021/3/8
 **/
@Service
public class DubboServiceImpl implements DubboService {
    @Override
    public String hello(String name) {
        return "Dubbo Service Provider: hello {" + name + "}";
    }
}
