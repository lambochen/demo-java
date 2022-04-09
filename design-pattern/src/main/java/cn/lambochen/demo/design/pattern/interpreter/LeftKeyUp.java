package cn.lambochen.demo.design.pattern.interpreter;

/**
 * @author lambochen
 * @date 2022-04-09 20:36
 */
public class LeftKeyUp implements Expression{
    @Override
    public void interpret() {
        System.out.println("松开鼠标左键");
    }
}
