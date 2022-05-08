package leetcode;

/**
 * Created by cshuo on 2021/7/19
 *
 * https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/610/week-3-july-15th-july-21st/3819/
 */
public class LC235 {
    public static void main(String[] args) {
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            return lowestCommonAncestor(root, q, p);
        }
        if (p.val == root.val || q.val == root.val) {
            return root;
        }
        if (root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
