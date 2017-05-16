package exam;

/**
 * author: cshuo
 * date: 2017/4/18
 * version: 1.0
 * description:
 */
import java.util.Scanner;


public class Toutiao04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int K = in.nextInt();

            int[][] w = new int[n+1][n+1];
            int[][][][] dp = new int[n + 1][n + 1][K + 1][2];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    w[i][j] = in.nextInt();
                }
            }
            //calc
            for (int j = 1; j <= n; j++) {
                dp[n][j][1][1] = w[n][j];
                dp[n][j][1][0] = 0;
                dp[n][j][0][0] = 0;
                dp[n][j][0][1] = 0;
            }
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= K; k++) {
                    dp[n][j][k][1] = w[n][j];
                }
            }


            for (int i = n - 1; i > 0; i--) {
                for (int j = 1; j <= i; j++) {
                    for (int k = 0; k <= K; k++) {
                        // use
                        for (int kk = 1; kk < k-1; kk++) {
                            dp[i][j][k][1] = Math.max(dp[i][j][k][1], dp[i + 1][j][kk][1] + dp[i + 1][j + 1][k - kk - 1][1]+w[i][j]);
                        }
                        // not use
                        for (int kk = 0; kk <= k; kk++) {
                            dp[i][j][k][0] = Math.max(dp[i][j][k][0], dp[i + 1][j][kk][1] + dp[i + 1][j + 1][k - kk][1]);
                            dp[i][j][k][0] = Math.max(dp[i][j][k][0], dp[i + 1][j][kk][0] + dp[i + 1][j + 1][k - kk][1]);
                            dp[i][j][k][0] = Math.max(dp[i][j][k][0], dp[i + 1][j][kk][1] + dp[i + 1][j + 1][k - kk][0]);
                            dp[i][j][k][0] = Math.max(dp[i][j][k][0], dp[i + 1][j][kk][0] + dp[i + 1][j + 1][k - kk][0]);
                        }
                    }
                }
            }
            System.out.println(Math.max(dp[1][1][K][0], dp[1][1][K][1]));

        }
    }

}

