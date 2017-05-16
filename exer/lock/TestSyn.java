package exer.lock;

/**
 * author: cshuo
 * date: 2017/4/23
 * version: 1.0
 * description:
 */
public class TestSyn {
    //对普通方法同步
    public synchronized void sayGoodbye() {
        System.out.println("say good bye");
    }
    //对静态方法同步
    public synchronized static void sayHi() {
        System.out.println("say hi");
    }
    //对方法块同步
    public void sayHello() {
        synchronized (TestSyn.class) {
            System.out.println("say hello");
        }
    }

    public static void main(String[] args) {
        TestSyn lockTest = new TestSyn();
        lockTest.sayGoodbye();
        lockTest.sayHello();
        TestSyn.sayHi();
    }
}
