package leetcode;

/**
 * Created by cshuo on 2021/5/23
 * https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
 *
 * 最长公共序列变体
 */
public class LC1312 {

    public int minInsertions(String s) {
        StringBuilder sb = new StringBuilder(s);
        String s1 = sb.reverse().toString();
        return s.length() - longestCommonSubsequence(s, s1);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
