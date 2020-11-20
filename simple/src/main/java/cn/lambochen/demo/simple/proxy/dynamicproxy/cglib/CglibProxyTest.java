package cn.lambochen.demo.simple.proxy.dynamicproxy.cglib;

/**
 * @author lambo.chen
 * @date 2020/11/20
 **/
public class CglibProxyTest {

    public static void main(String[] args) {
        // 目标对象
        UserDao target = new UserDao();

        System.out.println(target.getClass());

        // 代理对象
        UserDao proxy = (UserDao) new CglibProxyFactory(target).getProxyInstance();

        System.out.println(proxy.getClass());

        // 执行代理对象方法
        proxy.save();
    }
}
