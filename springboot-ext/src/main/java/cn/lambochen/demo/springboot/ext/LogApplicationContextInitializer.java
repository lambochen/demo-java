package cn.lambochen.demo.springboot.ext;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author lambochen
 *
 * 时机 : spring 容器还没被刷新之前准备阶段 this.prepareContext(context, environment, listeners, applicationArguments, printedBanner);
 * 此时所有的配置文件都已经加载
 */
public class LogApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("### ApplicationContextInitializer<ConfigurableApplicationContext>");
    }
}
