package cn.lambochen.demo.spock;

import java.util.function.Consumer;

/**
 * @author lambo.chen.2306@gmail.com
 * @date 2020/7/10
 * @description TODO
 **/
public class CatchUtil {

    public static <T> void tryDo(T t, Consumer<T> func) {
        try {
            func.accept(t);
        } catch (Exception e) {
            throw new RuntimeException(e.getCause());
        }
    }

}
