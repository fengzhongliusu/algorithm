package leetcode;

import java.util.Date;

/**
 * author: cshuo
 * date: 2017/3/23
 * version: 1.0
 * description:
 */
public class LC516 {
    public static int longestPalindromeSubStr(String s) {
        int max_len = 1;
        int l, r;
        int len;
        for(int i=0; i<s.length()-1; i++){
            l = i;
            r = i+1;
            if(s.charAt(l)!=s.charAt(r))
                continue;
            len = 2;
            while(--l>=0 && ++r<=s.length()-1) {
                if(s.charAt(l) != s.charAt(r)) break;
                else  len+=2;
            }
            if(len > max_len) max_len = len;
        }

        for(int i=1;i<s.length()-1; i++){
            l = i-1;
            r = i+1;
            if(s.charAt(l) != s.charAt(r))
                continue;
            len = 3;
            while(--l>=0 && ++r<=s.length()-1){
                if(s.charAt(l) != s.charAt(r)) break;
                else len+=2;
            }
            if(len > max_len) max_len = len;
        }

        return max_len;
    }

    public static int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int i=s.length()-1; i>=0; i--){
            dp[i][i] = 1;
            for(int j=i+1; j<s.length(); j++){
                if(s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i+1][j-1] + 2;
                else dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
            }
        }
        return dp[0][s.length()-1];
    }

    public static void main(String[] args) {
//        long b = new Date().getTime();
//        System.out.println(longestPalindromeSubStr(s));
//        System.out.println(new Date().getTime()-b);

        String s = "aaa";
        System.out.println(longestPalindromeSubseq(s));
    }
}
