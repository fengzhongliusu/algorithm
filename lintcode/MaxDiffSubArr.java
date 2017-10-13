package lintcode;

public class MaxDiffSubArr {
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,-3,1};
        System.out.println(maxDiffSubArrays(arr));
    }

    /**
     * 利用max sum of subarray思想，分别计算出四个数组，即以下表不超过i的最大子数组和以及最小子数组和， 下表不小于i的最大子数组和以及
     * 最小子数组和; 求出之后，遍历一边，结果是Max(maxEnd[i]-minBe[i+1], minEnd[i]-maxBe[i+1])，即用前一段的最小减去后一段的最大(abs),
     * 或者前一段的最大减去后一段的最小.
     */
    public static int maxDiffSubArrays(int[] nums) {
        int len = nums.length, ans = Integer.MIN_VALUE;
        int[] maxEnd = new int[len], minEnd = new int[len], maxBe = new int[len], minBe = new int[len];
        int sum1=0, sum2=0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int i=0; i<len; i++) {
            sum1 += nums[i];
            sum2 += nums[i];
            max = Math.max(sum1, max); maxEnd[i] = max;
            min = Math.min(sum2, min); minEnd[i] = min;
            sum1 = Math.max(0, sum1);
            sum2 = Math.min(0, sum2);
        }

        sum1 = 0; sum2 = 0; max = Integer.MIN_VALUE; min = Integer.MAX_VALUE;
        for(int i=len-1; i>=0; i--) {
            sum1 += nums[i];
            sum2 += nums[i];
            max = Math.max(sum1, max); maxBe[i] = max;
            min = Math.min(sum2, min); minBe[i] = min;
            sum1 = Math.max(0, sum1);
            sum2 = Math.min(0, sum2);
        }

        for(int i=0; i<len; i++) {
            System.out.println(maxEnd[i] + " " + minEnd[i] + " " + maxBe[i] + " " + minBe[i]);
            ans = i+1 < len ? Math.max(abs(maxEnd[i] - minBe[i+1]), ans) : ans;
            ans = i+1 < len ? Math.max(abs(minEnd[i] - maxBe[i+1]), ans) : ans;
        }
        return ans;
    }

    public static int abs(int a)  {
        return a>=0 ? a:-a;
    }
}
