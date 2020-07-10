package cn.lambochen.demo.dataway.springboot;

import net.hasor.spring.boot.EnableHasor;
import net.hasor.spring.boot.EnableHasorWeb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableHasor
@EnableHasorWeb
@SpringBootApplication(scanBasePackages = "com.lambochen.demo.dataway.springboot")
public class DatawaySpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatawaySpringbootApplication.class, args);
    }

}
