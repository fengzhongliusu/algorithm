package leetcode;


/**
 * Longest Palindromic Substring
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

 Example:

 Input: "babad"
 Output: "bab"
 Note: "aba" is also a valid answer.

 Example:
 Input: "cbbd"
 Output: "bb"
 */
public class LC5 {
    /**
     * dp[i][j] 表示子串(i,j)是否是palindrome, 是为1， 否为0;
     * 与统计palindrome子串数目思路基本一致.
     */
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 1) return null;
        int maxLen = -1, l=0, r=0;
        int[][] dp = new int[s.length()][s.length()];
        for(int i=s.length()-1; i>-1; i--)
            for(int j=i; j<s.length(); j++) {
                dp[i][j] = (j-i < 3 || dp[i+1][j-1] >0) && s.charAt(i) == s.charAt(j) ? 1 : 0;
                if(dp[i][j] > 0 && j-i+1 > maxLen) {
                    maxLen = j-i+1;
                    l = i;
                    r = j;
                }
            }
        return s.substring(l, r+1);
    }
}
