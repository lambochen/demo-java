package cn.lambochen.demo.springboot.ext;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

/**
 * @author lambochen
 * <p>
 * 时机: bean实例化之后,初始化之前
 */
@Component
public class LogBeanNameAware implements BeanNameAware {
    @Override
    public void setBeanName(String s) {
        System.out.println("### BeanNameAware.setBeanName");
    }
}
