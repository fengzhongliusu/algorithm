package collections.tree;

/**
 * 一棵树，节点值都是证正整数，现要做以下调整：增大某些节点的值，使得从根节点到每个叶子节点的路径和相等，求最小增加的数值是多少.
 * 如:
 *           1
 *         /   \
 *        2    3
 *       / \  / \
 *      3  2 2  4
 *            \
 *             1
 *    调整之后为
 *           1
 *         /   \
 *        4    3
 *       / \  / \
 *      3  3 3  4
 *            \
 *             1
 *  最少增加值为4.
 */
public class BalanceTree {
    static int minSum = 0;
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(2);
        TreeNode t6 = new TreeNode(2);
        TreeNode t7 = new TreeNode(4);
        TreeNode t8 = new TreeNode(1);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t6.left = t8;
        System.out.println(findAddSum(t1));
    }

    /**
     * 思路：尽量给上层的节点增加值，这样分支节点可以共用增加的值；
     * 类似后序遍历，分别求出左右子树的路径和，计算出差值，即当前节点需要增加的值.
     */
    public static int findAddSum(TreeNode root) {
        if(root == null) return 0;
        helper(root);
        return minSum;
    }

    public static int helper(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.val;
        int left = helper(root.left);
        int right = helper(root.right);
        // 只有在左右子树都存在的情况下才需调整当前节点的值.
        if(root.left != null && root.right != null)
            minSum += Math.abs(left-right);
        // 调整后的路径和.
        return Math.max(left, right) + root.val;
    }
}
