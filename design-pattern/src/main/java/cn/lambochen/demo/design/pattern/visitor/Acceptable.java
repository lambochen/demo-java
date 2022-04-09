package cn.lambochen.demo.design.pattern.visitor;

/**
 * @author lambochen
 * @date 2022-04-09 20:05
 *
 * 接待者接口
 */
public interface Acceptable {

    void accept(Visitor visitor);

}
