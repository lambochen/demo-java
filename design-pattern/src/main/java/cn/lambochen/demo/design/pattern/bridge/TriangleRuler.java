package cn.lambochen.demo.design.pattern.bridge;

/**
 * @author lambochen
 * @date 2022-04-05 17:39
 * <p>
 * 三角形尺子
 */
public class TriangleRuler implements Ruler {
    @Override
    public void regularize() {
        System.out.println("triangle");
    }
}
