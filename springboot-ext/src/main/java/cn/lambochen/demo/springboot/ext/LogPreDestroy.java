package cn.lambochen.demo.springboot.ext;

import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

/**
 * @author lambochen
 *
 * 时机: 销毁之前调用(@PreDestroy)所在的方法
 */
@Component
public class LogPreDestroy {

    @PreDestroy
    public void destroy() {
        System.out.println("### @PreDestroy");
    }
}
