package cn.lambochen.demo.design.pattern.proxy;

/**
 * @author lambochen
 * @date 2022-04-05 17:12
 *
 * 调制解调器
 */
public class Modem implements Internet {
    @Override
    public void httpAccess(String url) {
        System.out.println("Modem.httpAccess");
    }
}
