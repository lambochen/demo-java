package cn.lambochen.demo.springboot.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author lambochen
 * <p>
 * 时机: refresh() 的 this.invokeBeanFactoryPostProcessors(beanFactory);
 * 此时此 BeanDefinition 都已经加载完毕 但是还没到实例化以及初始化阶段
 */
@Component
public class LogBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        System.out.println("### BeanDefinitionRegistryPostProcessor.postProcessBeanDefinitionRegistry");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("### BeanDefinitionRegistryPostProcessor.postProcessBeanFactory");
    }
}
