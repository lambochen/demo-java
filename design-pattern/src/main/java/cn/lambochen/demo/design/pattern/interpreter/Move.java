package cn.lambochen.demo.design.pattern.interpreter;

/**
 * @author lambochen
 * @date 2022-04-09 20:34
 *
 * 鼠标移动表达式
 */
public class Move implements Expression {

    private int x, y;

    public Move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void interpret() {
        System.out.println("移动鼠标 x,y = " + x + "," + y);
    }
}
