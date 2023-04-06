package cn.lambochen.demo.springboot.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author lambochen
 *
 * 时机: refresh() 的 this.invokeBeanFactoryPostProcessors(beanFactory);
 * 此时此 BeanDefinition 都已经加载完毕 但是还没到实例化以及初始化阶段
 */
@Component
public class LogBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("### BeanFactoryPostProcessor.postProcessBeanFactory");
    }
}
