package cn.lambochen.demo.design.pattern.mediator;

/**
 * @author lambochen
 * @date 2022-04-05 23:22
 */
public class PrivateChatRoom extends ChatRoom {

    @Override
    protected synchronized void register(User user) {
        if (users.size() == 2) {
            return;
        }

        super.register(user);

        // todo
    }

    @Override
    protected void sendMsg(User from, User to, String msg) {
        users.forEach(user -> user.listen(from, null, msg));
    }

    @Override
    protected String processMsg(User from, User to, String msg) {
        // todo
        return null;
    }
}
