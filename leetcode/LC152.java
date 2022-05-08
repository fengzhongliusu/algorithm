package leetcode;

/**
 * Created by cshuo on 2021/8/28
 */
public class LC152 {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[] {2,3,-2,4}));
    }
    public static int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int preMin = 1, preMax = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                preMin = 0;
                preMax = 0;
            } else if (nums[i] > 0) {
                preMin = Math.min(nums[i] * preMin, nums[i]);
                preMax = Math.max(nums[i] * preMax, nums[i]);
            } else {
                int tmp = preMin;
                preMin = Math.min(nums[i] * preMax, nums[i]);
                preMax = Math.max(nums[i] * tmp, nums[i]);
            }
            max = Math.max(max, preMax);
        }
        return max;
    }
}
