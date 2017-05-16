package leetcode;

/**
 * Created by cshuo on 2017/3/3.
 */
public class CanPartition {
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n: nums){
            sum += n;
        }
        if(sum % 2 == 1) return false;

        boolean []dp = new boolean[(sum>>1) + 1];
        dp[0] = true;

        for(int i=0; i<nums.length; i++){
            for(int j = sum>>1; j>=nums[i]; j--){
                dp[j] = dp[j] || dp[j-nums[i]];
            }
        }

        return dp[sum>>1];
    }

    public static void main(String[] args){
        int[] a = {1,5,11,5};
        System.out.println(CanPartition.canPartition(a));
    }
}
