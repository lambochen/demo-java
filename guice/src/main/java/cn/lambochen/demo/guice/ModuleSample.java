package cn.lambochen.demo.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;

/**
 * @author lambochen
 * @date 2022-11-08 19:18
 */
@Singleton
public class ModuleSample {

    @Inject
    Printer printer;

    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new Selector());
        ModuleSample sample = injector.getInstance(ModuleSample.class);
        sample.printer.print();

    }

    interface Printer {
        void print();
    }

    static class HelloPrinter implements Printer {

        @Override
        public void print() {
            System.out.println("hello");
        }
    }

    static class WorldPrinter implements Printer {

        @Override
        public void print() {
            System.out.println("world");
        }
    }

    static class Selector extends AbstractModule {
        @Override
        protected void configure() {
            super.configure();

            bind(Printer.class).to(HelloPrinter.class);
        }
    }

}
