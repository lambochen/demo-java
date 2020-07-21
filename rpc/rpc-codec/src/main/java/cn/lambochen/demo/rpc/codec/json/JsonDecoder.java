package cn.lambochen.demo.rpc.codec.json;

import cn.lambochen.demo.rpc.codec.Decoder;
import com.alibaba.fastjson.JSON;

import javax.lang.model.type.DeclaredType;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/7/21 23:23
 * @Description 基于 JSON 反序列实现
 **/
public class JsonDecoder implements Decoder {
    @Override
    public <T> T decoder(byte[] bytes, Class<T> clazz) {
        return JSON.parseObject(bytes, clazz);
    }
}
