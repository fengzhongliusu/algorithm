package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by cshuo on 2021/7/15
 */
public class LC1502 {
    public static void main(String[] args) {
        System.out.println(canMakeArithmeticProgression(new int[] {1,2,4}));
    }

    public static boolean canMakeArithmeticProgression(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int i: arr) {
            if (i < min) min = i;
            if (i > max) max = i;
            set.add(i);
        }
        if ((max - min) % (arr.length - 1) != 0) {
            return false;
        }
        int interval = (max - min) / (arr.length - 1);
        for (int i = 1; i < arr.length - 1; i++) {
            if (!set.contains(min + i * interval)) {
                return false;
            }
        }
        return true;
    }
}
