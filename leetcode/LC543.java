package leetcode;

/**
 * Created by cshuo on 2017/8/9
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the
 * length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 Example:
 Given a binary tree
       1
      / \
     2  3
    / \
   4  5
 Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 */
public class LC543 {
    private int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getDepth(root);
        return diameter;
    }
    public int getDepth(TreeNode root) {
        if(root == null) return 0;
        int l = getDepth(root.left);
        int r = getDepth(root.right);
        if(l+r > diameter) diameter = l+r;
        return Math.max(l,r)+1;
    }
}
