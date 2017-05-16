package Concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * author: cshuo
 * date: 2017/4/23
 * version: 1.0
 * description:
 */
public class SchedulePool {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.schedule(new Runnable() {
            public void run() {
                System.out.println("delay 3 seconds");
            }
        }, 3, TimeUnit.SECONDS);
//        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
//            public void run() {
//                System.out.println("delay 1 seconds, and excute every 3 seconds");
//            }
//        }, 1, 2, TimeUnit.SECONDS);
        scheduledThreadPool.shutdown();
    }
}
