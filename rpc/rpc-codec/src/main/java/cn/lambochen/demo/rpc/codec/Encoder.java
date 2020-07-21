package cn.lambochen.demo.rpc.codec;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/7/21 23:19
 * @Description 序列化
 **/
@FunctionalInterface
public interface Encoder {

    byte[] encode(Object object);

}
