package cn.lambochen.demo.simple.proxy.dynamicproxy.jdk;

/**
 * @author lambo.chen
 * @date 2020/11/20
 **/
public class JdkDynamicProxyTest {

    public static void main(String[] args) {
        IUserDao target = new UserDao();

        // 输出目标对象信息
        System.out.println(target.getClass());

        IUserDao proxy = (IUserDao) new JdkProxyFactory(target).getProxyInstance();

        // 输出代理对象信息
        System.out.println(proxy.getClass());

        proxy.save();
    }
}
