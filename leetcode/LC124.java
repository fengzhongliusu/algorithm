package leetcode;

/**
 * Created by cshuo on 2017/9/4
 * Given a binary tree, find the maximum path sum.
 For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 For example:

 Given the below binary tree,
  1
 / \
2   3
 Return 6.
 */
public class LC124 {
    static int maxVal = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        // dfs(root);
        maxDown(root);
        return maxVal;
    }

    /**
     * @param root
     * 返回以root为根节点的包含左或右子树的最大路径值, 同时更新最大路径值.
     */
    public static long dfs(TreeNode root) {
        if(root == null) return Integer.MIN_VALUE;
        long maxL = dfs(root.left);
        long maxR = dfs(root.right);
        maxVal = Math.max(maxVal, max(new long[] {maxL, maxR, root.val, maxL + root.val, maxR+root.val, maxR+maxL+root.val}));
        return max(new long[] {root.val, root.val+maxR, root.val+maxL});
    }

    /**
     * 简化版.
     */
    public static int maxDown(TreeNode root) {
        if(root == null) return 0;
        int left = Math.max(0, maxDown(root.left));
        int right = Math.max(0, maxDown(root.right));
        maxVal = Math.max(maxVal, left+right+root.val);
        return Math.max(left, right) + root.val;
    }

    public static int max(long [] nums){
        long max = Long.MIN_VALUE;
        for(long e: nums) max = Math.max(e, max);
        return (int)max;
    }
}
