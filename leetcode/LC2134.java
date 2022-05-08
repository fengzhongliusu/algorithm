package leetcode;

/**
 * Created by cshuo on 2022/1/16
 *
 * Circular Array can be simplified by concatenating itself (n * 2).
 *
 */
public class LC2134 {
    public static void main(String[] args) {
        int[] nums = new int[] {1};
        System.out.println(minSwaps(nums));
    }

    public static int minSwaps(int[] nums) {
        int totalOnes = 0;
        for (int e: nums) {
            if (e == 1) totalOnes += 1;
        }
        int[] n2 = new int[nums.length * 2];
        for (int i = 0; i < nums.length * 2; i++) {
            n2[i] = nums[i%nums.length];
        }
        int maxOnes = 0, curSize = 0;
        for (int i = 0; i < nums.length * 2; i++) {
            if (i >= totalOnes && n2[i - totalOnes] == 1) curSize -= 1;
            if (n2[i] == 1) curSize += 1;
            maxOnes = Math.max(curSize, maxOnes);
        }
        return totalOnes - maxOnes;
    }
}
