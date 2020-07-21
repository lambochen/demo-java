package cn.lambochen.demo.rpc.transport;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/7/21 23:32
 * @Description 处理网络请求的 handler
 **/
public interface RequestHandler {

    void onRequest(InputStream receive, OutputStream toResponse);

}
