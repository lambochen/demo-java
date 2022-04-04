package cn.lambochen.demo.design.pattern.combination;

/**
 * @author lambochen
 * @date 2022-04-04 18:11
 */
public class File extends Node {
    public File(String name) {
        super(name);
    }

    @Override
    protected void add(Node child) {
        throw new UnsupportedOperationException();
    }

}
