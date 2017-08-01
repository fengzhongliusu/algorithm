package leetcode;

/**
 * Created by cshuo on 2017/7/30
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).

 Assume a BST is defined as follows:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.
 */
public class LC98 {
    /**
     * 直接判断大于左节点，小于右节点有错, 如：
     *        3
     *       / \
     *      2  5
     *     / \
     *    1  4
     *
     * 正确做法是设置一个范围，对于每个节点判断其是否小于最大，大于最小，不断缩小范围即可. (需要考虑int的边界大小，用long表示.)
     */
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper(TreeNode root, long min, long max) {
        if(root == null) return true;
        if(root.val <= min || root.val >= max) return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}
