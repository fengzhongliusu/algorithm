package leetcode;

import java.util.Arrays;

/**
 * Created by cshuo on 2017/8/13
 * 300. Longest Increasing Subsequence
 * Given an unsorted array of integers, find the length of longest increasing subsequence.

 For example,
 Given [10, 9, 2, 5, 3, 7, 101, 18],
 The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be
 more than one LIS combination, it is only necessary for you to return the length.
 */
public class LC300 {
    /**
     * dp[i]: 以nums[i]结尾的最长上升子序列的长度.
     */
    public static void main(String[] args) {
        int[] a = new int[] {1,2,3,5};
        System.out.println(Arrays.binarySearch(a, 0, 4, 0));
    }

    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length < 1) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for(int i=1; i<nums.length; i++) {
            int maxLen = -1;
            for(int j=0; j<i; j++) {
                // 取i之前dp[j]的最大值.
                if(nums[i] > nums[j] && dp[j]+1 > maxLen) maxLen = dp[j] + 1;
            }
            dp[i] = maxLen==-1 ? 1:maxLen;
        }
        // 最后返回dp中的最大值.
        int maxLen = -1;
        for(int e: dp) if(e > maxLen) maxLen = e;
        return maxLen;
    }
}
