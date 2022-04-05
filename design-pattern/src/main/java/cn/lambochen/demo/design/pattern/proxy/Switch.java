package cn.lambochen.demo.design.pattern.proxy;

/**
 * @author lambochen
 * @date 2022-04-05 17:18
 * <p>
 * 交换机
 */
public class Switch implements Intranet {
    @Override
    public void fileAccess(String path) {
        System.out.println("Switch.fileAccess");
    }
}
