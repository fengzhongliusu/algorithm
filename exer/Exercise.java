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
        Integer[] l = new Integer[] {1,2};
        List<Integer> s =  new ArrayList<>(Arrays.asList(l));
        System.out.println(s.get(0));
        l[0] = 5;
        System.out.println(s.get(0));
    }
}
