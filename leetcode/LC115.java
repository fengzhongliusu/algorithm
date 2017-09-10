package leetcode;

/**
 * Given a string S and a string T, count the number of distinct subsequences of S which equals T.
 A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 Here is an example:
 S = "rabbbit", T = "rabbit"
 Return 3.

 思路: DP，从后向前(前面的已经处理)进行字符的匹配, dp[i][j]表示以i结尾的s串和以j结尾的t串的结果
 状态转换公式： dp[i][j] = dp[i][j-1]     // s[i] != t[j]
                       = dp[i-1][j-1] + dp[i-1][j]   // s[i] == t[j], 此时可以选择匹配s[i]或者不匹配s[i]两种可能.
 */
public class LC115 {
    public static void main(String[] args) {
        System.out.println(numDistinct("b", "a"));
    }

    public static int numDistinct(String s, String t) {
        if(s == null || t == null) return 0;
        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int i=0; i<s.length(); i++)
            for(int j=0; j<t.length(); j++) {
                if(j==0) dp[i][j] = 1;
                if(s.charAt(i) != t.charAt(j)) dp[i+1][j+1] = dp[i][j+1];
                else dp[i+1][j+1] = dp[i][j] + dp[i][j+1];
            }
        return dp[s.length()][t.length()];
    }
}
