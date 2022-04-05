package cn.lambochen.demo.design.pattern.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lambochen
 * @date 2022-04-05 23:14
 */
public abstract class ChatRoom {

    protected List<User> users = new ArrayList<>();

    protected void register(User user) {
        this.users.add(user);
    }

    protected void deregister(User user) {
        this.users.remove(user);
    }

    protected abstract void sendMsg(User from, User to, String msg);
    protected abstract String processMsg(User from, User to, String msg);
}
