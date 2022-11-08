package cn.lambochen.demo.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.google.inject.multibindings.MapBinder;

import java.util.Map;

/**
 * @author lambochen
 * @date 2022-11-08 19:32
 */
@Singleton
public class InjectToMapSample {

    @Inject
    Map<String, Printer> printers;

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new InjectToMapModule());
        InjectToMapSample sample = injector.getInstance(InjectToMapSample.class);

        sample.printers.forEach((k, v) -> {
            System.out.println(k);
            v.print();
        });
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

    static class InjectToMapModule extends AbstractModule {
        @Override
        protected void configure() {
            super.configure();

            MapBinder<String, Printer> printers = MapBinder.newMapBinder(binder(), String.class, Printer.class);
            printers.addBinding("hello").to(HelloPrinter.class);
            printers.addBinding("world").to(WorldPrinter.class);
        }
    }

}
