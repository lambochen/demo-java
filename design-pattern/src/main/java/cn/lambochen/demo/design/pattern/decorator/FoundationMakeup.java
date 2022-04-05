package cn.lambochen.demo.design.pattern.decorator;


/**
 * @author lambochen
 * @date 2022-04-05 13:54
 *
 * 粉底类
 */
public class FoundationMakeup extends Decorator {

    public FoundationMakeup(Showable showable) {
        super(showable);
    }

    @Override
    public void show() {
        System.out.println("FoundationMakeup.show.pre");
        super.show();
        System.out.println("FoundationMakeup.show.post");
    }

}
