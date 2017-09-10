package leetcode;

import java.util.*;

public class LC128 {
    /**
     * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
     For example,
     Given [100, 4, 200, 1, 3, 2],
     The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

     Your algorithm should run in O(n) complexity.

     思路：将数组转换成set, 遍历数组元素，对于每一个元素，分别向左向右将set中对应的值删除掉，终止条件加上set.size() > -1;
     复杂度: 每次操作都是减少set中的元素，知道set的size为0，所以复杂度是O(n)；
     */
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length < 1) return 0;
        Set<Integer> set = new HashSet<>();
        for(int e : nums) set.add(e);
        int max = 1;
        for(int i = 0; i<nums.length && set.size() > -1; i++) {
            int e = nums[i];
            if(set.remove(e)) {
                int left = e, right = e;
                while(set.remove(--left));
                while(set.remove(++right));
                max = max < right - left - 1 ? right - left - 1 : max;
            }
        }
        return max;
    }
}
