package cn.lambochen.demo.design.pattern.adapter.old;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/7/14
 * @description 笔记本
 **/
public class NoteBook {

    TwoPhaseInterface two;

    public void setTwo(TwoPhaseInterface two) {
        this.two = two;
    }

    /**
     * 需要两相插座进行充电
     */
    public void power() {
        two.powerWithTwo();
    }

}
