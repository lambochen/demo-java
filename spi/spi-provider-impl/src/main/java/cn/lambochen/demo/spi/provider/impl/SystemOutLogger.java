package cn.lambochen.demo.spi.provider.impl;

import cn.lambochen.demo.spi.provider.Logger;

/**
 * @author lambochen
 * @date 2022-07-18 18:50
 */
public class SystemOutLogger implements Logger {
    @Override
    public void print(String log) {
        System.out.println("System.out:" + log);
    }
}
