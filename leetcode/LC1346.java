package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by cshuo on 2021/7/8
 */
public class LC1346 {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i: arr) {
            if (set.contains(i*2) || i % 2 == 0 && set.contains(i / 2)) {
                return true;
            }
            set.add(i);
        }
        return false;
    }
}
