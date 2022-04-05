package cn.lambochen.demo.design.pattern.bridge;

/**
 * @author lambochen
 * @date 2022-04-05 17:41
 * <p>
 * 黑色画笔
 */
public class BlackPen extends Pen {

    public BlackPen(Ruler ruler) {
        super(ruler);
    }

    @Override
    public void draw() {
        System.out.print("black-");
        ruler.regularize();
    }
}
