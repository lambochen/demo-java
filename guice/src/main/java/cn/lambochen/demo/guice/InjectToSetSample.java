package cn.lambochen.demo.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.google.inject.multibindings.Multibinder;

import java.util.Set;

/**
 * @author lambochen
 * @date 2022-11-08 19:32
 */
@Singleton
public class InjectToSetSample {

    @Inject
    Set<Printer> printers;

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new InjectToSetModule());
        InjectToSetSample sample = injector.getInstance(InjectToSetSample.class);

        sample.printers.forEach(Printer::print);
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

    static class InjectToSetModule extends AbstractModule {
        @Override
        protected void configure() {
            super.configure();

            Multibinder<Printer> printers = Multibinder.newSetBinder(binder(), Printer.class);
            printers.addBinding().to(HelloPrinter.class);
            printers.addBinding().to(WorldPrinter.class);
        }
    }

}
