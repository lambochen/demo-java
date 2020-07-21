package cn.lambochen.demo.rpc.codec.json;

import cn.lambochen.demo.rpc.codec.Encoder;
import com.alibaba.fastjson.JSON;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/7/21 23:23
 * @Description 基于 JSON 的序列化实现
 **/
public class JsonEncoder implements Encoder {
    @Override
    public byte[] encode(Object object) {
        return JSON.toJSONBytes(object);
    }
}
