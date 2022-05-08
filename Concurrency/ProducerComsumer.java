package Concurrency;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cshuo on 2021/10/6
 */
public class ProducerComsumer {
    private static final List<String> list = new ArrayList<>();
    public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {
            new Thread(new Pruducer(i)).start();
        }
        for (int i = 0; i < 3; i++) {
            new Thread(new Consumer(i)).start();
        }
    }
    private static class Pruducer implements Runnable {
        private int counter = 0;
        private int id;
        public Pruducer(int id) { this.id = id; }
        @Override
        public void run() {
            while (true) {
                synchronized (list) {
                    String s = "p-" + id + "-" + counter++;
                    System.out.println(s);
                    list.add(s);
                    try {
                        Thread.sleep(2000);
                        list.wait();
                        System.out.println("after wait");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static class Consumer implements Runnable {
        private int id;
        public Consumer(int id) {
            this.id = id;
        }
        @Override
        public void run() {
            while (true) {
                synchronized (list) {
                    if (list.size() < 1) continue;
                    String s = list.remove(0);
                    System.out.println("consumer-" + id + ": " + s);
                    try {
                        Thread.sleep(2000);
                        list.notify();
                        list.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
