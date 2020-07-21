package cn.lambochen.demo.rpc.proto;

import java.util.Objects;

/**
 * @Author lambo.chen.2306@gmail.com
 * @Date 2020/7/21 22:58
 * @Description 表示网络传输的一个端点
 **/
public class Peer {

    private String host;

    private Integer port;

    public Peer() {
    }

    public Peer(String host, Integer port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public String toString() {
        return "Peer{" +
                "host='" + host + '\'' +
                ", port=" + port +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Peer)) return false;
        Peer peer = (Peer) o;
        return Objects.equals(getHost(), peer.getHost()) &&
                Objects.equals(getPort(), peer.getPort());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHost(), getPort());
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
