package cn.lambochen.demo.zookeeper;

import org.apache.zookeeper.server.ServerConfig;
import org.apache.zookeeper.server.ZooKeeperServerMain;
import org.apache.zookeeper.server.quorum.QuorumPeerConfig;
import org.springframework.context.SmartLifecycle;
import org.springframework.util.ErrorHandler;
import org.springframework.util.SocketUtils;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.UUID;

/**
 * @author lambochen
 * @date 2022-07-25 23:45
 * <p>
 * from: https://github.com/apache/dubbo-samples/blob/master/dubbo-samples-spring-boot/dubbo-samples-spring-boot-provider/src/main/java/org/apache/dubbo/springboot/demo/provider/EmbeddedZooKeeper.java
 *
 * 启动命令： new EmbeddedZooKeeper(2181, false).start();
 */
public class EmbeddedZookeeper implements SmartLifecycle {

    private final int clientPort;
    private boolean autoStartup = true;
    private int phase = 0;
    private volatile Thread zkServerThread;
    private volatile ZooKeeperServerMain zkServer;
    private ErrorHandler errorHandler;
    private boolean daemon = true;

    public EmbeddedZookeeper() {
        clientPort = SocketUtils.findAvailableTcpPort();
    }

    public EmbeddedZookeeper(int clientPort, boolean daemon) {
        this.clientPort = clientPort;
        this.daemon = daemon;
    }

    public int getClientPort() {
        return clientPort;
    }

    public void setAutoStartup(boolean autoStartup) {
        this.autoStartup = autoStartup;
    }

    @Override
    public boolean isAutoStartup() {
        return autoStartup;
    }

    @Override
    public int getPhase() {
        return phase;
    }

    public void setPhase(int phase) {
        this.phase = phase;
    }

    @Override
    public synchronized void start() {
        if (null == zkServerThread) {
            zkServerThread = new Thread(new ServerRunnable(), "Zookeeper Server Starter");
            zkServerThread.setDaemon(daemon);
            zkServerThread.start();
        }
    }

    private class ServerRunnable implements Runnable {

        @Override
        public void run() {
            try {
                File file = new File(System.getProperty("java.io.tmpdir") + File.separator + UUID.randomUUID());
                file.deleteOnExit();

                Properties properties = new Properties();
                properties.setProperty("dataDir", file.getAbsolutePath());
                properties.setProperty("clientPort", String.valueOf(clientPort));

                QuorumPeerConfig quorumPeerConfig = new QuorumPeerConfig();
                quorumPeerConfig.parseProperties(properties);

                zkServer = new ZooKeeperServerMain();
                ServerConfig config = new ServerConfig();
                config.readFrom(quorumPeerConfig);

                zkServer.runFromConfig(config);
            } catch (Exception e) {
                if (null != errorHandler) {
                    errorHandler.handleError(e);
                } else {
                    // ignore
                }
            }
        }
    }

    @Override
    public synchronized void stop() {
        if (null != zkServerThread) {
            try {
                Method shutdown = ZooKeeperServerMain.class.getDeclaredMethod("shutdown");
                shutdown.setAccessible(true);
                shutdown.invoke(zkServer);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            try {
                zkServerThread.join(5000);
                zkServerThread = null;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();

                zkServerThread = null;
            }
        }
    }

    @Override
    public void stop(Runnable callback) {
        stop();
        callback.run();
    }

    @Override
    public boolean isRunning() {
        return null != zkServerThread;
    }

    public void setErrorHandler(ErrorHandler errorHandler) {
        this.errorHandler = errorHandler;
    }
}
