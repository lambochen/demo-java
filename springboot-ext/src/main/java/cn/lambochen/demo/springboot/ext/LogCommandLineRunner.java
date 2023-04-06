package cn.lambochen.demo.springboot.ext;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author lambochen
 * <p>
 * 时机: 容器刷新完成后
 */
@Component
public class LogCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("### CommandLineRunner.run ");
    }
}
