package cn.lambochen.demo.design.pattern.cor.handler;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/7/14
 * @description 价格处理器，抽象类。 直接与 client 进行交互
 **/
public abstract class PriceHandler {

    /**
     * 后继
     */
    protected PriceHandler successor;

    /**
     * 处理折扣
     *
     * @param discount
     */
    public abstract void process(float discount);

    public void setSuccessor(PriceHandler successor) {
        this.successor = successor;
    }
}
