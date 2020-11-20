package cn.lambochen.demo.simple.proxy.staticproxy;

/**
 * @author lambo.chen
 * @date 2020/11/20
 * <p>
 * 目标对象
 **/
public class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("目标对象：保存数据");
    }
}
