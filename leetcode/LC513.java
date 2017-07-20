/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private int max_depth, val;

    /*
    * Given a binary tree, find the leftmost value in the last row of the tree.
    * 全局变量记录最大深度以及对应的值，深度优先遍历整棵树即可。
    */
    public int findBottomLeftValue(TreeNode root) {
        max_depth = -1;
        dfs(root, 0);
        return val;
    }

    public void dfs(TreeNode node, int depth) {
        if(node == null) return;
        if(depth > max_depth) {
            val = node.val;
            max_depth = depth;
        }
        dfs(node.left, depth+1);
        dfs(node.right, depth+1);
    }
}
