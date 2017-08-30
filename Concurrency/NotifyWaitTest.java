package Concurrency;

/**
 * Created by cshuo on 2017/8/24
 */
public class NotifyWaitTest {

    private final static Object lock = new Object();

    private static boolean flag = false;
    public static void main(String[] args) {
        //lock.notify();

        for (int i = 0; i < 2; i++) {
            new ThreadWait().start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new ThreadA().start();
        new ThreadNotify().start();


    }


    private static  class ThreadA extends  Thread{

        @Override
        public void run() {

            while (!flag){yield();}
            synchronized (lock){
                System.out.println("Thread A抢到了锁");
            }
        }
    }

    private static  class ThreadWait extends  Thread{

        @Override
        public void run() {


            synchronized (lock){

                System.out.println("线程" + getName() + "即将等待");
                try {
                    /**
                     * 调用wait方法立即释放当前对象锁,并且使得当前线程进入阻塞状态.
                     * 这也意味着一个对象调用wait方法时当前线程必须要持有该对象的锁，否则会抛异常.
                     */

                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("线程" + getName() + "结束");
        }
    }



    /**
     * The awakened thread will not be able to proceed until the current
     * thread relinquishes the lock on this object. The awakened thread
     * will compete in the usual manner with any other threads that might
     * be actively competing to synchronize on this object; for example,
     * the awakened thread enjoys no reliable privilege or disadvantage
     * in being the next thread to lock this object.　　--doc
     *
     * 说明两点:
     *  被唤醒的线程要不仅要等待调用notify的线程释放它持有的锁,而且之后还要        去和其它要持有该对象锁的
     *  线程去竞争
     */
    private static  class ThreadNotify extends  Thread{

        @Override
        public void run() {

            synchronized (lock){
                System.out.println("notify 线程抢到锁");
                lock.notify();
                flag = true;

            }
        }
    }

}

