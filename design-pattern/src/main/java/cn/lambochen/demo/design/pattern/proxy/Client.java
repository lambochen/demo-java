package cn.lambochen.demo.design.pattern.proxy;

import java.lang.reflect.Proxy;

/**
 * @author lambochen
 * @date 2022-04-05 17:23
 */
public class Client {

    public static void main(String[] args) {
        // 访问互联网，生成路由器代理
        Internet internet = (Internet) Proxy.newProxyInstance(
                RouterProxy.class.getClassLoader(),
                RouterProxy.class.getInterfaces(),
                new BlackListFilter(
                        new RouterProxy()
                )
        );
        internet.httpAccess("http://www.study.com");
        internet.httpAccess("http://www.yellow.com");

        // 访问局域网，生成交换机代理
        Intranet intranet = (Intranet) Proxy.newProxyInstance(
                Switch.class.getClassLoader(),
                Switch.class.getInterfaces(),
                new BlackListFilter(
                        new Switch()
                )
        );
        intranet.fileAccess("/abc");
        intranet.fileAccess("/yellow");
    }

}
