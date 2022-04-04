package cn.lambochen.demo.design.pattern.abstractfactory.product;

/**
 * @author lambochen
 * @date 2022-04-04 14:15
 *
 * 兵种抽象类
 */
public abstract class Unit {

    // 攻击力
    protected int attack;
    // 防御力
    protected int defence;
    // 生命力
    protected int health;

    // 坐标
    protected int x;
    protected int y;

    // 绘制
    public abstract void show();
    // 攻击
    public abstract void attack();

    // getter setter

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
