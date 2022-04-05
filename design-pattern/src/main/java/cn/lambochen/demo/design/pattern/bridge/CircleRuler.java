package cn.lambochen.demo.design.pattern.bridge;

/**
 * @author lambochen
 * @date 2022-04-05 17:40
 * <p>
 * 圆形尺子
 */
public class CircleRuler implements Ruler {
    @Override
    public void regularize() {
        System.out.println("circle");
    }
}
