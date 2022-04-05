package cn.lambochen.demo.design.pattern.flyweight;

/**
 * @author lambochen
 * @date 2022-04-05 14:15
 * <p>
 * 图块类
 */
public class Tile {

    // 图块所用的材质图
    private String image;
    // 坐标
    private int x, y;

    public Tile(String image, int x, int y) {
        this.image = image;
        this.x = x;
        this.y = y;
    }

    public void draw() {
        System.out.println("Tile.draw");
    }
}
