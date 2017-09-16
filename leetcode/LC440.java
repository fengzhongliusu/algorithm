package leetcode;

/**
 * Given integers n and k, find the lexicographically k-th smallest integer in the range from 1 to n.
 Note: 1 ≤ k ≤ n ≤ 109.

 Example:
 Input:
 n: 13   k: 2
 Output:
 10

 Explanation:
 The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so the second smallest number is 10.
 */
public class LC440 {
    /**
     * 思路: denary tree, 十叉树；
     * 即找前序遍历的第k个节点, 计算sibling相邻节点(cur, cur+1)之间的节点数steps，如果k>=steps, 从cur+1开始搜索第k-steps个节点;
     * 如果k < steps, 那么从10*cur(节点第一个子节点)开始搜索第k-1个节点；
     *
     */
    public int findKthNumber(int n, int k) {
        if(k > n) return -1;
        int cur = 1;
        k = k - 1;
        while(k > 0) {
            long steps = calSteps(n, cur, cur+1);
            if(k >= steps) {
                cur++;
                k -= steps;
            } else {
                cur *= 10;
                k--;
            }
        }
        return cur;
    }

    /**
     * 计算相邻节点之间的节点数方式：相邻节点(cur, cur+1), 他们cur的第i层节点的数目 = (cur+1) * 10^i - cur*10^1; 如1的第一层是20-10;
     * 需要考虑n是否小于(cur+1)*10^i;
     */
    public long calSteps(long n, long n1, long n2) {
        long count = 0;
        while(n1 <= n) {
            count += Math.min(n+1, n2) - n1;
            n1 *= 10;
            n2 *= 10;
        }
        return count;
    }
}
