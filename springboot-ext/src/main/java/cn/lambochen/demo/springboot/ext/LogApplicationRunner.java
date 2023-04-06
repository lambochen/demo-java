package cn.lambochen.demo.springboot.ext;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author lambochen
 *
 * 时机: 容器刷新完成后
 */
@Component
public class LogApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("### ApplicationRunner.run ");
    }
}
