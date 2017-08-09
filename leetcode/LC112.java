package leetcode;

/**
 * Created by cshuo on 2017/8/9
 *
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
        5
       / \
      4  8
     /  / \
   11  13 4
  /  \     \
 7   2     1
 return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class LC112 {
    boolean sign = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        helper(root, 0, sum);
        return sign;
    }

    public void helper(TreeNode root, int sum, int target) {
        if(root.left == null && root.right == null && sum+root.val == target){
            sign = true;
            return;
        }
        if(root.left != null) helper(root.left, sum+root.val, target);
        if(root.right != null) helper(root.right, sum+root.val, target);
    }

    // 简洁的解法
    public boolean hasPathSum1(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left == null && root.right == null && sum == root.val) return true;
        return hasPathSum1(root.left, sum-root.val) || hasPathSum1(root.right, sum-root.val);
    }
}
