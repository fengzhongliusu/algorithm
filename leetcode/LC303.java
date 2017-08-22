package leetcode;

public class LC303 {
    int[] preSum;

    public LC303(int[] nums) {
        if(nums == null) return;
        preSum = new int[nums.length+1];
        for(int i=1; i<=nums.length; i++)
            preSum[i] = preSum[i-1] + nums[i-1];
    }

    /**
     * 考察前缀和的应用.
     */
    public int sumRange(int i, int j) {
        return preSum[j+1] - preSum[i];
    }
}
