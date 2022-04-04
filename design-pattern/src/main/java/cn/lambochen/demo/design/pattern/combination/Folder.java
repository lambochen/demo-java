package cn.lambochen.demo.design.pattern.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lambochen
 * @date 2022-04-04 18:10
 */
public class Folder extends Node {

    private List<Node> childrenNodes = new ArrayList<>();

    public Folder(String name) {
        super(name);
    }

    @Override
    protected void add(Node child) {
        childrenNodes.add(child);
    }

    @Override
    protected void tree(int space) {
        // 展示自己
        super.tree(space);

        // 展示子节点
        space++;
        for (Node node : childrenNodes) {
            node.tree(space);
        }
    }
}
