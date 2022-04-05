package cn.lambochen.demo.design.pattern.proxy;

import java.util.Arrays;
import java.util.List;

/**
 * @author lambochen
 * @date 2022-04-05 17:14
 *
 * 路由器
 */
public class RouterProxy implements Internet {

    // 被代理对象
    private Internet modem;

//    private List<String> blackList = Arrays.asList("yellow");

    public RouterProxy() {
        // 主动实例化了“猫”对象，而非由外部注入。从某种意义上讲，这是代理模式区别于装饰器模式的一种体现。
        // 虽然二者的理念与实现有点类似，但装饰器模式往往更加关注为其他对象增加功能，让客户端更加灵活地进行组件搭配；
        // 而代理模式更强调的则是一种对访问的管控，甚至是将被代理对象完全封装而隐藏起来，使其对客户端完全透明
        this.modem = new Modem();
    }

    @Override
    public void httpAccess(String url) {
        // 此逻辑已迁移至动态代理类
//        for (String key : blackList) {
//            if (url.contains(key)) {
//                System.out.println("this url is in black list");
//                return;
//            }
//        }

        // 转发请求到 Modem
        modem.httpAccess(url);
    }
}
