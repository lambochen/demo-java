package cn.lambochen.demo.design.pattern.observer;

/**
 * @author lambochen
 * @date 2022-04-09 20:20
 */
public abstract class Buyer {

    private String name;

    public Buyer(String name) {
        this.name = name;
    }

    public abstract void inform(String product);
}
