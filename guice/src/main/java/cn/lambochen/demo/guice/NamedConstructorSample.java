package cn.lambochen.demo.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

/**
 * @author lambochen
 * @date 2022-11-08 19:23
 */
@Singleton
public class NamedConstructorSample {

    Printer helloPrinter;
    Printer worldPrinter;

    @Inject
    public NamedConstructorSample(
            @Named("hello") Printer helloPrinter,
            @Named("world") Printer worldPrinter) {
        this.helloPrinter = helloPrinter;
        this.worldPrinter = worldPrinter;
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new NamedModule());
        NamedConstructorSample sample = injector.getInstance(NamedConstructorSample.class);

        sample.helloPrinter.print();
        sample.worldPrinter.print();
    }

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

    static class NamedModule extends AbstractModule {
        @Override
        protected void configure() {
            super.configure();

            bind(Printer.class).annotatedWith(Names.named("hello")).to(HelloPrinter.class);
            bind(Printer.class).annotatedWith(Names.named("world")).to(WorldPrinter.class);
        }
    }

}
