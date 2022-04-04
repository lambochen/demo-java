package cn.lambochen.demo.design.pattern.simplefactory.product;

/**
 * @author lambochen
 * @date 2022-04-04 13:50
 *
 * 敌人抽象类 Enemy
 */
public abstract class Enemy {

    protected int x;
    protected int y;

    // 初始化坐标
    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // 抽象方法，在地图上绘制
    public abstract void show();
}
