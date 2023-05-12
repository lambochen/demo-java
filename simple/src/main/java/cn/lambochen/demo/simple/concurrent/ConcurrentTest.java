package cn.lambochen.demo.simple.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author lambochen
 */
public class ConcurrentTest {

    static ThreadPoolExecutor executor =
            new ThreadPoolExecutor(
                    2,
                    4,
                    5, // 网络请求timeout=5s
                    TimeUnit.SECONDS,
                    new ArrayBlockingQueue<>(5),
                    new ThreadPoolExecutor.CallerRunsPolicy()
            );

    public static void main(String[] args) throws InterruptedException {


        CompletableFuture.runAsync(() -> {

            for (int i = 0; i < 99; i++) {
                async();
            }

            System.out.println("end");

        });

        Thread.sleep(10000);

        System.out.println("-------------");

        for (int i = 0; i < 5; i++) {
            async();
        }

        System.out.println("end second");

    }

    static void async() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        CompletableFuture.allOf(
                list.stream().map(l1 -> {
                            return CompletableFuture.runAsync(() -> {
                                System.out.println("L1: " + l1);


                                CompletableFuture.allOf(
                                        list.stream().map(l2 -> {
                                                    return CompletableFuture.runAsync(() -> {
                                                        System.out.println("L2: " + (l2 + 10));
                                                    }, executor);
                                                })
                                                .toArray(CompletableFuture[]::new)
                                ).join();


                            }, executor);
                        })
                        .toArray(CompletableFuture[]::new)
        ).join();

    }

}
