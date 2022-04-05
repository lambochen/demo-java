package cn.lambochen.demo.design.pattern.memento;

/**
 * @author lambochen
 * @date 2022-04-05 23:00
 */
public class Client {

    public static void main(String[] args) {
        Editor editor = new Editor(new Doc("<test>"));

        editor.append("xxx");
        editor.delete();
        editor.undo();
    }
}
