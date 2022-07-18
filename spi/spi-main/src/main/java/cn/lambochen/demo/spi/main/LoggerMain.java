package cn.lambochen.demo.spi.main;

import cn.lambochen.demo.spi.core.LoggerServiceLoader;

/**
 * @author lambochen
 * @date 2022-07-18 18:58
 */
public class LoggerMain {

    public static void main(String[] args) {
        LoggerServiceLoader.getLogger().print("spi singleton test");

        System.out.println();
        System.out.println("------  this is a line ------");
        System.out.println();

        LoggerServiceLoader.getLoggers().forEach(logger -> logger.print("spi multipart test"));
    }

}
