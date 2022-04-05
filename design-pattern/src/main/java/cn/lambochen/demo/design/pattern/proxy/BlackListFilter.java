package cn.lambochen.demo.design.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * @author lambochen
 * @date 2022-04-05 17:19
 *
 * 黑名单过滤器，动态代理类
 */
public class BlackListFilter implements InvocationHandler {

    private List<String> blackList = Arrays.asList("yellow");

    // 被代理的真实对象，如 Modem、Switch
    private Object origin;

    public BlackListFilter(Object origin) {
        this.origin = origin;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String arg = args[0].toString();
        for (String key : blackList) {
            if (arg.contains(key)) {
                System.out.println("this url is in black list");
                return null;
            }
        }

        return method.invoke(origin, args);
    }
}
