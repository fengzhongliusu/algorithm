package leetcode;

/**
 * Created by cshuo on 2017/9/4
 * Regular Expression Matching.
 *
 Implement regular expression matching with support for '.' and '*'.
 '.' Matches any single character.
 '*' Matches zero or more of the preceding element.

 The matching should cover the entire input string (not partial).
 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") → false
 isMatch("aa","aa") → true
 isMatch("aaa","aa") → false
 isMatch("aa", "a*") → true
 isMatch("aa", ".*") → true
 isMatch("ab", ".*") → true
 isMatch("aab", "c*a*b") → true
 */
public class LC10 {
    /**
     * 思路：DP: dp[i][j] 以i-1结尾的字符串和j-1结尾的模式字符串是否匹配.
     * 转换公式,三种情况考虑，
     * dp[i][j] = dp[i-1][j-1]    // p[j-1] == '.' 或者 s[i-1] == p[j-1]
     *          = dp[i][j-2]      // p[i-1] == '*' && p[j-2]不能匹配s[i-1]
     *          = dp[i-1][j] || dp[i][j-2]     // p[i-1] == '*' && p[j-2]可以匹配s[i-1]
     */
    public boolean isMatch(String s, String p) {
        if(s == null || p == null) return false;
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for(int i=0; i<=s.length(); i++) {
            for(int j=1; j<=p.length(); j++) {
                if(i == 0) {
                    dp[i][j] = p.charAt(j-1) == '*' && dp[i][j-2];
                }
                else if(p.charAt(j-1) == '*') {
                    if (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.')
                        dp[i][j] = dp[i-1][j] || dp[i][j-2];
                    else
                        dp[i][j] = dp[i][j-2];
                } else {
                    dp[i][j] = (p.charAt(j-1) == '.' || s.charAt(i-1) == p.charAt(j-1)) && dp[i-1][j-1] ;
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
