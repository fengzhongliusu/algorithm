package leetcode;

/**
 * Created by cshuo on 2021/5/22
 *
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/
 */
public class LC1448 {
    private int cnt = 0;

    public int goodNodes(TreeNode root) {
        cnt = 0;
        findGood(Integer.MIN_VALUE, root);
        return cnt;
    }

    private void findGood(int curMax, TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.val >= curMax) {
            curMax = node.val;
            cnt += 1;
        }
        findGood(curMax, node.left);
        findGood(curMax, node.right);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
