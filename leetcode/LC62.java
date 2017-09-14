package leetcode;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 The robot can only move either down or right at any point in time.
 The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 How many possible unique paths are there?

 Note: m and n will be at most 100.
 */
public class LC62 {
    /**
     * 思路: DP, dp[i][j]到达i行j列的可能路径数,
     * 传递公式: dp[i][j] = dp[i-1][j] + dp[i][j-1]; (增加一个0行, 0列减少边界判断.)
     */
    public static void main(String[] args) {
        System.out.println(uniquePaths(0,0));
    }

    public static int uniquePaths(int m, int n) {
        if(m == 0 || n == 0) return 0;
        int[][] dp = new int[m+1][n+1];
        dp[1][1] = 1;
        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(i == 1 && j == 1) continue;
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m][n];
    }
}
