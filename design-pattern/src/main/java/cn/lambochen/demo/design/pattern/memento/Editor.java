package cn.lambochen.demo.design.pattern.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lambochen
 * @date 2022-04-05 22:56
 */
public class Editor {

    private Doc doc;
    private List<History> histories;
    private int historyPosition = -1; // 历史记录当前位置

    public Editor(Doc doc) {
        this.doc = doc;
        this.histories = new ArrayList<>();

        backup();
        show();
    }

    private void show() {
        System.out.println(doc.getBody());
    }

    private void backup() {
        histories.add(doc.createHistory());
        historyPosition++;
    }

    public void undo() {
        if (historyPosition == 0) {
            return;
        }

        historyPosition--;
        History history = histories.get(historyPosition);
        doc.restoreHistory(history);
        show();
    }

    public void redo() {
        // todo
    }

    public void append(String txt) {
        doc.setBody(doc.getBody() + txt);

        backup();
        show();
    }

    public void save() {
        // todo
    }

    public void delete() {
        doc.setBody("");

        backup();
        show();
    }
}
