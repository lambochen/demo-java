package cn.lambochen.demo.design.pattern.interpreter;

/**
 * @author lambochen
 * @date 2022-04-09 20:39
 *
 * 循环表达式
 */
public class Repetition implements Expression{

    private int loopCount;
    private Expression loopBodySequence;

    public Repetition(int loopCount, Expression loopBodySequence) {
        this.loopCount = loopCount;
        this.loopBodySequence = loopBodySequence;
    }

    @Override
    public void interpret() {
        while (loopCount > 0) {
            loopBodySequence.interpret();
            loopCount--;
        }
    }
}
