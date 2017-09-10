package leetcode;

/**
 * Follow up for "Unique Paths":
 Now consider if some obstacles are added to the grids. How many unique paths would there be?
 An obstacle and empty space is marked as 1 and 0 respectively in the grid.

 For example,
 There is one obstacle in the middle of a 3x3 grid as illustrated below.
 [
 [0,0,0],
 [0,1,0],
 [0,0,0]
 ]
 The total number of unique paths is 2.

 Note: m and n will be at most 100.
 */
public class LC63 {
    public static void main(String[] args) {
        int[][] arrs =  {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        System.out.println(uniquePathsWithObstacles(arrs));
    }
    /**
     */
    public static int uniquePathsWithObstacles(int[][] grid) {
        if(grid == null || grid.length < 1 || grid[0].length < 1) return 0;
        int m = grid.length, n = grid[0].length;
        if(grid[0][0] == 1 || grid[m-1][n-1] == 1) return 0;

        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(i == 0 && j == 0) dp[i][j] = 1;
                else if(i == 0) dp[i][j] = grid[i][j-1] == 1 ? 0 : dp[i][j-1];
                else if(j == 0) dp[i][j] = grid[i-1][j] == 1 ? 0 : dp[i-1][j];
                else dp[i][j] = (grid[i-1][j] == 1 ? 0 : dp[i-1][j]) + (grid[i][j-1]==1 ? 0 : dp[i][j-1]);
            }
        }
        return dp[m-1][n-1];
    }
}
