package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by cshuo on 2021/9/12
 */
public class LC221 {
    public static void main(String[] args) {
        int[] n = new int[]{1,3,4,0,5,9,0};
        int idx = 0;
        for (int e: n) {
            if (e == 0) continue;
            n[idx++] = e;
        }
        System.out.println(idx);
        while (idx < n.length) {
            n[idx++] = 0;
        }
        for (int e: n) {
            System.out.print(e + " ");
        }
    }

    public static int maximalSquare(char[][] matrix) {
        int[] a = new int[]{1,2};
        int rLen = matrix.length;
        int cLen = matrix[0].length;
        // max area with <i, j> as right bottom point
        int[][] dp = new int[rLen][cLen];
        int max = 0;
        for (int i = 0; i < rLen; i++) {
            for (int j = 0; j < cLen; j++) {
                if (matrix[i][j] == '0') continue;
                dp[i][j] = 1;
                if (i - 1 >= 0 && j - 1 >= 0 && dp[i-1][j-1] > 0) {
                    int width = ((int)Math.sqrt(dp[i-1][j-1]));
                    boolean ok = true;
                    for (int k = j - width; k < j; k++) {
                        if (matrix[i][k] == '0') {
                            ok = false;
                            break;
                        }
                    }
                    if (!ok) continue;
                    for (int k = i - width; k < i; k++) {
                        if (matrix[k][j] == '0') {
                            ok = false;
                            break;
                        }
                    }
                    if (ok) {
                        dp[i][j] = (width + 1) * (width + 1);
                    }
                }
                if (dp[i][j] > max) max = dp[i][j];
            }
        }
        return max;
    }
}
