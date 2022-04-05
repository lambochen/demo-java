package cn.lambochen.demo.design.pattern.memento;

/**
 * @author lambochen
 * @date 2022-04-05 22:55
 */
public class Doc {

    private String title;
    private String body;

    public History createHistory() {
        return new History(body);
    }

    public void restoreHistory(History history) {
        this.body = history.getData();
    }

    public Doc(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
