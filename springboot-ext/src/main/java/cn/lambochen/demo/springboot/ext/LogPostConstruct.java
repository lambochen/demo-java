package cn.lambochen.demo.springboot.ext;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author lambochen
 *
 * 时机: 初始化完成之后调用(@PostConstruct)所在的方法；
 */
@Component
public class LogPostConstruct {

    @PostConstruct
    public void init() {
        System.out.println("### @PostConstruct ");
    }

}
