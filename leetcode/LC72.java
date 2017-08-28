package leetcode;

/**
 * Created by cshuo on 2017/8/13
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2.
 * (each operation is counted as 1 step.)

 You have the following 3 operations permitted on a word:

 a) Insert a character
 b) Delete a character
 c) Replace a character
 */
public class LC72 {
    public int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null) return -1;
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<=m; i++)
            for(int j=0; j<=n; j++) {
                if(i == 0 || j == 0) dp[i][j] = i + j;
                else if(word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
            }
        return dp[m][n];
    }
}
