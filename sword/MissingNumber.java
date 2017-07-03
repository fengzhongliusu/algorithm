package sword;

/**
 * author: cshuo
 * date: 2017/6/9
 * version: 1.0
 * description:
 */
public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {2,1,0};
        System.out.println(missingNumber(nums));
    }
    public static int missingNumber(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += i - nums[i];
        }
        return sum + nums.length;
    }
}
