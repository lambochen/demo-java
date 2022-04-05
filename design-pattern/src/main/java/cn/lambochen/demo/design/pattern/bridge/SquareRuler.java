package cn.lambochen.demo.design.pattern.bridge;

/**
 * @author lambochen
 * @date 2022-04-05 17:39
 *
 * 正方形尺子
 */
public class SquareRuler implements Ruler{
    @Override
    public void regularize() {
        System.out.println("square");
    }
}
