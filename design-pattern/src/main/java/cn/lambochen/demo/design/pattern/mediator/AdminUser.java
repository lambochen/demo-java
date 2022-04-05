package cn.lambochen.demo.design.pattern.mediator;

/**
 * @author lambochen
 * @date 2022-04-05 23:23
 */
public class AdminUser extends User {

    public AdminUser(String name) {
        super(name);
    }

    public void kick(User user) {
        user.logout();
    }
}
