package Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * author: cshuo
 * date: 2017/4/23
 * version: 1.0
 * description:
 */
public class CachedPool {
    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(new Runnable() {
                public void run() {
                    System.out.println(index + ": " + Thread.currentThread().getId());
                }
            });
        }
        cachedThreadPool.shutdown();
    }
}
