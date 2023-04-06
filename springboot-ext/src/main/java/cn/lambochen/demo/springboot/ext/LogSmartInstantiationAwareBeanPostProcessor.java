package cn.lambochen.demo.springboot.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;

/**
 * @author lambochen
 *
 * SmartInstantiationAwareBeanPostProcessor接口的主要作用也是在于目标对象的实例化过程中需要处理的事情。
 * 它是InstantiationAwareBeanPostProcessor接口的一个扩展。主要在Spring框架内部使用
 *
 * predictBeanType方法用于预测Bean的类型，返回第一个预测成功的Class类型，如果不能预测返回null。
 * 主要在于BeanDefinition无法确定Bean类型的时候调用该方法来确定类型
 *
 * determineCandidateConstructors方法用于选择合适的构造器，比如类有多个构造器，可以实现这个方法选择合适的构造器并用于实例化对象。
 * 该方法在postProcessBeforeInstantiation方法和postProcessAfterInstantiation方法之间调用，
 * 如果postProcessBeforeInstantiation方法返回了一个新的实例代替了原本该生成的实例，那么该方法会被忽略
 *
 * getEarlyBeanReference主要用于解决 循环依赖 问题。比如ReferenceA实例内部有ReferenceB的引用，
 * ReferenceB实例内部有ReferenceA的引用。首先先实例化ReferenceA，实例化完成之后提前把这个bean暴露在ObjectFactory中，
 * 然后populate属性，这个时候发现需要ReferenceB。然后去实例化ReferenceB，在实例化ReferenceB的时候它需要ReferenceA的实例才能继续，
 * 这个时候就会去ObjectFactory中找出了ReferenceA实例，ReferenceB顺利实例化。ReferenceB实例化之后，
 * ReferenceA的populate属性过程也成功完成，注入了ReferenceB实例。提前把这个bean暴露在ObjectFactory中，
 * 这个ObjectFactory获取的实例就是通过getEarlyBeanReference方法得到的
 *
 */
@Component
public class LogSmartInstantiationAwareBeanPostProcessor implements SmartInstantiationAwareBeanPostProcessor {
    @Override
    public Class<?> predictBeanType(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("### SmartInstantiationAwareBeanPostProcessor.predictBeanType ");
        return SmartInstantiationAwareBeanPostProcessor.super.predictBeanType(beanClass, beanName);
    }

    @Override
    public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("### SmartInstantiationAwareBeanPostProcessor.determineCandidateConstructors ");
        return SmartInstantiationAwareBeanPostProcessor.super.determineCandidateConstructors(beanClass, beanName);
    }

    @Override
    public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
        System.out.println("### SmartInstantiationAwareBeanPostProcessor.getEarlyBeanReference ");
        return SmartInstantiationAwareBeanPostProcessor.super.getEarlyBeanReference(bean, beanName);
    }
}
