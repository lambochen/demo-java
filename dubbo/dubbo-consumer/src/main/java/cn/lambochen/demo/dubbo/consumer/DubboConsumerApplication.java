package cn.lambochen.demo.dubbo.consumer;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@PropertySource("classpath:/dubbo-consumer.properties")
@EnableDubbo(scanBasePackages = "cn.lambochen.demo.dubbo.consumer")
@SpringBootApplication
public class DubboConsumerApplication {

    /**
     * 启动应用需先启动 zk，
     *      启动zk：zkServer start
     *      连接zk：zkCli
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerApplication.class, args);
    }

}
