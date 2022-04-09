package cn.lambochen.demo.design.pattern.interpreter;

import java.util.Arrays;

/**
 * @author lambochen
 * @date 2022-04-09 20:41
 */
public class Client {

    public static void main(String[] args) {
        // 构建指令集语义树
        Expression sequence = new Sequence(Arrays.asList(
                new Move(500, 600),
                new Repetition(
                        5,
                        new Sequence(
                                Arrays.asList(
                                        new LeftKeyClick(), new Delay(1)
                                )
                        )
                ),
                new LeftKeyDown(),
                new Delay(5)
        ));

        sequence.interpret();
    }
}
