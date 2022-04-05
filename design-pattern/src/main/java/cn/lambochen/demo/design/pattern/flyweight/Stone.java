package cn.lambochen.demo.design.pattern.flyweight;

/**
 * @author lambochen
 * @date 2022-04-05 14:18
 *
 * 道路
 */
public class Stone implements Drawable {

    private String image;

    @Override
    public void draw(int x, int y) {
        System.out.println("Stone.draw");
    }
}
