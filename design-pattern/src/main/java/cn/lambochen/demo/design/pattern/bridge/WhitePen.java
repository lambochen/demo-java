package cn.lambochen.demo.design.pattern.bridge;

/**
 * @author lambochen
 * @date 2022-04-05 17:41
 * <p>
 * 白色画笔
 */
public class WhitePen extends Pen {

    public WhitePen(Ruler ruler) {
        super(ruler);
    }

    @Override
    public void draw() {
        System.out.print("white-");
        ruler.regularize();
    }
}
