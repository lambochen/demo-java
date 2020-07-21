package cn.lambochen.demo.rpc.codec;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/7/21 23:20
 * @Description 反序列化
 **/
@FunctionalInterface
public interface Decoder {

    <T> T decoder(byte[] bytes, Class<T> clazz);

}
