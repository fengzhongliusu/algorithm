package Concurrency;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by cshuo on 2021/10/13
 */
public class BlockingQueue {
    private LinkedList<Integer> q = new LinkedList<>();
    private Lock lock = new ReentrantLock();
    private Condition full = lock.newCondition();
    private Condition empty = lock.newCondition();
    private final int capacity;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public static void main(String[] args) {
        BlockingQueue q = new BlockingQueue(3);
        Runnable producer = new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (true) {
                    try {
                        q.put(i++);
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Runnable consumer = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println(q.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        new Thread(consumer).start();
        new Thread(producer).start();
    }

    public int take1() throws InterruptedException {
        int val;
        synchronized (q) {
            System.out.println("take: lock");
            while (q.size() < 1) q.wait();
            val = q.pop();
            q.notify();
        }
        System.out.println("take: unlock");
        return val;
    }

    public void put1(int val) throws InterruptedException {
        synchronized (q) {
            System.out.println("put: lock");
            while (q.size() == capacity) q.wait();
            q.add(val);
            q.notify();
        }
        System.out.println("put: unlock");
    }

    public int take() throws InterruptedException {
        lock.lock();
        System.out.println("take: locked");
        if (q.size() < 1) {
            empty.await();
        }
        int val = q.pop();
        full.signal();
        lock.unlock();
        System.out.println("take: unlocked");
        return val;
    }

    public void put(int val) throws InterruptedException {
        lock.lock();
        System.out.println("put: locked");
        if (q.size() == capacity) {
            full.await();
        }
        q.add(val);
        empty.signal();
        lock.unlock();
        System.out.println("put: unlocked");
    }
}
