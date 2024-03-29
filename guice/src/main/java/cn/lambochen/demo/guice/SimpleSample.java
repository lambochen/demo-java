package cn.lambochen.demo.guice;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;

/**
 * @author lambochen
 * @date 2022-11-08 19:00
 */
@Singleton
public class SimpleSample {

    @Inject
    Printer printer;

    public void print() {
        printer.print();
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector();

        SimpleSample sample = injector.getInstance(SimpleSample.class);
        sample.print();
    }

    /**
     * 也可替换为 {@link javax.inject.Singleton}
     */
    @Singleton
    static class Printer {
        public void print() {
            System.out.println("hello world");
        }
    }

}


