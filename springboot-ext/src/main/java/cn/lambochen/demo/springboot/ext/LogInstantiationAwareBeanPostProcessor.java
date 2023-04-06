package cn.lambochen.demo.springboot.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;

/**
 * @author lambochen
 *
 * InstantiationAwareBeanPostProcessor接口的主要作用在于目标对象的实例化过程中需要处理的事情，包括实例化对象的前后过程以及实例的属性设置
 *
 * postProcessBeforeInstantiation (InstantiationAwareBeanPostProcessor自己的) 方法是最先执行的方法，
 * 它在目标对象实例化之前调用，该方法的返回值类型是Object，我们可以返回任何类型的值。由于这个时候目标对象还未实例化，
 * 所以这个返回值可以用来代替原本该生成的目标对象的实例(比如代理对象)。如果该方法的返回值代替原本该生成的目标对象，
 * 后续只有postProcessAfterInitialization方法会调用，其它方法不再调用；否则按照正常的流程走
 *
 * postProcessAfterInstantiation (InstantiationAwareBeanPostProcessor自己的) 方法在目标对象实例化之后调用，
 * 这个时候对象已经被实例化，但是该实例的属性还未被设置，都是null。
 * 如果该方法返回false，会忽略属性值的设置；如果返回true，会按照正常流程设置属性值
 *
 * postProcessPropertyValues(我这个springboot版本(2.1.x)已经被 postProcessProperties替换)
 * (InstantiationAwareBeanPostProcessor自己的) 方法对属性值进行修改(这个时候属性值还未被设置，
 * 但是我们可以修改原本该设置进去的属性值)。如果postProcessProperties方法返回false，该方法不会被调用。可以在该方法内对属性值进行修改
 *
 * 父接口BeanPostProcessor的2个方法postProcessBeforeInitialization和postProcessAfterInitialization是在对象被实例化之后
 * (一个是在初始化之前，一个是在初始化之后调用)
 *
 * Instantiation表示实例化，Initialization表示初始化。实例化前的意思在对象还未生成，初始化前的意思在对象已经生成，但是属性还没有赋值阶段
 */
@Component
public class LogInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("### InstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation ");
        return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInstantiation(beanClass, beanName);
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println("### InstantiationAwareBeanPostProcessor.postProcessAfterInstantiation ");
        return InstantiationAwareBeanPostProcessor.super.postProcessAfterInstantiation(bean, beanName);
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        System.out.println("### InstantiationAwareBeanPostProcessor.postProcessProperties ");
        return InstantiationAwareBeanPostProcessor.super.postProcessProperties(pvs, bean, beanName);
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        System.out.println("### InstantiationAwareBeanPostProcessor.postProcessPropertyValues ");
        return InstantiationAwareBeanPostProcessor.super.postProcessPropertyValues(pvs, pds, bean, beanName);
    }
}
