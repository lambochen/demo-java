package cn.lambochen.demo.zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

import java.util.List;

/**
 * @author lambo.chen
 * @date 2020/10/12
 * <p>
 * Apache Curator： https://curator.apache.org/
 **/
public class CuratorDemo {

    public static void main(String[] args) {
        /**
         * 1. 创建 Curator 客户端
         */
        CuratorFramework client = CuratorFrameworkFactory.builder()
                // zk 服务器，集群示例："127.0.0.1:2181,127.0.0.2:2181"
                .connectString("127.0.0.1:2181")
                // 会话超时时间
                .sessionTimeoutMs(5000)
                // 链接超时时间
                .connectionTimeoutMs(3000)
                // 重试策略
                .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                .build();

        /**
         * 2. 启用客户端
         */
        client.start();

        String path = "/demo/curator";
        String data = "hello";

        /**
         * 3. 创建 znode
         */
        try {
            client.create()
                    // 如果父节点不存在则创建
                    .creatingParentsIfNeeded()
                    // znode 节点类型
                    .withMode(CreateMode.PERSISTENT)
                    .forPath(path, data.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         * 4. 读取 znode 数据
         */
        try {
            Stat stat = new Stat();
            byte[] nodeData = client.getData()
                    .storingStatIn(stat)
                    .forPath(path);

            System.out.println("Node Data:" + new String(nodeData));
            System.out.println("Stat:" + stat);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         * 5. 更新 znode 数据
         */
        try {
            client.setData()
                    .withVersion(-1)
                    .forPath(path, "world".getBytes());

            // 读取数据
            Stat stat = new Stat();
            byte[] nodeData = client.getData()
                    // 获取 Stat 数据
                    .storingStatIn(stat)
                    // 获取 data
                    .forPath(path);

            System.out.println("[update] Node Data:" + new String(nodeData));
            System.out.println("[update] Stat:" + stat);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         * 6. 获取子节点列表
         */
        try {
            List<String> children = client.getChildren().forPath(path);
            System.out.println("Children: " + children);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         * 7. 删除节点
         */
        try {
            client.delete()
                    .guaranteed()
                    .deletingChildrenIfNeeded()
                    .withVersion(-1)
                    .forPath(path);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         * 8. 关闭客户端
         */
        client.close();
    }

}
