package cn.lambochen.demo.springboot.ext;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author lambochen
 *
 * 时机: bean 实例化并属性赋值之后他其实与 BeanPostProcessor 的关系 是 postProcessBeforeInitialization -> initializingBean -> postProcessAfterInitialization
 * 注意: afterPropertiesSet 发生作用的时机是当前类的实例化的时候，而 BeanPostProcessor 则是所有类，这也是为什么 afterPropertiesSet 的函数中没有参数
 */
@Component
public class LogInitializingBean implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("### InitializingBean.afterPropertiesSet");
    }
}
