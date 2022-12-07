package cn.lambochen.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        placeholder(context);
    }

    static void placeholder(ConfigurableApplicationContext context) {
        Environment environment = context.getEnvironment();
        String prefixxxx = environment.resolvePlaceholders("${placeholder.prefix}xxx");
        System.out.println(prefixxxx);
    }

}
