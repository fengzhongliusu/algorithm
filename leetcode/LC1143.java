package leetcode;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cshuo on 2021/5/23
 */
public class LC1143 {
    private int[][] result = new int[500][500];
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
        /*
        char[] c1 = text1.toCharArray();
        char[] c2 = text2.toCharArray();
        for (int i = 0; i < 500; i++) {
            for (int j = 0; j < 500; j++) {
                result[i][j] = -1;
            }
        }
        return foundLCS(c1, c2, c1.length - 1, c2.length - 1);
        */
    }

    public int foundLCS(char[] c1, char[] c2, int m, int n) {
        if (m == -1 || n == -1) {
            return 0;
        }
        if (result[m][n] != -1) {
            return result[m][n];
        }
        if (c1[m] == c2[n]) {
            return result[m][n] = foundLCS(c1, c2, m - 1, n - 1) + 1;
        } else {
            return result[m][n] = Math.max(foundLCS(c1, c2, m - 1, n), foundLCS(c1, c2, m, n - 1));
        }
    }

    public static void main(String[] args) {
        LC1143 test = new LC1143();
        System.out.println(test.longestCommonSubsequence("hofubmnylkra", "pqhgxgdofcvmr"));
//        System.out.println(test.longestCommonSubsequence("psnw", "vozsh"));
//        System.out.println(test.longestCommonSubsequence("mhunuzqrkzsnidwbun", "szulspmhwpazoxijwbq"));
    }

}
