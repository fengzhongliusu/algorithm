package leetcode;

import java.util.*;

/**
 * Created by cshuo on 2021/9/11
 */
public class LC79 {
    public static void main(String[] args) {
        int[] a = new int[] {2,3,1,1,4};
        System.out.println(jump(a));
        Map<Integer, Integer> map = new TreeMap<>((n1, n2) -> n2 - n1);
        Math.sqrt(1.0);
    }

    public static int jump(int[] A) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < A.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + A[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }
}
