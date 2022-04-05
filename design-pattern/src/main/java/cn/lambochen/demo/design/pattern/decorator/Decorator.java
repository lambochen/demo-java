package cn.lambochen.demo.design.pattern.decorator;

/**
 * @author lambochen
 * @date 2022-04-05 13:51
 *
 * 化妆品装饰器
 */
public abstract class Decorator implements Showable {

    // 被装饰的展示者
    private Showable showable;

    // 构造时注入被装饰者
    public Decorator(Showable showable) {
        this.showable = showable;
    }

    @Override
    public void show() {
        showable.show();
    }
}
