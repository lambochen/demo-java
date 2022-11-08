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
