package leetcode;

import java.util.ArrayList;

/**
 * Created by cshuo on 2017/7/27
 *
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

 For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

 Note:
 You must do this in-place without making a copy of the array.
 Minimize the total number of operations.
 */
public class LC283 {
    public static void main(String[] args) {
    }

    /**
     * 把每一个非0元素尽量移动到最前.
     */
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length < 1) return;
        int curse = 0;
        for(int e: nums)
            if(e != 0) nums[curse++]= e;
        for(; curse<nums.length; curse++)
            nums[curse] = 0;
    }
}
