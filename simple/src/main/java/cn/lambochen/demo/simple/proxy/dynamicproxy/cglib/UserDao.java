package cn.lambochen.demo.simple.proxy.dynamicproxy.cglib;

/**
 * @author lambo.chen
 * @date 2020/11/20
 * <p>
 * 目标对象
 **/
public class UserDao {

    public void save() {
        System.out.println("目标对象");
    }
}
