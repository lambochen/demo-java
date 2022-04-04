package cn.lambochen.demo.design.pattern.combination;

/**
 * @author lambochen
 * @date 2022-04-04 18:10
 *
 * 抽象节点类
 */
public abstract class Node {

    protected String name;

    public Node(String name) {
        this.name = name;
    }

    protected abstract void add(Node child);

    protected void tree(int space) {
        for (int i = 0; i < space; i++) {
            // 输出空格，结构化展示
            System.out.println(" ");
        }

        System.out.println(name);
    }

    protected void tree() {
        this.tree(0);
    }
}
