package cn.lambochen.demo.spi.provider.impl;

import cn.lambochen.demo.spi.provider.Logger;

/**
 * @author lambochen
 * @date 2022-07-18 18:52
 */
public class SystemErrLogger implements Logger {

    @Override
    public void print(String log) {
        System.err.println("System.err:" + log);
    }

}
