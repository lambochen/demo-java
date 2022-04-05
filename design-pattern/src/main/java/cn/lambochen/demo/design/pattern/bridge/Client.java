package cn.lambochen.demo.design.pattern.bridge;

/**
 * @author lambochen
 * @date 2022-04-05 17:43
 */
public class Client {

    public static void main(String[] args) {
        // 白色画笔
        new WhitePen(new CircleRuler()).draw();
        new WhitePen(new SquareRuler()).draw();
        new WhitePen(new TriangleRuler()).draw();

        // 黑色画笔
        new BlackPen(new CircleRuler()).draw();
        new BlackPen(new SquareRuler()).draw();
        new BlackPen(new TriangleRuler()).draw();
    }
}
