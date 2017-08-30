package Concurrency;
import java.util.*;

/**
 * Created by cshuo on 2017/8/24
 */
class Storage {
    private List<String> storage;
    public Storage() {
        this.storage = new ArrayList<>();
    }
    public List<String> getStorage() { return this.storage; }
    public void setStorage(List<String> storage) { this.storage = storage; }
}

class Producer extends Thread{
    private List<String> storage;
    public Producer(List<String> storage) {
        this.storage = storage;
    }

    public void run() {
        long oldTime = System.currentTimeMillis();
        while(true) {
            synchronized (storage) {
                if(System.currentTimeMillis() - oldTime >= 1000) {
                    oldTime = System.currentTimeMillis();
                    int size = (int)(Math.random()*100) + 1;
                    for(int i=0; i<size; i++) {
                        storage.add(UUID.randomUUID().toString());
                    }
                    System.out.println("生产消息：" + size);
                    storage.notify();
                }
            }
        }
    }
}

class Consumer extends Thread {
    List<String> storage;
    public Consumer(List<String> storage) { this.storage = storage; }

    public void run() {
        while(true) {
            synchronized (storage) {
                while(storage.isEmpty()) {  // 注意这里是while, 一半尽量要把wait()放到循环里面，避免wait()的非正常唤醒.
                    try {
                        storage.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int size = storage.size();
                for(int i=size-1; i>=0; i--) {
                    storage.remove(i);
                }
                System.out.println("消费消息：" + size);
            }
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        Storage storage = new Storage();
        Producer producer = new Producer(storage.getStorage());
        Consumer consumer = new Consumer(storage.getStorage());
        producer.start();
        consumer.start();
    }
}
