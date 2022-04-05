package cn.lambochen.demo.design.pattern.mediator;

/**
 * @author lambochen
 * @date 2022-04-05 23:14
 */
public class User {

    private String name;
    protected ChatRoom chatRoom;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    protected void login(ChatRoom chatRoom) {
        chatRoom.register(this);
        this.chatRoom = chatRoom;
    }
    protected void logout() {
        this.chatRoom.deregister(this);
        this.chatRoom = null;
    }

    protected void talk(User to, String msg) {
        if (null == chatRoom) {
            return;
        }

        chatRoom.sendMsg(this, to, msg);
    }

    public void listen(User from, User to, String msg) {
        // todo
    }
}
