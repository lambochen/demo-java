package cn.lambochen.demo.design.pattern.visitor;

/**
 * @author lambochen
 * @date 2022-04-09 19:56
 *
 * 访问者接口
 */
public interface Visitor {

    void visit(Candy candy);
    void visit(Wine wine);
    void visit(Fruit fruit);

}
