package leetcode;

/**
 * Created by cshuo on 2017/9/4
 */
public class LC279 {
    /**
     * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
     For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
     Credits:
     Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

     思路: DP, dp[i] = min {dp[i-j*j]+1}, 其中j<sqrt(i);
     */
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for(int i=1; i<=n; i++) {
            int min = Integer.MAX_VALUE;
            for(int j=1; j<= (int)Math.sqrt(i); j++) {
                if(i - j*j >= 0) min = Math.min(min, dp[i-j*j]+1);
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
