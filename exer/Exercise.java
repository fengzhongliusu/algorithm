package exer;


import java.util.*;

/**
 * author: cshuo
 * date: 2017/6/15
 * version: 1.0
 * description:
 */

public class Exercise {
    public static void main(String[] args) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.addFirst(1);
        q.addFirst(2);
        Iterator<Integer> itr = q.iterator();
        while(itr.hasNext())  {
            System.out.println(itr.next());
        }
        System.out.println(q.pollLast());
    }
}
