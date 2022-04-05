package cn.lambochen.demo.design.pattern.mediator;

/**
 * @author lambochen
 * @date 2022-04-05 23:19
 */
public class PublicChatRoom extends ChatRoom {

    @Override
    protected void sendMsg(User from, User to, String msg) {
        if (null == to) {
            users.forEach(user -> user.listen(from, null, msg));
            return;
        }

        users.stream().filter(user -> user.equals(to)).forEach(user -> user.listen(from, to, msg));
    }

    @Override
    protected String processMsg(User from, User to, String msg) {
        String toName = "所有人";
        if (null != to) {
            toName = to.getName();
        }

        return from.getName() + " to " + toName + ":" + msg;
    }
}
