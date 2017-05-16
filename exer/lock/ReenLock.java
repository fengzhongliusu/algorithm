package exer.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * author: cshuo
 * date: 2017/4/23
 * version: 1.0
 * description:
 */
public class ReenLock implements Runnable{
    ReentrantLock lock = new ReentrantLock();

    public void get() throws InterruptedException {
        lock.lock();
        System.out.println(Thread.currentThread().getId() + ": " + lock.getHoldCount());
        set();
        lock.unlock();
        System.out.println(Thread.currentThread().getId()+ ": " +lock.getHoldCount());
    }

    public void set() throws InterruptedException {
//        lock.lock();
        lock.lockInterruptibly();
        System.out.println(Thread.currentThread().getId() + ": " + lock.getHoldCount());
        lock.unlock();
        System.out.println(Thread.currentThread().getId() + ": " + lock.getHoldCount());
    }


    @Override public void run() {
        try {
            get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ReenLock ss = new ReenLock();
        new Thread(ss).start();
        new Thread(ss).start();
        new Thread(ss).start();
    }
}
