package cn.lambochen.demo.design.pattern.flyweight;

/**
 * @author lambochen
 * @date 2022-04-05 14:18
 *
 * 草地
 */
public class Grass implements Drawable {

    // 草地图片
    private String image;

    @Override
    public void draw(int x, int y) {
        System.out.println("Grass.draw");
    }
}
