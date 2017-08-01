package leetcode;

/**
 * Created by cshuo on 2017/7/26
 * Given a binary tree, find its maximum depth.
 The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class LC104 {
    /**
     * 取子树中的较高者+1;
     */
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
