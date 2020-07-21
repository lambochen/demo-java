package cn.lambochen.demo.rpc.proto;

import java.util.Objects;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/7/21 23:04
 * @Description RPC 的响应
 **/
public class Response {

    /**
     * 响应码, 0-成功， 非0-失败
     */
    private int code = 0;

    /**
     * 描述信息
     */
    private String message = "ok";

    /**
     * 响应对象
     */
    private Object data;

    public Response() {
    }

    public Response(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Response)) return false;
        Response response = (Response) o;
        return getCode() == response.getCode() &&
                Objects.equals(getMessage(), response.getMessage()) &&
                Objects.equals(getData(), response.getData());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode(), getMessage(), getData());
    }
}
