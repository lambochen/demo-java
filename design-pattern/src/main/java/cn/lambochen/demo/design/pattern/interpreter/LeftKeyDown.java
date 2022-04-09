package cn.lambochen.demo.design.pattern.interpreter;

/**
 * @author lambochen
 * @date 2022-04-09 20:35
 */
public class LeftKeyDown implements Expression {
    @Override
    public void interpret() {
        System.out.println("按下鼠标左键");
    }
}
