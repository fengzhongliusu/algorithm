package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by cshuo on 2021/10/13
 */
public class LC322 {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> q = new ArrayBlockingQueue<>(10);
        q.take();
        q.put(1);
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                int left = i - coins[j];
                if (left == 0) {
                    dp[i] = 1;
                } else if (left > 0 && dp[left] > 0) {
                    dp[i] = dp[i] == 0 ? dp[left] + 1 : Math.min(dp[left] + 1, dp[i]);
                }
            }
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }
}
