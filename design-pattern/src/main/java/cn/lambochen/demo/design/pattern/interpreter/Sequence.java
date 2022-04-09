package cn.lambochen.demo.design.pattern.interpreter;

import java.util.List;

/**
 * @author lambochen
 * @date 2022-04-09 20:40
 */
public class Sequence implements Expression {

    private List<Expression> expressions;

    public Sequence(List<Expression> expressions) {
        this.expressions = expressions;
    }

    @Override
    public void interpret() {
        for (Expression expression : expressions) {
            expression.interpret();
        }
    }
}
