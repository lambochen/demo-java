package cn.lambochen.demo.simple.proxy.staticproxy;

/**
 * @author lambo.chen
 * @date 2020/11/20
 * <p>
 * 静态代理对象
 **/
public class UserDaoProxy implements IUserDao {

    /**
     * 目标对象
     */
    private IUserDao target;

    /**
     * 构造静态代理对象
     *
     * @param target
     */
    public UserDaoProxy(IUserDao target) {
        this.target = target;
    }

    @Override
    public void save() {
        System.out.println("proxy: pre");
        target.save();
        System.out.println("proxy: after");
    }
}
