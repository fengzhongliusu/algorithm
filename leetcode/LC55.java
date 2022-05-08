package leetcode;

/**
 * Created by cshuo on 2021/9/6
 */
public class LC55 {
    public static void main(String[] args) {
        int[] nums = new int[] {3,0,8,2,0,0,1};
        System.out.println(canJump(nums));
    }
    public static boolean canJump(int[] nums) {
        int farMost = 0;
        for (int i = 0; i < nums.length && i <= farMost; i++) {
            farMost = Math.max(farMost, nums[i] + i);
            if (farMost >= nums.length - 1) return true;
        }
        return false;
    }
}
