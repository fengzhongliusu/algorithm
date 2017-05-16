package exer;

import sun.swing.SwingUtilities2;

import java.util.*;

/**
 * author: cshuo
 * date: 2017/4/7
 * version: 1.0
 * description:
 */
enum SingleTon{
    INSTANCE (0);


    SingleTon(int i) {
    }

    public void test(){
        System.out.println("hello, world");
    }
}

public class Test2 {
    public static void main(String[] args) {
        System.out.println(SingleTon.INSTANCE.equals(0));
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(3);
        a.add(2);
        a.remove(new Integer(1));
        System.out.println(a);
    }
}
