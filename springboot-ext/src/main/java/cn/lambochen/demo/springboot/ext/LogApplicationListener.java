package cn.lambochen.demo.springboot.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author lambochen
 */
public class LogApplicationListener implements ApplicationListener<ApplicationEvent> {
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("### ApplicationListener.onApplicationEvent ");
    }
}
