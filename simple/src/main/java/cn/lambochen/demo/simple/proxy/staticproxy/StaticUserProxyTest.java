package cn.lambochen.demo.simple.proxy.staticproxy;

/**
 * @author lambo.chen
 * @date 2020/11/20
 **/
public class StaticUserProxyTest {

    public void test() {
        // 目标对象
        IUserDao target = new UserDao();
        // 代理对象
        UserDaoProxy proxy = new UserDaoProxy(target);

        proxy.save();
    }
}
