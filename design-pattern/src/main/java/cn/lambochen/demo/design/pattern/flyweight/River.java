package cn.lambochen.demo.design.pattern.flyweight;

/**
 * @author lambochen
 * @date 2022-04-05 14:17
 *
 * 河流
 */
public class River implements Drawable {

    // 河流图片
    private String image;

    public River(String image) {
        this.image = image;
    }

    public River() {
    }

    @Override
    public void draw(int x, int y) {
        System.out.println("River.draw");
    }
}
