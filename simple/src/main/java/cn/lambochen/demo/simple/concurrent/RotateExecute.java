package cn.lambochen.demo.simple.concurrent;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lambochen
 *
 * https://zhuanlan.zhihu.com/p/370130458
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

        Thread print0 = new Thread(() -> executor.rotate(0));
        Thread print1 = new Thread(() -> executor.rotate(1));
        Thread print2 = new Thread(() -> executor.rotate(2));

        print0.setName("zero");
        print1.setName("one");
        print2.setName("two");

        print0.start();
        print1.start();
        print2.start();
    }

    void rotate(int flag) {
        while (true) {
            print(flag);
        }
    }

}

class RotateExecuteByJoin {

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            Thread a = new Thread(new Executor(null), "a");
            Thread b = new Thread(new Executor(a), "b");
            Thread c = new Thread(new Executor(b), "c");

            a.start();
            b.start();
            c.start();

            Thread.sleep(100);
        }
    }

    static class Executor implements Runnable {

        Thread before;

        public Executor(Thread before) {
            this.before = before;
        }

        @Override
        public void run() {
            if (null != before) {
                try {
                    before.join();
                } catch (InterruptedException ignore) {
                }
            }

            System.out.println(Thread.currentThread().getName());
        }
    }
}

class RotateExecuteByLock {

    volatile int state;
    volatile Lock lock = new ReentrantLock();

    void print(int flag) {
        while (true) {
            lock.lock();
            try {
                if (state % 3 == flag) {
                    state++;
                    System.out.println(Thread.currentThread().getName());
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        RotateExecuteByLock execute = new RotateExecuteByLock();
        execute.state = 0;

        new Thread(() -> execute.print(0), "a").start();
        new Thread(() -> execute.print(1), "b").start();
        new Thread(() -> execute.print(2), "c").start();
    }

}

class RotateExecuteByLockAndCondition {
    volatile int state;
    volatile Lock lock = new ReentrantLock();
    Condition zero = lock.newCondition();
    Condition one = lock.newCondition();
    Condition two = lock.newCondition();

    void print(int flag, Condition current, Condition next) {
        while (true) {
            lock.lock();
            try {
                while (state % 3 != flag) {
                    current.await();
                }

                state++;
                System.out.println(Thread.currentThread().getName());
                next.signal();
            } catch (InterruptedException ignore) {
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        RotateExecuteByLockAndCondition execute = new RotateExecuteByLockAndCondition();
        execute.state = 0;

        new Thread(() -> execute.print(0, execute.zero, execute.one), "a").start();
        new Thread(() -> execute.print(1,execute.one, execute.two),  "b").start();
        new Thread(() -> execute.print(2, execute.two, execute.zero), "c").start();
    }

}

class RotateExecuteBySemaphore {
    static Semaphore a = new Semaphore(1);
    static Semaphore b = new Semaphore(0);
    static Semaphore c = new Semaphore(0);

    void print(Semaphore current, Semaphore next) {
        while (true) {
            try {
                current.acquire();
                System.out.println(Thread.currentThread().getName());
                next.release();
            } catch (InterruptedException ignore) {
            }
        }
    }

    public static void main(String[] args) {
        RotateExecuteBySemaphore execute = new RotateExecuteBySemaphore();

        new Thread(() -> execute.print(a, b), "a").start();
        new Thread(() -> execute.print(b, c), "b").start();
        new Thread(() -> execute.print(c, a), "c").start();
    }
}
