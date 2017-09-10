package leetcode;
import java.util.*;

/**
 * Given two integers n and k, find how many different arrays consist of numbers from 1 to n such that there are exactly k inverse pairs.
 We define an inverse pair as following: For ith and jth element in the array, if i < j and a[i] > a[j] then it's an inverse pair; Otherwise, it's not.
 Since the answer may be very large, the answer should be modulo 109 + 7.
 Example 1:
 Input: n = 3, k = 0
 Output: 1
 Explanation:
 Only the array [1,2,3] which consists of numbers from 1 to 3 has exactly 0 inverse pair.
 */
public class LC629 {
    public static void main(String[] args) {
        System.out.println(kInversePairs(1000, 1000));
        System.out.println(KInversePs(1000, 1000));
    }

    /**
     * 思路DP: dp[i][j], 前i个元素构成j个pair的个数.
     * 则有：dp[n][k] = dp[n-1][k] + dp[n-1][k-1] + ... + dp[n-1][k-n+1] (将n插入到前n个数字中...)
     */
    public static int kInversePairs(int n, int k) {
        int[][] dp = new int[n+1][k+1];
        /**
         dp[n+1][k+1] = dp[n][j] (0=<j<=k+1);
         */
        for(int i=1; i<=n; i++) {
            for(int j=0; j<=k; j++) {
                if(j >= i*(i-1)/2){       //最大限制
                    dp[i][j] = j==i*(i-1)/2 ? 1:0;
                    continue;
                }
                else if(i == 1) {
                    if (j != 0) dp[i][j] = 0;
                    else dp[i][j] = 1;
                    continue;
                } else if(j==0) {
                    dp[i][j] = 1;
                    continue;
                }
                for(int p=0; p<=j; p++)
                    if(i-1 >= j-p) dp[i][j] = (dp[i][j] + dp[i-1][p]) % 1000000007;
            }
        }
        return dp[n][k];
    }

    /**
     * 优化：dp[n][k] = dp[n-1][k] + dp[n-1][k-1] + ... + dp[n-1][k-n+1] (将n插入到前n个数字中...)
     * dp[n][k+1] = dp[n-1][k+1] + dp[n-1][k] + ... + dp[n-1][k-n+2]
     * 则有 dp[n][k+1] - dp[n][k] = dp[n-1][k+1] - dp[n-1][k-n+1]
     * 即dp[n][k+1] = dp[n][k] + dp[n-1][k+1] - dp[n-1][k-n+1]
     * 复杂度: O(nk).
     */
    public static int KInversePs(int n, int k) {
        int mod = 1000000007;
        if (k > n*(n-1)/2 || k < 0) return 0;
        if (k == 0 || k == n*(n-1)/2) return 1;
        long[][] dp = new long[n+1][k+1];
        dp[2][0] = 1;
        dp[2][1] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= Math.min(k, i*(i-1)/2); j++)
                // 注意: 涉及到取模且有减法操作，要加上mod保证非负.
                dp[i][j] = (dp[i][j-1] + dp[i-1][j] - (j>=i?dp[i-1][j-i]:0)+mod) % mod;
        }
        return (int) dp[n][k];
    }
}
