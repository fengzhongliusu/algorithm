package leetcode;

import com.oracle.tools.packager.mac.MacAppBundler;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by cshuo on 2021/10/11
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(countTexts("222222222222222222222222222222222222"));
    }

    public static int[] findSumTarge(int[] nums, int target) {
        int[] res = new int[2];
        int begin = 0, end = nums.length - 1;
        while (begin < end) {
            int sum = nums[begin] + nums[end];
            if (sum == target) {
                res[0] = nums[begin];
                res[1] = nums[end];
                break;
            } else if (sum < target) {
                begin += 1;
            } else {
                end -= 1;
            }
        }
        if (begin == end) {
            return new int[0];
        }
        return res;
    }

    // contest-292: 01
    public String largestGoodInteger(String num) {
        char max = '0';
        boolean find = false;
        for (int p1 = 0; p1 < num.length() - 2; p1++) {
            char head = num.charAt(p1);
            if (head == num.charAt(p1 + 1) && head == num.charAt(p1 + 2)) {
                find = true;
                if (head > max) {
                    max = head;
                }
            }
        }
        return find ? new String(new char[] {max, max, max}): "";

    }

    // contest-292: 03
    public int averageOfSubtree(TreeNode root) {
        AtomicInteger cnt = new AtomicInteger();
        countTree(root, cnt);
        return cnt.get();
    }

    private int[] countTree(TreeNode node, AtomicInteger res) {
        if (node == null) return new int[] {0, 0};
        int count = 1, sum = node.val;
        if (node.left != null) {
            int[] leftRes = countTree(node.left, res);
            count += leftRes[0];
            sum += leftRes[1];
        }
        if (node.right != null) {
            int[] rRes = countTree(node.right, res);
            count += rRes[0];
            sum += rRes[1];
        }
        int avg = round(sum / (double) count);
        if (avg == node.val) res.incrementAndGet();
        return new int[] {count, sum};
    }

    private static int round(double num) {
        int res = (int) num;
        return num - res > 0.5 ? res + 1 : res;
    }

    // contest-292: 02
    public static int countTexts(String pressedKeys) {
        int[] maxPress = new int[] {3,3,3,3,3,4,3,4};
        int[] dp = new int[pressedKeys.length() + 1];
        int MOD = 1_000_000_007;
        dp[0] = 1;
        for (int i = 0; i < pressedKeys.length(); i++) {
            int maxPr = maxPress[pressedKeys.charAt(i) - '2'];
            for (int j = 0; j < maxPr; j++) { // repeat 1 to maxPr times
                if (j == 0) {
                    dp[i + 1] = dp[i];
                } else if (i - j >= 0 && pressedKeys.charAt(i - j) == pressedKeys.charAt(i)) {
                    dp[i + 1] += dp[i - j];
                    dp[i + 1] %= MOD;
                } else {
                    break;
                }
            }
        }
        return dp[pressedKeys.length()];
    }
}
