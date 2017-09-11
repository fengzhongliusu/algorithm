package leetcode;

/**
 * Created by cshuo on 2017/9/9
 * LC198 升级版, 将直线列表 换成 环.
 * 思路: 可以直接利用LC198解法, 即可以将环的问题规约到线性的问题，任何两个连续的房子都不能同时被偷，假设取0,n-1两个连续房子，即可以将问题
 * 分解为0不被抢和n-1不被抢两种情况，这样就转换成了线性的抢劫问题.
 */
public class LC213 {
    public int rob(int[] nums) {
        if(nums == null || nums.length < 1) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(helper(nums, 0, nums.length-2), helper(nums, 1, nums.length-1));
    }

    static int helper(int[] nums, int l, int r) {
        int prevYes = 0, prevNo = 0;
        for(int i=l; i<=r; i++) {
            int tmp = prevNo;
            prevNo = Math.max(prevYes, prevNo);
            prevYes = tmp + nums[i];
        }
        return Math.max(prevYes, prevNo);
    }
}
