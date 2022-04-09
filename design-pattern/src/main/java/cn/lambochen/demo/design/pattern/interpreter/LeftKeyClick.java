package cn.lambochen.demo.design.pattern.interpreter;

/**
 * @author lambochen
 * @date 2022-04-09 20:38
 */
public class LeftKeyClick implements Expression{

    private Expression leftKeyDown = new LeftKeyDown();
    private Expression leftKeyUp = new LeftKeyUp();

    @Override
    public void interpret() {
        leftKeyDown.interpret();
        leftKeyUp.interpret();
    }
}
