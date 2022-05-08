package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by cshuo on 2021/8/19
 */
public class LC376 {
    public static void main(String[] args) {
        Random rnd = new Random();
        System.out.println(rnd.nextInt(1));
    }
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) return 1;
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) dp[i][0] = Math.max(dp[j][1] + 1, dp[i][0]);
                if (nums[j] > nums[i]) dp[i][1] = Math.max(dp[j][0] + 1, dp[i][1]);
            }
        }
        int maxLen = -1;
        for (int i = 0; i < nums.length; i++) {
            maxLen = Math.max(maxLen, Math.max(dp[i][0], dp[i][1]));
        }
        return maxLen;
    }
}
