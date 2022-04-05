package cn.lambochen.demo.design.pattern.memento;

/**
 * @author lambochen
 * @date 2022-04-05 22:54
 */
public class History {

    private String data;

    public History(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
