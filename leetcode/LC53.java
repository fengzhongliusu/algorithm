package leetcode;

/**
 * Created by cshuo on 2021/7/15
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 */
public class LC53 {
    public static void main(String[] args) {
        int[] nums = new int[] {-2,-1,-3,-4,-1,-2,-1,-5,-4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (curSum > max) {
                max = curSum;
            }
            if (curSum < 0) {
                curSum = 0;
            }
        }
        return max;
    }
}
