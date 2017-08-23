package leetcode;

/**
 * Created by cshuo on 2017/8/14
 * Coin Change
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.

 Example 1:
 coins = [1, 2, 5], amount = 11
 return 3 (11 = 5 + 5 + 1)

 Example 2:
 coins = [2], amount = 3
 return -1.
 */
public class LC322 {
    int[] mem;

    /**
     * 带memory的动态规划, 递归写法.
     * 思路是：要求amount的最少组合硬币数，可以求amount-coin[i]中的最小者,再加1即可.
     */
    public int coinChange(int[] coins, int amount) {
        int[] mem = new int[amount+1];
        return helper(coins, amount, mem);
    }

    public int helper(int[] coins, int amount, int[] mem) {
        if(amount <= 0) return 0;

        int minNum = Integer.MAX_VALUE;
        for(int e: coins) {
            if(e <= amount) {
                if(mem[amount-e] == 0) {
                    int nums = helper(coins, amount-e, mem);
                    if(nums >= 0 && nums+1 < minNum) minNum = nums+1;
                } else if(mem[amount-e] != -1) {
                    int nums = mem[amount-e] + 1;
                    if(nums < minNum) minNum = nums;
                }
            }
        }
        mem[amount] = minNum == Integer.MAX_VALUE ? -1 : minNum;
        return mem[amount];
    }

    // 硬币可以重复使用: Iterative method, bottom up way;
    public int coinChangeNum(int[] coins, int amount) {
        if(amount < 1) return 0;
        int[] dp = new int[amount+1];
        int sum = 0;
        while(++sum <= amount) {
            int min = -1;
            for(int c: coins) {
                if(sum >= c && dp[sum-c] != -1) {
                    int tmp = dp[sum-c] + 1;
                    min = min<0 ? tmp : (min<tmp ? min : tmp);
                }
            }
            dp[sum] = min;
        }
        return dp[amount];
    }

    /**
     * 不可重复使用硬币.
     */
    public static int coinChange2(int[] coins, int amount) {
        if(amount < 1) return 0;
        int[][] dp = new int[coins.length+1][amount+1];
        for(int j=1; j<=amount; j++) dp[0][j] = Integer.MAX_VALUE;  // 不存在解法.
        for(int i=1; i<=coins.length; i++) {
            for(int j=1; j<=amount; j++) {
                int opt1 = dp[i-1][j];
//                可以重复使用第i枚硬币.   不同点在 * (下面的式子是i-1)                                           *
//                int opt2 = j>=coins[i-1]? (dp[i][j-coins[i-1]]==Integer.MAX_VALUE ? Integer.MAX_VALUE: dp[i][j-coins[i-1]]+1):Integer.MAX_VALUE;
                // 使用第i个硬币, 前提是j>=coins[i-1]并且dp[i-1][j-coins[i-1]]不是MAX_VALUE.
                int opt2 = j>=coins[i-1]? (dp[i-1][j-coins[i-1]]==Integer.MAX_VALUE ? Integer.MAX_VALUE: dp[i-1][j-coins[i-1]]+1):Integer.MAX_VALUE;
                dp[i][j] = Math.min(opt1, opt2);
            }
        }
        return dp[coins.length][amount] == Integer.MAX_VALUE ? -1 : dp[coins.length][amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1};
        System.out.println(coinChange2(coins, 2));
    }
}
