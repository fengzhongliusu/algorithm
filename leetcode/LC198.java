package leetcode;

public class LC198 {
    /**
     * 动态规划, 时间：O(n), 空间: O(1)
     * dp[i]表示前i个房子，可获取的最大值.
     */
    public static int rob(int[] nums) {
        if(nums == null || nums.length < 1) return 0;
        if(nums.length < 2) return nums[0];
        int[] dp = new int[nums.length+1];
        dp[1] = nums[0];
        for(int i=2; i<=nums.length; i++) {
            // 考虑当前房子抢不抢；1) 不抢，则为dp[i-1]; 2)抢, 则为当前价值加上dp[i-2](不管i-2有没有抢)；
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i-1]);
        }
        return dp[nums.length];
    }

    /**
     * 优化：O(1)空间
     * prevNo: 前一个房子不抢， prevYes: 前一个房子抢.
     */
    public static int rob2(int[] nums) {
        int prevNo=0, prevYes=0;
        for(int e: nums) {
            int tmp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = tmp + e;
        }
        return Math.max(prevNo, prevYes);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,1,1,2};
        System.out.println(rob(nums));
    }
}
