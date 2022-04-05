package cn.lambochen.demo.design.pattern.bridge;

/**
 * @author lambochen
 * @date 2022-04-05 17:40
 *
 * 画笔
 */
public abstract class Pen {

    // 尺子的引用
    protected Ruler ruler;

    public abstract void draw();

    public Pen(Ruler ruler) {
        this.ruler = ruler;
    }
}
