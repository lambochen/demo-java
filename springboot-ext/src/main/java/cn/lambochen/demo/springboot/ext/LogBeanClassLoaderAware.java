package cn.lambochen.demo.springboot.ext;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.stereotype.Component;

/**
 * @author lambochen
 */
@Component
public class LogBeanClassLoaderAware implements BeanClassLoaderAware {
    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("### BeanClassLoaderAware.setBeanClassLoader ");
    }
}
