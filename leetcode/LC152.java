package leetcode;

/**
 * Created by cshuo on 2017/8/4
 *
 Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 For example, given the array [2,3,-2,4],
 the contiguous subarray [2,3] has the largest product = 6.
 *
 */
public class LC152 {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, -1, -5, 2,3};
        System.out.println(maxProduct(nums));
    }

    /**
     * e是当前元素，max和min是以e结尾的最大和最小乘积.
     * rs记录推进过程中的最大值.
     * 可扩展到最小字数组乘积.
     */
    public static int maxProduct(int[] nums) {
        if(nums == null || nums.length < 1) return 0;
        int max = 1, min = 1, rs = Integer.MIN_VALUE;
        for(int e: nums) {
            int tmp = max;
            max = Math.max(Math.max(max*e, min*e), e);
            min = Math.min(Math.min(tmp*e, min*e), e);
            if(max > rs) rs = max;
        }
        return rs;
    }
}
