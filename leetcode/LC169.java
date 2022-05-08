package leetcode;

/**
 * Created by cshuo on 2021/8/6
 */
public class LC169 {
    public static void main(String[] args) {
    }

    public static int majorityElement(int[] nums) {
        int num = nums[0], cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (cnt == 0) {
                num = nums[i];
                cnt = 1;
            } else if (num == nums[i]) {
                cnt  += 1;
            } else {
                cnt -= 1;
            }
        }
        return num;
    }
}
