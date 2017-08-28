package leetcode;

/**
 * Created by cshuo on 2017/8/14
 */
public class LC518 {
    public static void main(String[] args) {
        int[] coins = new int[]{10,2,3,5,5};
        System.out.println(numOfChange2(coins, 10));
        System.out.println(numOfChange(10, coins));
    }

    /**
     * 思路：动态规划
     * dp[i][j] 使用前i个coin凑成j的组合数目.
     * 状态转换：
     * 1.不使用第i个coin: dp[i-1][j]
     * 2.使用第i个coin: dp[i][j-coin[i-1]]
     */
    public static int numOfChange(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 1;
        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i-1][j] + (j >= coins[i-1] ? dp[i][j-coins[i-1]] : 0);
            }
        }
        return dp[coins.length][amount];
    }

    // 优化空间
    public static int change(int amount, int[] coins) {
        if(amount < 1) return 0;
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int i=0; i<coins.length; i++)
            for(int j=coins[i]; j<=amount; j++)
                dp[j] += dp[j-coins[i]];
        return dp[amount];
    }

    /**
     * 硬币不能重复使用的解法.
     */
    public static int numOfChange2(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        dp[0][0] = 1;
        for(int i=1; i<=coins.length; i++) {
            dp[i][0] = 1;
            for(int j=1; j<=amount; j++) {
                dp[i][j] = dp[i-1][j] + (j >= coins[i-1] ? dp[i-1][j-coins[i-1]] : 0);
            }
        }
        return dp[coins.length][amount];
    }
}
