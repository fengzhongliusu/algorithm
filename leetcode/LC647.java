package leetcode;


public class LC647 {
    /**
     * Given a string, your task is to count how many palindromic substrings in this string.

     The substrings with different start indexes or end indexes are counted as different substrings even they consist
     of same characters.

     Example 1:
     Input: "abc"
     Output: 3
     Explanation: Three palindromic strings: "a", "b", "c".
     Example 2:
     Input: "aaa"
     Output: 6
     Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

     思路: dp[i][j] 表示substr(i, j)是否为palindrome, 1 表示 是， 0 为否.
     */
    public static int countSubstrings(String s) {
        if(s == null || s.length() < 1) return 0;
        int[][] dp = new int[s.length()][s.length()];
        for(int i=0; i<s.length(); i++) dp[i][i] = 1;
        int rs = s.length();
        for(int i=s.length()-2; i>-1; i--)
            for(int j=i+1; j<s.length(); j++) {
                dp[i][j] = (j-i < 3 || dp[i+1][j-1] > 0) && s.charAt(i) == s.charAt(j) ? 1 : 0;
                rs += dp[i][j] > 0 ? 1 : 0;
            }
        return rs;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
    }
}
