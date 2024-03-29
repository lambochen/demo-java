package cn.lambochen.demo.guice;

import com.google.inject.Guice;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;

/**
 * @author lambochen
 * @date 2022-11-08 19:10
 */
@Singleton
public class ImplementedBySample {

    @Inject
    Printer printer;
    
    public static void main(String[] args) {
        Injector injector = Guice.createInjector();
        ImplementedBySample sample = injector.getInstance(ImplementedBySample.class);
        sample.printer.print();
    }

    @ImplementedBy(WorldPrinter.class)
    interface Printer {
        void print();
    }

    /**
     * 此处不用 Singleton 标注也能正常启动
     *
     * 不用Singleton标注，每次获取实例时，Guice会重新构造一个，这个会有反射构造器的性能损耗，在高性能场景下，请谨慎
     */
    @Singleton
    static class HelloPrinter implements Printer {

        @Override
        public void print() {
            System.out.println("hello");
        }
    }

    @Singleton
    static class WorldPrinter implements Printer {

        @Override
        public void print() {
            System.out.println("world");
        }

    }
    
}
