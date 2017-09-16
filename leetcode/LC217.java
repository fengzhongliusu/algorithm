package leetcode;

import java.util.*;

/**
 * 判断一个数组的所有元素是否都是相异的.
 */
public class LC217 {
    public boolean containsDuplicate(int[] nums) {
        if(nums == null) return false;
        Set<Integer> set = new HashSet<>();
        for(int e: nums) set.add(e);
        return set.size() != nums.length;
    }
}
