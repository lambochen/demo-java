package cn.lambochen.demo.springboot.ext;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author lambochen
 *
 * 时机 : spring 容器还没被刷新之前准备阶段 this.prepareContext(context, environment, listeners, applicationArguments, printedBanner);
 * 此时所有的配置文件都已经加载
 *
 * 这时候spring容器还没被初始化，所以想要自己的扩展的生效，有以下三种方式：
 * 在启动类中用springApplication.addInitializers(new TestApplicationContextInitializer())语句加入
 * 配置文件配置context.initializer.classes=com.example.demo.TestApplicationContextInitializer
 * Spring SPI扩展，在spring.factories中加入org.springframework.context.ApplicationContextInitializer=com.example.demo.TestApplicationContextInitializer
 */
public class LogApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("### ApplicationContextInitializer<ConfigurableApplicationContext>");
    }
}
