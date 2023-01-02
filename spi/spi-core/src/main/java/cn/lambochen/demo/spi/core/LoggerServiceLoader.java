package cn.lambochen.demo.spi.core;

import cn.lambochen.demo.spi.provider.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

/**
 * @author lambochen
 * @date 2022-07-18 18:36
 */
public class LoggerServiceLoader {

    private static final List<Logger> loggers = new ArrayList<>();

    static {
        // load SPI impl
        ServiceLoader<Logger> loggerServiceLoader = ServiceLoader.load(Logger.class);
        loggerServiceLoader.iterator().forEachRemaining(loggers::add);
    }

    public static Logger getLogger() {
        // strategy
        return loggers.get(0);
    }

    public static List<Logger> getLoggers() {
        return loggers;
    }

}
