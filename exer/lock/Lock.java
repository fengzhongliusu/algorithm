package exer.lock;

/**
 * author: cshuo
 * date: 2017/4/23
 * version: 1.0
 * description:
 */
public class Lock {
    private boolean isLocked = false;
    public synchronized void lock() throws InterruptedException {
        while(isLocked){
            wait();
        }
        isLocked = true;
    }
    public synchronized void unlock(){
        isLocked = false;
        notify();
    }
}
