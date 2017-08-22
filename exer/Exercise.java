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
        List<int[]> a = new ArrayList<>();
        a.add(new int[]{1,2});
        int[] e = a.get(0);
        System.out.println(e[0] + " " + e[1]);
    }
}
