package cn.lambochen.demo.simple.concurrent;

/**
 * @author lambochen
 */
public class RotateExecute {

    static volatile int state;
    static final int max_state = 3;

    public synchronized void print(int flag) {
        try {
            while (state % max_state != flag) {
                this.wait();
            }

            System.out.println(Thread.currentThread().getName() + ":" + state++);
            Thread.sleep(10);
            this.notifyAll();
        } catch (InterruptedException e) {
            // do thing
        }
    }

    public static void main(String[] args) {
        RotateExecute.state = 0;
        RotateExecute executor = new RotateExecute();

        Thread print0 = new Thread(() -> executor.print(0));
        Thread print1 = new Thread(() -> executor.print(1));
        Thread print2 = new Thread(() -> executor.print(2));

        print0.setName("zero");
        print1.setName("one");
        print2.setName("two");

        print0.start();
        print1.start();
        print2.start();
    }

}
